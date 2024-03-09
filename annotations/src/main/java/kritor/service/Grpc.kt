package kritor.service

@Target(AnnotationTarget.FUNCTION)
annotation class Grpc(
    val serviceName: String,
    val funcName: String
)