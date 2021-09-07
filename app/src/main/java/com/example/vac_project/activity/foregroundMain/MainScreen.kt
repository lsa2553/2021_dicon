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

class MainScreen : AppCompatActivity() {

    private lateinit var binding: MainscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.mainscreen)

        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val calendar = Calendar.getInstance()
                val time = Date(System.currentTimeMillis())
                val timeFormat = SimpleDateFormat("HH:mm",)
                binding.number.text = timeFormat.format(time)
                binding.progressbar.progress = calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE) / 30

            }
        }, IntentFilter(Intent.ACTION_TIME_TICK))


//        binding.progressbar.progress = calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE) / 30

    }
}