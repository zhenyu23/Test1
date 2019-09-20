package com.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {


    public static void main(String[] args) {
        double i=12.0;
        Integer integer = Integer.valueOf(String.valueOf(i).substring(0, String.valueOf(i).length() - 2));
        Integer ks=12;
        double kk=Double.valueOf(12);
        System.out.println(kk+"-------");
        System.out.println(integer);
        String str="djsk-dsk-dsd";
        System.out.println(str.contains("-")+"-----------");
        List<String> list=new ArrayList<>();
        list.add("img0/M00/01/A0/wKgXJlvNmGCEEjjIAAAAAIsiR_E902.jpg");
        list.add("img0/M00/01/73/wKgXJltWzPSEQ7EYAAAAAEdWOjs304");
        System.out.println(list.toString());

//        List<String> list=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        list.add("1");list.add("1");list.add("1");list.add("4");
        list2.add("1");list2.add("2");list2.add("3");list2.add("4");
        long count = list.stream().filter(x -> x.equals("1")).count()+list2.size();
        System.out.println(count+"----------+++++++++++++---------------");
        if (count>2){
            System.out.println("成功测试");
        }


    }

    private static List<StaffPublic> convertToStaffPublic(List<Staff> staff) {
        List<StaffPublic> list=new ArrayList<>();
        list=staff.stream().map(x ->{
            StaffPublic staffPublic=new StaffPublic();
            staffPublic.setAge(x.getAge());
            return staffPublic;
        }).collect(Collectors.toList());
        return list;
    }


}
