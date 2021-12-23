package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView textViewFromValue;
    TextView textViewToValue;
    TextView textViewOutput;
    Spinner spinnerFromValue;
    Spinner spinnerToValue;
    EditText editTextInput;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UIs texts
        textViewFromValue = findViewById(R.id.textViewFromValue);
        textViewFromValue.setText(R.string.text_view_from_defu);

        textViewToValue = findViewById(R.id.textViewToValue);
        textViewToValue.setText(R.string.text_view_to_defu);

        textViewOutput = findViewById(R.id.textViewOutput);
        textViewOutput.setText(R.string.text_view_output_defu);

        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setText(R.string.button_calculate_defu);

        editTextInput = findViewById(R.id.editTextInput);

        //ExchangeRateDatabase
        final ExchangeRateDatabase exchangeRateDatabase = new ExchangeRateDatabase();

        //CurrencyListActivity
        String[] currencyList = exchangeRateDatabase.getCurrencies();

        //Adapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                R.layout.spinner_element,
                R.id.spinnerElement,
                currencyList);

        //Setting adapter to spinners
        spinnerFromValue = findViewById(R.id.spinnerFromValue);
        spinnerFromValue.setAdapter(spinnerAdapter);

        spinnerToValue= findViewById(R.id.spinnerToValue);
        spinnerToValue.setAdapter(spinnerAdapter);

        //Button event handler
        buttonCalculate.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String fromValue = (String) spinnerFromValue.getSelectedItem();
                String toValue = (String) spinnerToValue.getSelectedItem();
                double input = Double.parseDouble(editTextInput.getText().toString());
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                double output;

                //Two cases, because the exchange rate is calculated to 1 "EUR".
                // if the from or to value is 'EUR'
                if (fromValue.equals("EUR") || toValue.equals("EUR")) {
                    output = exchangeRateDatabase.convert(input, fromValue, toValue);
                    textViewOutput.setText(decimalFormat.format(output));
                }
                //the other case, if we convert from any currency to any other currency except "EUR"
                else {
                    output = exchangeRateDatabase.convert(input, fromValue, "EUR");
                    output = exchangeRateDatabase.convert(output, "EUR", toValue);
                    textViewOutput.setText(decimalFormat.format(output));
                }
            }
        });
    }
}
