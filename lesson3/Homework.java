package ru.geekbrains.java_2.homework.lesson3;

import java.util.HashMap;
import java.util.Map;

public class Homework {

    public static void main(String[] args) {

        String[] words = {
                "red",
                "green",
                "blue",
                "yellow",
                "pink",
                "red",
                "brown",
                "white",
                "black",
                "blue",
                "yellow",
                "pink"
        };

        ListNumberWords(words);

        Phonebook phonebook = new Phonebook();
        phonebook.add("Ivanov", "89185553366");
        phonebook.add("Ivanov", "89183335577");
        phonebook.add("Petrov", "89186662288");
        phonebook.add("Petrov", "89183388999");
        phonebook.add("Sidorov", "89181155777");

        System.out.println(phonebook.get("Petrov"));

    }

    private static void ListNumberWords(String[] words) {
        Map<String, Integer> listOfWords = new HashMap<>();
        for (String w : words) {
            if (listOfWords.containsKey(w)) {
                listOfWords.put(w, listOfWords.get(w) + 1);
            } else {
                listOfWords.put(w, 1);
            }
        }
        for (Map.Entry<String, Integer> list : listOfWords.entrySet()) {
            System.out.println(list.getKey() + ": " + list.getValue());
        }
    }
}

