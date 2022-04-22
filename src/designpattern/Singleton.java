package designpattern;

enum EnumSingleton {
    INSTANCE;
    private int data;

    public static EnumSingleton getESingleton() {
        return INSTANCE;
    }
    public void set(int data) {
        this.data = data;
    }
    public int get() {
        return this.data;
    }
}

public class Singleton {
    public static void main(String[] args) {
        EnumSingleton a = EnumSingleton.getESingleton();
        a.set(1);
        EnumSingleton b = EnumSingleton.INSTANCE;
        b.set(2);
        EnumSingleton c = EnumSingleton.getESingleton();
        c.set(3);
        System.out.println(a.get() + ", " + b.get());
    }
}
