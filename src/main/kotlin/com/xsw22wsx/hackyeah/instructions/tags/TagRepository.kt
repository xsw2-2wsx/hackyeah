package com.xsw22wsx.hackyeah.instructions.tags

interface TagRepository {
    suspend fun createTag(newTag: String)

    suspend fun findTagsForInput(input: String): List<String>

}