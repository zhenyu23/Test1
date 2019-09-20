package com.test1;

/**
 * @author czy
 * @date 2018/11/16 10:58
 */
public class Althrim{


    public static void main(String[] args)  {
        Staff staff=new Staff();
        try {
            String s = staff.methodA();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
