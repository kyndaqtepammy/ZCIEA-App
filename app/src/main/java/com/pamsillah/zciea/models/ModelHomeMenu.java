package com.pamsillah.zciea.models;

public class ModelHomeMenu {
    private String title;
    private int imgid;
    private String menuId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public ModelHomeMenu(String title, int imgid, String menuId) {
        this.title = title;
        this.imgid = imgid;
        this.menuId = menuId;
    }
}
