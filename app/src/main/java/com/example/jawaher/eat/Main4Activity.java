package com.example.jawaher.eat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.database.Cursor;

public class Main4Activity extends AppCompatActivity {

    EatDB myDB;
    EditText name ,no;

    Button b1;
    String p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        myDB = new EatDB(this);

        name=(EditText)findViewById(R.id.editText);
        no=(EditText)findViewById(R.id.editText3);
          p="25sar / 1 ";



        b1=(Button)findViewById(R.id.button);




        b1a();

    }

    public  void b1a() {
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData2(name.getText().toString(),
                                p.toString(),no.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(Main4Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main4Activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
