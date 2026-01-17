package tech.cpstudio.backend.record

import tech.cpstudio.backend.ruleset.RuleType
import tech.cpstudio.backend.student.StudentMetadata

/**
 * 记录列表类，用于存储一个学生的所有积分记录
 * @property whose 记录该列表的最终归属，类型为StudentMetadata
 * @property records 该列表所存储的记录
 * @property positive 该列表中所有正积分的积分总数
 * @property negative 该列表中所有负积分的积分总数
 * @property sort 该列表所存储的记录的排序方法
 * @property add 向列表中添加一条记录
 * @property delete 删除列表中一条记录
 * @property calcScore 计算列表中所有记录的积分总数
 * @throws backend.ruleset.IncorrectScore 如果添加的记录的积分数小于0则抛出
 */
class RecordList(val whose: StudentMetadata, val records: MutableList<Record>) {
    constructor(whose: StudentMetadata): this(whose, mutableListOf())

    var positive: Int = 0
    var negative: Int = 0

    init {
        sort()
    }

    fun sort() {
        records.sortBy { it.time }
    }

    fun add(record: Record) {
        records.add(record)
        when (record.detail.type) {
            RuleType.PRAISING -> positive += record.detail.score
            RuleType.CAUTION -> negative += record.detail.score
            else -> {}
        }
        sort()
    }

    fun delete(ind: Int) {
        when (records[ind].detail.type) {
            RuleType.PRAISING -> positive -= records[ind].detail.score
            RuleType.CAUTION -> negative -= records[ind].detail.score
            else -> {}
        }
        records.removeAt(ind)
        sort()
    }

    fun calcScore() {
        var positive = 0
        var negative = 0
        records.forEach {
            when (it.detail.type) {
                RuleType.PRAISING -> positive += it.detail.score
                RuleType.CAUTION -> negative += it.detail.score
                else -> {}
            }
        }
        this.positive = positive
        this.negative = negative
    }
}