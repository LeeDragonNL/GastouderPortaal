package com.example.opt3.Model;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.opt3.Model.users.Gastouder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    ObjectMapper mapper = new ObjectMapper();

    public void writer(ArrayList<Gastouder> gebruikers) {
        File file = new File("src/main/resources/com/example/opt3/json/Gebruikers.json");
        try {
            mapper.writeValue(new File(String.valueOf(file)), gebruikers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Gastouder> reader() {
        File file = new File("src/main/resources/com/example/opt3/json/Gebruikers.json");
        ArrayList<Gastouder> gebruikers = new ArrayList<>();
        try {
            JavaType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Gastouder.class);
            gebruikers = mapper.readValue(file, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return gebruikers;
    }
}
