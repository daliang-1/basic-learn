package com.jake.sf.lru;

import com.yeepay.g3.utils.common.json.JSONUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LUR-Least Recently Used
 * <p>
 * 链表+HashMap
 *
 * @author: chenliang.wang
 * @Date: 2019:06:14 上午10:30
 * @company: 易宝支付(YeePay)
 */
public class Lru<K, V> {

    private float loadFactor = 0.75f;
    private LinkedHashMap<K, V> map;
    private int size;

    public Lru(int size) {
        this.size = size;
        int capacity = (int) Math.ceil(size / loadFactor) + 1;
        map = new LinkedHashMap<K, V>(capacity, loadFactor, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > Lru.this.size;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int size() {
        return map.size();
    }

    public static void main(String[] args) {
        Lru<String, String> lru = new Lru<>(10);
        for (int i = 0; i < 100; i++) {
            lru.put(String.valueOf(i), String.valueOf(i) + String.valueOf(i));
        }
        System.out.println(lru.size());
        System.out.println(JSONUtils.toJsonString(lru.map));
    }
}
