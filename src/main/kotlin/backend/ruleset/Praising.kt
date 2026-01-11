package tech.cpstudio.backend.ruleset

import java.util.UUID

/**
 * 表扬（加分项）类，继承自Recordable
 * @see tech.cpstudio.backend.ruleset.Recordable
 */
class Praising(uuid: String, name: String, score: Int) : Recordable(uuid, name, score) {
    override val type: RecordableType =  RecordableType.PRAISING
    override fun actualScore(): Int {
        return score
    }
}