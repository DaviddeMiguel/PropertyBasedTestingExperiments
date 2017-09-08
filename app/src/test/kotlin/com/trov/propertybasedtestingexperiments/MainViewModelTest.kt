package com.trov.propertybasedtestingexperiments

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import com.trov.propertybasedtestingexperiments.util.RxJavaTestHooksResetRule
import com.trov.propertybasedtestingexperiments.util.TestSubscriber
import io.reactivex.Completable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitQuickcheck::class)
class MainViewModelTest {
  @get:Rule
  val rxJavaTestHooksResetRule = RxJavaTestHooksResetRule()

  val VISIBLE = true

  private lateinit var sut: MainViewModel

  private val marketManager: MarketManager = mock()

  @Before
  fun setUp() {
    sut = MainViewModel(marketManager)
  }

  @Test
  @Throws(Exception::class)
  fun doSomething() {
    whenever(marketManager.isValidRegion(any())).thenReturn(Completable.complete());
    val subscriber = TestSubscriber.create(sut.progressVisible)

    sut.doSomething()

    subscriber.assertValues(VISIBLE, !VISIBLE)
  }
}
