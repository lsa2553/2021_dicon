package com.example.vac_project.activity.foregroundMain

import android.content.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vac_project.R

import com.example.vac_project.databinding.ActivityMainBinding
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                setProgressByTime()
            }
        }, IntentFilter(Intent.ACTION_TIME_TICK))


        val currentTime = Calendar.getInstance().time
        binding.date.text = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(currentTime)
        binding.yoil.text = SimpleDateFormat("EE요일", Locale.KOREA).format(currentTime)
    }

    override fun onStart() {
        super.onStart()
//        setProgressByTime()
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
