package com.trov.propertybasedtestingexperiments.databinding.util

import android.databinding.ObservableField
import org.junit.Test
import org.quicktheories.quicktheories.QuickTheory.qt
import org.quicktheories.quicktheories.generators.SourceDSL.booleans
import org.quicktheories.quicktheories.generators.SourceDSL.lists


class QuickTheoriesTestSubscriber {
  @Test fun failingTestEarlierThanksToPropertyBasedTesting() {
    qt().forAll(lists().allListsOf(booleans().all()).ofSizeBetween(0, 100)).checkAssert({
      val values: Array<Boolean> = it.toTypedArray()

      val observable = ObservableField<Boolean>()
      val subscriber = TestSubscriber.create(observable)

      values.forEach({ it -> observable.set(it) })

      subscriber.assertValues(*values)
    })
  }
}
