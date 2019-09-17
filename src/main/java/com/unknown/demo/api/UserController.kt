package com.unknown.demo.api

import com.unknown.demo.dto.IsPhoneNoExist
import com.unknown.demo.model.User
import com.unknown.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    @RequestMapping(value = ["api/v1/user"], method = [RequestMethod.POST])
    fun insertUser(@RequestBody user: User): HttpStatus {
        val userResp = userService.insertUser(user)
        return if (userResp != null) HttpStatus.ACCEPTED else HttpStatus.BAD_GATEWAY
    }

    @RequestMapping(value = ["api/v1/users"], method = [RequestMethod.GET])
    fun getAllUsers(): List<User> {
        return userService.showAll()
    }

    @RequestMapping(value = ["api/v1/user/is_phone_no_exist"], method = [RequestMethod.GET])
    fun findPhoneNumberIsExist(@RequestParam("phoneNo") phoneNo: String): IsPhoneNoExist {
        return IsPhoneNoExist(userService.isPhoneNoIsExist(phoneNo))
    }
}