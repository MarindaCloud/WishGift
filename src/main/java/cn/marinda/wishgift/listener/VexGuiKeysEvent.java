package cn.marinda.wishgift.listener;

import cn.marinda.wishgift.WishGift;
import cn.marinda.wishgift.data.ConfigData;
import cn.marinda.wishgift.data.PlayerInfoData;
import cn.marinda.wishgift.data.WishGiftConfigurations;
import cn.marinda.wishgift.gui.VexPointsGui;
import cn.marinda.wishgift.mannager.ConfigMannager;
import cn.marinda.wishgift.mannager.VexGuiMannager;
import cn.marinda.wishgift.utils.VaultAPI;
import cn.marinda.wishgift.utils.VexGuiButtonUtils;
import lk.vexview.api.VexViewAPI;
import lk.vexview.event.ButtonClickEvent;
import lk.vexview.event.KeyBoardPressEvent;
import lk.vexview.gui.components.VexImage;
import lk.vexview.tag.TagDirection;
import lk.vexview.tag.components.VexImageTag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;

public class VexGuiKeysEvent implements Listener {
    ConfigMannager cm = new ConfigMannager();
    VexGuiMannager gm = new VexGuiMannager();
    @EventHandler
    public void onKeyUp(KeyBoardPressEvent e){
        if(e.getKey() == new ConfigMannager().getConfigData(WishGift.plugin).getKeyUp()){
            VexViewAPI.openGui(e.getPlayer(),new VexPointsGui(new ConfigMannager()));
        }
        PlayerInfoData data = new PlayerInfoData(e.getPlayer());
    }

    @EventHandler
    public void  onClick(ButtonClickEvent e){
        if(gm.getVexGui("points").getButtonById(e.getButtonID())!= null){
            PlayerInfoData data = new PlayerInfoData(e.getPlayer());
            VexGuiButtonUtils.pointsStart(cm,e.getPlayer(),data);
        }
        if(gm.getVexGui("money").getButtonById(e.getButtonID())!= null){
            PlayerInfoData data = new PlayerInfoData(e.getPlayer());
            VexGuiButtonUtils.start(cm,e.getPlayer(),data);
        }
        if(gm.getVexGui("menu").getButtonById(e.getButtonID())!= null){
        }
    }
}
