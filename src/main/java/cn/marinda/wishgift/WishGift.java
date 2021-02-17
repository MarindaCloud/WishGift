package cn.marinda.wishgift;

import cn.marinda.wishgift.commands.WishGiftCommand;
import cn.marinda.wishgift.listener.VexGuiKeysEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class WishGift extends JavaPlugin {
    public static WishGift plugin;
    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        saveDefaultConfig();
        defaultPluginMannager();
        defaultConfiguration();
        Bukkit.getConsoleSender().sendMessage("§6[WishGift]插件加载成功！");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("§7[WishGift]插件卸载成功！");
    }

    private void defaultPluginMannager(){
        Bukkit.getPluginCommand("wg").setExecutor(new WishGiftCommand());
        Bukkit.getPluginManager().registerEvents(new VexGuiKeysEvent(),this);
    }

    private void defaultConfiguration(){
            saveResource("lang.yml",false);
    }
}
