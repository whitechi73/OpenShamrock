package moe.fuqiuluo.symbols

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class OneBotHandler(
    val actionName: String,
    val alias: Array<String> = []
)
