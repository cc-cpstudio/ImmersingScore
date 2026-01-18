package tech.cpstudio.backend.student

import tech.cpstudio.backend.record.Record

data class JsonedStudent(
    val metadata: StudentMetadata,
    val records: List<Record>
)
