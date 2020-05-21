package com.demo.factory;

import com.demo.Interfaces.IBrowseTimes;
import com.demo.enums.EBrowseTimes;

public class BrowseFactory {
    public static IBrowseTimes getBrowseService(String type) {
        String path = EBrowseTimes.getPathByType(type);
        IBrowseTimes browse = null;
        try {
            browse = (IBrowseTimes) Class.forName(path).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return browse;
    }
}
