package com.example.paypalhack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;


public class Activity3 extends AppCompatActivity implements OnGestureListener {
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transactions);
        gestureDetector = new GestureDetector(Activity3.this,Activity3.this);

    }
    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if (motionEvent1.getX() - motionEvent2.getX() > 50) {
            //   Toast.makeText(MainActivity.this, "You Swiped Left!", Toast.LENGTH_LONG).show();


            return true;
        }
        if (motionEvent2.getX() - motionEvent1.getX() > 50) {
            // Toast.makeText(MainActivity.this, "You Swiped Right!", Toast.LENGTH_LONG).show();
            View v = new View(Activity3.this);
            Intent intent = new Intent (v.getContext(), Activity2.class);
            startActivityForResult(intent, 0);
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
