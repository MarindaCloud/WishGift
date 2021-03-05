package cn.marinda.wishgift.mannager;

import cn.marinda.wishgift.data.ConfigData;
import cn.marinda.wishgift.data.VexViewComponentData;
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

}

