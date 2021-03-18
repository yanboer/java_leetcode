package test;

import org.junit.Test;

import java.util.*;

public class Coll {

    @Test
    public void testMap(){
        Map<Integer,Integer> map = new HashMap<>();

        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        map.get(2);

    }



    @Test
    public void test(){
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(Arrays.toString(list.toArray()));


        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void test2(){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
    }

    @Test
    public void test3(){
        List<Integer> list = new ArrayList<>();
        //增
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);       //扩容

        //删
        list.remove(3);     //根据下标来删除
//        list.remove(Integer.valueOf(4));    //根据值来删除

        //改
        list.set(2,4);

        //查
        list.get(2);

        System.out.println(Arrays.toString(list.toArray()));
    }


    @Test
    public void test4(){
        List<Integer> list = new LinkedList<>();

        //增
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);

        //删
        list.remove(3);     //根据下标来删除
//        list.remove(Integer.valueOf(4));    //根据值来删除

        //改
        list.set(2,4);

        //查
        list.get(2);

        System.out.println(Arrays.toString(list.toArray()));
    }


    //ArrayList 按给定值删除元素时，会首先删除第一个与给定值相等的元素
    @Test
    public void t(){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        System.out.println(Arrays.toString(list.toArray()));
        list.remove(Integer.valueOf(1));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.get(13));     // IndexOutOfBoundsException，index 与 size 进行比较，不是与 elementData.length 进行比较
    }

    @Test
    public void testCal(){
        System.out.println(Math.pow(2,16));
    }

    @Test
    public void testHashCode(){
        System.out.println(Math.pow(2,16));
    }


    @Test
    public void testHashMapKey(){
        List<String> list = new LinkedList<>();
        list.add("a");

        Map<List<String>,Object> map = new HashMap<>();
        map.put(list,1);

        System.out.println(map.get(list));      //成功取出值

        list.add("b");      //list 值变了

        System.out.println(map.get(list));      //取出值为 null
    }
}
