@file:Suppress("UNCHECKED_CAST")
@file:OptIn(KspExperimental::class)

package moe.fuqiuluo.ksp.impl

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.getClassDeclarationByName
import com.google.devtools.ksp.getJavaClassByName
import com.google.devtools.ksp.getKotlinClassByName
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.symbol.KSTypeParameter
import com.google.devtools.ksp.symbol.Modifier
import com.google.devtools.ksp.validate
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import kritor.service.Grpc

class GrpcProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
): SymbolProcessor {
    private val subPackage = arrayOf("contact", "core", "file", "friend", "group", "message", "web")

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(Grpc::class.qualifiedName!!)
        val actions = (symbols as Sequence<KSFunctionDeclaration>).toList()

        if (actions.isEmpty()) return emptyList()

        // 怎么返回nullable的结果
        val packageName = "kritor.handlers"
        val funcBuilder = FunSpec.builder("handleGrpc")
            .addModifiers(KModifier.SUSPEND)
            .addParameter("cmd", String::class)
            .addParameter("data", ByteArray::class)
            .returns(ByteArray::class)
        val fileSpec = FileSpec.scriptBuilder("AutoGrpcHandlers", packageName)

        logger.warn("Found ${actions.size} grpc-actions")

        //logger.error(resolver.getClassDeclarationByName("io.kritor.AuthReq").toString())
        //logger.error(resolver.getJavaClassByName("io.kritor.AuthReq").toString())
        //logger.error(resolver.getKotlinClassByName("io.kritor.AuthReq").toString())

        actions.forEach { action ->
            val methodName = action.qualifiedName?.asString()!!
            val grpcMethod = action.getAnnotationsByType(Grpc::class).first()
            val service = grpcMethod.serviceName
            val funcName = grpcMethod.funcName
            funcBuilder.addStatement("if (cmd == \"${service}.${funcName}\") {\t")

            val reqType = action.parameters[0].type.toString()
            val rspType = action.returnType.toString()
            funcBuilder.addStatement("val resp: $rspType = $methodName($reqType.parseFrom(data))")
            funcBuilder.addStatement("return resp.toByteArray()")

            funcBuilder.addStatement("}")
        }
        funcBuilder.addStatement("return EMPTY_BYTE_ARRAY")
        fileSpec
            .addStatement("import io.kritor.*")
            .addStatement("import io.kritor.core.*")
            .addStatement("import io.kritor.contact.*")
            .addStatement("import io.kritor.group.*")
            .addStatement("import io.kritor.friend.*")
            .addStatement("import io.kritor.file.*")
            .addStatement("import io.kritor.message.*")
            .addStatement("import io.kritor.web.*")
            .addFunction(funcBuilder.build())
            .addImport("moe.fuqiuluo.symbols", "EMPTY_BYTE_ARRAY")
        runCatching {
            codeGenerator.createNewFile(
                dependencies = Dependencies(aggregating = false),
                packageName = packageName,
                fileName = fileSpec.name
            ).use { outputStream ->
                outputStream.writer().use {
                    fileSpec.build().writeTo(it)
                }
            }
        }

        return emptyList()
    }
}