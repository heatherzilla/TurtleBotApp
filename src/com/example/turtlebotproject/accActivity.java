package com.example.turtlebotproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class accActivity extends MainActivity {

    // create page buttons
    Button joyButton;
    Button scriptButton;
    Button accButton;
    Button voiceButton;

    // create accelerometer buttons
    Button accEnable;
    Button accDisable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acc);

        // setup page button listeners
        addListenerOnButton();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();

        //setup accelerometer buttons
        addListenerOnEnableButton();
        addListenerOnDisableButton();
    }

    // BUTTONS FOR LINKING TO SCREENS
    // button for going to Joystick page
    public void addListenerOnButton() {

        final Context context = this;

        // assign buttons to xml button ids
        joyButton = (Button) findViewById(R.id.button1);

        // joystick activity
        joyButton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(context, joystickActivity.class);
                startActivity(intent);
            }
        });
    }
    // button for going to Scripts page
    public void addListenerOnButton2() {

        final Context context = this;

        // assign buttons to xml button ids
        scriptButton = (Button) findViewById(R.id.button2);

        //scripts activity
        scriptButton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(context, scriptsActivity.class);
                startActivity(intent);

            }
        });
    }

    //button for going to voice control page
    public void addListenerOnButton3() {

        final Context context = this;

        // assign buttons to xml button ids
        voiceButton = (Button) findViewById(R.id.button3);

        // voice activity
        voiceButton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(context, voiceActivity.class);
                startActivity(intent);

            }
        });
    }
    // button for going to Accelerometer page
    public void addListenerOnButton4() {

        final Context context = this;

        // assign buttons to xml button ids
        accButton = (Button) findViewById(R.id.button4);

        // acc activity
        accButton.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                Intent intent = new Intent(context, accActivity.class);
                startActivity(intent);

            }
        });
    }

    // BUTTONS FOR ENABLING/DISABLING ACCELEROMETER
    // acc enable button listener
    public void addListenerOnEnableButton() {

        // assign buttons to xml button ids
        accEnable = (Button) findViewById(R.id.button5);

        // assign accEnable listener
        accEnable.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                // not implemented yet
            }
        });
    }
    // acc disable button listener
    public void addListenerOnDisableButton() {

        // assign buttons to xml button ids
        accDisable = (Button) findViewById(R.id.button6);

        // assign accDisable listener
        accDisable.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {

                // not implemented yet
            }
        });
    }

}
