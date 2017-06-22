package com.trov.propertybasedtestingexperiments.di

import com.trov.propertybasedtestingexperiments.MainViewModel
import com.trov.propertybasedtestingexperiments.repository.SettingsRepository

class Provide private constructor() {
  init {
    throw RuntimeException("This is a util class, use its methods statically")
  }

  companion object {

    fun mainViewModel(): MainViewModel {
      return MainViewModel(timesClickedRepository())
    }

    fun timesClickedRepository(): SettingsRepository {
      return SettingsRepository()
    }
  }
}
