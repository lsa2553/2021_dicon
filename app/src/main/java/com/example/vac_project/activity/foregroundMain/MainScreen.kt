package com.example.vac_project.activity.foregroundMain

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.nfc.Tag
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vac_project.R
import com.example.vac_project.databinding.ActivityMainBinding
import com.example.vac_project.databinding.MainscreenBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timer

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
