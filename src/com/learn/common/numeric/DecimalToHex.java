package com.learn.common.numeric;

public class DecimalToHex {

    public static void main(String[] args) {
        int num = 14;
        decToHex(num);
    }

    private static void decToHex(int num){
        int rem;
        String result="";

        // Digits in hexadecimal number system
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(num>0)
        {
            rem=num%16;
            result=hex[rem]+result;
            num=num/16;
        }
        System.out.println("Result:"+result);
    }
}
