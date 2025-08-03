package com.example.acordespiano;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private HorizontalScrollView scrollView;

    SoundPool soundPool;

    private Button button_c;
    private Button button_cSharp;
    private Button button_d;
    private Button button_dSharp;
    private Button button_e;
    private Button button_f;
    private Button button_fSharp;
    private Button button_g;
    private Button button_gSharp;
    private Button button_a;
    private Button button_aSharp;
    private Button button_b;
    private Button button_c2;
    private Button button_cSharp2;
    private Button button_d2;
    private Button button_dSharp2;
    private Button button_e2;
    private Button button_f2;
    private Button button_fSharp2;
    private Button button_g2;
    private Button button_gSharp2;
    private Button button_a2;
    private Button button_aSharp2;
    private Button button_b2;

    int c, cSharp, d, dSharp, e, f, fSharp, g, gSharp, a, aSharp, b, c2, cSharp2, d2, dSharp2, e2, f2, fSharp2, g2, gSharp2, a2, aSharp2, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        soundPool = new SoundPool.Builder().build();
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
        button_c.setOnClickListener(this);
        button_cSharp = findViewById(R.id.b1);
        button_cSharp.setOnClickListener(this);
        button_d = findViewById(R.id.w2);
        button_d.setOnClickListener(this);
        button_dSharp = findViewById(R.id.b2);
        button_dSharp.setOnClickListener(this);
        button_e = findViewById(R.id.w3);
        button_e.setOnClickListener(this);
        button_f = findViewById(R.id.w4);
        button_f.setOnClickListener(this);
        button_fSharp = findViewById(R.id.b3);
        button_fSharp.setOnClickListener(this);
        button_g = findViewById(R.id.w5);
        button_g.setOnClickListener(this);
        button_gSharp = findViewById(R.id.b4);
        button_gSharp.setOnClickListener(this);
        button_a = findViewById(R.id.w6);
        button_a.setOnClickListener(this);
        button_aSharp = findViewById(R.id.b5);
        button_aSharp.setOnClickListener(this);
        button_b = findViewById(R.id.w7);
        button_b.setOnClickListener(this);
        button_c2 = findViewById(R.id.w8);
        button_c2.setOnClickListener(this);
        button_cSharp2 = findViewById(R.id.b6);
        button_cSharp2.setOnClickListener(this);
        button_d2 = findViewById(R.id.w9);
        button_d2.setOnClickListener(this);
        button_dSharp2 = findViewById(R.id.b7);
        button_dSharp2.setOnClickListener(this);
        button_e2 = findViewById(R.id.w10);
        button_e2.setOnClickListener(this);
        button_f2 = findViewById(R.id.w11);
        button_f2.setOnClickListener(this);
        button_fSharp2 = findViewById(R.id.b8);
        button_fSharp2.setOnClickListener(this);
        button_g2 = findViewById(R.id.w12);
        button_g2.setOnClickListener(this);
        button_gSharp2 = findViewById(R.id.b9);
        button_gSharp2.setOnClickListener(this);
        button_a2 = findViewById(R.id.w13);
        button_a2.setOnClickListener(this);
        button_aSharp2 = findViewById(R.id.b10);
        button_aSharp2.setOnClickListener(this);
        button_b2 = findViewById(R.id.w14);
        button_b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.w1) {
            soundPool.play(c, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b1) {
            soundPool.play(cSharp, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w2) {
            soundPool.play(d, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b2) {
            soundPool.play(dSharp, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w3) {
            soundPool.play(e, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w4) {
            soundPool.play(f, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b3) {
            soundPool.play(fSharp, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w5) {
            soundPool.play(g, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b4) {
            soundPool.play(gSharp, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w6) {
            soundPool.play(a, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b5) {
            soundPool.play(aSharp, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w7) {
            soundPool.play(b, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w8) {
            soundPool.play(c2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b6) {
            soundPool.play(cSharp2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w9) {
            soundPool.play(d2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b7) {
            soundPool.play(dSharp2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w10) {
            soundPool.play(e2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w11) {
            soundPool.play(f2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b8) {
            soundPool.play(fSharp2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w12) {
            soundPool.play(g2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b9) {
            soundPool.play(gSharp2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w13) {
            soundPool.play(a2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.b10) {
            soundPool.play(aSharp2, 1, 1, 1, 0, 1);
        } else if (view.getId() == R.id.w14) {
            soundPool.play(b2, 1, 1, 1, 0, 1);
        }

    }
}