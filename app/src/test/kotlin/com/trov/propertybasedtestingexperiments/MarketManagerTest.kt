package com.trov.propertybasedtestingexperiments

import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.generator.ValuesOf
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.Assume.assumeThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitQuickcheck::class)
class MarketManagerTest {
  private lateinit var sut: MarketManager

  @Before
  fun setUp() {
    sut = MarketManager()
  }

  @Property
  @Throws(Exception::class)
  fun verifyValidRegion(@ValuesOf market: Market) {
    assumeThat(market, not(equalTo(Market.AU)))

    val subscriber = sut.isValidRegion(market).test()

    subscriber.assertError(InvalidRegionException::class.java)
  }

  @Test
  @Throws(Exception::class)
  fun verifyValidRegion() {
    val subscriber = sut.isValidRegion(Market.AU).test()

    subscriber.assertNoErrors()
  }
}
