package com.example.jawaher.eat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import  android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;

public class singupactivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singupactivity);

        autoCompleteTextView =
                (AutoCompleteTextView)findViewById(R.id.search);

        String[] suggestion = getResources().getStringArray(R.array.search);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, suggestion);
        autoCompleteTextView.setAdapter(adapter);

    }
    public void onButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(),zeterzeet.class);
        startActivity(myIntent);
    }
}
