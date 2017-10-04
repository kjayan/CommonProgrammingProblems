package com.learn.common.numeric;

public class DecimalToOctal {

    public static void main(String[] args) {
        int num= 8;
        decToOctal(num);
    }

    private static void decToOctal(int num){
        int rem;

        String result="";

        // Digits in Octal number system
        char dig[]={'0','1','2','3','4','5','6','7'};

        while(num>0)
        {
            rem=num%8;
            result=dig[rem]+result;
            num=num/8;
        }
        System.out.println("Result: "+result);
    }
}
