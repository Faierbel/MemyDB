package io.github.memydb.data.entities.contents

data class PreviewContent(val url: String) : Content() {

    override fun getContentType() = Type.PREVIEW
}
