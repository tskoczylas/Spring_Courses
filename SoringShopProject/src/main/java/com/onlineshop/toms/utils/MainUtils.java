package com.onlineshop.toms.utils;

public  class  MainUtils {

    public static boolean isIntegerAndNotNull(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }


}
