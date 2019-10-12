package com.example.paypalhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements OnGestureListener {
    GestureDetector gestureDetector;
    TextView lbl1, money;
    TextToSpeech talk;
    double rnum;
  //  boolean opened;

  private MediaPlayer ring4;
 // private TextView money;
  private static final String LOGCAT = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(MainActivity.this, MainActivity.this);
       // rnum = (int)(Math.random()* 50+1);


        money = (TextView)findViewById(R.id.textView2);

        talk = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    talk.setLanguage(Locale.US);
                    if(talk.equals(TextToSpeech.LANG_MISSING_DATA )|| talk.equals(TextToSpeech.LANG_NOT_SUPPORTED)){
                        money.setText(":(");
                    }
                    else{
                        String txt = "Hi testuser you're account balance is" + money.getText().toString();
                        talk.speak(txt,TextToSpeech.QUEUE_FLUSH,null);
                    }
                }

            }
        });

    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getX() - motionEvent2.getX() > 50) {
            //   Toast.makeText(MainActivity.this, "You Swiped Left!", Toast.LENGTH_LONG).show();
            MediaPlayer ring2= MediaPlayer.create(MainActivity.this,R.raw.open2);
            ring2.start();
            View v = new View(MainActivity.this);
            Intent intent = new Intent (v.getContext(), Activity2.class);
            startActivityForResult(intent, 0);
            return true;
        }
        if (motionEvent2.getX() - motionEvent1.getX() > 50) {
            return true;
        } else {
            return true;
        }

    }
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }
}
