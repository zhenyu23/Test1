package com.test1;

/**
 * @author czy
 * @date 2018/11/16 17:10
 */
import java.util.Map;

public class TypePojo<E> {

    private int primitive_type;
    private Map<String, ? extends Integer> parameterized_type;
    private E type_variable;
    private E[] array_type;

    public static void main(String[] args) {
//        String as="djwaybill201918100233123456";
//        System.out.println(new BigDecimal("1.2").equals(new BigDecimal("1.20")));  //输出
//        System.out.println(new BigDecimal("1.2").compareTo(new BigDecimal("1.20")) == 0); //输出
//
//        System.out.println(new BigDecimal(1.20).equals(new BigDecimal("1.20"))); //输出是?
//        System.out.println(new BigDecimal(1.20).compareTo(new BigDecimal("1.20")) == 0); //输出是?
//
//        System.out.println(new BigDecimal(1.2).equals(new BigDecimal(1.20))); //输出是?
//        System.out.println(new BigDecimal(1.2).compareTo(new BigDecimal(1.20)) == 0);//输出是?


    }

    public static void removeDuplicates(int[] nums) {

        int tmp;
        int first=0;
        int last=nums.length-1;
        int middle=nums.length/2;
        for (int i=0;i<middle;i++){
            if (nums[middle-i]==2){
                tmp=nums[last];
                nums[last]=nums[middle-i];
                nums[i]=tmp;
                last--;
                if (tmp==2){
                    i--;
                   break;
                }

            } if (middle+i==0){
                tmp=nums[first];
                nums[first]=nums[middle+i];
                nums[middle+i]=tmp;
                first++;
                if (tmp==0){
                    i--;
                    break;
                }

            }
        }
        for (int k=first+1;k<=last;k++){
            nums[k]=1;
        }
       for (int i=0;i<nums.length;i++){
           System.out.print(nums[i]+",");
       }
    }

}

