package tech.cpstudio.backend.student

import tech.cpstudio.backend.record.RecordList

/**
 * 学生类，用于存储学生信息
 * @property metadata 学生信息
 * @property records 学生记录
 */
class Student (val metadata: StudentMetadata, var records: RecordList) {
    constructor(metadata: StudentMetadata): this(metadata, RecordList(metadata))
}