package tech.cpstudio.backend.record

import tech.cpstudio.backend.ruleset.Recordable
import java.time.LocalDateTime

data class Record(
    val time: LocalDateTime,
    val type: Recordable,
)