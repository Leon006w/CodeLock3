package com.animation.codelock;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import androidx.annotation.Nullable;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;


public class MainActivity extends AppCompatActivity  {
    private CodeLockButton.OnClickListener digitOnClickListener;
    private CodeLockButton.OnClickListener enterOnClickListener;
    private CodeLockButton.OnClickListener clearOnClickListener;
    private TextView resultWindow;
    private CodeLockViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Basic: Bundle, ViewModel observations
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultWindow = findViewById(R.id.resultWindow);

        viewModel = new ViewModelProvider(this).get(CodeLockViewModel.class);
        viewModel.getLiveDataResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String result) {
                resultWindow.setText(result);
            }
        });

        // Views properties: tune clicks intercepts on every button
        digitOnClickListener = new CodeLockButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onClickListenerDigitButton(view);
            }
        };
        enterOnClickListener = new CodeLockButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onClickListenerEnterButton(view);
            }
        };
        clearOnClickListener = new CodeLockButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.onClickListenerClearButton(view);
            }
        };
        findViewById(R.id.btn1).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn2).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn3).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn4).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn5).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn6).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn7).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn8).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn9).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn0).setOnClickListener(digitOnClickListener);
        findViewById(R.id.btn_enter).setOnClickListener(enterOnClickListener);
        findViewById(R.id.btn_clear).setOnClickListener(clearOnClickListener);
    }

}