package id.co.gits.workmanagerexample.sendandreceive

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.support.v4.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import id.co.gits.gitsplayground.R

class SendWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        //getting the input data
        val taskDesc = inputData.getString(TASK_DESC) ?: ""

        displayNotification("My Worker", taskDesc)

        return Result.SUCCESS
    }

    private fun displayNotification(title: String, task: String) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("simplifiedcoding", "simplifiedcoding", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(applicationContext, "simplifiedcoding")
            .setContentTitle(title)
            .setContentText(task)
            .setSmallIcon(R.mipmap.ic_launcher)

        notificationManager.notify(1, notification.build())
    }

    companion object {
        //a public static string that will be used as the key
        //for sending and receiving data
        const val TASK_DESC = "task_desk"
    }
}