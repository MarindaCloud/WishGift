package cn.marinda.wishgift.gui;

import cn.marinda.wishgift.utils.VexGuiComponentUtils;
import cn.marinda.wishgift.mannager.ConfigMannager;
import cn.marinda.wishgift.mannager.VexGuiMannager;
import lk.vexview.api.VexViewAPI;
import org.bukkit.entity.Player;

public class VexMenuGui extends WishGiftViewGui {
    public VexMenuGui(ConfigMannager config) {
        super(config.getComponent().getGuiMap().get("menu").getLocalUrl(), config.getComponent().getGuiMap().get("menu").getX(), config.getComponent().getGuiMap().get("menu").getY(), config.getComponent().getGuiMap().get("menu").getWidth(), config.getComponent().getGuiMap().get("menu").getHeight());

    }

    @Override
    public void openGui(Player player) {
        VexViewAPI.openGui(player, this);
    }
}
