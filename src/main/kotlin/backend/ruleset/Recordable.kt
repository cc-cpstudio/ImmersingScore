package tech.cpstudio.backend.ruleset

import backend.ruleset.IncorrectScore

abstract class Recordable(var name: String, var score: Int) {
    init {
        if (score < 0)
            throw IncorrectScore()
    }
    abstract fun actualScore(): Int
}