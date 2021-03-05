package cn.marinda.wishgift.mannager;

import cn.marinda.wishgift.WishGift;
import cn.marinda.wishgift.data.ConfigData;
import cn.marinda.wishgift.data.LangConfiguration;
import cn.marinda.wishgift.data.PlayerInfoData;
import cn.marinda.wishgift.data.VexViewComponentData;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigMannager {
    public ConfigMannager(){

    }

    public VexViewComponentData getComponent(){
        return new VexViewComponentData();
    }

    public ConfigData getConfigData(Plugin plugin){
        return new ConfigData();
    }
    public PlayerInfoData getPlayerInfoData(Player player){
        return  new PlayerInfoData(player);
    }
    public LangConfiguration getLangConfig(){
        return  new LangConfiguration(new File(WishGift.plugin.getDataFolder(),"lang.yml"));
    }



}

