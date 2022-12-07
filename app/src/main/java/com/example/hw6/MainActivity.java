package com.example.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int shift = 0;
    String edStr;
    boolean done = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        TextView tv = findViewById(R.id.mytxt);
        EditText ed = (EditText)findViewById(R.id.edtxt);
        EditText ed2 = (EditText)findViewById(R.id.edtxt2);
        Bundle info = new Bundle();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                String temp = ed2.getText().toString();
                shift = Integer.parseInt(temp);
                edStr = ed.getText().toString();

                if (edStr.equals("")) {
                    info.putString("myStr", "");
                } else {
                    info.putString("myStr", edStr);
                }
                // adjusts for any number larger than 26. Shift should still work
                // but rather than shifting the number a bunch, I just edit it correctly
                while (shift > 26) {
                    shift -= 26;
                }
                // this compensates for negative numbers, so that it will function as
                // a correct shift in the other direction. Fancy tricks
                while (shift < 0) {
                    shift += 26;
                }
                // get the user entered data into my activity
                info.putInt("shift", shift);
                i.putExtras(info);
                startActivity(i);
            }
        });
    }
}