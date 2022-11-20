package com.xsw22wsx.hackyeah.utils

data class PagedResponse<T>(
    val totalEntries: Int,
    val content: Collection<T>
)

fun <T> Collection<T>.paged(numPages: Int) = PagedResponse(numPages, this)