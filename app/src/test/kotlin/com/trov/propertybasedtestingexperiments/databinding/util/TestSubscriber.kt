package com.trov.propertybasedtestingexperiments.databinding.util

import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import java.util.*

internal class TestSubscriber private constructor() {
  private val values = ArrayList<Any>()

  companion object {
    fun create(observable: ObservableField<*>): TestSubscriber {
      val subscriber = TestSubscriber()
      observable.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable, i: Int) {
          subscriber.addNewValue(observable.get())
        }
      })
      return subscriber
    }

    fun create(observable: ObservableBoolean): TestSubscriber {
      val subscriber = TestSubscriber()
      observable.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable, i: Int) {
          subscriber.addNewValue(observable.get())
        }
      })
      return subscriber
    }

    fun create(observable: ObservableInt): TestSubscriber {
      val subscriber = TestSubscriber()
      observable.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable, i: Int) {
          subscriber.addNewValue(observable.get())
        }
      })
      return subscriber
    }
  }

  private fun addNewValue(value: Any) {
    values.add(value)
  }

//  /**
//   * Asserts that there are values set.
//
//   * @throws AssertionError if there were any values
//   * *
//   * @since 1.1.0
//   */
//  fun assertNoValues() {
//    val s = values.size
//    if (s != 0) {
//      assertionError("No values expected yet some set: " + s)
//    }
//  }

//  /**
//   * Asserts that the given number of values are set.
//
//   * @param count the expected number of values set
//   * *
//   * @throws AssertionError if there were more or fewer values set than specified by `count`
//   * *
//   * @since 1.1.0
//   */
//  fun assertValueCount(count: Int) {
//    val s = values.size
//    if (s != count) {
//      assertionError("Number of values differ; expected: $count, actual: $s")
//    }
//  }

  /**
   * Asserts that the set values, in order, are the specified items.

   * @param items the items to check
   * *
   * @throws AssertionError if the items emitted do not exactly match those specified by `values`
   */
  fun assertValues(vararg items: Any) {
    val itemsList = Arrays.asList(*items)
    if (values.size != itemsList.size) {
      assertionError("Number of items does not match. Provided: "
          + itemsList.size
          + "  Actual: "
          + values.size
          + ".\n"
          + "Provided values: "
          + itemsList
          + "\n"
          + "Actual values: "
          + values
          + "\n")
    }

    for (i in itemsList.indices) {
      assertItem(itemsList[i], i)
    }
  }

  private fun assertItem(expected: Any?, i: Int) {
    val actual: Any? = values[i]
    if (expected == null) {
      // check for null equality
      if (actual != null) {
        assertionError("Value at index: $i expected to be [null] but was: [$actual]\n")
      }
    } else if (expected != actual) {
      assertionError("Value at index: $i expected to be [$expected] (" + expected.javaClass
          .simpleName + ") but was: [" + actual + "] (" + (if (actual != null)
        actual.javaClass
            .simpleName
      else
        "null") + ")\n")
    }
  }

  private fun assertionError(message: String) {
    throw AssertionError(message)
  }
}
