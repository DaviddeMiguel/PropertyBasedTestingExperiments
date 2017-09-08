package com.trov.propertybasedtestingexperiments.pbt

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.trov.propertybasedtestingexperiments.util.TestSubscriber
import org.junit.Test
import java.util.*
import kotlin.test.fail


class TestSubscriberTest {
  @Test
  @Throws(Exception::class)
  fun assertValues_verifyObservableFieldValuesInOrder() {
    val observable = ObservableField<String>()
    val subscriber = TestSubscriber.create(observable)

    val expectedValues = Arrays.asList("First value", "Second value", "Third value")
    observable.set(expectedValues[0])
    observable.set(expectedValues[1])
    observable.set(expectedValues[2])

    subscriber.assertValues(expectedValues[0], expectedValues[1], expectedValues[2])
  }

  @Test
  @Throws(Exception::class)
  fun assertValues_failsToVerifyObservableFieldValuesInOrderWhenWrongValues() {
    val observable = ObservableField<String>()
    val subscriber = TestSubscriber.create(observable)

    val expectedValues = Arrays.asList("First value", "Second value", "Third value")
    observable.set(expectedValues[0])
    observable.set(expectedValues[1])
    observable.set(expectedValues[2])

    try {
      subscriber.assertValues(expectedValues[2], expectedValues[1], expectedValues[0])
      fail("The value's order is wrong but the subscriber didn't notify it")
    } catch (ignored: AssertionError) {

    }

  }

  @Test
  @Throws(Exception::class)
  fun assertValues_verifyObservableBooleanValuesInOrder() {
    val observable = ObservableBoolean()
    val subscriber = TestSubscriber.create(observable)

    val expectedValues = Arrays.asList(true, false, true)
    observable.set(expectedValues[0])
    observable.set(expectedValues[1])
    observable.set(expectedValues[2])

    subscriber.assertValues(expectedValues[0], expectedValues[1], expectedValues[2])
  }

  @Test
  @Throws(Exception::class)
  fun assertValues_failsToVerifyObservableBooleanValuesInOrderWrongValues() {
    val observable = ObservableBoolean()
    val subscriber = TestSubscriber.create(observable)

    val expectedValues = Arrays.asList(true, false, true)
    observable.set(expectedValues[0])
    observable.set(expectedValues[1])
    observable.set(expectedValues[2])

    try {
      subscriber.assertValues(expectedValues[2], expectedValues[1], expectedValues[0])
      fail("The value's order is wrong but the subscriber didn't notify it")
    } catch (ignored: AssertionError) {

    }

  }

  @Test
  @Throws(Exception::class)
  fun assertValues_verifyObservableIntValuesInOrder() {
    val observable = ObservableInt()
    val subscriber = TestSubscriber.create(observable)

    val expectedValues = Arrays.asList(1, 2, 3)
    observable.set(expectedValues[0])
    observable.set(expectedValues[1])
    observable.set(expectedValues[2])

    subscriber.assertValues(expectedValues[0], expectedValues[1], expectedValues[2])
  }

  @Test
  @Throws(Exception::class)
  fun assertValues_failsToVerifyObservableIntValuesInOrderWrongValues() {
    val observable = ObservableInt()
    val subscriber = TestSubscriber.create(observable)

    val expectedValues = Arrays.asList(1, 2, 3)
    observable.set(expectedValues[0])
    observable.set(expectedValues[1])
    observable.set(expectedValues[2])

    try {
      subscriber.assertValues(expectedValues[2], expectedValues[1], expectedValues[0])
      fail("The value's order is wrong but the subscriber didn't notify it")
    } catch (ignored: AssertionError) {

    }
  }
}
