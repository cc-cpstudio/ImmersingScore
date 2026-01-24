package tech.cpstudio.backend.class_

import com.google.gson.GsonBuilder
import tech.cpstudio.backend.basicfunc.getWorkingDir
import tech.cpstudio.backend.ruleset.Ruleset
import tech.cpstudio.backend.student.Student
import tech.cpstudio.backend.synchronizer.ClassSynchronizer
import java.io.File

class Class (val name: String, val students: MutableList<Student>, val ruleset: Ruleset) {
    constructor(name: String): this(name, mutableListOf(), Ruleset(name))
    
    val synchronizer = ClassSynchronizer()
    
    fun save() {
        val gson = GsonBuilder()
            .create()

        val dataPath = "${getWorkingDir()}/data/$name/"
        val studentPath = "$dataPath/students/"
        students.forEach {
            val json = gson.toJson(it)
            val file = File("$studentPath${it.metadata.id}.json")
            file.writeText(json)
        }
        ruleset.serialize()
    }
}