package com.example.acer.firsthomeworktechnotrack;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    DateFormat format = DateFormat.getDateInstance();
    Calendar calendar = Calendar.getInstance();
    TextView date;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    private String fName;
    private String lName;
    private String gDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getBooleanExtra("finish", false)) finish();
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        date = (TextView) findViewById(R.id.date);
        date.setOnClickListener(this);
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDate();
        }
    };

    public void setDate(){
        new DatePickerDialog(MainActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void updateDate(){
        date.setText(format.format(calendar.getTime()));
    }

    public void onClickSave(View view){
        transaction = manager.beginTransaction();
            EditText firstName = (EditText) findViewById(R.id.firstName);
            EditText lastName = (EditText) findViewById(R.id.lastName);
            TextView sdate = (TextView) findViewById(R.id.date);

            gDate = sdate.getText().toString();
            fName = firstName.getText().toString();
            lName = lastName.getText().toString();
        transaction.commit();


        if (fName.length()>0 && lName.length()>0 && gDate.length()>0){
            Intent intent = new Intent(this, LastActivity.class);
            intent.putExtra("Date", gDate);
            intent.putExtra("First Name", fName);
            intent.putExtra("Last Name", lName);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        setDate();
    }
}
