package com.xsw22wsx.hackyeah.instructions.ratings

data class Rating(
    val userId: Int,
    val instructionId: Int,
    val rating: Int,
    val comment: String,
)