package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    private EditText inputEditText;
    private Spinner fromSpinner;
    private Spinner toSpinner;
    private TextView resultTextView;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        inputEditText = findViewById(R.id.input_edit_text);
        fromSpinner = findViewById(R.id.from_spinner);
        toSpinner = findViewById(R.id.to_spinner);
        resultTextView = findViewById(R.id.result_text_view);
        convertButton = findViewById(R.id.convert_button);



        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.from_spinner, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.to_spinner, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(adapter2);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        String inputText = inputEditText.getText().toString();
        if (inputText.isEmpty()) {
            resultTextView.setText(R.string.empty_input_error);
            return;
        }

        double inputValue = Double.parseDouble(inputText);
        double result;

        String fromUnit = fromSpinner.getSelectedItem().toString();
        String toUnit = toSpinner.getSelectedItem().toString();

        if (fromUnit.equals(getString(R.string.centimeters)) && toUnit.equals(getString(R.string.meters))) {
            result = inputValue / 100;
        } else if (fromUnit.equals(getString(R.string.centimeters)) && toUnit.equals(getString(R.string.inches))) {
            result = inputValue / 2.54;
        } else if (fromUnit.equals(getString(R.string.centimeters)) && toUnit.equals(getString(R.string.feet))) {
            result = inputValue / 30.48;
        } else if (fromUnit.equals(getString(R.string.meters)) && toUnit.equals(getString(R.string.centimeters))) {
            result = inputValue * 100;
        } else if (fromUnit.equals(getString(R.string.meters)) && toUnit.equals(getString(R.string.inches))) {
            result = inputValue * 39.37;
        } else if (fromUnit.equals(getString(R.string.meters)) && toUnit.equals(getString(R.string.feet))) {
            result = inputValue * 3.281;
        } else if (fromUnit.equals(getString(R.string.inches)) && toUnit.equals(getString(R.string.centimeters))) {
            result = inputValue * 2.54;
        } else if (fromUnit.equals(getString(R.string.inches)) && toUnit.equals(getString(R.string.meters))) {
            result = inputValue / 39.37;
        } else if (fromUnit.equals(getString(R.string.inches)) && toUnit.equals(getString(R.string.feet))) {
            result = inputValue / 12;
        } else if (fromUnit.equals(getString(R.string.feet)) && toUnit.equals(getString(R.string.centimeters))) {
            result = inputValue * 30.48;
        } else if (fromUnit.equals(getString(R.string.feet)) && toUnit.equals(getString(R.string.meters))) {
            result = inputValue / 3.281;
        } else if (fromUnit.equals(getString(R.string.feet)) && toUnit.equals(getString(R.string.inches))) {
            result = inputValue * 12;
        } else {
            // Units are the same, no need to convert
            result = inputValue;
        }
        resultTextView.setText(String.valueOf(result));
    }
}