package question_every_day.linkedhashmap_order_test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapOrderTest {

    public static void main(String[] args) {

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", 1);
        linkedHashMap.put("b", 2);
        linkedHashMap.put("c", 3);

        //LinkedHashMap能够按照添加顺序遍历
        Set<Map.Entry<String, Integer>> entries = linkedHashMap.entrySet();
        System.out.println("==========LinkedHashMap遍历=============");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }


        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        Set<Map.Entry<String, Integer>> hashMapEntries = map.entrySet();
        System.out.println("==========HashMap遍历=============");
        for (Map.Entry<String, Integer> entry : hashMapEntries) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

}
