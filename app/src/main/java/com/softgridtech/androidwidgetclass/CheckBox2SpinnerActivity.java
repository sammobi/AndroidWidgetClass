package com.softgridtech.androidwidgetclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CheckBox2SpinnerActivity extends AppCompatActivity {

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

        maleChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    femaleChk.setChecked(false);

                    mainSpn.setSelection(((ArrayAdapter<String>) mainSpn.getAdapter()).getPosition("Male"));
                }
            }
        });

        femaleChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    maleChk.setChecked(false);
                    mainSpn.setSelection(((ArrayAdapter<String>) mainSpn.getAdapter()).getPosition("Female"));

                }
            }
        });


        spnData = new ArrayList<String>();


        spnData.add("Select Gender");
        spnData.add("Male");
        spnData.add("Female");


        ArrayAdapter<String> spnAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spnData);
        mainSpn.setAdapter(spnAdapter);


    }


  /*  @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        if (maleChk.isChecked()) {

            mainSpn.setSelection(((ArrayAdapter<String>) mainSpn.getAdapter()).getPosition("1"));


        } else if (femaleChk.isChecked()) {

            mainSpn.setSelection(((ArrayAdapter<String>) mainSpn.getAdapter()).getPosition("2"));


        }


    }*/
}

