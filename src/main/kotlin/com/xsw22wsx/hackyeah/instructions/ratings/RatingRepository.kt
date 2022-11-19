package com.xsw22wsx.hackyeah.instructions.ratings

interface RatingRepository {

    suspend fun saveRating(rating: Rating)

    suspend fun deleteRatingsForInstructions(instructionId: Int)

    suspend fun findRatingsForInstruction(instructionId: Int): List<Rating>

}