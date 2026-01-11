package tech.cpstudio.backend.ruleset

/**
 * JsonedRecordable类，用来序列、反序列化Recordable类
 * @see tech.cpstudio.backend.ruleset.Recordable
 */
data class JsonedRecordable(
    val uuid: String,
    val name: String,
    val score: Int
)
