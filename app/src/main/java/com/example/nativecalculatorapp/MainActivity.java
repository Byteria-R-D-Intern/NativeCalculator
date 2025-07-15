package com.example.nativecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nativecalculatorlibrary.CalculatorBridge;
import com.example.nativecalculatorlibrary.Operation;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.nativecalculatorapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("native-lib");
    }
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputA = findViewById(R.id.inputA);
        EditText inputB = findViewById(R.id.inputB);
        Spinner operationSpinner = findViewById(R.id.operationSpinner);
        Button button = findViewById(R.id.button);
        TextView resultText = findViewById(R.id.resultText);

        ArrayAdapter<Operation> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Operation.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operationSpinner.setAdapter(adapter);

        button.setOnClickListener(v ->{
            try{
                double a = Double.parseDouble(inputA.getText().toString());
                double b = Double.parseDouble(inputB.getText().toString());
                Operation selectedOp = (Operation) operationSpinner.getSelectedItem();
                double result = CalculatorBridge.calculate(a,b,selectedOp.ordinal());
                resultText.setText("Sonuç: " + result);
            }catch(Exception e) {
                resultText.setText("Hata: " + e.getMessage());
            }
        });

    }
}