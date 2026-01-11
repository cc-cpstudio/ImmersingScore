package tech.cpstudio.backend.student

/**
 * 学生元数据，用于识别、比对每一个学生
 * @property name 学生姓名
 * @property id 学生学号
 */
data class StudentMetadata(
    var name: String,
    var id: Int
)