package id.co.gits.gitsplayground.view.pushnotification

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import id.co.gits.gitsplayground.R

class PushNotificationMessageService: FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.data != null) {
            val title = remoteMessage.data.getValue("title")
            val body = remoteMessage.data.getValue("body")

            sendNotification(title,  body)
        }
    }

    private fun sendNotification(title: String?, body: String?) {
        // case kalo dari background
        // pake task stack builder
        // dan tambahkan reference parent activity di manifest
        val baseIntent = Intent(applicationContext, PushNotificationActivity::class.java)
        val taskStackBuilder = TaskStackBuilder.create(this)
        taskStackBuilder.addNextIntentWithParentStack(baseIntent)

        val pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, getString(R.string.firebase_channel_id))
                .setSmallIcon(R.drawable.ic_notifications_2)
                .setColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                .setContentTitle(title)
                //.setContentText(body)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setStyle(NotificationCompat.InboxStyle()
                        .addLine(body))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(pendingIntent) as NotificationCompat.Builder

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(getString(R.string.firebase_channel_id), getString(R.string.app_name), importance)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            notificationBuilder.setChannelId(getString(R.string.firebase_channel_id))
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0, notificationBuilder.build())
    }
}