package id.co.gits.gitsplayground.view.pushnotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.iid.FirebaseInstanceId
import id.co.gits.gitsplayground.R
import id.co.gits.gitsplayground.view.workmanager.WorkmanagerActivity
import kotlinx.android.synthetic.main.push_notification_activity.*


class PushNotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.push_notification_activity)

        btn_pushNotif_send.setOnClickListener {
            if (!switch_pushNotif.isChecked) {
                sendNotif()
            } else {
                try {
                    val firebaseTokenId = FirebaseInstanceId.getInstance().token
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun sendNotif() {
        // Referensi : https://stackoverflow.com/questions/13800680/back-to-main-activity-from-notification-created-activity
        // Case kalo di foreground
        // skema dari A - C - B - A
        // tambah back intent
        val backIntent = Intent(this, PushNotificationActivity::class.java)
        backIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        // skema dari A - B - A
        // langsung target intent
        val targetIntent = Intent(applicationContext, WorkmanagerActivity::class.java)
        val pendingIntent = PendingIntent.getActivities(applicationContext, 0,
                arrayOf(targetIntent), PendingIntent.FLAG_ONE_SHOT)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, getString(R.string.firebase_channel_id))
                .setSmallIcon(R.drawable.ic_notifications_2)
                .setColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                .setContentTitle(getString(R.string.app_name))
                //.setContentText(getString(R.string.firebase_channel_id))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setStyle(NotificationCompat.InboxStyle()
                        .addLine(getString(R.string.firebase_channel_id)))
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
