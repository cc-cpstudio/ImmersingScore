package tech.cpstudio.backend.record

import tech.cpstudio.backend.student.StudentMetadata

class RecordList(val whose: StudentMetadata, val records: MutableList<Record>) {
    constructor(whose: StudentMetadata): this(whose, mutableListOf())

    var score: Int = 0

    init {
        sort()
        score = totalScore()
    }

    fun sort() {
        records.sortBy { it.time }
    }

    fun add(record: Record) {
        records.add(record)
        score += record.type.actualScore()
        sort()
    }

    fun delete(ind: Int) {
        score -= records[ind].type.actualScore()
        records.removeAt(ind)
        sort()
    }

    fun totalScore(): Int {
        var sum = 0
        records.forEach {
            sum += it.type.actualScore()
        }
        return sum
    }

    fun filteredScore(func: (Record) -> Boolean): Int {
        val filtered = records.filter(func)
        var sum = 0
        filtered.forEach {
            sum += it.type.actualScore()
        }
        return sum
    }
}