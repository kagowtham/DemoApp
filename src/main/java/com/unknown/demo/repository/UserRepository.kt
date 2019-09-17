package com.unknown.demo.repository

import com.unknown.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
    fun phoneNo(phoneNo: String): User?
}