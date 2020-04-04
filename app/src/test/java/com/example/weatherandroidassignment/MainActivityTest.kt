package com.example.weatherandroidassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.weatherandroidassignment.ui.activity.MainActivity
import com.example.weatherandroidassignment.ui.viewmodel.MainViewModel
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainActivityTest {

    @Mock
    private lateinit var mainViewModel: MainViewModel

    // Instant task Rule executor for Live data Mocking
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // Dispatcher & Scope for testing coroutines
    val testDispatcher = TestCoroutineDispatcher()
    val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var mainActivity: MainActivity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        mainActivity =
            MainActivity()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun `main activity executes api call`() {
        Mockito.doNothing().`when`(mainViewModel).getWeather("Jaipur")

        verify(mainViewModel, times(0)).getWeather("Jaipur")
        verifyNoMoreInteractions(mainViewModel)
    }

    @Test
    fun `main activity executes api call on refresh`() {
        Mockito.doNothing().`when`(mainViewModel).apiCallToGetWeatherData("Jaipur")

        verify(mainViewModel, times(0)).apiCallToGetWeatherData("Jaipur")
        verifyNoMoreInteractions(mainViewModel)
    }
}