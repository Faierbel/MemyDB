package io.github.memydb.data.entities.contents

abstract class Content {

    abstract fun getContentType(): Type

    enum class Type {
        IMAGE, VIDEO, GALLERY, CAPTIONED_GALLERY, GIF, PREVIEW, TEXT
    }

}
