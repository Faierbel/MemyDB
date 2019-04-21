package io.github.memydb.data.entities.contents

data class CaptionedGalleryContent(val images: List<CaptionedGallerySlide>) : Content() {

    override fun getContentType() = Type.CAPTIONED_GALLERY

    data class CaptionedGallerySlide(
        val url: String = "",

        val title: String = "",

        val caption: String = ""
    )
}
