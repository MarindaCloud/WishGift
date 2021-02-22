package cn.marinda.wishgift.data;

import java.util.ArrayList;
import java.util.List;

public class VexViewTextData {
    private int x;
    private int y;
    private List<String> textList = new ArrayList<>();
    private double scale;
    public VexViewTextData(int x,int y,List<String> textList,double scale){
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.textList = textList;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<String> getTextList() {
        return textList;
    }

    public void setTextList(List<String> textList) {
        this.textList = textList;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
