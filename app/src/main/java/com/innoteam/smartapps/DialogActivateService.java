package com.innoteam.smartapps;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DialogActivateService extends DialogFragment {

    int mNum;

    static DialogActivateService newInstance(int num) {
        DialogActivateService f = new DialogActivateService();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Fill the dialog with the right texts
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_activate, null);
        View tv = v.findViewById(R.id.dialog_activate_instructions);
        ((TextView)tv).setText(R.string.dialog_activate_text_instructions);

        builder.setView(v);
        builder.setTitle(R.string.dialog_activate_service_title)
                .setPositiveButton(R.string.dialog_activate_service_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        return builder.create();

    }

}