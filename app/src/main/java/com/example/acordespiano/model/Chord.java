package com.example.acordespiano.model;

import java.util.Set;

public class Chord {
    private String name;
    private String suffix;
    private Set<Integer> intervals;

    public Chord(String name, String suffix, Set<Integer> intervals){
        this.name = name;
        this.suffix = suffix;
        this.intervals = intervals;
    }

    public String getName() {
        return name;
    }

    public String getSuffix() {
        return suffix;
    }

    public Set<Integer> getIntervals() {
        return intervals;
    }
}
