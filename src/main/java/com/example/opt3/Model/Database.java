package com.example.opt3.Model;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    public static ArrayList<Gebruiker> data = fillarray();
    ObjectMapper mapper = new ObjectMapper();
    String url = "OPT3/src/main/resources/com/example/opt3/json/";

    private static ArrayList<Gebruiker> fillarray(){
        ArrayList<Gebruiker> fill = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Gebruiker gastouder = new Gastouder
                    ("Franklin",
                            "teststraat",
                            "3465AD",
                            Gebruiker.randomInt(),
                            Gebruiker.randomDouble(),
                            Gebruiker.randomDouble(),
                            Gebruiker.randomInt(),
                            "test",
                            "test");
            fill.add(gastouder);
        }
        return fill;
    }


    public void writer (ArrayList<Babies> gebruikers, String jsonfile) {
        File file = new File(url + jsonfile);
        try {
            // Java objects to JSON file
            mapper.writeValue(new File(String.valueOf(file)), gebruikers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Babies> reader(String jsonfile) {
        File file = new File(url + jsonfile);
        ArrayList<Babies> gebruikers = new ArrayList<>();
        try {
            //JsonNode jsonNode = mapper.readTree(file);
            //gebruikers = mapper.treeToValue(jsonNode, Gebruiker[].class);
            JavaType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Gebruiker.class);
            gebruikers = mapper.readValue(file, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return gebruikers;
    }

    public void writer2(ArrayList<Gebruiker> gebruikers, String jsonfile) {
        File file = new File(url + jsonfile);
        try {
            // Java objects to JSON file
            mapper.writeValue(new File(String.valueOf(file)), gebruikers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Gebruiker> reader2(String jsonfile) {
        File file = new File(url + jsonfile);
        ArrayList<Gebruiker> gebruikers = new ArrayList<>();
        try {
            //JsonNode jsonNode = mapper.readTree(file);
            //gebruikers = mapper.treeToValue(jsonNode, Gebruiker[].class);
            JavaType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Gebruiker.class);
            gebruikers = mapper.readValue(file, type);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return gebruikers;
    }
}
