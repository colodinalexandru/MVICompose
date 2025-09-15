package com.colodin.mvicompose.product.data

class HProductImpl : HProduct {

    override fun getImagesWithoutThumbnail(images: List<String>): List<String> {

        return images.filter { !it.contains("thumbnail") }
    }
}