package com.trov.propertybasedtestingexperiments.di

import com.trov.propertybasedtestingexperiments.MainViewModel
import com.trov.propertybasedtestingexperiments.MarketManager

class Provide private constructor() {
  init {
    throw RuntimeException("This is a util class, use its methods statically")
  }

  companion object {

    fun mainViewModel(): MainViewModel {
      return MainViewModel(timesClickedRepository())
    }

    fun timesClickedRepository(): MarketManager {
      return MarketManager()
    }
  }
}
