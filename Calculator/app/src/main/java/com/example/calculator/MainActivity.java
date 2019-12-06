package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private TextView greetingText;
    private static final Map<String, String> ageMap = new HashMap<String, String>() {{
        put("1", "Newborn"); put("2", "Infant");
        put("3", "Toddler"); put("4", "Lil kid");
        put("5", "Older lil kid"); put("6", "Child");
        put("13", "Teenager"); put("18", "Deceased");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingText = findViewById(R.id.greeting_textView);
        greetingText.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            String lifeStage = "";
            String celebration = "HAPPY BIRTHDAY";

            @Override
            public void onClick(View v) {
                if(counter==18) {
                    counter = 0;
                    celebration = "HAPPY REBIRTH";
                }
                counter++;
                if(ageMap.containsKey(""+counter)) {
                    lifeStage = ageMap.get("" + counter);
                    greetingText.setText(lifeStage);
                }
                Toast.makeText(MainActivity.this, celebration, Toast.LENGTH_SHORT).show();
                celebration = "HAPPY BIRTHDAY";
            }
        });
    }
}