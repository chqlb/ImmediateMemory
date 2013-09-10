package com.chqla.immediatememory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class ButtonAdapter extends BaseAdapter {
    private Context context;
    private int count;
    private int array[];
    private long delay;
    private int curNumber;
    
    private Button buttons[];
    private Handler handler;
    private Activity activity;
    private Runnable puzzleButtons = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < count; i ++) {
				buttons[i].setText("?");
	        	buttons[i].setClickable(true);
			}
			curNumber = 1;
		}
    };


    public ButtonAdapter(Context c, int ct, double d, Activity a) {
        context = c;
        count = ct;
        array = new int[count];
        buttons = new Button[count];
        this.delay = (long)d*1000;
        curNumber = 1;
        handler = new Handler();
        activity = a;
        
        // init array
        for (int i = 0; i < count; i++) {
        	array[i] = i+1;
        	
        	buttons[i] = new Button(context);
        	buttons[i].setLayoutParams(new GridView.LayoutParams(80, 80));
        	buttons[i].setPadding(0, 0, 0, 0);
        	buttons[i].setClickable(false);
        	buttons[i].setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Button btn = (Button) v;
					int value = Integer.parseInt(btn.getHint().toString());
					
					if (value == curNumber) {
						btn.setText(String.valueOf(value));
						btn.setClickable(false);
						if (value == count) {
							
							promptAlertDialog("You win!");
						}
						else {
							curNumber++;
						}
					}
					else {
						promptAlertDialog("You lose!");
						showArray();
					}
				}
        	});
        }
        start();
    }
    
    private void start() {
        // shuffle array
        for (int i = count-1; i >= 0; i--) {
        	int p = (int) (Math.random()*(i+1));
        	int t = array[i];
        	array[i] = array[p];
        	array[p] = t;
        	buttons[i].setText(String.valueOf(array[i]));
        	buttons[i].setHint(String.valueOf(array[i]));        
        }
        handler.postDelayed(puzzleButtons, this.delay);
    }
    
    private void showArray() {
        for (int i = count-1; i >= 0; i--) {
        	CharSequence c = buttons[i].getHint();
        	buttons[i].setText(c);
        	buttons[i].setClickable(false);
        }
    }
    
    private void promptAlertDialog (String str) {
    	new AlertDialog.Builder(context)
        .setMessage(str)
        .setCancelable(false)
        .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
         	   dialog.cancel();
         	   start();
            }
        })
        .setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
          	   dialog.cancel();
          	   activity.finish();
             }
         })
        .show();	
    }
    

    public int getCount() {
        return count;
    }

    public Object getItem(int position) {
        return buttons[position];
    }

    public long getItemId(int position) {
        return buttons[position].getId();
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) { 
        	buttons[position] = (Button) convertView;
        }
        return buttons[position];
    }

}