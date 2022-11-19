package com.xsw22wsx.hackyeah.instructions.tags.io.storage

import com.xsw22wsx.hackyeah.instructions.tags.TagRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class InMemoryTagRepository : TagRepository {

    private val tags: MutableList<String> = LinkedList()

    override suspend fun createTag(newTag: String) {
        if(newTag !in tags) tags.add(newTag)
    }

    override suspend fun findTagsForInput(input: String): List<String> = tags
        .filter { it.contains(input) }
}