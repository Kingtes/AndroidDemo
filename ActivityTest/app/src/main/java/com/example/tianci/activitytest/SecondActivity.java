package com.example.tianci.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        final Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Toast.makeText(this, "data is : " + data, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate: extra data is: " + data);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
