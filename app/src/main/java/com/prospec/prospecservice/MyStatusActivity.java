package com.prospec.prospecservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MyStatusActivity extends AppCompatActivity {

    private int index;
    private String jsonString;
    private String[] titleStrings = {"สินเชื่อ", "ตลาด", "พนักงานประเมิน"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_status);

        index = getIntent().getIntExtra("index", 0);
        jsonString = getIntent().getStringExtra("json");

//        Create Toolbar
        createToolbar();

//        Create Fragment
        if (savedInstanceState == null) {

            switch (index) {
                case 0:
                    getSupportFragmentManager().beginTransaction().add(R.id.contentMyStatusFragment, new LoanFragment()).commit();
                    break;
                case 1:
                    getSupportFragmentManager().beginTransaction().add(R.id.contentMyStatusFragment, new MarketingFragment()).commit();
                    break;
                case 2:
                    getSupportFragmentManager().beginTransaction().add(R.id.contentMyStatusFragment, new ValuerFragment()).commit();
                    break;
            }

        }

    }   // Main Method

    private void createToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarMyStatus);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titleStrings[index]);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}   // Main Class
