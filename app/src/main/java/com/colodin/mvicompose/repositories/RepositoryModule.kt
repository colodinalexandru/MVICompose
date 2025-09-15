package com.colodin.mvicompose.repositories

import com.colodin.mvicompose.repositories.product.RepositoryProduct
import com.colodin.mvicompose.repositories.product.RepositoryProductImpl
import org.koin.dsl.module

val RepositoryModule = module {

    single<RepositoryProduct> { RepositoryProductImpl() }
}