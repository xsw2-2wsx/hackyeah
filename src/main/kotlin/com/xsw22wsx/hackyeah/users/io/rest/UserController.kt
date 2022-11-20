package com.xsw22wsx.hackyeah.users.io.rest

import com.xsw22wsx.hackyeah.users.User
import com.xsw22wsx.hackyeah.users.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    suspend fun addUser(
        @RequestBody user: User
    ) = userService.addUser(user)

    @GetMapping("/{id}")
    suspend fun getUserById(@PathVariable("id") id: Int): User? =
        userService.getUserById(id)

}