package com.example.vac_project.activity.foregroundMain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vac_project.R
import com.example.vac_project.databinding.MainscreenBinding
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale


class MainScreen : AppCompatActivity() {

    private lateinit var binding: MainscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.mainscreen)

        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                setProgressByTime()
            }
        }, IntentFilter(Intent.ACTION_TIME_TICK))


        val currentTime = Calendar.getInstance().time
        binding.date.text = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(currentTime)
        binding.yoil.text = SimpleDateFormat("EE요일", Locale.KOREAN).format(currentTime)
    }

    override fun onStart() {
        super.onStart()
        setProgressByTime()
    }

    private fun Calendar.getMinuteOfDay(): Int =
        get(Calendar.HOUR_OF_DAY) * 60 + get(Calendar.MINUTE)

    private fun setProgressByTime() {
        val now = Calendar.getInstance()

        binding.number.text =
            SimpleDateFormat("HH:mm", Locale.KOREAN).format(now.time)
        binding.nowSec = now.getMinuteOfDay()


    }

}
