package com.colodin.mvicompose.dummy.adapter

import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertTrue

class JSONExtensionsTest {
    @Test
    fun getStringField() {
        val json = JsonObject()
        json.add("s", JsonPrimitive("test"))
        val result = json.getStringField("s")
        assertTrue(result == "test")
    }

    @Test
    fun getStringFieldOptionalFalse() {
        val json = JsonObject()
        json.add("s", JsonPrimitive("test"))
        val result = json.getStringField("s", false)
        assertTrue(result == "test")
    }

    @Test
    fun getStringFieldOptionalTrue() {
        val json = JsonObject()
        val result = json.getStringField("s", true)
        assertTrue(result == null)
    }

    @Test
    fun getStringFieldThrows() {
        val json = JsonObject()
        val exception = Assert.assertThrows(JsonParseException::class.java) {
            json.getStringField("s", false)
        }
        assertTrue(exception is JsonParseException)
    }

    @Test
    fun getIntField() {
        val json = JsonObject()
        json.add("value", JsonPrimitive(1))
        val result = json.getIntField("value")
        Assert.assertTrue(result == 1)
    }

    @Test
    fun getIntFieldOptionalTrue() {
        val json = JsonObject()
        val result = json.getIntField("value",true)
        Assert.assertTrue(result == null)
    }

    @Test
    fun getIntFieldOptionalFalse() {
        val json = JsonObject()
        json.add("value", JsonPrimitive(1))
        val result = json.getIntField("value",false)
        Assert.assertTrue(result == 1)
    }

    @Test
    fun getIntFieldThrows() {
        val json = JsonObject()
        val exception = Assert.assertThrows(JsonParseException::class.java) {
            json.getIntField("value")
        }
        Assert.assertTrue(exception is JsonParseException)
    }

    @Test
    fun getDoubleField() {
        val json = JsonObject()
        json.add("value", JsonPrimitive(1))
        val result = json.getDoubleField("value")
        Assert.assertTrue(result == 1.0)
    }

    @Test
    fun getDoubleFieldOptionalTrue() {
        val json = JsonObject()
        val result = json.getDoubleField("value",true)
        Assert.assertTrue(result == null)
    }

    @Test
    fun getDoubleFieldOptionalFalse() {
        val json = JsonObject()
        json.add("value", JsonPrimitive(1))
        val result = json.getDoubleField("value",false)
        Assert.assertTrue(result == 1.0)
    }

    @Test
    fun getDoubleFieldThrows() {
        val json = JsonObject()
        val exception = Assert.assertThrows(JsonParseException::class.java) {
            json.getDoubleField("value")
        }
        Assert.assertTrue(exception is JsonParseException)
    }
}