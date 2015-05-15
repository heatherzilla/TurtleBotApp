package com.example.turtlebotproject;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class jingleActivity extends MainActivity	{

    Button startButton;
    Button stopButton;
    //defines the notes for jingle bells
    byte[] jingle = {(byte)140, (byte)0, (byte)16,
            (byte)76, (byte)16, (byte)76, (byte)16, (byte)76,  (byte)32,
            (byte)76, (byte)16, (byte)76, (byte)16, (byte)76,(byte)32,
            (byte)76, (byte)16, (byte)79, (byte)16,(byte)72, (byte)16,
            (byte)74, (byte)16, (byte)76,(byte)32, (byte)77, (byte)16,
            (byte)77, (byte)16, (byte)77, (byte)16, (byte)77, (byte)32, (byte)77, (byte)16,
            (byte)140, (byte)1, (byte)7,
            (byte)76, (byte)16, (byte)76, (byte)32, (byte)79, (byte)16,
            (byte)79, (byte)16, (byte)77, (byte)16, (byte)74, (byte)16, (byte)72, (byte)32};
    //defines code needed to start playing jingle bells
    byte[] play1 ={(byte)141,(byte)0};
    byte[] play2 = {(byte)141,(byte)1};

    //overwrites jingle bells once we are done.
    // This prevents the song from starting in the middle next time we play it.
    byte[] cleanup ={(byte)140, (byte)0, (byte)1, (byte)76, (byte)0,
            (byte)140, (byte)1, (byte)1, (byte)76, (byte)0,
            (byte)141, (byte)0, (byte)141, (byte)1};

    //happy birthday
/*    byte[] jingle = {(byte)140,  (byte)0, (byte)16,
    (byte)67,  (byte)32, (byte)67, (byte)32, (byte)69, (byte)32, (byte)67, (byte)32, (byte)72, (byte)32, (byte)71 , (byte)32,
    (byte)67, (byte)32, (byte)67, (byte)32, (byte)69, (byte)32, (byte)67, (byte)32, (byte)74, (byte)32, (byte)72, (byte)32,
    (byte)67, (byte)32, (byte)67, (byte)32, (byte)68, (byte)32, (byte)64, (byte)32,
     (byte)140, (byte)1, (byte)9,
     (byte)72, (byte)16, (byte)71, (byte)16, (byte)69, (byte)16,
    (byte)65, (byte)16, (byte)65, (byte)16, (byte)64, (byte)16, (byte)72, (byte)16, (byte)74, (byte)16, (byte)72, (byte)16};*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jingle);
        addListenerOnStartButton();
        addListenerOnStopButton();
    }

    // button for starting script
    public void addListenerOnStartButton() {

        // assign buttons to xml button ids
        startButton = (Button) findViewById(R.id.button1);

        // joystick activity
        startButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                TurtleBotController.sendRaw(jingle);
                TurtleBotController.sendRaw(play1);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TurtleBotController.sendRaw(play2);

            }
        });
    }

    // button for stopping script
    public void addListenerOnStopButton() {

        // assign buttons to xml button ids
        stopButton = (Button) findViewById(R.id.button2);

        //scripts activity
        stopButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                TurtleBotController.stop();
                TurtleBotController.sendRaw(cleanup);

            }
        });
    }
}
