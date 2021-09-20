package com.example.vac_project.activity.foregroundMain

import android.content.*
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vac_project.R
import com.example.vac_project.activity.backgroundMain.Todo
import com.example.vac_project.activity.backgroundMain.TodoAdapter
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



        val todolist = arrayListOf(

            Todo(false, R.drawable.ic_line)
        )
        val adapter = TodoAdapter(todolist)
        binding.rvTodos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.button?.setOnClickListener {
            adapter.addItem(binding.editText.text.toString())

        }
        binding.rvTodos.setHasFixedSize(true)
        binding.rvTodos.adapter = TodoAdapter(todolist)


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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        item.itemId
        return super.onOptionsItemSelected(item)
    }


    }





