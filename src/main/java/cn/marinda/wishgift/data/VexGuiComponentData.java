package cn.marinda.wishgift.data;

import cn.marinda.wishgift.mannager.ConfigMannager;
import cn.marinda.wishgift.mannager.VexGuiMannager;
import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.VexButton;
import lk.vexview.gui.components.VexImage;
import lk.vexview.gui.components.VexText;
import lk.vexview.gui.components.VexTextField;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class VexGuiComponentData {
    public VexGuiComponentData(ConfigMannager cm,String guiName,VexGuiMannager gm){
        defaultTextComponent(cm,guiName,gm);
    }

    private void defaultTextComponent(ConfigMannager cm, String guiName, VexGuiMannager gm){
        switch (guiName){
            case "menu":
                defaultMenuComponent(cm, gm);
                break;
            case "money":
                defaultMoneyComponent(cm, gm);
                break;
            case "points":
                defaultPointsComponent(cm, gm);
                break;
        }
    }

    private void defaultMenuComponent(ConfigMannager cm,VexGuiMannager gm){
        defaultAddTextComponent(cm,gm.getVexGui("menu"),"menu");
        defaultAddImgComponent(cm,gm.getVexGui("menu"),"menu");
        defaultAddTextFieldComponent(cm,gm.getVexGui("menu"),"menu");
        defaultAddButtonComponent(cm,gm.getVexGui("menu"),"menu");
    }

    private void defaultPointsComponent(ConfigMannager cm,VexGuiMannager gm){
        defaultAddTextComponent(cm,gm.getVexGui("points"),"points");
        defaultAddImgComponent(cm,gm.getVexGui("points"),"points");
        defaultAddTextFieldComponent(cm,gm.getVexGui("points"),"points");
        defaultAddButtonComponent(cm,gm.getVexGui("points"),"points");
    }

    private void defaultMoneyComponent(ConfigMannager cm,VexGuiMannager gm){
        defaultAddTextComponent(cm,gm.getVexGui("money"),"money");
        defaultAddImgComponent(cm,gm.getVexGui("money"),"money");
        defaultAddTextFieldComponent(cm,gm.getVexGui("money"),"money");
        defaultAddButtonComponent(cm,gm.getVexGui("money"),"money");
    }

    private void defaultAddTextComponent(ConfigMannager cm, VexGui gui, String guiName){
        List<String> vexTextComponent = cm.getComponent().getGuiMap().get(guiName).getVexText();
        List<String> text = new ArrayList<>();
        for(String s : vexTextComponent){
            //储存text列表
            if(cm.getComponent().getTextMap().containsKey(s)) {
                text.add(s);
                continue;
            }
        }
        addTextComponent(text,cm,gui);
    }
    private void addTextComponent(List<String> list, ConfigMannager cm, VexGui gui){
        for(String str : list){
            //控件名
            gui.addComponent(new VexText(cm.getComponent().getTextMap().get(str).getX(),cm.getComponent().getTextMap().get(str).getY(),cm.getComponent().getTextMap().get(str).getTextList(),cm.getComponent().getTextMap().get(str).getScale()));  ;
        }
    }

    private void defaultAddImgComponent(ConfigMannager cm, VexGui gui, String guiName){
        try {
            List<String> vexImgComponent = cm.getComponent().getGuiMap().get(guiName).getVexImg();
            List<String> text = new ArrayList<>();
            for (String s : vexImgComponent) {
                //储存text列表
                if (cm.getComponent().getImgMap().containsKey(s)) {
                    text.add(s);
                    continue;
                }
            }
            addImgComponent(text,cm,gui);
        }catch (NullPointerException e){
            Bukkit.getConsoleSender().sendMessage("§c检查配置文件中图像gui设置是否有误！");
        }

    }

    private void addImgComponent(List<String> list, ConfigMannager cm, VexGui gui){
        for(String str : list){
            //控件名
            gui.addComponent(new VexImage(cm.getComponent().getImgMap().get(str).getUrl(),cm.getComponent().getImgMap().get(str).getX(),cm.getComponent().getImgMap().get(str).getY(),cm.getComponent().getImgMap().get(str).getXs(),cm.getComponent().getImgMap().get(str).getYs()));  ;
        }
    }

    private void defaultAddTextFieldComponent(ConfigMannager cm, VexGui gui, String guiName){
        try {
            String vexTextFieldComponent = cm.getComponent().getGuiMap().get(guiName).getVexTextField();
                if (cm.getComponent().getFieldMap().containsKey(vexTextFieldComponent)) {
                    addTextFieldComponent(cm,gui,vexTextFieldComponent);
            }
        }catch (NullPointerException e){
            Bukkit.getConsoleSender().sendMessage("§c检查配置文件中输入框gui设置是否有误！");
        }

    }
    private void addTextFieldComponent(ConfigMannager cm, VexGui gui,String fieldKeyName){
            //控件名
            gui.addComponent(new VexTextField(cm.getComponent().getFieldMap().get(fieldKeyName).getX(),cm.getComponent().getFieldMap().get(fieldKeyName).getY(),cm.getComponent().getFieldMap().get(fieldKeyName).getWidth(),cm.getComponent().getFieldMap().get(fieldKeyName).getHeight(),cm.getComponent().getFieldMap().get(fieldKeyName).getMaxLength(),cm.getComponent().getFieldMap().get(fieldKeyName).getId(),cm.getComponent().getFieldMap().get(fieldKeyName).getDefaultText()));
    }

    private void defaultAddButtonComponent(ConfigMannager cm, VexGui gui, String guiName){
        try {
            List<String> vexButtonComponent = cm.getComponent().getGuiMap().get(guiName).getVexButton();
            List<String> text = new ArrayList<>();
            for (String s : vexButtonComponent) {
                //储存text列表
                if (cm.getComponent().getBtnMap().containsKey(s)) {
                    text.add(s);
                    continue;
                }
            }
            addButtonComponent(text,cm,gui);
        }catch (NullPointerException e){
            Bukkit.getConsoleSender().sendMessage("§c检查配置文件中按钮gui设置是否有误！");
        }

    }

    private void addButtonComponent(List<String> list, ConfigMannager cm, VexGui gui){
        for(String str : list){
            //控件名
            gui.addComponent(new VexButton(cm.getComponent().getBtnMap().get(str).getId(),cm.getComponent().getBtnMap().get(str).getBtnText(),cm.getComponent().getBtnMap().get(str).getUrl(),cm.getComponent().getBtnMap().get(str).getUrl(),cm.getComponent().getBtnMap().get(str).getX(),cm.getComponent().getBtnMap().get(str).getY(),cm.getComponent().getBtnMap().get(str).getWidth(),cm.getComponent().getBtnMap().get(str).getHeight()));
        }
    }
}
