package com.example.movimiento;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView imagen;
	float x;
	float y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		imagen = (ImageView) findViewById(R.id.imagen);
		return true;
	}
	
	public boolean onTouchEvent(MotionEvent e) {
		super.onTouchEvent(e);
		x = e.getX();
		y = e.getY();
		
		switch (e.getAction()) {
		case MotionEvent.ACTION_DOWN:
			float x2 = imagen.getX();
			float y2 = imagen.getY();
			
			if (x >= x2) {
				x2 += 5;
			} else {
				x2 -= 5;
			}
			
			if (y >= y2 + 100) {
				y2 += 5;
			} else {
				y2 -= 5;
			}
			
			imagen.setX(x2);
			imagen.setY(y2);
			
			break;
		}
		
		return true;
	}
	
	public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_S){
            imagen.setY(imagen.getY()+5);
            event.startTracking();
        }
        if(keyCode==KeyEvent.KEYCODE_W){
        	imagen.setY(imagen.getY()-5);
            event.startTracking();
        }
        if(keyCode==KeyEvent.KEYCODE_D){
        	imagen.setX(imagen.getX()+5);
            event.startTracking();
        }
        if(keyCode==KeyEvent.KEYCODE_A){
        	imagen.setX(imagen.getX()-5);
            event.startTracking();
        }

        return false;
    }
}
