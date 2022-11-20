package com.xsw22wsx.hackyeah.instructions.ratings.io.rest

import com.xsw22wsx.hackyeah.instructions.ratings.Rating
import com.xsw22wsx.hackyeah.instructions.ratings.RatingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/instructions/{instructionId}/ratings")
class RatingController(
    private val ratingService: RatingService,
) {

    @PostMapping
    suspend fun addRating(
        @RequestBody rm: RatingModel,
        @PathVariable("instructionId") instructionId: Int,
    ) =
        ratingService.addRating(Rating(rm.userId, instructionId, rm.rating, rm.comment))

    @GetMapping
    suspend fun getRatings(
        @PathVariable("instructionId") instructionId: Int,
    ) = ratingService.getRatingsForInstruction(instructionId)

    @GetMapping("/average")
    suspend fun getAverageRating(
        @PathVariable("instructionId") instructionId: Int,
    ) = ratingService.averageRatingForInstruction(instructionId)
}