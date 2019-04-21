package io.github.memydb.data.entities

data class Page(
    val title: String,

    val memes: List<Meme>,

    val nextPage: String
)
