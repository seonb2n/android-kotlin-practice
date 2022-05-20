package com.example.kotlinapplication.di

import com.example.kotlinapplication.data.repository.TestToDoRepository
import com.example.kotlinapplication.data.repository.ToDoRepository
import com.example.kotlinapplication.domain.todo.GetToDoListUseCase
import com.example.kotlinapplication.domain.todo.InsertToDoListUseCase
import com.example.kotlinapplication.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    //ViewModel
    viewModel { ListViewModel(get()) }

    //UseCase
    factory { GetToDoListUseCase(get()) }

    factory { InsertToDoListUseCase(get()) }

    //Repository
    single<ToDoRepository> { TestToDoRepository() }
}