package kritor.service

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
annotation class Grpc(
    val serviceName: String,
    val funcName: String,

)
