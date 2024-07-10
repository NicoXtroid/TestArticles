package com.example.testnote

import android.content.Context
import java.io.*

object ConvertToString {
    @Throws(IOException::class)
    fun convertStreamToString(`is`: InputStream): String {
        val writer: Writer = StringWriter()
        val buffer = CharArray(2048)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(`is`, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        } finally {
            `is`.close()
        }
        return writer.toString()
    }
}

fun readJsonFromAssets(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}