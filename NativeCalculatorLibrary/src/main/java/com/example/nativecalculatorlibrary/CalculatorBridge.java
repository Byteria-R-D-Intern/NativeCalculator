package com.example.nativecalculatorlibrary;

public class CalculatorBridge {
    static {
        System.loadLibrary("native-lib");
    }

    public static native double calculate(double a,double b,int opOrdinal);
}
