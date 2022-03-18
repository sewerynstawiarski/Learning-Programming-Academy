package com.HighLand;

public class MyGenericClass <T /*extends Number*/,V> { // mogą otrzymywać więcej niż jedną wartość, zwykle druga to V
    // "extends Number - sprawia, że można przekazywać tylko subclass class Number, czyli to co do niej należy
    T x;
    V y;

    MyGenericClass(T x, V y) {
        this.x = x;
        this.y =y;
    }
    public V getValue() { // zależnie co tu wpiszesz tego będzie dotyczyła metoda
        return y;
    }
}
