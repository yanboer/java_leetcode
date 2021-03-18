package test;

import java.util.*;

/**
 * 重写 equals 方法而不重写 hashcode
 */
class Car {
    private int age;

    private String name;

    public Car(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return age == car.age &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return age == car.age &&
//                Objects.equals(name, car.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age, name);
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class Car_Test {
//    public static void main(String[] args) {
//        Map<Car,String> map = new HashMap<>();
//
//        /**
//         * 类似于：
//         *      Integer i = new Integer(10);
//         *      map.put(i,"target_value");
//         *
//         *      System.out.println(map.get(new Integer(10)));       //正常获取到值
//         *
//         */
//        Car car1 = new Car(18,"car1");
//        map.put(car1,"target_value");
//
//        System.out.println(map.get(new Car(18,"car1")));        //本来应该能获取到存入的值，结果现在获取到的是 null
//    }

    public static void main(String[] args) {
        Set<Car> set = new HashSet<>();

        Car car1 = new Car(18,"car1");
        Car car2 = new Car(18,"car1");

        set.add(car1);              //放入 set
        set.add(car2);              //放入 set

        for(Car temp : set){
            System.out.println(temp);       //取出两个 car，没有达到去重的目的
        }
    }
}
