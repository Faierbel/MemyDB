package io.github.memydb.data.entities

import io.github.memydb.data.entities.contents.Content

data class Meme(
    val title: String,

    val content: List<Content>,

    val url: String,

    val viewUrl: String,

    val author: Author,

    val comments: List<Comment>,

    val tags: List<Tag>,

    val description: String,

    val commentAmount: Int,

    val points: Int
)
