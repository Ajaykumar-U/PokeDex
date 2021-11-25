package com.ajay.pokemondex.home.data;

import java.io.Serializable;
import java.util.List;

public class Pokemon implements Serializable {
    public int id;
    public String num;
    public String name;
    public String img;
    public List<String> type;
    public String height;
    public String weight;
    public String candy;
    public int candy_count;
    public String egg;
    public double spawn_chance;
    public double avg_spawns;
    public String spawn_time;
    public List<String> weaknesses;

    public int getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public List<String> getType() {
        return type;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getCandy() {
        return candy;
    }

    public int getCandy_count() {
        return candy_count;
    }

    public String getEgg() {
        return egg;
    }

    public double getSpawn_chance() {
        return spawn_chance;
    }

    public double getAvg_spawns() {
        return avg_spawns;
    }

    public String getSpawn_time() {
        return spawn_time;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }
}
