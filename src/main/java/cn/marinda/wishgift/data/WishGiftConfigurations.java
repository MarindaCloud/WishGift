package cn.marinda.wishgift.data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public abstract class WishGiftConfigurations {
    public WishGiftConfigurations(File file){
        defaultConfig(file);
    }

    public WishGiftConfigurations(Player player){

    }
    //初始化
    abstract  void defaultConfig(File file);
    abstract YamlConfiguration getConfig();
}
