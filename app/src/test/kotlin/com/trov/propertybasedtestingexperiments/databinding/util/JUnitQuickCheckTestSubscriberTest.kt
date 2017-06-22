package com.trov.propertybasedtestingexperiments.databinding.util

import android.databinding.ObservableField
import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import org.junit.runner.RunWith


@RunWith(JUnitQuickcheck::class)
class JUnitQuickCheckTestSubscriberTest {
  @Property fun failingTestEarlierThanksToPropertyBasedTesting(values: Array<Boolean>) {
    val observable = ObservableField<Boolean>()
    val subscriber = TestSubscriber.create(observable)

    values.forEach({ it -> observable.set(it) })

    subscriber.assertValues(*values)
  }
}
