package com.colodin.mvicompose.dummy.adapter

import com.google.gson.JsonNull
import com.google.gson.JsonObject
import com.google.gson.JsonParseException

@Throws(JsonParseException::class)
fun JsonObject.getStringField(field: String, optional: Boolean = false): String? {

    if (this.has(field)) {
        val test = this.get(field) !is JsonNull
        if (test) {
            return this.getAsJsonPrimitive(field).asString
        }
    }

    if (optional) {
        return null
    }

    throw JsonParseException("Json object: $this does not have field : $field ")
}


@Throws(JsonParseException::class, NumberFormatException::class)
fun JsonObject.getIntField(field: String, optional: Boolean = false): Int? {

    if (this.has(field)) {
        val test = this.get(field) !is JsonNull
        if (test) {
            return this.getAsJsonPrimitive(field).asInt
        }

    }

    if (optional) {
        return null
    }

    throw JsonParseException("Json object: $this does not have field : $field ")
}

@Throws(JsonParseException::class, NumberFormatException::class)
fun JsonObject.getDoubleField(field: String, optional: Boolean = false): Double? {

    if (this.has(field)) {
        val test = this.get(field) !is JsonNull
        if (test) {
            return this.getAsJsonPrimitive(field).asDouble
        }

    }

    if (optional) {
        return null
    }

    throw JsonParseException("Json object: $this does not have field : $field ")
}