package cn.marinda.wishgift.data;

import cn.marinda.wishgift.mannager.ConfigMannager;
import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.VexText;

import java.util.ArrayList;
import java.util.List;

public class VexMenuGui extends VexGui {
    public VexMenuGui(String a, int a2, int a3, int a4, int a5) {
        super(a, a2, a3, a4, a5);
    }
    private void defaultMenuComponent(ConfigMannager cm){
        List<String> vexTextComponent = cm.getComponent().getGuiMap().get("menu").getVexText();
        List<String> text = new ArrayList<>();
            for(String s : vexTextComponent){
                //储存text列表
                if(cm.getComponent().getTextMap().containsKey(s)) {
                    text.add(s);
                    continue;
                }

        }
    }
    private void addComponents(List<String> list,VexGui gui){
        for(String str : list){

        }

    }
}
