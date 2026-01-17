package tech.cpstudio.backend.ruleset

/**
 * JsonedRuleset类，用于序列、反序列化Ruleset类
 * @see tech.cpstudio.backend.ruleset.Ruleset
 */
data class JsonedRuleset(
    val className: String,
    val rules: List<JsonedRule>
)
