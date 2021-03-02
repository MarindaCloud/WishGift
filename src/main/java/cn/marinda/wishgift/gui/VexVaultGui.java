package cn.marinda.wishgift.gui;

import cn.marinda.wishgift.data.VexViewGuiData;
import cn.marinda.wishgift.mannager.ConfigMannager;
import cn.marinda.wishgift.mannager.VexGuiMannager;
import lk.vexview.api.VexViewAPI;
import lk.vexview.gui.components.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VexVaultGui extends WishGiftViewGui{
    public  List<VexComponents> components = new ArrayList<>();
    public VexVaultGui(ConfigMannager config) {
        super(config.getComponent().getGuiMap().get("money").getLocalUrl(), config.getComponent().getGuiMap().get("money").getX(), config.getComponent().getGuiMap().get("money").getY(), config.getComponent().getGuiMap().get("money").getWidth(), config.getComponent().getGuiMap().get("money").getHeight());
        defaultTextComponent(config,"money",new VexGuiMannager());
    }

    @Override
    public void openGui(Player player) {
        VexViewAPI.openGui(player,this);
    }

    private  void defaultTextComponent(ConfigMannager cm, String guiName, VexGuiMannager gm){
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
        defaultAddTextComponent(cm,"menu");
        defaultAddImgComponent(cm,"menu");
        defaultAddTextFieldComponent(cm,"menu");
        defaultAddButtonComponent(cm,"menu");
        this.addAllComponents(components);
        print(gm);
    }

    private void defaultPointsComponent(ConfigMannager cm,VexGuiMannager gm){
        defaultAddTextComponent(cm,"points");
        defaultAddImgComponent(cm,"points");
        defaultAddTextFieldComponent(cm,"points");
        defaultAddButtonComponent(cm,"points");
        this.addAllComponents(components);
    }

    private void defaultMoneyComponent(ConfigMannager cm,VexGuiMannager gm){
        defaultAddTextComponent(cm,"money");
        defaultAddImgComponent(cm,"money");
        defaultAddTextFieldComponent(cm,"money");
        defaultAddButtonComponent(cm,"money");
        this.addAllComponents(components);
    }
    private void print(VexGuiMannager gm){
        for(VexComponents str : this.getComponents()){
            System.out.println("type:" + str.getType() );
        }
    }
    private void defaultAddTextComponent(ConfigMannager cm, String guiName){
        List<String> vexTextComponent = cm.getComponent().getGuiMap().get(guiName).getVexText();
        List<String> text = new ArrayList<>();
        for(String s : vexTextComponent){
//            储存text列表
            if(cm.getComponent().getTextMap().containsKey(s) && !text.contains(s)) {
                text.add(s);
            }else{
                continue;
            }
        }
        addTextComponent(text,cm);
    }
    private void addTextComponent(List<String> list, ConfigMannager cm){
        for(String str : list){
            System.out.println("str:" + str);
            //控件名
            components.add(new VexText(cm.getComponent().getTextMap().get(str).getX(),cm.getComponent().getTextMap().get(str).getY(),cm.getComponent().getTextMap().get(str).getTextList(),cm.getComponent().getTextMap().get(str).getScale()));  ;
        }
    }

    private void defaultAddImgComponent(ConfigMannager cm, String guiName){
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
            addImgComponent(text,cm);
        }catch (NullPointerException e){
            Bukkit.getConsoleSender().sendMessage("§c检查配置文件中图像gui设置是否有误！");
        }

    }

    private  void addImgComponent(List<String> list, ConfigMannager cm){
        for(String str : list){
            //控件名
            components.add(new VexImage(cm.getComponent().getImgMap().get(str).getUrl(),cm.getComponent().getImgMap().get(str).getX(),cm.getComponent().getImgMap().get(str).getY(),cm.getComponent().getImgMap().get(str).getXs(),cm.getComponent().getImgMap().get(str).getYs()));  ;
        }
    }

    private void defaultAddTextFieldComponent(ConfigMannager cm, String guiName){
        try {
            String vexTextFieldComponent = cm.getComponent().getGuiMap().get(guiName).getVexTextField();
            if (cm.getComponent().getFieldMap().containsKey(vexTextFieldComponent)) {
                addTextFieldComponent(cm,vexTextFieldComponent);
            }
        }catch (NullPointerException e){
            Bukkit.getConsoleSender().sendMessage("§c检查配置文件中输入框gui设置是否有误！");
        }

    }
    private  void addTextFieldComponent(ConfigMannager cm,String fieldKeyName){
        //控件名
        components.add(new VexTextField(cm.getComponent().getFieldMap().get(fieldKeyName).getX(),cm.getComponent().getFieldMap().get(fieldKeyName).getY(),cm.getComponent().getFieldMap().get(fieldKeyName).getWidth(),cm.getComponent().getFieldMap().get(fieldKeyName).getHeight(),cm.getComponent().getFieldMap().get(fieldKeyName).getMaxLength(),cm.getComponent().getFieldMap().get(fieldKeyName).getId(),cm.getComponent().getFieldMap().get(fieldKeyName).getDefaultText()));
    }

    private  void defaultAddButtonComponent(ConfigMannager cm, String guiName){
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
            addButtonComponent(text,cm);
        }catch (NullPointerException e){
            Bukkit.getConsoleSender().sendMessage("§c检查配置文件中按钮gui设置是否有误！");
        }

    }

    private void addButtonComponent(List<String> list, ConfigMannager cm){
        for(String str : list){
            //控件名
            components.add(new VexButton(cm.getComponent().getBtnMap().get(str).getId(),cm.getComponent().getBtnMap().get(str).getBtnText(),cm.getComponent().getBtnMap().get(str).getUrl(),cm.getComponent().getBtnMap().get(str).getUrl(),cm.getComponent().getBtnMap().get(str).getX(),cm.getComponent().getBtnMap().get(str).getY(),cm.getComponent().getBtnMap().get(str).getWidth(),cm.getComponent().getBtnMap().get(str).getHeight()));
        }
    }
}
