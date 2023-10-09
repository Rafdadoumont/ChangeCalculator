package com.example.changecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Calculator calculator;

    Button calculateButton;
    EditText amountToPay, amountPaid;

    double amountToPayValue, amountPaidValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();

        amountToPay = findViewById(R.id.amountToPay);
        amountPaid = findViewById(R.id.amountPaid);

        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> {
            amountToPayValue = Double.parseDouble(amountToPay.getText().toString());
            amountPaidValue = Double.parseDouble(amountPaid.getText().toString());
            resetChangesView();
            updateChangesView(calculator.calculateChange(amountToPayValue, amountPaidValue));
        });


    }

    private void resetChangesView() {
        for (ChangeEnum changeEnum: ChangeEnum.values()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("text").append(changeEnum.getStringValue());

            int resourceId = getResources().getIdentifier(stringBuilder.toString(), "id", getPackageName());
            TextView textView = findViewById(resourceId);
            textView.setText(String.valueOf(0));
        }
    }

    private void updateChangesView(Map<ChangeEnum, Integer> changeMap) {
        Iterator<Map.Entry<ChangeEnum, Integer>> iterator = changeMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<ChangeEnum, Integer> entry = iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("text").append(entry.getKey().getStringValue());

            int resourceId = getResources().getIdentifier(stringBuilder.toString(), "id", getPackageName());
            TextView textView = findViewById(resourceId);
            textView.setText(String.valueOf(entry.getValue()));
        }
    }
}