package com.example.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class ResultActivity extends AppCompatActivity {
    private String newStr = "";
    int ascii;
    char c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView ab_tv = findViewById(R.id.result_tv);
        Button btn = findViewById(R.id.btn3);

        int passedInt = 0;
        String passedString = "";
        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            passedInt = extras.getInt("shift");
            passedString = extras.getString("myStr");
            passedString = passedString.toLowerCase();
        }
        /* Here I'm using ascii values to letters. I concatenate the results to newStr
        * with a few checks for other characters and whether a shift will go past the end of
        * the alphabet. If another character or a space was typed in, it remains the same */
        for (int i = 0; i < passedString.length(); i++) {
            ascii = passedString.charAt(i);
            if (ascii > 96 && ascii < 123) {
                if (ascii+passedInt <= 122) {
                    ascii += passedInt;
                    c = (char)ascii;
                    newStr = newStr + c;
                } else {
                    ascii = ascii + passedInt - 123 + 97;
                    c = (char)ascii;
                    newStr = newStr + c;
                }
            } else {
                c = (char)ascii;
                newStr = newStr + c;
            }
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ab_tv.setText(newStr);
            }
        });
    }
}