package com.example.mpd_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText startDateValue;
    EditText endDateValue;
    Spinner filerBySpinner;
    Spinner sortBySpinner;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startDateValue = findViewById(R.id.startDateValue);
        endDateValue  = findViewById(R.id.endDateValue);

        //#################################################################################################

        filerBySpinner = findViewById(R.id.filerBySpinner);

        ArrayAdapter<CharSequence> filerBySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.filterByOptions, android.R.layout.simple_spinner_item);
        filerBySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filerBySpinner.setAdapter(filerBySpinnerAdapter);

        //#################################################################################################
        sortBySpinner  = findViewById(R.id.sortBySpinner);

        ArrayAdapter<CharSequence> sortrBySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.sortByOptions, android.R.layout.simple_spinner_item);
        filerBySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortBySpinner.setAdapter(sortrBySpinnerAdapter);

        //#################################################################################################


        startDateValue.setOnClickListener(this);
        endDateValue.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == startDateValue) {
            final Calendar calendar = Calendar.getInstance ();
            mYear = calendar.get ( Calendar.YEAR );
            mMonth = calendar.get ( Calendar.MONTH );
            mDay = calendar.get ( Calendar.DAY_OF_MONTH );

            //show dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog ( this, new DatePickerDialog.OnDateSetListener () {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    startDateValue.setText ( dayOfMonth + "/" + (month + 1) + "/" + year );
                    startDateValue.setTextColor(Color.parseColor("#000000"));
                }
            }, mYear, mMonth, mDay );
            datePickerDialog.show ();
        }

        if (v == endDateValue) {
            final Calendar calendar = Calendar.getInstance ();
            mYear = calendar.get ( Calendar.YEAR );
            mMonth = calendar.get ( Calendar.MONTH );
            mDay = calendar.get ( Calendar.DAY_OF_MONTH );

            //show dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog ( this, new DatePickerDialog.OnDateSetListener () {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    endDateValue.setText ( dayOfMonth + "/" + (month + 1) + "/" + year );
                    endDateValue.setTextColor(Color.parseColor("#000000"));
                }
            }, mYear, mMonth, mDay );
            datePickerDialog.show ();
        }

    }
}