package Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать, сколько раз встречается каждое слово.
         */
        String [] arr = {"мама", "папа", "брат", "мама", "мама", "брат", "папа", "сестра", "мама", "брат"};
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        System.out.println(set);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String man = arr[i];
            Integer count = map.getOrDefault(man, 0);
            map.put(man, count+1);
        }
        System.out.println(map);

        /**
         * Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         * В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get()
         * искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
         * (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
         */

        PhoneNumbers phoneNumbers = new PhoneNumbers();
        phoneNumbers.add("Ivanov", new HashSet<>(Arrays.asList(34567, 34235)));
        phoneNumbers.add("Petrov", new HashSet<>(Arrays.asList(65784, 56764)));
        phoneNumbers.add("Sidorov", new HashSet<>(Arrays.asList(4536, 1342, 334567)));
        phoneNumbers.add("Fedorov", new HashSet<>(Arrays.asList(657)));
        System.out.println(phoneNumbers.get("Petrov"));
        System.out.println(phoneNumbers.get("Ivanov"));
        System.out.println(phoneNumbers.get("Fedorov"));
        System.out.println(phoneNumbers.get("Sidorov"));
    }
}
