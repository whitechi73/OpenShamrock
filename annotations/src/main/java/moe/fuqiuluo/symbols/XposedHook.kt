package moe.fuqiuluo.symbols

enum class Process {
    ALL,
    MAIN,
    MSF
}

@Target(AnnotationTarget.CLASS)
annotation class XposedHook(
    val process: Process = Process.ALL,
    val priority: Int = 10
)