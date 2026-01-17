package tech.cpstudio.backend.ruleset

import tech.cpstudio.backend.ruleset.Rule
import java.util.UUID

/**
 * 奖励（需分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Rule
 */
class Prize(uuid: String, name: String, score: Int) : Rule(uuid, name, score) {
    constructor(): this(UUID.randomUUID().toString().replace("-", ""), "新的规则", 1)

    override val type: RuleType = RuleType.PRIZE
    override fun actualScore(): Int {
        return -score
    }
}