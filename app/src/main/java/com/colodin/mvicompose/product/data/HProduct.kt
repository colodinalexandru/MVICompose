package com.colodin.mvicompose.product.data

interface HProduct {
    /**
     *
     * [HProductImpl.getImagesWithoutThumbnail]
     */
    fun getImagesWithoutThumbnail(images: List<String>): List<String>
}