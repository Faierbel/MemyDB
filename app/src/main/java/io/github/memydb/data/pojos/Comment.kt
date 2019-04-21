package io.github.memydb.data.pojos

data class Comment(
    val content: String,

    val author: Author,

    val responses: List<Comment>,

    val points: Int,

    val isReply: Boolean = false
)
