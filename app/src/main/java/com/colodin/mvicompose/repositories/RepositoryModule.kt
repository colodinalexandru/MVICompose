package com.colodin.mvicompose.repositories

import com.colodin.mvicompose.dummy.impls.ServiceProductImpl
import com.colodin.mvicompose.repositories.product.RepositoryProduct
import com.colodin.mvicompose.repositories.product.RepositoryProductImpl
import com.colodin.mvicompose.services.ServiceProduct
import org.koin.dsl.module

val RepositoryModule = module {

    single<ServiceProduct> { ServiceProductImpl() }

    single<RepositoryProduct> { RepositoryProductImpl() }
}