package io.github.memydb.data.entities.contents

data class ImageContent(val url: String) : Content() {

    override fun getContentType() = Type.IMAGE
}
