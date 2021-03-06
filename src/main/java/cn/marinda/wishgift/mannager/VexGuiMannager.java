package cn.marinda.wishgift.mannager;

import cn.marinda.wishgift.gui.VexPointsGui;
import cn.marinda.wishgift.gui.VexVaultGui;
import lk.vexview.gui.VexGui;

public class VexGuiMannager {
    public VexGuiMannager(){

    }
    public VexGui getVexGui(String guiType){
        ConfigMannager cm = new ConfigMannager();
        switch (guiType){
            case "money":
                return new VexVaultGui(cm);
            case "points":
                return new VexPointsGui(cm);
        }
        return null;
    }
}
