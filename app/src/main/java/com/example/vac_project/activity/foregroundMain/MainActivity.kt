package com.example.vac_project.activity.foregroundMain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.vac_project.R
import com.example.vac_project.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val modalBottomSheet = ModalBottomSheet()
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this,R.layout.activity_main)

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

//        val dialogView = layoutInflater.inflate(R.layout.modal_bottom_sheet_content, null)
//        val dialog = BottomSheetDialog(this)
//        dialog.setContentView(dialogView)
//        dialog.show()
//
//        val bottomSheetFragment = BottomSheetFragment()
//        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }


}
