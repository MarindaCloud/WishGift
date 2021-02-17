package cn.marinda.wishgift;

import cn.marinda.wishgift.commands.WishGiftCommand;
import cn.marinda.wishgift.listener.VexGuiKeysEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WishGift extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginCommand("wg").setExecutor(new WishGiftCommand());
        Bukkit.getPluginManager().registerEvents(new VexGuiKeysEvent(),this);
        Bukkit.getConsoleSender().sendMessage("§6[WishGift]插件加载成功！");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("§7[WishGift]插件卸载成功！");
    }
}
