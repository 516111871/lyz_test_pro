package com.demo.check;

public enum ECheck {
    /**
     * 类型
     */
    check("check","com.demo.check.IService.impl.Check"),
    share("share","com.demo.check.IService.impl.Share"),
    guanZhu("guanZhu","com.demo.check.IService.impl.GuanZhu");

    private String type;

    private String path;

    ECheck(String type, String path) {
        this.type = type;
        this.path = path;
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

    public static String getPathByType(String type){
        String path = null;
        for (int i=0;i<ECheck.values().length;i++) {
            if (type.equals(ECheck.values()[i].getType())){
                path = ECheck.values()[i].getPath();
            }
        }
        return path;
    }
}
