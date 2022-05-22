package com.example.kotlinapplication.di

import com.example.kotlinapplication.data.repository.TestToDoRepository
import com.example.kotlinapplication.data.repository.ToDoRepository
import com.example.kotlinapplication.domain.todo.*
import com.example.kotlinapplication.presentation.detail.DetailMode
import com.example.kotlinapplication.presentation.detail.DetailViewModel
import com.example.kotlinapplication.presentation.list.ListViewModel
import org.koin.android.experimental.dsl.viewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    //ViewModel
    viewModel { ListViewModel(get(), get(), get()) }
    viewModel { (detailMode: DetailMode, id: Long) ->
        DetailViewModel(
            detailMode = detailMode,
            id = id,
            get(),
            get(),
            get()
        )
    }

    //UseCase
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { InsertToDoItemUseCase(get()) }
    factory { UpdateToDoUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get()) }
    factory { DeletelToDoItemUseCase(get()) }

    //Repository
    single<ToDoRepository> { TestToDoRepository() }
}