package tech.cpstudio.backend.class_

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import tech.cpstudio.backend.basicfunc.getWorkingDir
import tech.cpstudio.backend.record.RecordList
import tech.cpstudio.backend.ruleset.Ruleset
import tech.cpstudio.backend.student.JsonedStudent
import tech.cpstudio.backend.student.Student
import tech.cpstudio.backend.student.StudentMetadata
import java.io.File

object ClassManager {
    val gson: Gson? = GsonBuilder()
            .create()

    val classes = mutableListOf<Class>()
    val currentClass: Class? = null

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
            val students = mutableListOf<Student>()
            (studentFiles?.filter { stuff -> stuff.isFile })?.forEach { file ->
                val jsonedStudent = gson!!.fromJson(file.readText(), JsonedStudent::class.java)
                students.add(Student(
                    StudentMetadata(jsonedStudent.metadata.name, jsonedStudent.metadata.id),
                    RecordList(StudentMetadata(jsonedStudent.metadata.name, jsonedStudent.metadata.id))
                ))
            }
            classes.add(Class(it.name, students, ruleset))
        }
    }
    fun findClass(name: String): Class? {
        return classes.find {
            it.name == name
        }
    }
}