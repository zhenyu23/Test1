package com.test1;

import java.math.BigDecimal;

/**
 * @author czy
 * @date 2018/7/6 20:27
 */
public class Staff {
    private String name;
    private int age;
    private BigDecimal salary;

    public String methodA()  {
        try{
            //这里会抛出ArithmeticException
            int a = 10/0;
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
        return null;
    }

//    public Staff(String name, int age, BigDecimal salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
