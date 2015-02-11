package com.innoteam.smartapps;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DialogActivate extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activate);

        // Fill the dialog with the right texts
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_activate, null);
        View tv = v.findViewById(R.id.dialog_activate_instructions);
        ((TextView)tv).setText(R.string.dialog_activate_text_instructions);

        LinearLayout boton = (LinearLayout)findViewById(R.id.dialog_activate_ok_button);
        boton.setOnClickListener(mCorkyListener);


    }


    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(DialogActivate.this,
                    "activar",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(v.getContext(), ResultActivate.class);
            startActivity(intent);
        }
    };



}
