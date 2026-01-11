package tech.cpstudio.backend.ruleset

import backend.ruleset.IncorrectScore
import java.util.UUID

/**
 * 积分规则抽象类，用于定义三类积分规则的公共方法
 * @property uuid 每一个规则的唯一标识符
 * @property name 规则名称
 * @property score 该规则对应的积分
 * @property type 规则类型
 * @property actualScore 该规则实际对应的积分，可能为正整数、负整数
 */
abstract class Recordable(val uuid: String, var name: String, var score: Int) {
    constructor(): this(UUID.randomUUID().toString().replace("-", ""), "新的规则", 1)

    abstract val type: RecordableType

    init {
        if (score < 0)
            throw IncorrectScore()
    }
    abstract fun actualScore(): Int
}