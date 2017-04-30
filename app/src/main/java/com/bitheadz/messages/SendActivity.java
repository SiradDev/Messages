package com.bitheadz.messages;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        /* make reference to a button and set onClick
        listener to use onSend method */
        Button btnSend = (Button)findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSend();
            }
        });
    }

    //method to execute on button click
    public void onSend() {

        //make reference to editText and put its value into String variable
        EditText msgText = (EditText)findViewById(R.id.editMessage);
        String message = msgText.getText().toString();

        //check if editText is empty or not
        if(!message.toString().equals("")) {

            //make new intent and use putExtra to convey the value
            Intent i = new Intent(this, ReceiveActivity.class);
            i.putExtra(ReceiveActivity.EXTRA_MESSAGE, message);
            startActivity(i);

        }else{
            //get value for toast message from Strings.xml
            String toastMessage = getString(R.string.toastMessage);

            //show toast message in case editText is empty
            Toast.makeText(SendActivity.this, toastMessage,Toast.LENGTH_SHORT).show();
        }

    }
}
