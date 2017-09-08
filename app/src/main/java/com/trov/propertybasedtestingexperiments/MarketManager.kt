package com.trov.propertybasedtestingexperiments

import io.reactivex.Completable

class MarketManager {
  fun isValidRegion(market: Market): Completable {
    return if (Market.AU == market) {
      Completable.complete()
    } else {
      Completable.error(InvalidRegionException())
    }
  }
}
