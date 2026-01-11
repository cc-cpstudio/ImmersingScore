package tech.cpstudio.backend.record

import tech.cpstudio.backend.ruleset.Recordable
import java.time.LocalDateTime

/**
 * 记录类，用于存储一条积分记录
 * @property time 记录创建的时间
 * @property detail 记录详情，都继承自Recordable
 */
data class Record(
    val time: LocalDateTime,
    val detail: Recordable,
)