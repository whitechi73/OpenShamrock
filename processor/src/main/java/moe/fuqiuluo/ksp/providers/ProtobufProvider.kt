package moe.fuqiuluo.ksp.providers

import com.google.auto.service.AutoService
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import moe.fuqiuluo.ksp.impl.ProtobufProcessor

@AutoService(SymbolProcessorProvider::class)
class ProtobufProvider: SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return ProtobufProcessor(
            environment.codeGenerator,
            environment.logger
        )
    }
}