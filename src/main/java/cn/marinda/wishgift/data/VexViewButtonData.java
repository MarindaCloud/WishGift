package cn.marinda.wishgift.data;

public class VexViewButtonData {
    private String id;
    private String btnText;
    private String url;
    private int x;
    private int y;
    private int width;
    private int height;
    public VexViewButtonData(String id,String btnText,String url,int x, int y,int width,int height){
        this.id = id;
        this.btnText = btnText;
        this.url = url;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public String getBtnText() {
        return btnText;
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
}
