package cn.marinda.wishgift.data;

import java.util.ArrayList;
import java.util.List;

public class VexViewGuiData {
    private String localUrl;
    private int x;
    private int y;
    private int width;
    private int height;
    private List<String> vexText = new ArrayList<>();
    private List<String> vexImg = new ArrayList<>();
    private String vexTextField;
    private List<String> vexButton = new ArrayList<>();

    public VexViewGuiData(String localUrl,int x,int y,int width,int height,List<String> vexText,List<String> vexImg,List<String> vexButton,String textField){
        this.localUrl = localUrl;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.vexButton = vexButton;
        this.vexTextField = textField;
        this.vexText = vexText;
        this.vexImg = vexImg;
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getVexText() {
        return vexText;
    }

    public List<String> getVexImg() {
        return vexImg;
    }

    public String getVexTextField() {
        return vexTextField;
    }

    public List<String> getVexButton() {
        return vexButton;
    }
}
