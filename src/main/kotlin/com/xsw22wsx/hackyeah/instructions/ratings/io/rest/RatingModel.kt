package com.xsw22wsx.hackyeah.instructions.ratings.io.rest

data class RatingModel(
    val userId: Int,
    val rating: Int,
    val comment: String,
)