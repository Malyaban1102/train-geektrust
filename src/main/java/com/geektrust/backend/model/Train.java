package com.geektrust.backend.model;

import java.util.List;

public class Train {
    private String name;
    private List<Bogie> bogies;

    public Train(String name, List<Bogie> bogies) {
        this.name = name;
        this.bogies = bogies;
    }

    public String getName() {
        return name;
    }

    public List<Bogie> getBogies() {
        return bogies;
    }
}
