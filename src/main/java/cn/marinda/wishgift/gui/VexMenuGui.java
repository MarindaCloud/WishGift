package cn.marinda.wishgift.gui;

import cn.marinda.wishgift.mannager.ConfigMannager;
import lk.vexview.api.VexViewAPI;
import org.bukkit.entity.Player;

public class VexMenuGui extends WishGiftViewGui {
    public VexMenuGui(ConfigMannager config) {
        super(config.getComponent().getGuiMap().get("menu").getLocalUrl(), config.getComponent().getGuiMap().get("money").getX(), config.getComponent().getGuiMap().get("money").getY(), config.getComponent().getGuiMap().get("money").getWidth(), config.getComponent().getGuiMap().get("money").getHeight());
    }

    @Override
    void openGui(Player player) {
        VexViewAPI.openGui(player, this);
    }
}
