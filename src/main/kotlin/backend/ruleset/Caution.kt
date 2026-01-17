package tech.cpstudio.backend.ruleset

/**
 * 提醒（减分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Rule
 */
class Caution(uuid: String, name: String, score: Int) : Rule(uuid, name, score) {
    override val type: RuleType = RuleType.CAUTION
    override fun actualScore(): Int {
        return -score
    }
}