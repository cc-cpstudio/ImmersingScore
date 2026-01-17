package tech.cpstudio.backend.class_

import tech.cpstudio.backend.ruleset.Ruleset
import tech.cpstudio.backend.student.Student

class Class (val name: String, val students: MutableList<Student>, val ruleset: Ruleset) {
    constructor(name: String): this(name, mutableListOf(), Ruleset(name))
}