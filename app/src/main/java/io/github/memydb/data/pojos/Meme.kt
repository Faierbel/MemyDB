package io.github.memydb.data.pojos

import io.github.memydb.data.pojos.contents.Content
import java.io.Serializable

data class Meme(
    val title: String,

    val content: Content,

    val url: String,

    val viewUrl: String,

    val author: Author,

    val comments: List<Comment>,

    val tags: List<Tag>,

    val description: String,

    val commentAmount: Int,

    val points: Int
) : Serializable
