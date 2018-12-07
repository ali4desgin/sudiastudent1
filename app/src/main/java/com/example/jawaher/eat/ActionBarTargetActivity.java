package com.example.jawaher.eat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActionBarTargetActivity extends AppCompatActivity {

    ActionBar actionBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_target);

        // Get ActionBar
        actionBar = getSupportActionBar();
        // Set below attributes to add logo in ActionBar.
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.drawable.logo);

        actionBar.setTitle("Dev2Qa.com - News");
    }

    /* This method will be called by system when app initialize. */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the action bar menu from menu xml file.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_example_target_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* This method will be invoked when user select a menu in action bar. */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Get user select menu id and title.
        int itemId = item.getItemId();
        String menuTitle = (String)item.getTitle();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("You clicked menu ");
        stringBuffer.append(menuTitle);

        String message = stringBuffer.toString();

        switch (itemId)
        {
            case R.id.menuadol:
                this.showAlertDialog(message);
                break;
            case R.id.menuBack:
                Intent intent = new Intent(this, ActionBarActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.menuv:
                this.showAlertDialog(message);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    // Show a AlertDialog to show message.
    private void showAlertDialog(String message)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(ActionBarTargetActivity.this).create();
        alertDialog.setMessage(message);
        alertDialog.show();
    }
}
