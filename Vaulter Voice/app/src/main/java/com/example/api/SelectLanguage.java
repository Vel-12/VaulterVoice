package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class SelectLanguage extends AppCompatActivity {

    TextView eng,tam;
    ApiCall obj = new ApiCall();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_language);

        eng = findViewById(R.id.englishtext);
        tam = findViewById(R.id.tamil);

        //Text To Speech
        new asynCall().execute();

        //English Page Button
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Locale locale =new Locale("en");
                locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
                Intent i = new Intent(SelectLanguage.this, Login.class);
                obj.languageCode="english";
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        //Tamil Page Button
        tam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale locale =new Locale("ta");
                locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
                Intent ij = new Intent(SelectLanguage.this, Login.class);
                obj.languageCode="tamil";
                ij.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(ij);
            }
        });
    }

    //Async Call Of Text To Speech
    private class asynCall extends AsyncTask<Void,Void,String>
    {
        @Override
        protected String doInBackground(Void... voids) {
            obj.TextToSpeech("please select language","english");
            return null;
        }
    }

}