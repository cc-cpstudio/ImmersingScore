package tech.cpstudio.backend.ruleset

import tech.cpstudio.backend.ruleset.Rule
import java.util.UUID

/**
 * 提醒（减分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Rule
 */
class Caution(uuid: String, name: String, score: Int) : Rule(uuid, name, RuleType.CAUTION, score) {
    constructor(): this(UUID.randomUUID().toString().replace("-", ""), "新的规则", 1)

    override val type: RuleType = RuleType.CAUTION
}