package io.github.memydb.data.pojos.contents

data class CaptionedGalleryContent(val images: List<CaptionedGallerySlide>) : Content() {

    data class CaptionedGallerySlide(
        val url: String = "",

        val title: String = "",

        val caption: String = ""
    )
}
