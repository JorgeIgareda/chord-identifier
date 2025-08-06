package com.example.acordespiano;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.acordespiano.model.Chord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    SoundPool soundPool;
    private Map<ToggleButton, int[]> toggleButtonSoundMap = new HashMap<>();
    private ToggleButton button_c, button_cSharp, button_d, button_dSharp, button_e, button_f, button_fSharp, button_g, button_gSharp, button_a, button_aSharp, button_b, button_c2, button_cSharp2, button_d2, button_dSharp2, button_e2, button_f2, button_fSharp2, button_g2, button_gSharp2, button_a2, button_aSharp2, button_b2;

    private Button play;

    private TextView text;

    int c, cSharp, d, dSharp, e, f, fSharp, g, gSharp, a, aSharp, b, c2, cSharp2, d2, dSharp2, e2, f2, fSharp2, g2, gSharp2, a2, aSharp2, b2;

    private static final String[] ENGLISH_NOTES = {
            "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
    };

    private static final String[] LATIN_NOTES = {
            "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
    };

    private static final Set<Chord> chords = new HashSet<>();
    static {
        // =========== TRIADAS ===========
        chords.add(new Chord("Mayor", "", Set.of(0, 4, 7)));
        chords.add(new Chord("Menor", "m", Set.of(0, 3, 7)));
        chords.add(new Chord("Disminuido", "º", Set.of(0, 3, 6)));
        chords.add(new Chord("Aumentado", "+", Set.of(0, 4, 8)));
        chords.add(new Chord("Suspendido 2ª", "sus2", Set.of(0, 2, 7)));
        chords.add(new Chord("Suspendido 4ª", "sus4", Set.of(0, 5, 7)));
        // =========== SÉPTIMA ===========
        chords.add(new Chord("Séptima dominante", "7", Set.of(0, 4, 7, 10)));
        chords.add(new Chord("Séptima mayor", "maj7", Set.of(0, 4, 7, 11)));
        chords.add(new Chord("Séptima menor", "m7", Set.of(0, 3, 7, 10)));
        chords.add(new Chord("Séptima disminuida", "º7", Set.of(0, 3, 6, 9)));
        chords.add(new Chord("Séptima semi-disminuida", "m7♭5", Set.of(0, 3, 6, 10)));
        // =========== SEXTA ===========
        chords.add(new Chord("Sexta mayor", "6", Set.of(0, 4, 7,9)));
        chords.add(new Chord("Sexta menor", "m6", Set.of(0, 3, 7, 9)));
        // =========== EXTENDIDOS ===========
        chords.add(new Chord("Novena dominante", "9", Set.of(0, 2, 4, 7, 10)));
        chords.add(new Chord("Novena mayor", "maj9", Set.of(0, 2, 4, 7, 11)));
        chords.add(new Chord("Novena menor", "m9", Set.of(0, 2, 3, 7, 10)));
        chords.add(new Chord("Mayor añadir 9", "add9", Set.of(0, 2, 4, 7)));
        chords.add(new Chord("Menor añadir 9", "madd9", Set.of(0, 2, 3, 7)));
        chords.add(new Chord("Undécima dominante", "11", Set.of(0, 2, 4, 5, 7, 10)));
        chords.add(new Chord("Decimotercera dominante", "13", Set.of(0, 2, 4, 7, 9, 10)));
        // =========== POTENCIA ===========
        chords.add(new Chord("Acorde de potencia", "5", Set.of(0, 7)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSplash();
        soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        loadSounds();
        initializeAllPianoKeys();
    }

    void loadSounds() {
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
        text = findViewById(R.id.text);

        toggleButtonSoundMap.put(button_c, new int[]{0,c});
        toggleButtonSoundMap.put(button_cSharp, new int []{1, cSharp});
        toggleButtonSoundMap.put(button_d, new int []{2, d});
        toggleButtonSoundMap.put(button_dSharp, new int []{3, dSharp});
        toggleButtonSoundMap.put(button_e, new int []{4, e});
        toggleButtonSoundMap.put(button_f, new int []{5, f});
        toggleButtonSoundMap.put(button_fSharp, new int []{6, fSharp});
        toggleButtonSoundMap.put(button_g, new int []{7, g});
        toggleButtonSoundMap.put(button_gSharp, new int []{8, gSharp});
        toggleButtonSoundMap.put(button_a, new int []{9, a});
        toggleButtonSoundMap.put(button_aSharp, new int []{10, aSharp});
        toggleButtonSoundMap.put(button_b, new int []{11, b});
        toggleButtonSoundMap.put(button_c2, new int []{12, c2});
        toggleButtonSoundMap.put(button_cSharp2, new int []{13, cSharp2});
        toggleButtonSoundMap.put(button_d2, new int []{14, d2});
        toggleButtonSoundMap.put(button_dSharp2, new int []{15, dSharp2});
        toggleButtonSoundMap.put(button_e2, new int []{16, e2});
        toggleButtonSoundMap.put(button_f2, new int []{17, f2});
        toggleButtonSoundMap.put(button_fSharp2, new int []{18, fSharp2});
        toggleButtonSoundMap.put(button_g2, new int []{19, g2});
        toggleButtonSoundMap.put(button_gSharp2, new int []{20, gSharp2});
        toggleButtonSoundMap.put(button_a2, new int []{21, a2});
        toggleButtonSoundMap.put(button_aSharp2, new int []{22, aSharp2});
        toggleButtonSoundMap.put(button_b2, new int []{23, b2});

        for (Map.Entry<ToggleButton, int[]> entry : toggleButtonSoundMap.entrySet()) {
            entry.getKey().setOnClickListener(view -> playActiveNotes());
        }
    }

    private void playActiveNotes() {
        List<Integer> activeNotes = new ArrayList<>();
        for (Map.Entry<ToggleButton, int[]> entry : toggleButtonSoundMap.entrySet()) {
            if (entry.getKey().isChecked()) {
                activeNotes.add(entry.getValue()[0]);
                soundPool.play(entry.getValue()[1], 1, 1, 1, 0, 1);
            }
        }
        if (activeNotes.size() >= 2) {
            detectChord(activeNotes);
        }
    }

    private void detectChord(List<Integer> activeNotes) {
        Collections.sort(activeNotes);
        Set<Integer> intervals = new HashSet<>();
        int root = activeNotes.get(0);

        for (Integer note : activeNotes) {
            int interval = (note - root + 12) % 12;
            intervals.add(interval);
        }

        for (Chord chord : chords) {
            if (intervals.equals(chord.getIntervals())) {
                text.setText(String.format(LATIN_NOTES[root%12] + " " + chord.getName() +"\n"+ ENGLISH_NOTES[root%12] + chord.getSuffix()));
                return;
            }
        }
        text.setText(getString(R.string.not_found));
    }

    public void showSplash() {

        final Dialog dialog = new Dialog(MainActivity.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_splash);
        dialog.setCancelable(true);
        dialog.show();

        final Handler handler = new Handler();
        final Runnable runnable = dialog::dismiss;
        handler.postDelayed(runnable, 10000);
    }
}