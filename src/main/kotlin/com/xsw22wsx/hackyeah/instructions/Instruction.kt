package com.xsw22wsx.hackyeah.instructions

data class Instruction(
    var id: Int,
    var creator: Int,
    var category: Category,
    var title: String,
    var tags: MutableList<String>,
    var additionalMaterials: MutableList<String>,
    var steps: MutableList<String>,
    var content: String,
    var images: List<String>,
    ) {
    enum class Category {
        DIY
    }
}