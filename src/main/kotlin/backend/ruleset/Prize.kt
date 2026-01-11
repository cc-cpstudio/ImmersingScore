package tech.cpstudio.backend.ruleset

import java.util.UUID

/**
 * 奖励（需分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Recordable
 */
class Prize(uuid: String, name: String, score: Int) : Recordable(uuid, name, score) {
    override val type: RecordableType = RecordableType.PRIZE
    override fun actualScore(): Int {
        return -score
    }
}