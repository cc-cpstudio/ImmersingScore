package tech.cpstudio.backend.ruleset

/**
 * JsonedRecordable类，用来序列、反序列化Recordable类
 * @see tech.cpstudio.backend.ruleset.Rule
 */
data class JsonedRule(
    val uuid: String,
    val name: String,
    val type: RuleType,
    val score: Int
)
