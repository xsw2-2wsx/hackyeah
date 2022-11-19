package com.xsw22wsx.hackyeah.instructions.io.rest

import com.xsw22wsx.hackyeah.instructions.Instruction
import com.xsw22wsx.hackyeah.instructions.InstructionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/instructions")
class InstructionController(
    private val instructionService: InstructionService,
) {

    @PostMapping
    suspend fun createInstruction(@RequestBody instruction: Instruction) {
        instructionService.saveInstruction(instruction)
    }

    @GetMapping
    suspend fun getInstructions(
        @RequestParam("page") page: Int,
        @RequestParam("count") count: Int,
        @RequestParam("tags", required = false) tagsParam: String?,
        @RequestParam("category", required = false) categoryParam: String?,

    ): List<Instruction> {
        val tags = tagsParam?.split(",")
        val category = categoryParam?.split(",")?.map { Instruction.Category.valueOf(it) }

        return instructionService.getInstructions(page, count, tags, category)
    }


    @GetMapping("/{id}")
    suspend fun getInstructionById(
        @PathVariable("id") id: Int,
    ): Any = instructionService.getInstructionById(id)?: ResponseEntity.notFound().build<Unit>()

    @DeleteMapping("/{id}")
    suspend fun deleteInstructionById(
        @PathVariable("id") id: Int,
    ) =
        instructionService.deleteInstructionById(id)


}