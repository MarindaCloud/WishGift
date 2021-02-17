package cn.marinda.wishgift.data;

import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.*;
import org.bukkit.Bukkit;

import java.util.Arrays;

public class VexGuiTest extends VexGui {
    public VexGuiTest() {
        super("[local]gui.png", -1, -1, 240, 158);
        addText();
    }
    public void addText(){
//        VexText text = new VexText(1,1,Arrays.asList("自定义信息"),1.5);
//        VexImage img = new VexImage("[local]login.png",this.getWidth()/4,this.getHeight()/4,150,100);
        VexButton btn = new VexButton("_01","快来点我","[local]button.png","[local]button.png",0,0,50,10);
//        VexCheckBox checkBox = new VexCheckBox(0,"[local]check.png","[local]check_.png",0,0,8,8,true) ;
//        VexTextField textfield = new VexTextField(10,10,100,100,55,0);
        VexPlayerDraw pd = new VexPlayerDraw(100,100, 10,Bukkit.getPlayer("North_City_Q"));
        this.addComponent(btn);
        this.addComponent(pd);

    }
}
