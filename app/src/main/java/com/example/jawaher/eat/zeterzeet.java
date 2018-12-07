package com.example.jawaher.eat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
public class zeterzeet extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeterzeet);
        b1=(Button)findViewById(R.id.falf);




        b1a();
    }
    public  void b1a() {
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(),falafel.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
