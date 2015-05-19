package com.example.turtlebotproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import com.example.turtlebotproject.JoystickMovedListener;
import com.example.turtlebotproject.JoystickView;

public class joystickActivity extends MainActivity {

    // create page buttons
    Button joyButton;
    Button scriptButton;
    Button accButton;
    Button voiceButton;

    // create radio group
    RadioGroup velocityGroup;
    RadioButton fast;
    RadioButton medium;
    RadioButton slow;

    //joystick variables
    TextView txtX, txtY;
    JoystickView joystick;

    // create arrow buttons
    ImageButton up;
    ImageButton down;
    ImageButton left;
    ImageButton right;

    // speed factor for velocity of turtlebot
    int factor = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joystick);

        // setup page button listeners
        addListenerOnButton();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();

        // setup velocity listener
        addRadioButtonListener1();
        addRadioButtonListener2();
        addRadioButtonListener3();

        //arrow button listeners
        addListenerOnButtonLeft();
        addListenerOnButtonRight();
        addListenerOnButtonForward();
        addListenerOnButtonBackward();

        // joystick variables
        // variables show x and y joystick movement
        txtX = (TextView)findViewById(R.id.textView2);
        txtY = (TextView)findViewById(R.id.textView3);
        // joystick view
        joystick = (JoystickView)findViewById(R.id.joystickView);
        // joystick listener
        joystick.setOnJostickMovedListener(_listener);
    }

    // method to set speed factor
    public void setFactor(int x)
    {
        this.factor=x;
    }

    // method to print factor
    public void printFactor()
    {
        System.out.println("" + this.factor + "");
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

    //turn left
    public void addListenerOnButtonLeft() {
        left = (ImageButton) findViewById(R.id.imageButton3);

        left.setOnTouchListener(new OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View arg0, MotionEvent event) {
                                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                            TurtleBotController.drive(-(10*factor), 10*factor);
                                        }
                                        else if (event.getAction() == MotionEvent.ACTION_UP){
                                            TurtleBotController.drive(0, 0);
                                        }
                                        return false;}
                                }
        );
    }

    //turn right
    public void addListenerOnButtonRight(){
        right = (ImageButton) findViewById(R.id.imageButton4);

        right.setOnTouchListener(new OnTouchListener() {

                                     public boolean onTouch(View arg0, MotionEvent event) {
                                         if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                             TurtleBotController.drive(10*factor, -(10*factor));
                                         } else if (event.getAction() == MotionEvent.ACTION_UP) {
                                             TurtleBotController.drive(0, 0);
                                         }
                                         return false;
                                     }
                                 }
        );
    }
    //reverse
    private void addListenerOnButtonBackward() {

        down = (ImageButton) findViewById(R.id.imageButton);

        down.setOnTouchListener(new OnTouchListener() {

                                    public boolean onTouch(View arg0, MotionEvent event) {
                                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                            TurtleBotController.drive(-(10*factor), -(10*factor));
                                        } else if (event.getAction() == MotionEvent.ACTION_UP) {
                                            TurtleBotController.drive(0, 0);
                                        }
                                        return false;
                                    }
                                }
        );
    }

    //forward
    private void addListenerOnButtonForward() {

        up = (ImageButton) findViewById(R.id.imageButton2);

        up.setOnTouchListener(new OnTouchListener() {

                                  public boolean onTouch(View arg0, MotionEvent event) {
                                      /*byte[] forward = new byte[]{(byte) 128, (byte) 131, (byte) 137, (byte) 200, (byte) 0,
                                              (byte) 128, (byte) 0};*/
                                      if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                          /*TurtleBotController.sendRaw(forward);*/
                                          TurtleBotController.drive(10*factor, 10*factor);
                                      } else if (event.getAction() == MotionEvent.ACTION_UP) {
                                          TurtleBotController.drive(0, 0);
                                      }
                                      return false;
                                  }
                              }
        );
    }

    //joystick method creates the listener, and sets the value of the orientation to the screen
    private JoystickMovedListener _listener = new JoystickMovedListener() {

        @Override
        public void OnMoved(int pan, int tilt) {
            txtX.setText(Integer.toString(pan));
            txtY.setText(Integer.toString(tilt));

            int x = pan * factor;
            int y = -tilt * factor;


            //System.out.println("" + x + ", " + y);
            TurtleBotController.driveXY(x, y);
        }

        @Override
        public void OnReleased() {
            txtX.setText("Stopped");
            txtY.setText("Stopped");
            TurtleBotController.drive(0, 0);
        }
    };


    private void addRadioButtonListener1() {

        // get radio button ids
        fast = (RadioButton) findViewById(R.id.radio0);

        // setup listeners
        // fast radio button
        fast.setOnClickListener(new OnClickListener() {

                                    public void onClick(View arg0) {

                                        // set speed to fast
                                        setFactor(100);
                                        printFactor();
                                    }

                                }
        );
        System.out.println("" + factor + "");
    }

    // medium velocity button listener
    private void addRadioButtonListener2() {

        // get radio button ids
        medium = (RadioButton) findViewById(R.id.radio1);

        // setup listeners
        medium.setOnClickListener(new OnClickListener() {

                                      public void onClick(View arg0) {

                                          // set speed to medium
                                          setFactor(23);
                                          printFactor();
                                      }
                                  }
        );
        System.out.println("" + factor + "");
    }

    // slow velocity button listener
    private void addRadioButtonListener3() {

        // get radio button ids
        slow = (RadioButton) findViewById(R.id.radio2);

        // fast radio button
        slow.setOnClickListener(new OnClickListener() {

                                    public void onClick(View arg0) {

                                        // set speed to slow
                                        setFactor(4);
                                        printFactor();
                                    }
                                }
        );
    }
}