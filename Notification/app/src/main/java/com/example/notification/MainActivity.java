package com.example.notification;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import android.os.Build;
import android.content.Context;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static String CHANNEL_ID = "example_channel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        createAChannel();

    }
    public void createAChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            //human readable name for the channel
            CharSequence name= "Example channel";
            //importance level of the channel
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name,importance); //name = name of the channel

            //register channel with the android system
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void notiFunction(View view){
        //build and display notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                .setSmallIcon(R.drawable.noti)
                .setContentTitle("NOTIFICATION")
                .setContentText("Eda mwone")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager man = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        man.notify(1,builder.build());
    }
}