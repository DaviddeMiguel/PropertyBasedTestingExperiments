package com.trov.propertybasedtestingexperiments.repository

import io.reactivex.Completable
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class SettingsRepository {
  var featureEnabled = false

  fun enableFeature(value: Boolean):Completable {
    featureEnabled = value
    return Completable.complete().delay(2000, TimeUnit.MILLISECONDS)
  }

  fun isFeatureEnabled(): Observable<Boolean> = Observable.just(featureEnabled)
}
