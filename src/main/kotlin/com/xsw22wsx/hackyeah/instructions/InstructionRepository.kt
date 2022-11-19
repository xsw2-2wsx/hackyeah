package com.xsw22wsx.hackyeah.instructions

interface InstructionRepository {

    suspend fun saveInstruction(newInstruction: Instruction)

    suspend fun findInstructions(limit: Int, offset: Int): List<Instruction>

    suspend fun findInstruction(id: Int): Instruction?

    suspend fun findAllInstructions(): List<Instruction>

    suspend fun deleteInstruction(instructionId: Int)

    suspend fun updateInstruction(instruction: Instruction)

}