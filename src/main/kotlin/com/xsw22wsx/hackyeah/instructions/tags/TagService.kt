package com.xsw22wsx.hackyeah.instructions.tags

import org.springframework.stereotype.Service

@Service
class TagService(
    private val tagRepository: TagRepository
) {

    suspend fun createTag(tag: String) = tagRepository.createTag(tag)

    suspend fun findTagsForInput(input: String) = tagRepository.findTagsForInput(input)


}