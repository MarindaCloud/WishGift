package cn.marinda.wishgift.data;

public class VexViewImgData {
    private String url;
    private int x;
    private int y;
    private int width;
    private int height;
    private int xs;
    private int ys;

    public VexViewImgData(String url,int x,int y,int width,int height,int xs,int ys){
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xs = xs;
        this.ys = ys;
    }

    public String getUrl() {
        return url;
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

    public int getXs() {
        return xs;
    }

    public int getYs() {
        return ys;
    }
}
