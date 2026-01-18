package tech.cpstudio.backend.class_

import com.google.gson.GsonBuilder
import tech.cpstudio.backend.basicfunc.getWorkingDir
import tech.cpstudio.backend.ruleset.Ruleset
import tech.cpstudio.backend.student.JsonedStudent
import tech.cpstudio.backend.student.StudentMetadata
import java.io.File

object ClassManager {
    val gson =  GsonBuilder()
            .create()

    val classes = mutableListOf<Class>()

    fun newClass(name: String) {
        classes.add(Class(name))
    }
    fun scanClasses() {
        val dataDir = File("${getWorkingDir()}/data/")
        (dataDir.listFiles()?.filter {
            it.isDirectory
        })?.forEach {
            val ruleset = Ruleset(it.name)
            val studentFiles = File("${it.absolutePath}/students/").listFiles()
            (studentFiles?.filter { it.isFile })?.forEach {
                val jsonedStudent = gson.fromJson(it.readText(), JsonedStudent::class.java)
            }
        }
    }
}