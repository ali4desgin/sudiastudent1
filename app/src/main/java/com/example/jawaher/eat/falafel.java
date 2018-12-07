package com.example.jawaher.eat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class falafel extends AppCompatActivity {
    EatDB myDB;
    EditText name,no ;

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falafel);

        myDB = new EatDB(this);

        name=(EditText)findViewById(R.id.editText);
        no=(EditText)findViewById(R.id.editText3);


        b1=(Button)findViewById(R.id.addord);




        b1a();
        //research();

    }

    public  void b1a() {
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData2(name.getText().toString(),"Falafel",
                                no.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(falafel.this,"order Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(falafel.this,"order not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
