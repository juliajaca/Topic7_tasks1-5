package com.example.topic7_tasks1_5;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker.
        final Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it.
        return new TimePickerDialog(getActivity(), this, hora, min,
                DateFormat.is24HourFormat(getActivity()));
    }


    @Override
    public void onTimeSet(android.widget.TimePicker view, int hora, int min) {
        MainActivity activity = (MainActivity) getActivity();
        activity.recogerHora(hora, min);
    }


}
