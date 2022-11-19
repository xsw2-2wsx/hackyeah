package com.xsw22wsx.hackyeah.instructions

import org.springframework.stereotype.Service

@Service
class InstructionService(
    private val instructionRepository: InstructionRepository,
) {

    suspend fun saveInstruction(instruction: Instruction) {
        instructionRepository.saveInstruction(instruction)
    }

    suspend fun getInstructions(page: Int, count: Int) =
        instructionRepository.findInstructions(count, count * page)

    suspend fun getInstructionById(id: Int): Instruction? = instructionRepository.findInstruction(id)

    suspend fun deleteInstructionById(id: Int) = instructionRepository.deleteInstruction(id)

}