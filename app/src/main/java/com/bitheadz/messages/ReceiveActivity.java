package com.bitheadz.messages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        //get intent and value from putExtra
        Intent i = getIntent();
        String messageText = i.getStringExtra(EXTRA_MESSAGE);

        //make reference to textView and show the message from putExtra
        TextView receiveMessage = (TextView)findViewById(R.id.receivedMsg);
        receiveMessage.setText(messageText);

        //make reference to close button and set it to use onClose method
        Button btnClose = (Button)findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClose();
            }
        });
    }

    public void onClose() {
        finish();
    }
}
