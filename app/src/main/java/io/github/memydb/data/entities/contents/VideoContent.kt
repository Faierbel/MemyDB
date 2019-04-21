package io.github.memydb.data.entities.contents

data class VideoContent(val url: String) : Content() {

    override fun getContentType() = Type.VIDEO
}
