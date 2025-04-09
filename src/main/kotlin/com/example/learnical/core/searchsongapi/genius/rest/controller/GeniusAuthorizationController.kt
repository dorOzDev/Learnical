package com.example.learnical.core.searchsongapi.genius.rest.controller

import com.example.learnical.core.common.logger
import com.example.learnical.core.searchsongapi.AuthorizationToken
import com.example.learnical.core.searchsongapi.genius.model.GeniusJWT
import com.example.learnical.core.searchsongapi.genius.rest.service.GeniusAuthorizationControllerService
import com.example.learnical.core.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/genius")
class GeniusAuthorizationController(val controllerService : GeniusAuthorizationControllerService, val userService: UserService) {

    val LOGGER by logger()

    @GetMapping("/generatecodecallback")
    fun generatedCodeCallBack(@RequestParam(value = "code") code : String, @RequestParam(value = "state") state : String) : ResponseEntity<out Any> {
        TODO("not implemented")
    }

    @PostMapping("/addcredential")
    fun addGeniusCredential(@RequestBody geniusJWT : GeniusJWT) : ResponseEntity<out Any> {
        return storeUserCredential(geniusJWT)
    }

    private fun storeUserCredential(geniusJWT : GeniusJWT) : ResponseEntity<out Any> {
        try {
            controllerService.storeAuthorizationToken(userService.getLoggedInUser(), geniusJWT)
        } catch (e : Exception) {
            LOGGER.error("something went wrong storing the token: ${e.message}")
            return ResponseEntity.badRequest().build()
        }
        return ResponseEntity.ok().build()
    }


}