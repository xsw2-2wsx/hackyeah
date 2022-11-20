package com.xsw22wsx.hackyeah.instructions

interface InstructionRepository {

    suspend fun saveInstruction(newInstruction: Instruction)

    suspend fun findInstructionsPaged(
        limit: Int,
        offset: Int,
        tags: List<String>?,
        category: List<Instruction.Category>?,
        query: String?
    ): List<Instruction>

    suspend fun getInstructionCount(
        tags: List<String>?,
        category: List<Instruction.Category>?,
        query: String?
    ): Int

    suspend fun findInstruction(id: Int): Instruction?

    suspend fun findAllInstructions(): List<Instruction>

    suspend fun deleteInstruction(instructionId: Int)

    suspend fun updateInstruction(instruction: Instruction)

}