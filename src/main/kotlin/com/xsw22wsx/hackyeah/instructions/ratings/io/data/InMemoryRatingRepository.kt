package com.xsw22wsx.hackyeah.instructions.ratings.io.data

import com.xsw22wsx.hackyeah.instructions.ratings.Rating
import com.xsw22wsx.hackyeah.instructions.ratings.RatingRepository
import org.springframework.stereotype.Repository
import java.util.LinkedList

@Repository
class InMemoryRatingRepository : RatingRepository {

    private val ratings: MutableList<Rating> = LinkedList()

    override suspend fun saveRating(rating: Rating) {
        ratings.add(rating)
    }

    override suspend fun deleteRatingsForInstructions(instructionId: Int) {
        ratings.removeIf { it.instructionId == instructionId }
    }

    override suspend fun findRatingsForInstruction(instructionId: Int): List<Rating> = ratings
        .filter { it.instructionId == instructionId }
}