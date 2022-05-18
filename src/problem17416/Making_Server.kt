package problem17416

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val r = BufferedReader(InputStreamReader(System.`in`))
    val w = BufferedWriter(OutputStreamWriter(System.out))

    class IP {
        var data: String? = null
        var redirectIP: String? = null
    }

    fun String.isIP(): Boolean {
        this.split('.').apply {
            if (size != 4) return false
            forEach {
                it.toIntOrNull() ?: return false
            }

        }
        return true
    }

    fun String.isCorrectIP(): Boolean {
        this.split('.').apply {
            if (size != 4) return false
            forEach {
                val num = it.toIntOrNull() ?: return false
                if (num < 0 || num > 255) return false
            }
        }
        return true
    }

    class Server {
        private val ipList = emptyMap<String, IP>().toMutableMap()
        private val urlList = emptyMap<String, String>().toMutableMap()

        fun setURL(url: String, ipAddress: String) {
            urlList[url] = ipAddress
        }

        fun setData(ipAddress: String, data: String?) {
            if (ipList[ipAddress] == null) {
                ipList[ipAddress] = IP().apply {
                    this.data = data
                }
            } else {
                ipList[ipAddress]!!.data = data
            }
        }

        fun redirect(ip: String, toIP: String) {
            if (ipList[ip] == null) {
                ipList[ip] = IP().apply {
                    this.redirectIP = toIP
                }
                ipList[toIP]!!.data = null
            } else {
                ipList[ip]!!.apply {
                    redirectIP = toIP
                    setData(toIP, data)
                }
            }
        }

        fun getData(ipOrUrl: String): String {
            return if (ipOrUrl.isIP()) {
                getDataByIP(ipOrUrl)
            } else {
                var ipAddress = urlList[ipOrUrl]

                if (ipAddress == null) {
                    ipAddress = urlList["www.$ipOrUrl"] ?: throw IllegalArgumentException("404 Not Found")
                }
                try {
                    getDataByIP(ipAddress)
                } catch (e: IllegalArgumentException) {
                    getDataByIP(urlList["www.$ipOrUrl"] ?: throw IllegalArgumentException("404 Not Found"))
                }
            }
        }

        private fun getDataByIP(ipAddress: String): String {
            return if (ipAddress.isCorrectIP()) {
                val ip = ipList[ipAddress]
                if (ip == null) {
                    throw IllegalArgumentException("404 Not Found")
                } else {
                    if (ip.redirectIP == null) {
                        ip.data ?: throw IllegalArgumentException("404 Not Found")
                    } else {
                        getDataByIP(ip.redirectIP!!)
                    }
                }
            } else {
                throw IllegalArgumentException("400 Bad Request")
            }
        }
    }


    val server = Server()

    repeat(r.readLine().toInt()) {
        StringTokenizer(r.readLine()).apply {
            when (nextToken()) {
                "URL" -> {
                    val url = nextToken()
                    val linkedIp = nextToken()
                    server.setURL(url, linkedIp)
                }
                "IP" -> {
                    val ip = nextToken()
                    val data = nextToken()
                    server.setData(ip, data)
                }
                "REDIRECT" -> {
                    val ip = nextToken()
                    val toIp = nextToken()
                    server.redirect(ip, toIp)
                }
                "HTTP" -> {
                    val ipOrUrl = nextToken()
                    w.write("HTTP ")
                    w.write(
                        try {
                            "200 OK\nRequested Data : ${server.getData(ipOrUrl)}\n"
                        } catch (e: IllegalArgumentException) {
                            "${e.message}\n"
                        }
                    )
                }
            }
        }
    }
    w.flush()
}

