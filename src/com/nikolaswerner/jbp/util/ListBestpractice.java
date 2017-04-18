package com.nikolaswerner.jbp.util;

import com.nikolaswerner.jbp.common.helper.Car;
import java.util.List;

/**
 * This file contains multiple methods that should show you what the best practice for handling Lists is.
 * @author nikolaswerner
 */
public class ListBestpractice {
    public boolean doesContainValueWithAttribute(List<Car> list, String vendor) {
        boolean toReturn = false;
        
        // way how it is often done and not very nice to look at
        for(Car entry : list) {
            if(vendor.equals(entry.getVendor())) {
                toReturn = true;
                break;
            }
        }
        
        // We can improve this a bit without using new Java 8 functions
        for(int i = 0; i < list.size() && !toReturn; i++) {
            toReturn = vendor.equals(list.get(i).getVendor());
        }
        
        // With java 8 it will look even nicer
        toReturn = list.stream().filter((item) -> {return vendor.equals(item.getVendor());}).findFirst().isPresent();
        
        return toReturn;
    }
}
