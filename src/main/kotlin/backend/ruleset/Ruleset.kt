package tech.cpstudio.backend.ruleset

import com.google.gson.GsonBuilder
import tech.cpstudio.backend.basicfunc.getUserDataLocation
import java.io.File

/**
 * 规则集，用于管理对应班级的所有积分规则
 */
object Ruleset {
    val ruleset: MutableSet<Recordable> = mutableSetOf()

    fun resolve(className: String) {
        val file = File(getUserDataLocation() + "/classes/$className/ruleset.json")

        val gson = GsonBuilder()
            .create()
        val json = file.readText()
        val ruleset = gson.fromJson(json, JsonedRuleset::class.java)
        ruleset.rules.forEach {

        }
    }
}