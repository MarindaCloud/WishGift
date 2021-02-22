package cn.marinda.wishgift.data;

public class VexViewTextFieldData {
    private int x;
    private int y;
    private int width;
    private int height;
    private int maxLength;
    private String defaultText;
    private int id;
    public VexViewTextFieldData(int x,int y,int width,int height,int maxlength,int id,String defaultText){
        this.x = x;
        this.y = y;
        this.defaultText = defaultText;
        this.height = height;
        this.maxLength = maxlength;
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getId() {
        return id;
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

    public int getMaxLength() {
        return maxLength;
    }

    public String getDefaultText() {
        return defaultText;
    }
}
