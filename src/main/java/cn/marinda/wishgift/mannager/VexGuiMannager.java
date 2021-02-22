package cn.marinda.wishgift.mannager;

import cn.marinda.wishgift.data.VexVaultGui;
import lk.vexview.gui.VexGui;

public class VexGuiMannager {
    public VexGuiMannager(){

    }
    public VexGui getVexGui(String guiType,ConfigMannager cm){
        switch (guiType){
            case "money":
                break;
            case "points":
                break;
            case "menu":
                break;
            default:
                throw new NullPointerException();
        }
        return null;
    }
}
