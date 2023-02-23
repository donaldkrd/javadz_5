import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class dz5 {
    public static void main(String[] args) {
        task_01_String();
        System.out.println();
        task_01_List();  
        System.out.println();
        Task_02("Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, " + 
        "Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, " +
        "Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.");    
    }

    static void task_01_String() {
        /*
        1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
        что 1 человек может иметь несколько телефонов.
        */

        Map<String, String> map = new HashMap<>();
        newPut(map, "Димитрий", "8-913-456-78-98");
        newPut(map, "Кристина", "8-922-960-48-24");
        newPut(map, "Ирина", "8-913-456-78-98");
        newPut(map, "Мила", "8-962-555-66-77");
        newPut(map, "Димитрий", "8-956-789-25-25");
        newPut(map, "Виолета", "8-913-456-78-98");
        newPut(map, "Кристина", "228-69-45");
        newPut(map, "Мила", "8-958-922-48-69");
        newPut(map, "Карина", "8-913-852-00-01");
        newPut(map, "Димитрий", "253-89-56");
        newPut(map, "Кристина", "8-999-456-12-23");
        newPut(map, "Карина", "256-48-36");
        for (Map.Entry item : map.entrySet()) {
            System.out.println(item);
        }
    }

    static void task_01_List() {
        /*
        1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
        что 1 человек может иметь несколько телефонов.
        */

        Map<String, List<String>> map = new HashMap<>();
        newPutVer2(map, "Димитрий", "8-913-456-78-98");
        newPutVer2(map, "Кристина", "8-922-960-48-24");
        newPutVer2(map, "Ирина", "8-913-456-78-98");
        newPutVer2(map, "Мила", "8-962-555-66-77");
        newPutVer2(map, "Димитрий", "8-956-789-25-25");
        newPutVer2(map, "Виолета", "8-913-456-78-98");
        newPutVer2(map, "Кристина", "228-69-45");
        newPutVer2(map, "Мила", "8-958-922-48-69");
        newPutVer2(map, "Карина", "8-913-852-00-01");
        newPutVer2(map, "Димитрий", "253-89-56");
        newPutVer2(map, "Кристина", "8-999-456-12-23");
        newPutVer2(map, "Карина", "256-48-36");
        for (Map.Entry item : map.entrySet()) {
            System.out.println(item);
        }
    }

    static void newPut(Map<String, String> map, String key, String value) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + ", " + value);
        } else {
            map.put(key, value);
        }
    }
    
    static void newPutVer2(Map<String, List<String>> map, String key, String value) {
        if (map.containsKey(key)) {
            List<String> list = map.get(key);
            list.add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    static void Task_02(String str) {
        /*
        2. Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, 
        Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, 
        Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. 
        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
        Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
         */
        str = str.replace(".", "");
        str = str.replace(",", "");
        String[] s = str.split(" ");
        TreeMap <Integer, List<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        int count = 1;
        List<String> name = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!(name.contains(s[i]))) {
                name.add(s[i]);
            } else {
                continue;
            }
            for (int j = i + 1; j < s.length; j++) {
                if (s[i].equals(s[j])) {
                    count += 1;
                } else if (j == s.length - 1) {
                    if (count > 1) {
                        if (treeMap.containsKey(count)) {
                            List<String> list = treeMap.get(count);
                            list.add(s[i]);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(s[i]);
                            treeMap.put(count, list);
                        }
                    }
                }    
            }
            count = 1;
        }
        System.out.println(treeMap);
    }
}