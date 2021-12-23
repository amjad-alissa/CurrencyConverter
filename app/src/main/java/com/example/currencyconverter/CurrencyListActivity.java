package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CurrencyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);

        ListView listViewCurrencies = findViewById(R.id.listViewCurrency);

        ExchangeRate[] RATES = {
                new ExchangeRate("EUR", 1.0),
                new ExchangeRate("USD", 1.0845),
                new ExchangeRate("JPY", 130.02),
                new ExchangeRate("BGN", 1.9558),
                new ExchangeRate("CZK", 27.473),
                new ExchangeRate("DKK", 7.4690),
                new ExchangeRate("GBP", 0.73280),
                new ExchangeRate("HUF", 299.83),
                new ExchangeRate("PLN", 4.0938),
                new ExchangeRate("RON", 4.4050),
                new ExchangeRate("SEK", 9.3207),
                new ExchangeRate("CHF", 1.0439),
                new ExchangeRate("NOK", 8.6545),
                new ExchangeRate("HRK", 7.6448),
                new ExchangeRate("RUB", 62.5595),
                new ExchangeRate("TRY", 2.8265),
                new ExchangeRate("AUD", 1.4158),
                new ExchangeRate("BRL", 3.5616),
                new ExchangeRate("CAD", 1.3709),
                new ExchangeRate("CNY", 6.7324),
                new ExchangeRate("HKD", 8.4100),
                new ExchangeRate("IDR", 14172.71),
                new ExchangeRate("ILS", 4.3019),
                new ExchangeRate("INR", 67.9180),
                new ExchangeRate("KRW", 1201.04),
                new ExchangeRate("MXN", 16.5321),
                new ExchangeRate("MYR", 4.0246),
                new ExchangeRate("NZD", 1.4417),
                new ExchangeRate("PHP", 48.527),
                new ExchangeRate("SGD", 1.4898),
                new ExchangeRate("THB", 35.328),
                new ExchangeRate("ZAR", 13.1446)
        };

        CurrencyListAdapter currencyListAdapter = new CurrencyListAdapter(Arrays.asList(RATES));

        listViewCurrencies.setAdapter(currencyListAdapter);
    }
}
