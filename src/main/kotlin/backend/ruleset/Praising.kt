package tech.cpstudio.backend.ruleset

/**
 * 表扬（加分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Rule
 */
class Praising(uuid: String, name: String, score: Int) : Rule(uuid, name, score) {
    override val type: RuleType =  RuleType.PRAISING
    override fun actualScore(): Int {
        return score
    }
}