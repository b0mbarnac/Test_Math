package com.example.testmath;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.testmath.ui.main.MainViewModel;

//import android.support.annotation.NonNull;

public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "Выбор есть всегда.";
        String message = "При использовании подсказки, Вы получите 50% баллов. Вы уверены?";
        String button2String = "Да!";
        String button1String = "Нет!";
        MainViewModel mainViewModel = new MainViewModel();
//

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), mainViewModel.getHelp().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), "Вам повезет!", Toast.LENGTH_LONG)
                        .show();
            }
        });
        builder.setCancelable(true);

        return builder.create();
    }
}
