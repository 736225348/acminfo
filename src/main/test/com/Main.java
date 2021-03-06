package com;


public class Main {
    public static void main(String[] args) {
        Singleton1 singleton1 = new Singleton1();
        System.out.println(Singleton1.getSingleton1());
        System.out.println(Singleton1.getSingleton1());
    }
}

//
class Singleton1 { //饿汉模式1
    private static final Singleton1 singlseton1 = new Singleton1();

    public static Singleton1 getSingleton1() {
        return singlseton1;
    }
}

class Singleton2 { //懒汉模式  （存在线程安全问题非正规写法）
    private static Singleton2 singleton2 = null;

    private Singleton2() {
    }


    public static Singleton2 getSingleton2() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
            return singleton2;
        } else {
            return singleton2;
        }
    }


}
//synchronized

class Singleton3 { //懒汉模式    synchronized 加入synchronized 锁
    private static Singleton3 singleton3 = null;

    private Singleton3() {
    }

    public static synchronized Singleton3 getSingleton3() { //
        if (singleton3 == null) {
            singleton3 = new Singleton3(); //
            return singleton3;
        } else {
            return singleton3; //
        }
    }


}

class Singleton4 {   // 懒汉模式   优化
    private static Singleton4 singleton4 = null;

    private Singleton4() {
    }

    public static Singleton4 getSingleton4() {

        if (singleton4 == null) {//
            synchronized (Singleton4.class) { //
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                    return singleton4;
                }
            }
        }
        return singleton4;
    }
}


