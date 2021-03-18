package sort_algorithm;

import sort_algorithm.test.MyHashMap;

import java.util.HashMap;

public class TestMaHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        // put 测试
        myHashMap.put(1,"a");
        myHashMap.put(2,"b");
        myHashMap.put(3,"c");

        Per per1 = new Per(1,"yb1");
        Per per2 = new Per(2,"yb2");
        Per per3 = new Per(3,"yb3");
        Per per4 = new Per(4,"yb4");
        Per per5 = new Per(5,"yb5");

        //测试成链表
        myHashMap.put(per1,"1per");
        myHashMap.put(per2,"2per");
        myHashMap.put(per3,"3per");
        myHashMap.put(per4,"4per");
        myHashMap.put(per5,"5per");

        myHashMap.put(4,"d");
        myHashMap.put(5,"e");
        myHashMap.put(6,"f");
        myHashMap.put(7,"g");
        myHashMap.put(8,"h");
        myHashMap.put(9,"i");
        myHashMap.put(10,"j");
        myHashMap.put(11,"k");
        myHashMap.put(12,"l");

        //测试扩容
        myHashMap.put(13,"m");
        myHashMap.put(14,"n");
        myHashMap.put(15,"o");
        myHashMap.put(16,"p");
        myHashMap.put(17,"q");


        //get 测试
        Object val = myHashMap.get(3);
        System.out.println(val);

        Object val2 = myHashMap.get(13);
        System.out.println(val2);

        Object val3 = myHashMap.get(14);
        System.out.println(val3);

        System.out.println("==============================================");


        //链表测试
        System.out.println(per1.hashCode() == per2.hashCode());
        System.out.println(myHashMap.get(per1) + ":" + myHashMap.get(per2) + ":" + myHashMap.get(per3)
                + ":" + myHashMap.get(per4) + ":" + myHashMap.get(per5));

        System.out.println("==============================================");

        // remove 测试
        MyHashMap.Node remove_val = myHashMap.remove(17);
        System.out.println(remove_val.value);

        System.out.println(myHashMap.get(17));


        MyHashMap.Node remove_val2 = myHashMap.remove(per5);
        System.out.println(remove_val2.value);

        System.out.println(myHashMap.get(per5));


        MyHashMap.Node remove_val3 = myHashMap.remove(per3);
        System.out.println(remove_val3.value);

        System.out.println(myHashMap.get(per3));

        System.out.println(myHashMap.get(per1) + ":" + myHashMap.get(per2) + ":" + myHashMap.get(per3)
                + ":" + myHashMap.get(per4) + ":" + myHashMap.get(per5));



        HashMap<String, Integer> hm = new HashMap<>();


        // jdk HashMap 性能测试         =======》405 ms
        long s3 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            hm.put(i + " ", i);
        }
        for (int i = 0; i < 1000000; i++) {
            hm.get(i);
        }
        long s4 = System.currentTimeMillis();
        System.out.println("jdkHashMap usetime:" + (s4 - s3));


        // MyHashMap 性能测试       ======》1502 ms
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            myHashMap.put(i + " ", i);
        }
        for (int i = 0; i < 1000000; i++) {
            myHashMap.get(i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("MyHashMap usetime:" + (s2 - s1));
    }
}
