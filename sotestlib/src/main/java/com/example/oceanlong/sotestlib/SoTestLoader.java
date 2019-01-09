package com.example.oceanlong.sotestlib;

/**
 * Created by oceanlong on 2019/1/9.
 */

public class SoTestLoader {



    public static void init(){
        System.loadLibrary("native3-lib");
    }

    public static String getTestString(){
        return stringFromJNI();
    }

    public native static String stringFromJNI();
}
