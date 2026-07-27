<details><summary>点击展开</summary><pre>package com.adskipper.cleaner

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
}
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
startActivity(Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS))
}
}
}</pre></details>
