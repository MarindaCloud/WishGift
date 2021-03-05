package cn.marinda.wishgift.data;

import cn.marinda.wishgift.WishGift;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;

public abstract class WishGiftConfigurations {
    protected FileConfiguration config;
    public WishGiftConfigurations(File file){

    }

    public WishGiftConfigurations(Player player){

    }
    //初始化
    abstract  void defaultConfig(File file);
    abstract YamlConfiguration getConfig();
}
