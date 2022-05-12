package ru.geekbrains.java_2.homework.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Phonebook {

    private HashMap<String, List<String>> phonebook;

    public Phonebook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String lastName, String phone) {
        if (phonebook.containsKey(lastName)) {
            List<String> phones = phonebook.get(lastName);
            phones.add(phone);
        }
        else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phonebook.put(lastName, phones);
        }
    }

    public List<String> get(String lastName) {
        return  phonebook.get(lastName);
    }

}
