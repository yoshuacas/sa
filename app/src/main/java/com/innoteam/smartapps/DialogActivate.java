package com.innoteam.smartapps;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class DialogActivate extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.dialog_activate);

        // Fill the dialog with the right texts
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_activate, null);
        View tv = v.findViewById(R.id.dialog_activate_instructions);
        ((TextView)tv).setText(R.string.dialog_activate_text_instructions);

        LinearLayout buttonAccept = (LinearLayout)findViewById(R.id.dialog_activate_ok_button);
        buttonAccept.setOnClickListener(mAcceptListener);

        LinearLayout buttonCancel = (LinearLayout)findViewById(R.id.dialog_activate_cancel_button);
        buttonCancel.setOnClickListener(mCancelListener);


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private View.OnClickListener mAcceptListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ResultActivate.class);
            startActivity(intent);
            finish();
        }
    };

    private View.OnClickListener mCancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
