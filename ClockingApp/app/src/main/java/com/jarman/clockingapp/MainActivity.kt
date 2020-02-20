package com.jarman.clockingapp

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.work.*
import java.util.*
import java.util.concurrent.TimeUnit

private val TAG: String = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun activeWorker(view: View){

        Log.d(TAG,"activate work: 'ClockingEntryWork'")
        // Create a Constraints object that defines when the task should run
        val constraints = Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build()

        // ...then create a OneTimeWorkRequest that uses those constraints
        val workrequest =
            OneTimeWorkRequestBuilder<ClockingEntryWork>()
                .addTag("clockentry")
                .setConstraints(constraints)
                .build()

        WorkManager.getInstance(applicationContext).enqueue(workrequest)
    }

    fun activePeriodicWorker(view: View) {

        Log.d(TAG,"activate repeat work: 'ClockingEntryWork'")
        // Create a Constraints object that defines when the task should run
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        // ...then create a that uses those contrainst
        val workrequest =
            PeriodicWorkRequestBuilder<ClockingEntryWork>(15,TimeUnit.MINUTES)
                .addTag("clockentry")
                //.setInitialDelay(15,TimeUnit.MINUTES)
                .build()

        WorkManager.getInstance(applicationContext).enqueue(workrequest)
    }

    fun cancelWorker(view: View) {
        Log.d(TAG,"cancel work: 'ClockingEntryWork'")
        WorkManager.getInstance(applicationContext).cancelAllWorkByTag("clockentry")
    }
}
