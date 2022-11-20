package com.xsw22wsx.hackyeah.users.io.data

import com.xsw22wsx.hackyeah.users.User
import com.xsw22wsx.hackyeah.users.io.UserRepository
import org.springframework.stereotype.Repository
import java.util.LinkedList


@Repository
class InMemoryUserRepository : UserRepository {

    private val users: MutableList<User> = LinkedList()

    private val userIds = generateSequence(0) { it + 1}.iterator()

    @Synchronized fun generateUserId() = userIds.next()


    override suspend fun saveUser(user: User) {
        user.id = generateUserId()
        users.add(user)
    }

    override suspend fun getUserById(id: Int): User? = users.firstOrNull { it.id == id }
}