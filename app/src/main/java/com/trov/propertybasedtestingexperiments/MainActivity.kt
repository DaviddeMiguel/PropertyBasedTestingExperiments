package com.trov.propertybasedtestingexperiments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.trov.propertybasedtestingexperiments.databinding.ActivityMainBinding
import com.trov.propertybasedtestingexperiments.di.Provide

class MainActivity : AppCompatActivity() {
  val viewModel = Provide.mainViewModel()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val contentView = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    contentView.data = viewModel
  }
}
