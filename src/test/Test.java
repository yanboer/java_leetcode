package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        Set set1 = new HashSet<>();
//        Set set2 = new HashSet<>();
//        set1.add(1);
//        set1.add(2);
//
//        set2.add(2);
//        set2.add(1);
//
//        System.out.println(set1.equals(set2));

//        List list1 = new LinkedList();
//        List list2 = new LinkedList();
//
//        list1.add(1);
//        list1.add(2);
//
//        list2.add(2);
//        list2.add(1);
//
//        System.out.println(list1.equals(list2));
//
//        System.out.println(0%1);
//
//        String a = "abcd";
//        System.out.println(a.charAt(1));

//        String str = "Xest string";
//        StringBuilder strBuilder = new StringBuilder(str);
//        strBuilder.setCharAt(1, 'X');
//        strBuilder.setCharAt(0, 'C');
//        strBuilder.setCharAt(strBuilder.length() - 1, 'C');
//        str=strBuilder.toString();
//        System.out.println(str);
//
//        System.out.println(strBuilder.substring(0,1).equals(strBuilder.substring(1,2)));

//        int a = (int)Math.pow(10,10);
//        double b = Math.pow(10,10);
//        System.out.println(a);
//        System.out.println(b);
//        char c = (char) 97;
//        System.out.println(c);
//        System.out.println(String.valueOf((char)(0 + 97)).equals(String.valueOf("abaac".charAt(4 - 1))));

//        Set<Integer> set = new HashSet<>();
//        for(int i = 0;i <= 10;i++){
//            set.add(i);
//        }
//
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//
//        System.out.println(list.contains(1));


//        String a = "+100";
//        String b = "0123";
//        String c = "1.2.3";
//        String d = "-1E-16";
//
//        System.out.println(Integer.valueOf(a));
//        System.out.println(Integer.valueOf(b));
//        System.out.println(Integer.valueOf(d));
//        System.out.println(Integer.valueOf(c));

//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        System.out.println(list.get(0));
//
//        Map<String,Integer> map = new HashMap<>();
//        map.put("a",1);
//        map.put("a",2);
//        map.put("a",1);
//
//        System.out.println(map.get("a"));
//        System.out.println(map.get("b"));
//
//        for(char i = 'a';i <= 'z';i++){
//            System.out.println(i);
//        }

//        List<Integer> list1 = new LinkedList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//
//        List<Integer> list2 = new LinkedList<>(list1);      //真复制
////        list1 = list2;  //浅 copy
//
//        list1.add(4);
//
//        System.out.println(list1);
//        System.out.println(list2);

//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//
//        set1.add(1);
//        set1.add(2);
//
//        set2.add(2);
//        set2.add(1);
//        System.out.println(set1.equals(set2));

//        String a = "abc";
//        String b = new String(a);
//        String c = a;
//        a = a + "d";
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        List<Integer> list = new LinkedList<>();
        list.add(1);
        Integer[] integers = list.toArray(new Integer[0]);


        System.out.println(list.contains(1));

        Map<Integer,Integer> map = new HashMap<>();     //创建哈希表存储 A 数组，使得查询效率提高
        map.put(1,3);
        map.put(2,4);

        System.out.println(map.containsValue(3));
        Set<Integer> set = map.keySet();
        for(Integer temp:set){
            if(map.get(temp) == 3){
                System.out.println(temp);
            }
        }

    }

}