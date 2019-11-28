package com.example.a210.myapplication;
import android.graphics.drawable.Drawable;
public class ListViewItem { //리스트뷰 안에 들어갈 내용
    private Drawable iconDrawable;
    private String titleStr;//이름
    private String descStr;//전화번호
    private String location;//고양

    public void setIcon(Drawable icon){
        iconDrawable = icon;
    }
    public void setTitle(String title){
        titleStr=title;
    }
    public void setDesc(String desc){
        descStr=desc;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public Drawable getIcon(){
        return this.iconDrawable;
    }
    public String getTitle(){
        return this.titleStr;
    }
    public String getDesc(){
        return this.descStr;
    }

    public String getLocation(){
        return this.location;
    }
    public void setData(Drawable iconDrawable,String titleStr, String descStr,String location) {
        this.iconDrawable = iconDrawable;
        this.titleStr = titleStr;
        this.descStr = descStr;
        this.location = location;
    }
}

