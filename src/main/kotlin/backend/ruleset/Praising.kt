package tech.cpstudio.backend.ruleset

import tech.cpstudio.backend.ruleset.Rule
import java.util.UUID

/**
 * 表扬（加分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Rule
 */
class Praising(uuid: String, name: String, score: Int) : Rule(uuid, name, score) {
    constructor(): this(UUID.randomUUID().toString().replace("-", ""), "新的规则", 1)

    override val type: RuleType =  RuleType.PRAISING
    override fun actualScore(): Int {
        return score
    }
}