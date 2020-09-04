package com.seu.film.tool;

public interface MyTool {
    static String deleteReserve(String reserve_info, String seats){
        if(seats.length() != reserve_info.length())return reserve_info;
        StringBuilder strBuilder = new StringBuilder(reserve_info);
        for(int i = 0; i < reserve_info.length(); i++){
            if(seats.charAt(i) == '1') {
                strBuilder.setCharAt(i, '0');
            }
        }
        reserve_info=strBuilder.toString();
        return reserve_info;
    }
    static String addReserve(String reserve_info, String seats){
        if(seats.length() != reserve_info.length())return reserve_info;
        StringBuilder strBuilder = new StringBuilder(reserve_info);
        for(int i = 0; i < reserve_info.length(); i++){
            if(seats.charAt(i) == '1') {
                strBuilder.setCharAt(i, '1');
            }
        }
        reserve_info=strBuilder.toString();
        return reserve_info;
    }
}
