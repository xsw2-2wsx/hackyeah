package com.xsw22wsx.hackyeah.instructions

import org.springframework.stereotype.Service

@Service
class InstructionService(
    private val instructionRepository: InstructionRepository,
) {

    suspend fun saveInstruction(instruction: Instruction) {
        instructionRepository.saveInstruction(instruction)
    }

    suspend fun getInstructions(page: Int, count: Int, tags: List<String>?, category: List<Instruction.Category>?, query: String?) =
        instructionRepository.findInstructionsPaged(count, count * page, tags, category, query)

    suspend fun getInstructionCount(tags: List<String>?, category: List<Instruction.Category>?, query: String?): Int =
        instructionRepository.getInstructionCount(tags, category, query)

    suspend fun getInstructionById(id: Int): Instruction? = instructionRepository.findInstruction(id)

    suspend fun deleteInstructionById(id: Int) = instructionRepository.deleteInstruction(id)

}