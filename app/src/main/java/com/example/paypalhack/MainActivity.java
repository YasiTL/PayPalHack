package com.example.paypalhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

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
    private final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(MainActivity.this, MainActivity.this);
        ImageButton speak = findViewById(R.id.speak);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Need to speak");
                try {
                    startActivityForResult(intent, REQ_CODE);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            "Sorry your device not supported",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
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
            // Toast.makeText(MainActivity.this, "You Swiped Right!", Toast.LENGTH_LONG).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK && null != data) {
                ArrayList result = data
                        .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                if(result.get(0).toString().contains("checking")){
                    MediaPlayer ring2= MediaPlayer.create(MainActivity.this,R.raw.open2);
                    ring2.start();
                    View v = new View(MainActivity.this);
                    Intent intent = new Intent (v.getContext(), Activity2.class);
                    startActivityForResult(intent, 0);
                }
                if(result.get(0).toString().contains("transactions")) {
                    MediaPlayer ring2= MediaPlayer.create(MainActivity.this,R.raw.open2);
                    ring2.start();
                    View v = new View(MainActivity.this);
                    Intent intent = new Intent (v.getContext(), Activity2.class);
                    startActivityForResult(intent, 0);
                }
                if(result.get(0).toString().contains("never mind")) {
                    MediaPlayer ring2= MediaPlayer.create(MainActivity.this,R.raw.open2);
                    ring2.start();
                    View v = new View(MainActivity.this);
                    Intent intent = new Intent (v.getContext(), Activity2.class);
                    startActivityForResult(intent, 0);
                } else {

                }
                }
            }
        }
    }
