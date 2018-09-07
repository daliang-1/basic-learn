package com.jake.jdk.jdk8.lambda;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: chenliang.wang
 * @Date: 2018年08月16日 下午5:40
 * @company: 易宝支付(YeePay)
 */
public class LambdaTest {

    private List<User> list;

    @Before
    public void init() {
        Random random = new Random();
        list = new ArrayList() {
            {
                for (int i = 0; i < 10; i++) {
                    add(new User("name" + i, random.nextInt(100)));
                }
            }
        };

    }

    @Test
    public void test() {
        List<String> list2 = list.stream()
                .filter(user-> user.getSoure()>60)
                .sorted(Comparator.comparing((user)->user.getSoure()))
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
        System.out.println(list2);
    }


    class User {
        String name;

        Integer soure;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSoure() {
            return soure;
        }

        public void setSoure(Integer soure) {
            this.soure = soure;
        }

        public User(String name, Integer soure) {
            this.name = name;
            this.soure = soure;
        }
    }

    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        // 根据首字母排序
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 首字母排序
//        Arrays.sort(players, (str1, str2) -> str1.compareTo(str2));

        // 根据字符串长度排序
        Arrays.sort(players, (str1, str2) -> str1.length() - str2.length());
        System.out.println(JSON.toJSONString(players));
    }
}
