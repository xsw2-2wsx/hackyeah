package com.xsw22wsx.hackyeah.instructions.tags.io.rest

import com.xsw22wsx.hackyeah.instructions.tags.TagService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tags")
class TagController(
    private val tagService: TagService,
) {

    @PostMapping("")
    suspend fun createTag(@RequestBody tag: String) = tagService.createTag(tag)

    @GetMapping("")
    suspend fun findTagsForInput(@RequestParam("q") query: String) = tagService.findTagsForInput(query)

}