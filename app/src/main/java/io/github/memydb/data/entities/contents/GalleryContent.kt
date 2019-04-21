package io.github.memydb.data.entities.contents

data class GalleryContent(val urls: List<String>) : Content() {

    override fun getContentType() = Type.GALLERY
}
