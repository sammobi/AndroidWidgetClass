package com.softgridtech.androidwidgetclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Spinner2CheckBoxActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView mainTv;
    //  SeekBar mainSkb;
    CheckBox maleChk, femaleChk;
    Spinner mainSpn;
    List<String> spnData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTv = (TextView) findViewById(R.id.main_activity_tv);

        // mainSkb = (SeekBar) findViewById(R.id.main_activity_skBar);
        maleChk = (CheckBox) findViewById(R.id.male__chk);
        femaleChk = (CheckBox) findViewById(R.id.female_chk);
        mainSpn = (Spinner) findViewById(R.id.main_activity_spn);


        maleChk.setText("Male");
        femaleChk.setText("Female");
        mainSpn.setOnItemSelectedListener(this);

        spnData = new ArrayList<String>();
        spnData.add("Select Gender");
        spnData.add("Male");
        spnData.add("Female");

        ArrayAdapter<String> spnAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spnData);
        mainSpn.setAdapter(spnAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedvalue = parent.getItemAtPosition(position).toString();
        if (selectedvalue.equalsIgnoreCase("Male")) {
            maleChk.setChecked(true);

            femaleChk.setChecked(false);

        } else if (selectedvalue.equalsIgnoreCase("Female")) {
            femaleChk.setChecked(true);
            maleChk.setChecked(false);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
