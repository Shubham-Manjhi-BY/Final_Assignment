package com.Shop_Managment_Service.model;

import java.util.Map;

public class PayloadValidation {

    public static boolean createdPayloadIdValidation(Category category){


        if(category.getId()>0){
            return false;
        }

        return true;
    }

    public static boolean createdPayloadIdValidation(Product product){

        if(product.getId()>0){
            return false;
        }

        return true;
    }


    public static boolean createdPayloadCategoryField(Map<String, Object> map){

        if(!map.containsKey("description") && !map.containsKey("name")) return false;
        return true;
    }

    public static boolean createdPayloadProductField(Map<String, Object> map){

        if(!map.containsKey("description") && !map.containsKey("price") && !map.containsKey("name")) return false;
        return true;
    }


}
