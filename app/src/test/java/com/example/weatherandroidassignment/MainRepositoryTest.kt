package com.example.weatherandroidassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.weatherandroidassignment.data.network.RestAPIClient
import com.example.weatherandroidassignment.data.network.SafeApiRequest
import com.example.weatherandroidassignment.data.network.response.WeatherResponse
import com.example.weatherandroidassignment.data.repository.MainRepository
import com.example.weatherandroidassignment.data.repository.MainRepository.Companion.API_KEY
import com.example.weatherandroidassignment.data.repository.MainRepository.Companion.METRIC
import com.example.weatherandroidassignment.data.repository.MainRepository.Companion.DAY_COUNT
import com.example.weatherandroidassignment.data.repository.MainRepository.Companion.MODE
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

class MainRepositoryTest {

    @Mock
    private lateinit var myAPi: RestAPIClient

    @Mock
    private lateinit var safeApiRequest: SafeApiRequest

    // Instant task Rule executor for Live data Mocking
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // Dispatcher & Scope for testing coroutines
    val testDispatcher = TestCoroutineDispatcher()
    val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var mainRepository: MainRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        mainRepository = MainRepository(myAPi)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }
    @Test
    fun `main repo executes api call`(){
        testScope.runBlockingTest {

            //Given
            val popularRepositoryData = Mockito.mock(WeatherResponse::class.java)
            whenever( safeApiRequest.apiRequest { myAPi.getWeatherDetails("Jaipur", METRIC, API_KEY, DAY_COUNT, MODE)}).thenReturn(popularRepositoryData)

            //When
            myAPi.getWeatherDetails("Jaipur", METRIC, API_KEY, DAY_COUNT, MODE)

            //Then
            verify(myAPi, times(1)).getWeatherDetails("Jaipur", METRIC, API_KEY, DAY_COUNT, MODE)
            verifyNoMoreInteractions(myAPi)
        }
    }
}

