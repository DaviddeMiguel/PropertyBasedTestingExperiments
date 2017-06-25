package com.trov.propertybasedtestingexperiments.databinding.util

import android.annotation.SuppressLint
import android.databinding.ObservableField
import io.vavr.CheckedFunction1
import io.vavr.collection.List
import io.vavr.test.Arbitrary
import io.vavr.test.Property
import org.junit.Test
import java.util.function.Consumer

@SuppressLint("NewApi") // Vavr requires java8 but we can ignore the lint error
class VavrTestSubscriberTest {
  @Test
  fun name() {
    val booleans = Arbitrary.of(true, false)
    val list = Arbitrary.list(booleans)

    Property.def("Test will fail when a list has two consecutive items with the same value (eg. {true, true}")
        .forAll(list)
        .suchThat(object : CheckedFunction1<List<Boolean>, Boolean> {
          override fun apply(items: List<Boolean>): Boolean {
            val observable = ObservableField<Boolean>()
            val subscriber = TestSubscriber.create(observable)
            items.forEach(Consumer<Boolean> { observable.set(it) })
            subscriber.assertValues(*items.toJavaArray())
            return true
          }
        }).check().assertIsSatisfied()
  }
}
