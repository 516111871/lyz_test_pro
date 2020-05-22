package com.demo.enums;

/**
 * @author lyz
 */
public enum EBrowseTimes {
    /**
     * 商品
     */
    goods("goods","com.demo.Interfaces.impl.goodsBrowse"),
    /**
     * 动态
     */
    news("news","com.demo.Interfaces.impl.newsBrowse");

    private String type;

    private String path;


     EBrowseTimes(String type, String path) {
        this.type = type;
        this.path = path;
    }

    public static String getPathByType(String type) {
         String path = null;
         for (int i=0;i<EBrowseTimes.values().length;i++){
             if (type.equals(EBrowseTimes.values()[i].getType())){
                 path = EBrowseTimes.values()[i].getPath();
             }
         }
        return path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
