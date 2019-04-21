package io.github.memydb.data.pojos.contents

abstract class Content {

    lateinit var contentType: Type

    enum class Type {
        IMAGE, VIDEO, GALLERY, CAPTIONED_GALLERY, GIF, PREVIEW, TEXT
    }

}
