package com.example.welprating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TA {
    public String name;
    public double total_rating;
    public int count;
    public ArrayList<String> comments;
    public double average;

    public TA() {
        name = "";
        total_rating = 0;
        count = 0;
        comments = new ArrayList<>();
        average = 0;
    }

    public TA(String arg) {
        name = arg;
        total_rating = 0;
        count = 0;
        comments = new ArrayList<>();
        average = 0;
    }

    public void updateCount() {
        count++;
    }

    public void updateRating(double rating) {
        total_rating = rating + total_rating;
        System.out.println(total_rating);
    }

    public void averageIt() {
        average = total_rating / count;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("count", count);
        result.put("totalRating", total_rating);
        return result;
    }
}
