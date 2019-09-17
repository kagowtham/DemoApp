package com.unknown.demo.service

import com.unknown.demo.model.User
import com.unknown.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun insertUser(user: User): User? {
        return userRepository.save(user)
    }

    fun showAll(): List<User> {
        return userRepository.findAll()
    }

    fun isPhoneNoIsExist(phoneNo: String): Boolean {
        return userRepository.phoneNo(phoneNo) != null
    }

}