package com.example.weatherandroidassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.weatherandroidassignment.data.network.response.WeatherResponse
import com.example.weatherandroidassignment.data.repository.MainRepository
import com.example.weatherandroidassignment.ui.viewmodel.MainViewModel
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    // Mock the repository object and verify interactions on this mock
    @Mock
    private lateinit var mainRepository: MainRepository

    // Instant task Rule executor for Live data Mocking
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // Dispatcher & Scope for testing coroutines
    val testDispatcher = TestCoroutineDispatcher()
    val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(mainRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun `main view model executes apiCall`() {

        testScope.runBlockingTest {

            val popularRepositoryData = Mockito.mock(WeatherResponse::class.java)
            whenever(mainRepository.getWeatherResult("Jaipur")).thenReturn(popularRepositoryData)

            verify(mainRepository, times(0)).getWeatherResult("Jaipur")
            verifyNoMoreInteractions(mainRepository)
        }
    }
}