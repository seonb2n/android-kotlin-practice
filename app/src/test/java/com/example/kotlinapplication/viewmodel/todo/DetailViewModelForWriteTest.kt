package com.example.kotlinapplication.viewmodel.todo

import com.example.kotlinapplication.data.entity.ToDoEntity
import com.example.kotlinapplication.viewmodel.ViewModelTest
import com.example.kotlinapplication.presentation.detail.DetailMode
import com.example.kotlinapplication.presentation.detail.DetailViewModel
import com.example.kotlinapplication.presentation.detail.ToDoDetailState
import com.example.kotlinapplication.presentation.list.ListViewModel
import com.example.kotlinapplication.presentation.list.ToDoListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.test.inject

/**
[DetailViewModelForWriteTest] 을 테스트
1. test viewModel fetch
2. test insert
 **/
@ExperimentalCoroutinesApi
internal class DetailViewModelForWriteTest: ViewModelTest() {

    private val id = 0L
    private val detailViewModel by inject<DetailViewModel> { parametersOf(DetailMode.WRITE, id) }
    private val listViewModel by inject<ListViewModel>()

    private val todo = ToDoEntity(
        id  = id,
        title = "title $id",
        description = "description $id",
        hasCompleted = false
    )

    @Test
    fun `test viewModel fetch`() = runBlockingTest {
        val testObservable = detailViewModel.todoDetailLiveData.test()
        detailViewModel.fetchData()

        testObservable.assertValueSequence(
            listOf(
                ToDoDetailState.UnInitialized,
                ToDoDetailState.Write
            )
        )
    }

    @Test
    fun `test insert todo`() = runBlockingTest {
        val detailTestObservable = detailViewModel.todoDetailLiveData.test()
        val listTestObservable = listViewModel.toDoListLiveData.test()

        detailViewModel.writeToDo(
            title = todo.title,
            description = todo.description
        )

        detailTestObservable.assertValueSequence(
            listOf(
                ToDoDetailState.UnInitialized,
                ToDoDetailState.Loading,
                ToDoDetailState.Success(todo)
            )
        )

        assert(detailViewModel.detailMode == DetailMode.DETAIL)
        assert(detailViewModel.id == id)

        // 뒤로 나가서 리스트 보기
        listViewModel.fetchData()
        listTestObservable.assertValueSequence(
            listOf(
                ToDoListState.UnInitialized,
                ToDoListState.Loading,
                ToDoListState.Success(listOf(
                    todo
                ))
            )
        )
    }

}