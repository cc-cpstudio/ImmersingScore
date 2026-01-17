package tech.cpstudio.backend.ruleset

/**
 * 奖励（需分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Rule
 */
class Prize(uuid: String, name: String, score: Int) : Rule(uuid, name, score) {
    override val type: RuleType = RuleType.PRIZE
    override fun actualScore(): Int {
        return -score
    }
}