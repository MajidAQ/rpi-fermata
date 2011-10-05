package test.helloworld;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;

public class Hellomain extends Activity {
    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    final TextView textView = (TextView)findViewById(R.id.textView);
	    // this is the view on which you will listen for touch events
	    final View touchView = findViewById(R.id.touchView);
	    touchView.setOnTouchListener(new View.OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            textView.setText("Touch coordinates : " +
	                String.valueOf(event.getXPrecision()) + "x" + String.valueOf(event.getYPrecision()));
	            textView.setText("Touch coordinates : " +
		                String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
		            
	            return true;
	        }
	    });
	}
}