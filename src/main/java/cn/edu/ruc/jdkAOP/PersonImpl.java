package cn.edu.ruc.jdkAOP;

import cn.edu.ruc.Speakable;

/**
 * @Author: Lishuai
 * @Date: Created on 2018/4/25
 */
public class PersonImpl implements Speakable{

    @Override
    public void sayHi() {
        try {
            Thread.currentThread().sleep(30);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!");
    }

    @Override
    public void sayBye() {
        try {
            Thread.currentThread().sleep(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!");
    }
}
