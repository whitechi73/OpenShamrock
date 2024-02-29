@file:JvmName("ModuleInfo")
package moe.fuqiuluo.shamrock.xposed.loader.tmpnativehelper

import moe.fuqiuluo.shamrock.xposed.loader.LuoClassloader

val moduleClassLoader: ClassLoader = LuoClassloader::class.java.classLoader!!