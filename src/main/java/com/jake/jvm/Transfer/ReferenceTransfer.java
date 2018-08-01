package com.jake.jvm.Transfer;

/**
 * 值传递(or 值传递和引用传递)
 * <p>
 * 内存分配:基本数据类型全部在栈内存中,且对应基本数据类型有值
 *         引用数据类型也在栈内存中,但是只有引用数据类型的引用(or 地址值),引用类型数据保存在堆内存,栈内存中的引用(or 地址值)指向堆内存数据
 *
 * @author: chenliang.wang
 * @Date: 2018年08月01日 AM10:36
 * @company: 易宝支付(YeePay)
 */
public class ReferenceTransfer {

    public static void main(String[] args) {
        TransferEntity entity = new TransferEntity();
        int num = 10;
        String name = "JAKE";

        System.out.println("addParam begin num = [" + num + "],name = [" + name + "]");
        addParam(num, name);
        System.out.println("addParam end num = [" + num + "],name = [" + name + "]");
        System.out.println();

        entity.setAge(num);
        entity.setName(name);

        System.out.println("changeParam begin = " + entity.toString());
        changeParam(entity);
        System.out.println("changeParam end = " + entity.toString());
        System.out.println();

        System.out.println("changeEntity begin = " + entity.toString());
        changeEntity(entity);
        System.out.println("changeEntity end = " + entity.toString());
    }

    public static void changeParam(TransferEntity entity) {
        entity.age++;
        entity.name = "nameTest";
    }

    public static void addParam(int age, String name) {
        age++;
        name = "addParam name" + name;
    }

    public static void changeEntity(TransferEntity entity) {
        entity = new TransferEntity();
        entity.setAge(100);
        entity.setName("changeEntityName");
    }
}
