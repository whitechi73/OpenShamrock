package moe.fuqiuluo.shamrock.tools

fun Result<*>.errMsg(): String {
    return this.exceptionOrNull()?.message ?: exceptionOrNull().toString()
}