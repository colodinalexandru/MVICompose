package com.colodin.mvicompose.dummy.adapter

import com.colodin.mvicompose.dummy.data.DProductModel
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class JSONDProductModelAdapter : JsonDeserializer<DProductModel> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext): DProductModel {
        val jsonObject = json.asJsonObject
        val id = jsonObject.getIntField("id")!!
        val title = jsonObject.getStringField("title")!!
        val description = jsonObject.getStringField("description")!!
        val price = jsonObject.getDoubleField("price")!!
        val discountPercentage = jsonObject.getDoubleField("discountPercentage")!!
        val rating = jsonObject.getDoubleField("rating")!!
        val stock = jsonObject.getIntField("stock")!!
        val category = jsonObject.getStringField("category")!!
        val thumbnail = jsonObject.getStringField("thumbnail")!!
        val token = object : TypeToken<List<String>>() {}.type
        val images = context.deserialize<List<String>>(jsonObject.getAsJsonArray("images"),token )

        return DProductModel(
            id = id,
            title = title,
            description = description,
            price = price,
            discountPercentage = discountPercentage,
            rating = rating,
            stock = stock,
            category = category,
            thumbnail = thumbnail,
            images = images
        )
    }
}