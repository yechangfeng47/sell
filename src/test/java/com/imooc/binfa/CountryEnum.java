package com.imooc.binfa;

import lombok.Getter;

public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");

    @Getter
    private Integer code;

    @Getter
    private String message;

    CountryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static  CountryEnum forEachCountryEnum(int index){

        CountryEnum[] myArray = CountryEnum.values();
        for(CountryEnum element : myArray){
            if(index == element.getCode()){
                return  element;
            }
        }

        return null;
    }
}
