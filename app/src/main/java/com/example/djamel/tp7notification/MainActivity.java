package com.example.djamel.tp7notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    NotificationManager nmanager;
    int id=32;
    public void addnotification(View view) {
        NotificationCompat.Builder nbuilder= new NotificationCompat.Builder(this)
                .setContentTitle("Danger")
                .setContentText("the rainig is comming soon")
        .setSmallIcon(R.drawable.ic_stat_new_message);

        Intent resultintent=new Intent(this,resultActivity.class);

        TaskStackBuilder taskStackBuilder=TaskStackBuilder.create(this);
       taskStackBuilder.addParentStack(resultActivity.class);
       taskStackBuilder.addNextIntent(resultintent);
       PendingIntent pendingIntent=taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
       nbuilder.setContentIntent(pendingIntent);
       nbuilder.addAction(R.drawable.ic_action_stat_share,"read it",pendingIntent);
        nbuilder.addAction(R.drawable.ic_action_stat_reply,"open",pendingIntent);


        nmanager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nmanager.notify(id,nbuilder.build());
id++;
    }

    public void removnotification(View view) {
        nmanager.cancelAll();

    }

    NewMessageNotification messageNotification=new NewMessageNotification();
    public void addnotification2(View view) {

        messageNotification.notify(this,"hi djamel",1234);
        messageNotification.notify(this,"rabeh cv ",134);

    }
    public void removnotification2(View view) {
        messageNotification.cancel(this);
    }
}
