package com.example.mpd_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RSSReader rssReader = new RSSReader();

    Button goToTrafficInfo;
    Button goToWelcome;
    Button displayInformation;
    EditText startDateValue;
    EditText endDateValue;
    Spinner filerBySpinner;
    Spinner sortBySpinner;
    int mYear, mMonth, mDay;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //#################################################################################################

        startDateValue = findViewById(R.id.startDateValue);
        startDateValue.setOnClickListener(this);

        //#################################################################################################

        endDateValue  = findViewById(R.id.endDateValue);
        endDateValue.setOnClickListener(this);

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

        goToTrafficInfo = findViewById(R.id.goToTrafficInfo);
        goToTrafficInfo.setOnClickListener(this);

        //#################################################################################################

        goToWelcome = findViewById(R.id.goToWelcome);
        goToWelcome.setOnClickListener(this);

        //#################################################################################################

        displayInformation = findViewById(R.id.displayInformation);
        displayInformation.setOnClickListener(this);

        //#################################################################################################

        viewFlipper = findViewById(R.id.viewFlipper);

        //#################################################################################################





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

        if(v==goToTrafficInfo)
        {
            viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.trafficInfo)));

        }

        if(v==goToWelcome)
        {
            viewFlipper.setDisplayedChild(viewFlipper.indexOfChild(findViewById(R.id.welcome)));
        }

        if(v==displayInformation)
        {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            executor.execute(new Runnable() {

                @Override
                public void run() {

                    ///////////////////////////////////////////////////////////////////////////////////

                    // Fetch RSS data from BBC News
                    rssReader.FetchRSS();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(rssReader.getRSSString());

                        }
                    });



                }
            });
        }

    }
}