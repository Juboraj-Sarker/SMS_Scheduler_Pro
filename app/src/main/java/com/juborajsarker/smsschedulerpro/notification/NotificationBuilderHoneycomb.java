package com.juborajsarker.smsschedulerpro.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.juborajsarker.smsschedulerpro.R;

/**
 * Created by jubor on 1/31/2018.
 */

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
class NotificationBuilderHoneycomb extends NotificationBuilder {

    protected Notification.Builder builder;

    @Override
    public NotificationBuilder setTitle(String title) {
        builder.setContentTitle(title);
        return this;
    }

    @Override
    public NotificationBuilder setMessage(String message) {
        builder.setContentText(message);
        return this;
    }

    @Override
    public NotificationBuilder setIntent(Intent intent) {
        builder.setContentIntent(getPendingIntent(intent));
        return this;
    }

    @Override
    public Notification build() {
        return builder.getNotification();
    }

    public NotificationBuilderHoneycomb(Context context) {
        super(context);
        builder = new Notification.Builder(context)
                .setSmallIcon(R.drawable.ic_notification)
                .setAutoCancel(true)
        ;
    }
}

