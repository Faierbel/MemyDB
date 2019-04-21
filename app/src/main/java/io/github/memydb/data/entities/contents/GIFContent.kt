package io.github.memydb.data.entities.contents

data class GIFContent(val url: String) : Content() {

    override fun getContentType() = Type.GIF
}
