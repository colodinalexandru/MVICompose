package com.colodin.mvicompose.product.domain

import com.colodin.mvicompose.services.data.SProductFull
import com.colodin.mvicompose.services.data.SProductShort

interface RepositoryProductHelper {

    var productShorts:  List<SProductShort>?

    var productFull: SProductFull?
}