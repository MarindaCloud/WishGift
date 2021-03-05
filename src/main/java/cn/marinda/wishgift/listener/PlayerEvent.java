package cn.marinda.wishgift.listener;

import cn.marinda.wishgift.WishGift;
import cn.marinda.wishgift.data.PlayerInfoData;
import cn.marinda.wishgift.utils.PlayerFileUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class PlayerEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        PlayerFileUtils util = new PlayerFileUtils(event.getPlayer());
        PlayerInfoData data = new PlayerInfoData(event.getPlayer());
        System.out.println("Data:" + data.getLuckyValue());
    }
}
