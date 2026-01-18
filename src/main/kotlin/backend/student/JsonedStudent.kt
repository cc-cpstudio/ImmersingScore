package tech.cpstudio.backend.student

data class JsonedStudent(
    val metadata: StudentMetadata,
    val records: List<JsonedRecord>
)
