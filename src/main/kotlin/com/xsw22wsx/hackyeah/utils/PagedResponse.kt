package com.xsw22wsx.hackyeah.utils

data class PagedResponse<T>(
    private val numPages: Int,
    private val entries: Collection<T>
)

fun <T> Collection<T>.paged(numPages: Int) = PagedResponse(numPages, this)