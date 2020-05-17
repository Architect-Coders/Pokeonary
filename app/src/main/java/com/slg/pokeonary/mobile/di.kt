package com.slg.pokeonary.mobile

import android.app.Application
import com.slg.pokeonary.data.repository.common.WebServiceProvider
import com.slg.pokeonary.data.repository.pokemon.PokemonDataRepository
import com.slg.pokeonary.data.repository.pokemon.dataSource.PokemonDataSource
import com.slg.pokeonary.data.repository.pokemon.dataSource.remote.PokemonApi
import com.slg.pokeonary.data.repository.pokemon.dataSource.remote.PokemonRemoteDataSource
import com.slg.pokeonary.domain.pokemon.PokemonRepository
import com.slg.pokeonary.domain.pokemon.useCase.GetPokemonList
import com.slg.pokeonary.mobile.pokemonList.PokemonListFragment
import com.slg.pokeonary.mobile.pokemonList.PokemonListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDi() {
    startKoin {
        printLogger()
        androidContext(this@initDi)
        modules(listOf(appModule, dataModule))
    }
}

private val dataModule = module {
    single(named("baseUrl")) { "https://pokeapi.co/" }
    single { WebServiceProvider(get(named("baseUrl"))) }
    single { get<WebServiceProvider>().getWebService(PokemonApi::class.java) }
    factory<PokemonDataSource> { PokemonRemoteDataSource(get()) }
    factory<PokemonRepository> { PokemonDataRepository(get()) }
}

private val appModule = module {
    scope(named<PokemonListFragment>()) {
        viewModel { PokemonListViewModel(get()) }
        scoped { GetPokemonList(get()) }
    }
}
