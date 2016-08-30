package com.wckj.gfsj.Agora;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;


/**
 * Provide basic func for all activities used in App
 *
 * Created by on 9/12/15.
 */
public class BaseActivity extends FragmentActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }


    // Global view click listener
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onUserInteraction(view);
        }
    };


    public View.OnClickListener getViewClickListener(){
        return onClickListener;
    }

    /**
     * Central point of handling all view click events
     * @param view
     */
    public void onUserInteraction(View view){

    }


}
