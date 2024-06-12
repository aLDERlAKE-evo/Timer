@file:Suppress("UNUSED_PARAMETER")

package com.example.timerapp

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("MemberVisibilityCanBePrivate")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun startTimerMilkButtonClicked(view: View) {
        Log.i("Main Timer Activity", "Starting timer for Milk with 600 seconds")
        startTimer("Milk", 600)
    }

    fun startTimerWaterMotorButtonClicked(view: View) {
        Log.i("Main Timer Activity", "Starting timer for Water Motor with 6000 seconds")
        startTimer("Water Motor", 6000)
    }

    fun startTimerToastButtonClicked(view: View) {
        Log.i("Main Timer Activity", "Starting timer for Toast with 90 seconds")
        startTimer("Toast", 90)
    }

    fun startTimer(message: String, seconds: Int) {

        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        startActivity(intent)
        Toast.makeText(this,"timer initiated, check notification bar to track status.",
                       Toast.LENGTH_SHORT).show()
    }
}