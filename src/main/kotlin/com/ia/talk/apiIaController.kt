package com.ia.talk

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/ia")
class apiIaController {

    @Autowired
    lateinit var apiIaService: ApiIaService

    @PostMapping("/talk")
    fun resposeIa(@RequestBody question : String):ResponseEntity<Any>{
        val resp = apiIaService.obtenerRespuestaOpenAI(question)
        return ResponseEntity(resp,HttpStatus.OK)
    }
}