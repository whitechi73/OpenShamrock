@file:Suppress("UNCHECKED_CAST")
package moe.fuqiuluo.ksp.impl

import com.google.devtools.ksp.isInternal
import com.google.devtools.ksp.isPrivate
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.validate
import com.squareup.kotlinpoet.FileSpec
import kotlinx.serialization.Serializable

class ProtobufProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
): SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(Serializable::class.qualifiedName!!)
        val unableToProcess = symbols.filterNot { it.validate() }
        val actions = (symbols.filter {
            it is KSClassDeclaration && it.validate()  && it.classKind == ClassKind.CLASS
        } as Sequence<KSClassDeclaration>).filter {
            it.superTypes.any { superType ->
                superType.resolve().declaration.qualifiedName?.asString() == "moe.fuqiuluo.symbols.Protobuf"
            }
        }.toList()

        if (actions.isNotEmpty()) {
            actions.forEachIndexed { index, clz ->
                if (clz.isInternal()) return@forEachIndexed
                if (clz.isPrivate()) return@forEachIndexed

                val packageName = "protobuf.auto"
                val fileSpecBuilder = FileSpec.scriptBuilder("FastProtobuf", packageName)

                fileSpecBuilder.addImport("kotlinx.serialization.protobuf", "ProtoBuf")
                fileSpecBuilder.addImport("kotlinx.serialization", "decodeFromByteArray")
                fileSpecBuilder.addImport("kotlinx.serialization", "encodeToByteArray")

                if (clz.parentDeclaration != null) {
                    fileSpecBuilder.addImport(clz.importPackage, clz.simpleName.asString())
                } else {
                    fileSpecBuilder.addImport(clz.packageName.asString(), clz.simpleName.asString())
                }
                if (clz.typeParameters.isNotEmpty()) {
                    val genericType = clz.typeParameters.joinToString(", ") { it.name.asString() }
                    fileSpecBuilder.addStatement("""inline fun <$genericType> ${clz.simpleName.asString()}<$genericType>.toByteArray() = ProtoBuf.encodeToByteArray(this)""")
                } else {
                    fileSpecBuilder.addStatement("inline fun ${clz.simpleName.asString()}.toByteArray() = ProtoBuf.encodeToByteArray(this)")
                }

                codeGenerator.createNewFile(
                    dependencies = Dependencies.ALL_FILES,
                    packageName = packageName,
                    fileName = "FP${clz.simpleName.asString().hashCode()}"
                ).use { outputStream ->
                    outputStream.writer().use {
                        fileSpecBuilder.build().writeTo(it)
                    }
                }
            }
        }

        return unableToProcess.toList()
    }

    private val KSDeclaration.importPackage: String
        get() = if (parentDeclaration != null) {
            parentDeclaration!!.importPackage + "." + parentDeclaration!!.simpleName.asString()
        } else packageName.asString()
}