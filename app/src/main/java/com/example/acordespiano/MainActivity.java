package com.example.acordespiano;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ToggleButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    private HorizontalScrollView scrollView;

    SoundPool soundPool;
    private Map<ToggleButton, Integer> toggleButtonSoundMap = new HashMap<>();
    private ToggleButton button_c;
    private ToggleButton button_cSharp;
    private ToggleButton button_d;
    private ToggleButton button_dSharp;
    private ToggleButton button_e;
    private ToggleButton button_f;
    private ToggleButton button_fSharp;
    private ToggleButton button_g;
    private ToggleButton button_gSharp;
    private ToggleButton button_a;
    private ToggleButton button_aSharp;
    private ToggleButton button_b;
    private ToggleButton button_c2;
    private ToggleButton button_cSharp2;
    private ToggleButton button_d2;
    private ToggleButton button_dSharp2;
    private ToggleButton button_e2;
    private ToggleButton button_f2;
    private ToggleButton button_fSharp2;
    private ToggleButton button_g2;
    private ToggleButton button_gSharp2;
    private ToggleButton button_a2;
    private ToggleButton button_aSharp2;
    private ToggleButton button_b2;

    private Button play;

    int c, cSharp, d, dSharp, e, f, fSharp, g, gSharp, a, aSharp, b, c2, cSharp2, d2, dSharp2, e2, f2, fSharp2, g2, gSharp2, a2, aSharp2, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSplash();
        scrollView = findViewById(R.id.scrollView);
        soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        c = soundPool.load(this, R.raw.c, 1);
        cSharp = soundPool.load(this, R.raw.c_sharp, 1);
        d = soundPool.load(this, R.raw.d, 1);
        dSharp = soundPool.load(this, R.raw.d_sharp, 1);
        e = soundPool.load(this, R.raw.e, 1);
        f = soundPool.load(this, R.raw.f, 1);
        fSharp = soundPool.load(this, R.raw.f_sharp, 1);
        g = soundPool.load(this, R.raw.g, 1);
        gSharp = soundPool.load(this, R.raw.g_sharp, 1);
        a = soundPool.load(this, R.raw.a, 1);
        aSharp = soundPool.load(this, R.raw.a_sharp, 1);
        b = soundPool.load(this, R.raw.b, 1);
        c2 = soundPool.load(this, R.raw.c2, 1);
        cSharp2 = soundPool.load(this, R.raw.c_sharp2, 1);
        d2 = soundPool.load(this, R.raw.d2, 1);
        dSharp2 = soundPool.load(this, R.raw.d_sharp2, 1);
        e2 = soundPool.load(this, R.raw.e2, 1);
        f2 = soundPool.load(this, R.raw.f2, 1);
        fSharp2 = soundPool.load(this, R.raw.f_sharp2, 1);
        g2 = soundPool.load(this, R.raw.g2, 1);
        gSharp2 = soundPool.load(this, R.raw.g_sharp2, 1);
        a2 = soundPool.load(this, R.raw.a2, 1);
        aSharp2 = soundPool.load(this, R.raw.a_sharp2, 1);
        b2 = soundPool.load(this, R.raw.b2, 1);

        initializeAllPianoKeys();
    }

    void initializeAllPianoKeys() {
        button_c = findViewById(R.id.w1);
        button_cSharp = findViewById(R.id.b1);
        button_d = findViewById(R.id.w2);
        button_dSharp = findViewById(R.id.b2);
        button_e = findViewById(R.id.w3);
        button_f = findViewById(R.id.w4);
        button_fSharp = findViewById(R.id.b3);
        button_g = findViewById(R.id.w5);
        button_gSharp = findViewById(R.id.b4);
        button_a = findViewById(R.id.w6);
        button_aSharp = findViewById(R.id.b5);
        button_b = findViewById(R.id.w7);
        button_c2 = findViewById(R.id.w8);
        button_cSharp2 = findViewById(R.id.b6);
        button_d2 = findViewById(R.id.w9);
        button_dSharp2 = findViewById(R.id.b7);
        button_e2 = findViewById(R.id.w10);
        button_f2 = findViewById(R.id.w11);
        button_fSharp2 = findViewById(R.id.b8);
        button_g2 = findViewById(R.id.w12);
        button_gSharp2 = findViewById(R.id.b9);
        button_a2 = findViewById(R.id.w13);
        button_aSharp2 = findViewById(R.id.b10);
        button_b2 = findViewById(R.id.w14);
        play = findViewById(R.id.play);
        play.setOnClickListener(view -> playActiveNotes());

        toggleButtonSoundMap.put(button_c, c);
        toggleButtonSoundMap.put(button_cSharp, cSharp);
        toggleButtonSoundMap.put(button_d, d);
        toggleButtonSoundMap.put(button_dSharp, dSharp);
        toggleButtonSoundMap.put(button_e, e);
        toggleButtonSoundMap.put(button_f, f);
        toggleButtonSoundMap.put(button_fSharp, fSharp);
        toggleButtonSoundMap.put(button_g, g);
        toggleButtonSoundMap.put(button_gSharp, gSharp);
        toggleButtonSoundMap.put(button_a, a);
        toggleButtonSoundMap.put(button_aSharp, aSharp);
        toggleButtonSoundMap.put(button_b, b);
        toggleButtonSoundMap.put(button_c2, c2);
        toggleButtonSoundMap.put(button_cSharp2, cSharp2);
        toggleButtonSoundMap.put(button_d2, d2);
        toggleButtonSoundMap.put(button_dSharp2, dSharp2);
        toggleButtonSoundMap.put(button_e2, e2);
        toggleButtonSoundMap.put(button_f2, f2);
        toggleButtonSoundMap.put(button_fSharp2, fSharp2);
        toggleButtonSoundMap.put(button_g2, g2);
        toggleButtonSoundMap.put(button_gSharp2, gSharp2);
        toggleButtonSoundMap.put(button_a2, a2);
        toggleButtonSoundMap.put(button_aSharp2, aSharp2);
        toggleButtonSoundMap.put(button_b2, b2);

        for (Map.Entry<ToggleButton, Integer> entry: toggleButtonSoundMap.entrySet()) {
            entry.getKey().setOnClickListener(view -> playActiveNotes());
        }
    }

    private void playActiveNotes() {
        for (Map.Entry<ToggleButton, Integer> entry: toggleButtonSoundMap.entrySet()) {
            if (entry.getKey().isChecked()) {
                soundPool.play(entry.getValue(), 1, 1, 1, 0, 1);
            }
        }
    }


    public void showSplash() {

        final Dialog dialog = new Dialog(MainActivity.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_splash);
        dialog.setCancelable(true);
        dialog.show();

        final Handler handler  = new Handler();
        final Runnable runnable = dialog::dismiss;
        handler.postDelayed(runnable, 10000);
    }
}