package com.example.meyman.data.remote

import okhttp3.*

class WebSocketClient {
    private val client = OkHttpClient()

    fun connectWebSocket() {
        val request = Request.Builder()
            .url("ws://b0ca-109-201-165-30.ngrok-free.app/ws/notification") // Замените на ваш адрес WebSocket-сервера
            .build()

        val socketListener = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                println("WebSocket connection opened")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                println("Received message: $text")
                // Здесь обрабатывайте полученные уведомления
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                println("WebSocket connection closed")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                println("WebSocket connection failure: ${t.message}")
            }
        }

        val webSocket = client.newWebSocket(request, socketListener)

        // Для закрытия соединения (например, при завершении приложения)
        // webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye")
    }
}