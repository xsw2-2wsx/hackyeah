package com.xsw22wsx.hackyeah.users.io

import com.xsw22wsx.hackyeah.users.User

interface UserRepository {

    suspend fun saveUser(user: User)

}