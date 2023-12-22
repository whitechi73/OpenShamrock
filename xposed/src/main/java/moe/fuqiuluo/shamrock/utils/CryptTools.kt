package moe.fuqiuluo.shamrock.utils

object CryptTools {

    fun getSHA1(string: String): ByteArray {
        return getSHA1(string.toByteArray())
    }

    fun getSHA1(bytes: ByteArray): ByteArray {
        return getDigest(bytes, "SHA-1")
    }

    private fun getDigest(bytes: ByteArray, algorithm: String): ByteArray {
        val digest = java.security.MessageDigest.getInstance(algorithm)
        digest.update(bytes)
        return digest.digest()
    }

}