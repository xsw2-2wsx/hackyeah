package com.xsw22wsx.hackyeah.users

import com.xsw22wsx.hackyeah.users.io.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    suspend fun addUser(user: User) = userRepository.saveUser(user)
    suspend fun getUserById(id: Int): User? =
        userRepository.getUserById(id)
}