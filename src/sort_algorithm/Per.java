package sort_algorithm;

import java.util.Objects;

/**
 * 测试 HashMap 的扩容阈值
 *
 *  结果：链表长度 > 8 且数组长度 >= 64
 */
class Per{
    public Per() {
    }
    private int age;

    private String name;

    public Per(int age, String name) {
        this.age = age;
        this.name = name;
    }

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

    @Override
    public int hashCode() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Per per = (Per) o;
        return age == per.age &&
                Objects.equals(name, per.name);
    }
}