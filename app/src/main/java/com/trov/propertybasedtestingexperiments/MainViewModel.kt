package com.trov.propertybasedtestingexperiments

import android.databinding.ObservableBoolean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val manager: MarketManager) {

  val subscriptions = CompositeDisposable()
  val featureEnabled = ObservableBoolean()
  val progressVisible = ObservableBoolean()

  fun doSomething() {
    subscriptions.add(
        manager.isValidRegion(Market.AU)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _ ->
              progressVisible.set(true)
            }.doFinally {
          progressVisible.set(false)
        }.subscribe({
          //TODO(david) Notify the UI when action is completed
        }))
  }
}
