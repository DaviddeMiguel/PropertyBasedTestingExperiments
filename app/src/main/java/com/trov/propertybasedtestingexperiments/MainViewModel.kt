package com.trov.propertybasedtestingexperiments

import android.databinding.ObservableBoolean
import com.trov.propertybasedtestingexperiments.repository.SettingsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val repository: SettingsRepository) {

  val subscriptions = CompositeDisposable()
  val featureEnabled = ObservableBoolean()
  val progressVisible = ObservableBoolean()

  fun saveFeatureState() {
    subscriptions.add(
        repository.enableFeature(featureEnabled.get())
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
