package cn.marinda.wishgift.gui;

import cn.marinda.wishgift.data.VexViewGuiData;
import cn.marinda.wishgift.mannager.ConfigMannager;
import lk.vexview.api.VexViewAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;

public class VexPointsGui extends WishGiftViewGui {
    public VexPointsGui(ConfigMannager config) {
        super(config.getComponent().getGuiMap().get("points").getLocalUrl(), config.getComponent().getGuiMap().get("points").getX(), config.getComponent().getGuiMap().get("points").getY(), config.getComponent().getGuiMap().get("points").getWidth(), config.getComponent().getGuiMap().get("points").getHeight());
    }

    @Override
    public void openGui(Player player) {
        VexViewAPI.openGui(player, this);
    }
}
