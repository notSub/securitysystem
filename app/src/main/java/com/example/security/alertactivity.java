package com.example.security;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Vibrator;
public class alertactivity extends AppCompatActivity {
    TextView alertmsg;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertactivity);
        //text view r.id
        alertmsg=findViewById(R.id.textView3);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // store the data in base
        DatabaseReference myRef = database.getReference("message");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(alertactivity.this,value, Toast.LENGTH_SHORT).show();
                alertmsg.setText(value);
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 400 milliseconds
                v.vibrate(10000);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                DatabaseException a = error.toException();
            }
        });

        //sendNotification();


    }
    /*private void sendNotification() {
        context=this;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(alertactivity.this,"myking")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("This is title")
                .setContentText("This is the content of the notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());
    }*/
}