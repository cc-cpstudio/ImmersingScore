package tech.cpstudio.backend.basicfunc

import java.io.File

/**
 * 获取用户数据存储位置，位于软件工作目录的data文件夹中
 */
fun getUserDataLocation(): String {
    val current = File("").absolutePath
    return "$current/data"
}