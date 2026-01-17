package tech.cpstudio.backend.basicfunc

import java.io.File

/**
 * 获取程序工作目录
 */
fun getWorkingDir(): String {
    val current = File("").absolutePath
    return "$current"
}