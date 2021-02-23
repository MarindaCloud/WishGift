package cn.marinda.wishgift.listener;

import cn.marinda.wishgift.utils.PlayerFileUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEvent {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        PlayerFileUtils util = new PlayerFileUtils(event.getPlayer());
    }
}
