package com.example.learnical.core.user

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl : UserService {

    //TODO currently assumes there is only one logged in user. implement this once there is a persistence layer and authentication mechanism
    override fun getLoggedInUser(): User {
        return UserServiceImpl.user
    }

    companion object {
        val user : User = User(UUID.randomUUID())
    }
}