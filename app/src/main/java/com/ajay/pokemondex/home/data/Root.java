package com.ajay.pokemondex.home.data;

import java.io.Serializable;
import java.util.List;

public class Root implements Serializable {
    public List<Pokemon> pokemon;

    public List<Pokemon> getPokemon() {
        return pokemon;
    }
}
