package com.example.vac_project.activity.foregroundMain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vac_project.R
import com.example.vac_project.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainTimes : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
//        this.also { binding. = it }

        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        binding.number.setText(timeFormat.format(System.currentTimeMillis()))

        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val time2 = Date(System.currentTimeMillis())
                binding.number.text = timeFormat.format(time2)

            }
        }, IntentFilter(Intent.ACTION_TIME_TICK))

        val calendar = Calendar.getInstance()
        binding.progressbar.progress = calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE) / 30



    }
}