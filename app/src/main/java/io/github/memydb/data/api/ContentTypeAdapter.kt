package io.github.memydb.data.api

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import io.github.memydb.data.pojos.contents.*
import io.github.memydb.data.pojos.contents.Content.Type.*
import java.lang.reflect.Type

class ContentTypeAdapter : JsonDeserializer<Content> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Content {
        val classType = when (valueOf(json.asJsonObject.get("contentType").asString)) {
            IMAGE -> ImageContent::class.java
            CAPTIONED_GALLERY -> CaptionedGalleryContent::class.java
            TEXT -> TextContent::class.java
            GIF -> GIFContent::class.java
            VIDEO -> VideoContent::class.java
            PREVIEW -> PreviewContent::class.java
            GALLERY -> GalleryContent::class.java
        }
        return context.deserialize(json, classType)
    }
}
