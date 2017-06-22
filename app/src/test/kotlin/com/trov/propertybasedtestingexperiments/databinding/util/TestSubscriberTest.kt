package com.trov.propertybasedtestingexperiments.databinding.util

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
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

//  @Test
//  @Throws(Exception::class)
//  fun assertNoValues_isSuccessWhenNoValuesAreSet() {
//    val observable = ObservableField<String>()
//    val subscriber = TestSubscriber.create(observable)
//
//    subscriber.assertNoValues()
//  }

//  @Test
//  @Throws(Exception::class)
//  fun assertNoValues_throwsAssertionErrorWhenThereWasSomeValue() {
//    val observable = ObservableField<String>()
//    val subscriber = TestSubscriber.create(observable)
//    observable.set("Some value")
//
//    try {
//      subscriber.assertNoValues()
//      fail("The test failed because there was at least 1 value and the subscriber says there was none")
//    } catch (ignored: AssertionError) {
//
//    }
//  }

//  @Test
//  @Throws(Exception::class)
//  fun assertValueCount_countsTheNumberOfValuesThatTheObservableHad() {
//    //David: This test could clearly use Property Based Testing: https://trovinc.atlassian.net/wiki/display/ENG/2017/01/18/Property+based+testing
//
//    val observable1 = ObservableField<String>()
//    val subscriber1 = TestSubscriber.create(observable1)
//    observable1.set("Some value")
//
//    subscriber1.assertValueCount(1)
//
//    val observable2 = ObservableField<String>()
//    val subscriber2 = TestSubscriber.create(observable2)
//    observable2.set("Some value 1")
//    observable2.set("Some value 2")
//    observable2.set("Some value 3")
//    observable2.set("Some value 4")
//
//    subscriber2.assertValueCount(4)
//  }
}
