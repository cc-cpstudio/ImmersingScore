package tech.cpstudio.backend.basicfunc

import oshi.SystemInfo
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * U盘信息工具类，支持 Windows/macOS/Linux 的U盘信息获取
 * @author cc-cpstudio
 */
object UsbDriverDetector {
    val os = SystemInfo().operatingSystem

    /**
     * U盘信息数据类，用于方便查看和管理U盘信息
     * @property devicePath 设备路径
     * @property volumeName 卷名
     */
    data class UsbDriveInfo(
        val devicePath: String,
        val volumeName: String
    )

    /**
     * 获取所有已插入的U盘信息，根据系统调用不同的函数实现
     * @return 已插入的U盘信息列表
     */
    fun getUsbDrives(): List<UsbDriveInfo> {
        return when (os.family) {
            "Windows" -> getFromWindows()
            else -> throw NotImplementedError("Not implemented for ${os.family}")
        }
    }

    private fun getFromWindows(): List<UsbDriveInfo> {
        val usbDrives = mutableListOf<UsbDriveInfo>()
        val process = Runtime.getRuntime().exec(
            "wmic logicaldick where drivetype=2 get deviceid, volumename /format:csv"
        )
        BufferedReader(InputStreamReader(process.inputStream, "GBK")).use { reader ->
            var line: String?
            var isFirstLine = true
            while (reader.readLine().also { line = it } != null) {
                if (isFirstLine) {
                    isFirstLine = false
                    continue
                }
                val parts = line?.split(",")?.map { it.trim() } ?: emptyList()
                if (parts.size >= 2) {
                    val devicePath = parts[0]
                    val volumeName = parts[1]
                    if (devicePath.isNotBlank()) {
                        usbDrives.add(UsbDriveInfo(devicePath, volumeName))
                    }
                }
            }
        }
        process.waitFor()
        return usbDrives
    }
    // TODO: 差macOS和Linux
}