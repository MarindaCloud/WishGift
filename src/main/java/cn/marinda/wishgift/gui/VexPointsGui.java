package cn.marinda.wishgift.gui;

import cn.marinda.wishgift.data.VexViewGuiData;
import cn.marinda.wishgift.mannager.ConfigMannager;
import lk.vexview.api.VexViewAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;

public class VexPointsGui extends WishGiftViewGui {
    public VexPointsGui(ConfigMannager config) {
        super(config.getComponent().getGuiMap().get("points").getLocalUrl(), config.getComponent().getGuiMap().get("money").getX(), config.getComponent().getGuiMap().get("money").getY(), config.getComponent().getGuiMap().get("money").getWidth(), config.getComponent().getGuiMap().get("money").getHeight());
    }

    @Override
    void openGui(Player player) {
        VexViewAPI.openGui(player, this);
    }
}
