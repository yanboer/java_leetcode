package test;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("a") + new String("b");

        String s2 = "ab";
        String s3 = new String("ab");

        System.out.println(s == s2);

        System.out.println(s == s3);

        System.out.println(s2 == s3);

    }
}
