package cn.edu.ruc.springAOP;


import org.springframework.stereotype.Service;

/**
 * @Author: Lishuai
 * @Date: Created on 2018/4/25
 */
@Service
public class PersonSpring implements Speakable {
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
