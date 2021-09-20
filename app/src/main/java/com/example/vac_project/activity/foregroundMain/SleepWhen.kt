package com.example.vac_project.activity.foregroundMain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.vac_project.R
import com.example.vac_project.databinding.ActivityMainBinding
import com.example.vac_project.databinding.SleepWhenBinding

class SleepWhen : AppCompatActivity() {
    lateinit var binding: SleepWhenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.sleep_when)

    }
}