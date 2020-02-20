package com.jarman.clockingapp
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.util.Log
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.*

private val TAG: String = ClockingEntryWork::class.java.simpleName
// Unique request code.
private const val WRITE_REQUEST_CODE: Int = 43

class ClockingEntryWork (appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        try {
            //TODO: tasks to work
            Log.d(TAG,"working tasks 'ClockingEntryWork'")
            notificationWork()
            //val externalEnable =
            //    Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
            //if (externalEnable) {
                //createFile("text/plain", "clocking.txt")
            //}
        }catch (e: Exception) {
            Log.d(TAG, "Exception $e")
            return Result.failure()
        }
        Log.d(TAG, "Result success")
        return Result.success()
    }

    // Here are some examples of how you might call this method.
    // The first parameter is the MIME type, and the second parameter is the name
    // of the file you are creating:
    //
    // createFile("text/plain", "foobar.txt");
    // createFile("image/png", "mypicture.png");
    private fun createFile(mimeType: String, fileName: String) {
        val fileNameNew = fileName + Calendar.MINUTE.toString()
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
            // Filter to only show results that can be "opened", such as
            // a file (as opposed to a list of contacts or timezones).
            addCategory(Intent.CATEGORY_OPENABLE)

            // Create a file with the requested MIME type.
            type = mimeType
            putExtra(Intent.EXTRA_TITLE, fileNameNew)
        }
        val activity = NotifyAcivity()
        startActivityForResult( activity, intent, WRITE_REQUEST_CODE, null)
        Log.d(TAG, "Create file: $fileNameNew")
    }

    private fun notificationWork(){

        val time = "Hora ${Calendar.HOUR}: ${Calendar.MINUTE}:${Calendar.SECOND}"

        val fullScreenIntent = Intent(applicationContext, MainActivity::class.java)
        val fullScreenPendingIntent = PendingIntent.getActivity(applicationContext, 0,
            fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        var builder = NotificationCompat.Builder(applicationContext, "CHANNEL_01")
            //.setSmallIcon(R.drawable.notification_icon)
            .setContentTitle("Notification: $time")
            .setContentText("Task entry")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setFullScreenIntent(fullScreenPendingIntent, true)
            .build()

        Log.d(TAG, "nofificationWork")

    }

}