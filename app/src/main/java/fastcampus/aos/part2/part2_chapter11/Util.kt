package fastcampus.aos.part2.part2_chapter11

import android.content.Context
import com.google.gson.Gson
import java.io.IOException

fun <T> Context.readData(fileName: String, classT: Class<T>): T? {

    return try {
        val inputStream = this.resources.assets.open(fileName)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()

        val gson = Gson()
        gson.fromJson(String(buffer), classT)
    } catch (e: IOException) {
        null
    }
}

//fun Context.readData(): Home? {
//
//    return try {
//        val inputStream = this.resources.assets.open("home.json")
//        val buffer = ByteArray(inputStream.available())
//        inputStream.read(buffer)
//        inputStream.close()
//
//        val gson = Gson()
//        gson.fromJson(String(buffer), Home::class.java)
//    } catch (e: IOException) {
//        null
//    }
//}