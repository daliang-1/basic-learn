package com.jake.jvm.FX;

/**
 * 泛型类
 * 在实例化泛型类时,必须指定泛型具体类型
 * 如果不指定具体类型,则使用泛型的方法及成员变量定义的类型可以为任意类型
 *
 * @param <T>
 */
class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}