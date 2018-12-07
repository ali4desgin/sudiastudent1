package com.example.jawaher.eat;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    EatDB myDB;
    EditText name,pass,ph ;
    Spinner s1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new EatDB(this);

        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.password);
        ph=(EditText)findViewById(R.id.number);
        s1=(Spinner) findViewById((R.id.city));

        b1=(Button)findViewById(R.id.button);




        b1a();
        //research();


    }



    public  void b1a() {
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData(name.getText().toString(),
                                pass.getText().toString(),
                                ph.getText().toString(),s1.getSelectedItem().toString() );
                        if(isInserted == true){
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        addnotificationcall();}
                        else{
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();}
                    }
                }
        );
    }



     public void onButtonClick(View v){
         showAlertDialog("Welcom");
        Intent myIntent;
         myIntent = new Intent(getBaseContext(),singupactivity.class);
         startActivity(myIntent);
    }

    public void addnotificationcall(){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("Eat App say hello")
                        .setContentText("Don't make food stop Eat App with y.");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mm) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, mm);
        return true;
    }


    private void showAlertDialog(String message)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setMessage(message);
        alertDialog.show();
    }

}
