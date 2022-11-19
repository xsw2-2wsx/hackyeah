package com.xsw22wsx.hackyeah.instructions.ratings

import org.springframework.stereotype.Service
import kotlin.math.roundToInt

@Service
class RatingService(
    private val ratingRepository: RatingRepository,
) {


    suspend fun addRating(rating: Rating) {
        ratingRepository.saveRating(rating)
    }


    suspend fun averageRatingForInstruction(instructionId: Int): Double? {
        val ratings = ratingRepository.findRatingsForInstruction(instructionId)

        if(ratings.isEmpty()) return null

        return (ratings.map { it.rating }.average() * 10).roundToInt().toDouble() / 10
    }

    suspend fun getRatingsForInstruction(instructionId: Int) = ratingRepository.findRatingsForInstruction(instructionId)

}