package io.github.memydb.data.pojos

data class Page(
    val title: String,

    val memes: List<Meme>,

    val nextPage: String
)
