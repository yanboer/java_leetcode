package test;

public class Constructor {
    public static void main(String[] args) {
        test();
    }
    static void test(){
        B b = new B();
        A a = b;
        C c = new C(a);
        C d = new C(b);
        D e = new D(a);
        D f = new D(b);
    }
}
class A{}
class B extends A{}
class C{
    public <T> C(T t){
        System.out.println(t.getClass());
    }
}
class D{
    public D(B c){
        System.out.println("B");
    }
    public D(A a){
        System.out.println("A");
    }
}
