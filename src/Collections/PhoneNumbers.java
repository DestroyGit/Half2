package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneNumbers{
    private String name;
    private Set<Integer> phones;
    private Map<String, Set<Integer>> numbers = new HashMap<>();

    void add(String name, Set<Integer> phones){
        this.name = name;
        this.phones = phones;
        numbers.put(this.name, this.phones);
    }

    Set<Integer> get(String name){
        return numbers.get(name);
    }
}
