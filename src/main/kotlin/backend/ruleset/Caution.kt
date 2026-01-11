package tech.cpstudio.backend.ruleset

import java.util.UUID

/**
 * 提醒（减分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Recordable
 */
class Caution(uuid: String, name: String, score: Int) : Recordable(uuid, name, score) {
    override val type: RecordableType = RecordableType.CAUTION
    override fun actualScore(): Int {
        return -score
    }
}