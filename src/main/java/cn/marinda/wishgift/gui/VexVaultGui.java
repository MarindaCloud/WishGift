package cn.marinda.wishgift.gui;

import cn.marinda.wishgift.data.VexViewGuiData;
import cn.marinda.wishgift.mannager.ConfigMannager;
import lk.vexview.api.VexViewAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;

public class VexVaultGui extends WishGiftViewGui{
    public VexVaultGui(ConfigMannager config) {
        super(config.getComponent().getGuiMap().get("money").getLocalUrl(), config.getComponent().getGuiMap().get("money").getX(), config.getComponent().getGuiMap().get("money").getY(), config.getComponent().getGuiMap().get("money").getWidth(), config.getComponent().getGuiMap().get("money").getHeight());
    }

    @Override
    public void openGui(Player player) {
        VexViewAPI.openGui(player,this);
    }

}
