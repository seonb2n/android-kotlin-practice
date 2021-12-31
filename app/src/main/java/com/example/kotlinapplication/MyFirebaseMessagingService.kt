package com.example.kotlinapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        createNotificationChannel()

        val type = message.data["type"]?.let {
            NotificationType.valueOf(it)
        }
        type?: return

        val title = message.data["title"]
        val messageContent = message.data["message"]

        NotificationManagerCompat.from(this)
            .notify(type.id, createNotification(type, title, messageContent))
    }

    private fun createNotification(
        type: NotificationType,
        title: String?,
        messageContent: String?
    ): Notification {

        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle(title)
            .setContentText(messageContent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        when(type) {
            NotificationType.NORMAL -> Unit
            NotificationType.EXPANDABLE -> {
                notificationBuilder.setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText(
                            "😒 😞 😔 😟 😕 🙁 ☹️ 😣 😖 😫 😩 🥺 😢 😭 😤 😠 😡 🤬 🤯 😳 🥵 🥶 😱 😨 😰 😥 😓 🤗 🤔 🤭 🤫 🤥 😶"+
                                    "\uD83D\uDE00 \uD83D\uDE03 \uD83D\uDE04 \uD83D\uDE01 \uD83D\uDE06 \uD83D\uDE05 \uD83D\uDE02 \uD83E\uDD23 \uD83E\uDD72 ☺️ \uD83D\uDE0A \uD83D\uDE07 \uD83D\uDE42 \uD83D\uDE43 \uD83D\uDE09 \uD83D\uDE0C \uD83D\uDE0D"+
                                    " \uD83E\uDD70 \uD83D\uDE18 \uD83D\uDE17 \uD83D\uDE19 \uD83D\uDE1A \uD83D\uDE0B"
                        )
                )
            }
            NotificationType.CUSTOM -> {
                notificationBuilder.setStyle(
                    NotificationCompat.DecoratedCustomViewStyle())
                    .setCustomContentView(
                        RemoteViews(
                            packageName,
                            R.layout.view_custom_notification
                        ).apply {
                            setTextViewText(R.id.title, title)
                            setTextViewText(R.id.message, messageContent)
                        }
                    )
            }
        }

        return notificationBuilder.build()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = CHANNEL_DESCRIPTION

            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                .createNotificationChannel(channel)
        }
    }

    companion object {
        private const val CHANNEL_NAME = "Emoji party"
        private const val CHANNEL_DESCRIPTION = "Emoji party 를 위한 채널"
        private const val CHANNEL_ID = "Channel Id"
    }
}