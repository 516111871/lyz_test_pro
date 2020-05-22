package com.demo.check.factory;

import com.demo.check.ECheck;
import com.demo.check.IService.ICheck;

public class Factory {

    public static ICheck getCheck(String type){
        ICheck check = null;
        String path = ECheck.getPathByType(type);
        try {
             check = (ICheck) Class.forName(path).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
