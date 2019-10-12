package com.example.paypalhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;

import android.widget.Button;
import android.widget.ListView;

public class Activity2 extends AppCompatActivity implements OnGestureListener  {
    Button btn2 ;
    GestureDetector gestureDetector;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transactions);
        gestureDetector = new GestureDetector(Activity2.this, Activity2.this);
        list = (ListView)findViewById(R.id.listView);

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent (v.getContext(), MainActivity.class);
//                startActivityForResult(intent, 0);
//            }
//        });



    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getX() - motionEvent2.getX() > 50) {
            //   Toast.makeText(MainActivity.this, "You Swiped Left!", Toast.LENGTH_LONG).show();
            View v = new View(Activity2.this);
            Intent intent = new Intent (v.getContext(), Activity3.class);
            startActivityForResult(intent, 0);
            MediaPlayer ring2= MediaPlayer.create(Activity2.this,R.raw.open3);
            ring2.start();

            return true;
        }
        if (motionEvent2.getX() - motionEvent1.getX() > 50) {
            // Toast.makeText(MainActivity.this, "You Swiped Right!", Toast.LENGTH_LONG).show();
            View v = new View(Activity2.this);
            Intent intent = new Intent (v.getContext(), MainActivity.class);
            startActivityForResult(intent, 0);
            MediaPlayer ring2= MediaPlayer.create(Activity2.this,R.raw.open1);
            ring2.start();
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
