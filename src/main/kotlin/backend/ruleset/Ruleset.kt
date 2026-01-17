package tech.cpstudio.backend.ruleset

import com.google.gson.GsonBuilder
import tech.cpstudio.backend.basicfunc.getWorkingDir
import java.io.File

/**
 * 规则集，用于管理对应班级的所有积分规则
 * @property rules 存储规则的Map，key为规则的uuid，value为规则对象
 * @property belongTo 所属的班级名称
 * @property ruleFactory 规则工厂，用于根据JsonedRule创建规则对象
 * @property resolve 将规则集从Json文件中读入
 * @property serialize 将规则集写入Json文件
 * @property addRule 添加规则
 * @property removeRule 删除规则
 */
class Ruleset(val belongTo: String) {
    private val rules = mutableMapOf<String, Rule>()

    init {
        resolve()
        if (rules.isEmpty()) {
            addRule(Praising())
            addRule(Caution())
            addRule(Prize())
        }
    }

    fun ruleFactory(jsoned: JsonedRule): Rule {
        return when (jsoned.type) {
            RuleType.PRAISING -> Praising(jsoned.uuid, jsoned.name, jsoned.score)
            RuleType.CAUTION -> Caution(jsoned.uuid, jsoned.name, jsoned.score)
            RuleType.PRIZE -> Prize(jsoned.uuid, jsoned.name, jsoned.score)
        }
    }

    fun resolve() {
        val gson = GsonBuilder()
            .create()

        val dataPath = "${getWorkingDir()}/data/$belongTo/ruleset/"
        val files = File(dataPath).listFiles()
        (files?.filter { it.isFile } ?: emptyList<File>()).forEach {
            val json = it.readText()
            val jsoned = gson.fromJson(json, JsonedRule::class.java)
            val rule = ruleFactory(jsoned)
            rules[rule.uuid] = rule
        }
    }

    fun serialize() {
        val gson = GsonBuilder()
            .create()

        val dataPath = "${getWorkingDir()}/data/$belongTo/ruleset/"
        rules.forEach { (_, rule) ->
            val jsoned = JsonedRule(rule.uuid, rule.name, rule.type, rule.score)
            val json = gson.toJson(jsoned)
            val file = File("$dataPath${rule.uuid}.json")
            file.writeText(json)
        }
    }

    fun addRule(rule: Rule) {
        rules[rule.uuid] = rule
    }

    fun removeRule(uuid: String) {
        rules.remove(uuid)
    }
}