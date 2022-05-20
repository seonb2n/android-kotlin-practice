package com.example.kotlinapplication.viewmodel.todo

import com.example.kotlinapplication.ViewModelTest
import com.example.kotlinapplication.data.entity.ToDoEntity
import com.example.kotlinapplication.domain.todo.InsertToDoListUseCase
import com.example.kotlinapplication.presentation.list.ListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.test.inject

/**
[ListViewModel] 을 테스트
 1. initData()
 2. test viewModel fetch
 3. test Item Update
 4. test Item Delete
 **/
@ExperimentalCoroutinesApi
internal class ListViewModelTest: ViewModelTest() {

    private val viewModel: ListViewModel by inject()

    private val insertToDoListUseCase: InsertToDoListUseCase by inject()

    private val mockList = (0 until 10).map {
        ToDoEntity(
            id = it.toLong(),
            title = "title $it",
            description = "description $it",
            hasCompleted = false
        )
    }

    /**
     * 1. InsertToDoListUseCase
     * 2. GetToDoItemUseCase
    */

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertToDoListUseCase(mockList)
    }

    // Test : 입력된 데이터를 불러와서 검증한다.
    @Test
    fun `test viewModel fetch`(): Unit = runBlockingTest {
        val testObserver = viewModel.toDoListLiveData.test()
        viewModel.fetchData()
        testObserver.assertValueSequence(
            listOf(
                mockList
            )
        )
    }

}