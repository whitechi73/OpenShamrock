@file:OptIn(KspExperimental::class)
@file:Suppress("LocalVariableName", "UNCHECKED_CAST")

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
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import moe.fuqiuluo.symbols.OneBotHandler

class OneBotHandlerProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
): SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val ActionManagerNode = resolver.getClassDeclarationByName("moe.fuqiuluo.shamrock.remote.action.ActionManager")
        if (ActionManagerNode == null) {
            logger.error("OneBotHandlerProcessor: ActionManager not found")
            return emptyList()
        }
        val symbols = resolver.getSymbolsWithAnnotation(OneBotHandler::class.qualifiedName!!)
        val unableToProcess = symbols.filterNot { it.validate() }
        val oneBotHandlers = (symbols.filter {
            it is KSClassDeclaration && it.validate()  && it.classKind == ClassKind.OBJECT
        } as Sequence<KSClassDeclaration>).toList()

        if (oneBotHandlers.isNotEmpty()) {
            ActionManagerNode.accept(ActionManagerVisitor(oneBotHandlers), Unit)
        }

        return unableToProcess.toList()
    }

    inner class ActionManagerVisitor(
        private val actionHandlers: List<KSClassDeclaration>
    ): KSVisitorVoid() {
        override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
            val packageName = classDeclaration.packageName.asString()

            // generate kotlin `init { }`
            val fileSpec = FileSpec.builder(packageName, classDeclaration.qualifiedName?.asString() ?: run {
                throw IllegalStateException("ActionManagerVisitor: classDeclaration.qualifiedName is null")
            }).addFunction(FunSpec.builder("initManager").apply {
                actionHandlers.forEach { handler ->
                    // fetch the params of the annotation
                    val annotation = handler.getAnnotationsByType(OneBotHandler::class).first()
                    val actionName = annotation.actionName
                    val alias = annotation.alias
                    alias.forEach { name ->
                        addStatement("actionMap[\"$name\"] = ${handler.simpleName.asString()}")
                    }
                    addStatement("actionMap[\"$actionName\"] = ${handler.simpleName.asString()}")
                }
            }.build()).apply {
                addImport("moe.fuqiuluo.shamrock.remote.action.ActionManager", "actionMap")
                actionHandlers.forEach {
                    addImport(it.packageName.asString(), it.simpleName.asString())
                }
            }.build()

            codeGenerator.createNewFile(
                dependencies = Dependencies(aggregating = false),
                packageName = packageName,
                fileName = "Auto" + classDeclaration.simpleName.asString()
            ).use { outputStream ->
                outputStream.writer().use {
                    fileSpec.writeTo(it)
                }
            }
        }
    }
}