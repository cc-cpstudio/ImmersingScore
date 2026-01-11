package tech.cpstudio.backend.student

import tech.cpstudio.backend.record.RecordList

class Student (val metadata: StudentMetadata, var records: RecordList) {
    constructor(metadata: StudentMetadata): this(metadata, RecordList(metadata))
}