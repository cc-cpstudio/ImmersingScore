package tech.cpstudio.backend.synchronizer

import backend.synchronizer.ThisHasInitialized
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/**
 * 同步工具箱，为分值同步系统提供必要的工具和事件
 * @property findClass 查找U盘内是否有某班级的同步文件夹
 * @author cc-cpstudio
 */
object SynchronizeToolKit {
    private lateinit var channel: Channel<String>
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var isInitialized = false

    fun init(channel: Channel<String>) {
        if (!isInitialized) {
            this.channel = channel
            isInitialized = true
        } else {
            throw ThisHasInitialized()
        }
    }

    fun start() {
        check(isInitialized) { "Oi，这玩意还没初始化！" }
        scope.launch {
            while (isActive) {
                // TODO: 添加事件处理逻辑
                delay(1000)
            }
        }
    }
}