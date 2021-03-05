package cn.marinda.wishgift;

import cn.marinda.wishgift.commands.WishGiftCommand;
import cn.marinda.wishgift.listener.PlayerEvent;
import cn.marinda.wishgift.listener.VexGuiKeysEvent;
import cn.marinda.wishgift.mannager.ConfigMannager;
import me.clip.placeholderapi.PlaceholderAPI;
import net.milkbowl.vault.economy.Economy;
import org.black_ixx.playerpoints.PlayerPoints;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class WishGift extends JavaPlugin {
    public static WishGift plugin;
    public static Economy eco = null;
    public static boolean isVaultEnabled = false;
    public static PlayerPoints points = null;
    public static double version;
    public static String prefix;
    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        version = Double.parseDouble(Bukkit.getVersion().substring(Bukkit.getVersion().indexOf("MC:") + 3, Bukkit.getVersion().length() - 3));
        defaultPluginMannager();
        defaultConfiguration();
        defaultDepenedPluginMessage();
        reloadConfig();
        prefix = getConfig().getString("prefix");

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
        Bukkit.getPluginManager().registerEvents(new PlayerEvent(),this);
    }

    private void defaultConfiguration(){
            saveDefaultConfig();
            saveResource("lang.yml",false);
            saveResource("component.yml",false);
            saveResource("players/North_City_Q.yml",false);
    }

    public static Economy getEco() {
        return eco;
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            eco = economyProvider.getProvider();
        }
        return (eco != null);
    }

    public void defaultDepenedPluginMessage(){
        if(Bukkit.getPluginManager().isPluginEnabled("Vault")){
            Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§6正在挂载§e[Vault]");
            if(setupEconomy()){
                Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§b挂载完毕§e[Vault]");
            }else{
                Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§b挂载失败§e[Vault]");
            }
        }else{
            Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§c未找到Vault插件");
        }

        if (Bukkit.getPluginManager().isPluginEnabled("Vault"))
        {
            Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§e已找到PlayerPoints");
            if (hookPlayerPoints()) {
                Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§aPlayerPoints初始化成功");
            }else{
                Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§aPlayerPoints初始化失败");
            }
        }
        else
        {
            Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§c未找到PlayerPoints插件");
        }

        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§b挂载完毕§b[PlaceHolderAPI]");
        }else{
            Bukkit.getServer().getConsoleSender().sendMessage("§7[PotentialSystem]§c未找到PlaceHolderAPI插件");
        }

    }

    private boolean hookPlayerPoints()
    {
        Plugin plugin = getServer().getPluginManager().getPlugin("PlayerPoints");
        points = (PlayerPoints)PlayerPoints.class.cast(plugin);
        return points != null;
    }

    public PlayerPoints getPlayerPoints()
    {
        return points;
    }


}
