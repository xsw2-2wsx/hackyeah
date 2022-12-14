package com.xsw22wsx.hackyeah.instructions.io.storage

import com.xsw22wsx.hackyeah.instructions.Instruction
import com.xsw22wsx.hackyeah.instructions.InstructionRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class InMemoryInstructionRepository : InstructionRepository {

    private val instructions: MutableCollection<Instruction> = LinkedList()

    private val instructionIds: Iterator<Int> = generateSequence(0) { it + 1 }.iterator()

    @Synchronized fun generateId(): Int = instructionIds.next()


    override suspend fun saveInstruction(newInstruction: Instruction) {
        newInstruction.id = generateId()
        instructions.add(newInstruction)
    }

    override suspend fun findInstructionsPaged(
        limit: Int,
        offset: Int,
        tags: List<String>?,
        category: List<Instruction.Category>?,
        query: String?,
    ): List<Instruction>  {
        val instructions: List<Instruction> = findInstructions(category, tags, query)

        return instructions
            .drop(offset)
            .take(limit)
    }

    private fun findInstructions(
        category: List<Instruction.Category>?,
        tags: List<String>?,
        query: String?
    ): List<Instruction> {
        var instructions: List<Instruction> = instructions.toList()

        if (!category.isNullOrEmpty()) instructions = instructions.filter { it.category in category }

        if (tags != null) instructions = instructions.sortedWith { i1, i2 ->
            tags.count { i2.tags.contains(it) } - tags.count { i1.tags.contains(it) }
        }

        if (query != null) instructions = instructions.filter {
            it.content.contains(query, true) || it.title.contains(query, true)
        }
        return instructions
    }

    override suspend fun getInstructionCount(
        tags: List<String>?,
        category: List<Instruction.Category>?,
        query: String?
    ): Int = findInstructions(category, tags, query).size

    override suspend fun findAllInstructions(): List<Instruction> = LinkedList(instructions)

    override suspend fun deleteInstruction(instructionId: Int) {
        instructions
            .removeIf { it.id == instructionId }
    }

    override suspend fun updateInstruction(instruction: Instruction) {
        deleteInstruction(instruction.id)
        instructions.add(instruction)
    }

    override suspend fun findInstruction(id: Int): Instruction? = instructions.firstOrNull { it.id == id }

}