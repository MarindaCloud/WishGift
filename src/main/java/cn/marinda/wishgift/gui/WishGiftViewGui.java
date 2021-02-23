package cn.marinda.wishgift.gui;

import cn.marinda.wishgift.mannager.ConfigMannager;
import lk.vexview.gui.VexGui;
import org.bukkit.entity.Player;

public abstract class WishGiftViewGui extends VexGui {
    //实现Gui
    public WishGiftViewGui(String url, int x, int y, int width, int height) {
        super(url,x,y,width,height);
    }

    public WishGiftViewGui(String url, int x, int y, int width, int height,ConfigMannager config) {
        super(url,x,y,width,height);
    }

    abstract void openGui(Player player);
}
