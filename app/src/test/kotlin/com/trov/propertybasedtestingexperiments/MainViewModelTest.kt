package com.trov.propertybasedtestingexperiments

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.trov.propertybasedtestingexperiments.databinding.util.TestSubscriber
import com.trov.propertybasedtestingexperiments.repository.SettingsRepository
import com.trov.propertybasedtestingexperiments.rx.util.RxJavaTestHooksResetRule
import io.reactivex.Completable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
  @get:Rule val rxJavaTestHooksResetRule = RxJavaTestHooksResetRule()

  val VISIBLE = true

  private lateinit var sut: MainViewModel

  private val repository: SettingsRepository = mock()

  @Before
  fun setUp() {
    sut = MainViewModel(repository)
  }

  @Test
  fun test() {
    whenever(repository.enableFeature(any())).thenReturn(Completable.complete());
    val subscriber = TestSubscriber.create(sut.progressVisible)

    sut.saveFeatureState()

    subscriber.assertValues(VISIBLE, !VISIBLE)
  }
}
