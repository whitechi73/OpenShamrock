package moe.fuqiuluo.ksp.providers

import com.google.auto.service.AutoService
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import moe.fuqiuluo.ksp.impl.OneBotHandlerProcessor

@AutoService(SymbolProcessorProvider::class)
class OneBotHandlerProcessorProvider: SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return OneBotHandlerProcessor(
            environment.codeGenerator,
            environment.logger
        )
    }
}