package com.ia.talk

import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import org.springframework.stereotype.Service

@Service
class ApiIaService {

    val openAiApiKey = "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"
    val openAiApiUrl = "https://api.openai.com/v1/engines/davinci/completions"

    // Función para realizar la solicitud a OpenAI
    fun obtenerRespuestaOpenAI(prompt: String): ResponseModel {
        println(prompt)
        val requestBody = "{\"prompt\": $prompt}"
        val respuesta: HttpResponse<JsonNode> = Unirest.post(openAiApiUrl)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer $openAiApiKey")
            .body(requestBody)
            .asJson()

        println(requestBody)

        val response = ResponseModel(
            response = respuesta.body.toString(),
            resul = true
        )

        return response
    }
}