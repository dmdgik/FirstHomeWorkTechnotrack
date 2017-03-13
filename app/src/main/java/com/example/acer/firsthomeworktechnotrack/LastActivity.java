package com.example.acer.firsthomeworktechnotrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    private TextView getFirstName;
    private TextView getLastName;
    private TextView getDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        getFirstName = (TextView) findViewById(R.id.getFirstName);
        getLastName = (TextView) findViewById(R.id.getLastName);
        getDate = (TextView) findViewById(R.id.getDate);

        getFirstName.setText(getIntent().getStringExtra("First Name"));
        getLastName.setText(getIntent().getStringExtra("Last Name"));
        getDate.setText(getIntent().getStringExtra("Date"));
    }

    public void onClickEdit(View view){
        Intent intentEdit = new Intent(this, MainActivity.class);
        startActivity(intentEdit);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("finish", true);
        startActivity(intent);
    }
}
