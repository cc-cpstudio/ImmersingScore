package tech.cpstudio.backend.record

import tech.cpstudio.backend.student.StudentMetadata

/**
 * 记录列表类，用于存储一个学生的所有积分记录
 * @property whose 记录该列表的最终归属，类型为StudentMetadata
 * @property records 该列表所存储的记录
 * @property score 该列表所存储的记录的积分总数
 * @property sort 该列表所存储的记录的排序方法
 * @property add 向列表中添加一条记录
 * @property delete 删除列表中一条记录
 * @property totalScore 获取列表中所有记录的积分总数
 * @property filteredScore 获取列表中指定条件的记录的积分总数
 * @throws backend.ruleset.IncorrectScore 如果添加的记录的积分数小于0则抛出
 */
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
        score += record.detail.actualScore()
        sort()
    }

    fun delete(ind: Int) {
        score -= records[ind].detail.actualScore()
        records.removeAt(ind)
        sort()
    }

    fun totalScore(): Int {
        var sum = 0
        records.forEach {
            sum += it.detail.actualScore()
        }
        return sum
    }

    fun filteredScore(func: (Record) -> Boolean): Int {
        val filtered = records.filter(func)
        var sum = 0
        filtered.forEach {
            sum += it.detail.actualScore()
        }
        return sum
    }
}