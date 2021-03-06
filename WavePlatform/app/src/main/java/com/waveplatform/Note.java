package com.waveplatform;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static android.graphics.Rect.intersects;


/**
 * Created by Sam on 1/20/2017.
 */

public class Note extends Activity {

    Bitmap note;

    public final int STOP = 1;

    public final int UP = 2;

    public final int DOWN = 3;

    private int moving = STOP;

    private float x, y;

    private final long SPEED = 2000;

    private float length, height;

    private float screenX;

    private Rect Sharp;

    private Rect player;

    private int x2, y2, y3;

    public Note(Bitmap n, int x, int y){
        screenX = x;

        this.x = x/3 - (n.getWidth()/2);
        this.y = y-400;

        note = n;

    }

    public float[] getArea() {
        float xVal = this.x - this.height;
        float yVal = this.y + this.length;
        float[] area = new float[2];
        area[0] = xVal;
        area[1] = yVal;
        return area;
    }

    public Bitmap getNote(){
        return this.note;
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public boolean checkCollision(Rect player, Rect Sharp) {
        this.player = player;
        this.Sharp = Sharp;
        return intersects(player, Sharp);
    }

    public Rect GetBounds(){
        return new Rect(this.x2, this.y2, this.x2 + note.getWidth(), this.y2 + note.getHeight());
    }

    public void setMovement(int state){
        moving = state;
    }

    public void update(long fps){
        if (moving == UP){
            y = y - 150;
            if (note.getHeight() >= 0)
                y = y - 1;
        }
        if (moving == DOWN)
        {
            y = y + SPEED/fps;
        }

    }
}
