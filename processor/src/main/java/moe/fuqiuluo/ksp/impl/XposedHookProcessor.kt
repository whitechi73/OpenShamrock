@file:Suppress("UNCHECKED_CAST", "LocalVariableName", "PrivatePropertyName")
@file:OptIn(KspExperimental::class)

package moe.fuqiuluo.ksp.impl

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.getClassDeclarationByName
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.google.devtools.ksp.validate
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import moe.fuqiuluo.symbols.Process
import moe.fuqiuluo.symbols.XposedHook

class XposedHookProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
): SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(XposedHook::class.qualifiedName!!)
        val unableToProcess = symbols.filterNot { it.validate() }
        val actions = (symbols.filter {
            it is KSClassDeclaration && it.validate()  && it.classKind == ClassKind.CLASS
        } as Sequence<KSClassDeclaration>).toList()

        if (actions.isNotEmpty()) {
            val firstActions = arrayListOf<KSClassDeclaration>()
            val serviceActions = arrayListOf<KSClassDeclaration>()
            actions.forEach {
                val priority = it.getAnnotationsByType(XposedHook::class).first().priority
                if (priority >= 10) {
                    serviceActions.add(it)
                } else {
                    firstActions.add(it)
                }
            }

            val context = ClassName("android.content", "Context")
            val packageName = "moe.fuqiuluo.shamrock.xposed.hooks"
            val fileSpec = FileSpec.builder(packageName, "AutoActionLoader").addFunction(FunSpec.builder("runFirstActions")
                .addParameter("ctx", context)
                .apply {
                    firstActions.forEach { handler ->
                        val annotation = handler.getAnnotationsByType(XposedHook::class).first()
                        val process = annotation.process
                        val className = handler.simpleName.asString()
                        if (process == Process.MAIN) {
                            addStatement("if (PlatformUtils.isMainProcess()) ")
                        } else if (process == Process.MSF) {
                            addStatement("if (PlatformUtils.isMsfProcess()) ")
                        }
                        addStatement("$className().invoke(ctx)")
                    }
                }.build()
            ).addFunction(FunSpec.builder("runServiceActions")
                .addParameter("ctx", context).apply {
                    serviceActions.forEach { handler ->
                        val annotation = handler.getAnnotationsByType(XposedHook::class).first()
                        val process = annotation.process
                        val className = handler.simpleName.asString()
                        if (process == Process.MAIN) {
                            addStatement("if (PlatformUtils.isMainProcess()) ")
                        } else if (process == Process.MSF) {
                            addStatement("if (PlatformUtils.isMsfProcess()) ")
                        }
                        addStatement("$className().invoke(ctx)")
                    }
                }.build()
            ).apply {
                firstActions.forEach {
                    addImport(it.packageName.asString(), it.simpleName.asString())
                }
                serviceActions.forEach {
                    addImport(it.packageName.asString(), it.simpleName.asString())
                }
                addImport("moe.fuqiuluo.shamrock.utils", "PlatformUtils")
            }.build()

            codeGenerator.createNewFile(
                dependencies = Dependencies(aggregating = false),
                packageName = packageName,
                fileName = "AutoActionLoader"
            ).use { outputStream ->
                outputStream.writer().use {
                    fileSpec.writeTo(it)
                }
            }
        }

        return unableToProcess.toList()
    }

    inner class ActionLoaderVisitor(
        private val firstActions: List<KSClassDeclaration>,
        private val serviceActions: List<KSClassDeclaration>,
    ): KSVisitorVoid() {
        override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {

        }
    }
}