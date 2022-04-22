package designpattern;

import java.util.ArrayList;
import java.util.List;

class Coder implements Cloneable {
    private List<String> languages;

    public Coder() {
        this.languages = new ArrayList<>();
    }

    public Coder(List<String> languages) {
        this.languages = languages;
    }

    public void addLanguage(String language) {
        this.languages.add(language);
    }

    public List<String> getLanguages() {
        return languages;
    }


    @Override
    public Coder clone() {
        Coder clone = new Coder();
        for (String s : this.languages) {
            clone.addLanguage(s);
        }
        return clone;
    }
}

public class Prototype {
    public static void main(String[] args) {
        Coder shawn = new Coder();
        shawn.addLanguage("Java");
        shawn.addLanguage("JavaScript");
        shawn.addLanguage("Python");

        Coder me = shawn.clone();
        me.addLanguage("Go");
        System.out.println(me.getLanguages());
        System.out.println(shawn.getLanguages());
    }
}
