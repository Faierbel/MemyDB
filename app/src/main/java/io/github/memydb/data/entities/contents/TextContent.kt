package io.github.memydb.data.entities.contents

data class TextContent(val content: String) : Content() {

    override fun getContentType() = Type.TEXT
}
