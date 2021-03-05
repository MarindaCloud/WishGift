package cn.marinda.wishgift.utils;

import cn.marinda.wishgift.WishGift;
import cn.marinda.wishgift.data.ConfigData;
import cn.marinda.wishgift.data.PlayerInfoData;
import cn.marinda.wishgift.mannager.ConfigMannager;
import cn.marinda.wishgift.mannager.VexGuiMannager;
import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.*;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValueAdapter;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VexGuiButtonUtils {

    /*
    关于 button click事件的工具类
     */
    private static boolean bol = false;


    public static boolean start(ConfigMannager cm, Player player, PlayerInfoData playerData) {
        ConfigData data = cm.getConfigData(WishGift.plugin);
        int consume_vaultNumber = data.getVault_consume();
        int vault_lucky = data.getVault_addNumber();
        int playerLucky = playerData.getLuckyValue();
        if (clickButtonTakeMoney(player, consume_vaultNumber)) {
            if(isLuckyControls(playerLucky, player,playerData,consume_vaultNumber) && !bol){
                return true;
            }
            setPlayerLuckyInfoData(player, playerData, player.getUniqueId() + ".info.luckyValue", (playerLucky + vault_lucky));
            bol = false;
        } else {
            player.sendMessage(WishGift.prefix + "§c你没有足够的钱许愿");
        }
        return false;
    }

    //points
    public static boolean pointsStart(ConfigMannager cm, Player player, PlayerInfoData playerData) {
        ConfigData data = cm.getConfigData(WishGift.plugin);
        int consume_pointsNumber = data.getPoint_consume();
        int points_lucky = data.getPoint_addNumber();
        int playerLucky = playerData.getLuckyValue();
        if (clickButtonTakePoint(player, consume_pointsNumber)) {
            if(isLuckyControls(playerLucky, player,playerData,consume_pointsNumber) && !bol){
                return true;
            }
            setPlayerLuckyInfoData(player, playerData, player.getUniqueId() + ".info.luckyValue", (playerLucky + points_lucky));
            bol = false;
        } else {
            player.sendMessage(WishGift.prefix + "§c你没有足够的点卷许愿");
        }
        return false;
    }

    //vault 金币扣款处理
    private static boolean clickButtonTakeMoney(Player player, double takeMoney) {
        VaultAPI api = new VaultAPI(WishGift.eco);
        double player_Money = api.getMoney(player);
        if (player_Money >= takeMoney) {
            api.takeMoney(player, takeMoney);
            return true;
        }
        return false;
    }

    //points 点卷处理
    private static boolean clickButtonTakePoint(Player player, int takeMoney){
        PlayerPointsAPI point = new PlayerPointsAPI(WishGift.points);
        int player_points = point.look(player.getUniqueId());
        if(player_points>= takeMoney){
            point.take(player.getUniqueId(),takeMoney);
            return true;
        }
        return false;
    }
    //金币新增
    //vault 金币扣款处理
    private static boolean clickButtonAddMoney(Player player, double addMoney) {
        VaultAPI api = new VaultAPI(WishGift.eco);
        double player_Money = api.getMoney(player);
        if (player_Money >= addMoney) {
            api.giveMoney(player, addMoney);
            return true;
        }
        return false;
    }
    //写入幸运值
    private static boolean setPlayerLuckyInfoData(Player player, PlayerInfoData playerData, String path, int value) {
        String playerName = player.getName();
        final int[] index = {0};
         boolean bo = player.hasMetadata("button");
       new BukkitRunnable() {
            @Override
            public synchronized void run() {
                    try {

                        if (playerData.getConfig().getInt(player.getUniqueId() + ".info.luckyValue") >= 100) {
                            playerData.getConfig().set(path, 0);
                            playerData.getConfig().save(new File(WishGift.plugin.getDataFolder(), "players/" + playerName + ".yml"));
                            playerData.reloadConfig(player);
                        }else{
                            playerData.getConfig().set(path, value);
                            playerData.getConfig().save(new File(WishGift.plugin.getDataFolder(), "players/" + playerName + ".yml"));
                            playerData.reloadConfig(player);
                            index[0] = 1;
                        }
//                            }
//                        player.setMetadata("button",new FixedMetadataValue(WishGift.plugin,1));
//                            if (playerData.getConfig().getInt(player.getUniqueId() + ".info.luckyValue") >= 100) {
//                                playerData.getConfig().set(path, 0);
//                                playerData.getConfig().save(new File(WishGift.plugin.getDataFolder(), "players/" + playerName + ".yml"));
//                                playerData.reloadConfig();
//                            }
//                            player.removeMetadata("button",WishGift.plugin);
//
//                        if(bo){
//                            System.out.println("233");
//                            player.setMetadata("button",new FixedMetadataValue(WishGift.plugin,1));
//
//                            player.removeMetadata("button",WishGift.plugin);
//
//                        }else{
//                            Thread.sleep(2000);
//                            playerData.getConfig().set(path, value);
//                            playerData.getConfig().save(new File(WishGift.plugin.getDataFolder(), "players/" + playerName + ".yml"));
//                            playerData.reloadConfig();
//                            index[0] = 1;
//                            System.out.println("123");
//                        }
                    } catch (Exception e) {
                        index[0] = -1;
                    }
                }

        }.runTaskAsynchronously(WishGift.plugin);
        if(index[0] == 1){
            return true;
        }
        return false;
    }

    //控制幸运值以及保底等
    private static boolean isLuckyControls(int playerLucky, Player player,PlayerInfoData data,int consume) {
        ConfigMannager cm = new ConfigMannager();
        try {
            if (playerLucky >= 0 && playerLucky < 30) {
                if (randomBol()) { //5 - 7 30%
                    player.sendMessage(WishGift.prefix + cm.getLangConfig().getWishSuccessPrefix());
                    isCmd(player, new ConfigMannager(), "30", getVauleItemName(cm, "30"));
                    return true;
                } else {
                    player.sendMessage(WishGift.prefix + cm.getLangConfig().getWishLoseMsg());
                }
            } else if (playerLucky == 30) {
                isCmd(player, new ConfigMannager(), "30", getVauleItemName(cm, "30"));
                player.sendMessage(WishGift.prefix +"§6幸运值满30 许愿成功！");
                bol = true;
                return true;
            } else if (playerLucky > 30 && playerLucky < 60) {
                if (randomBol()) { //5 - 7 30%
                    player.sendMessage(WishGift.prefix + cm.getLangConfig().getWishSuccessPrefix());
                    isCmd(player, new ConfigMannager(), "60", getVauleItemName(new ConfigMannager(), "60"));
                    return true;
                } else {
                    player.sendMessage(WishGift.prefix + cm.getLangConfig().getWishLoseMsg());
                    return false;
                }
            } else if (playerLucky == 60) {
                player.sendMessage(WishGift.prefix +"§6幸运值满60 许愿成功！");
                isCmd(player, new ConfigMannager(), "60", getVauleItemName(new ConfigMannager(), "60"));
                bol = true;
                return true;
            } else if (playerLucky > 60 && playerLucky < 90) {
                if (randomBol()) { //5 - 7 30%
                    player.sendMessage(WishGift.prefix + cm.getLangConfig().getWishSuccessPrefix());
                    isCmd(player, new ConfigMannager(), "90", getVauleItemName(new ConfigMannager(), "90"));
                    return true;
                } else {
                    player.sendMessage(WishGift.prefix + cm.getLangConfig().getWishLoseMsg());
                    return false;
                }
            } else if (playerLucky == 90) {
                bol = true;
                player.sendMessage(WishGift.prefix +"§6幸运值满90 许愿成功！");
                isCmd(player, new ConfigMannager(), "90", getVauleItemName(new ConfigMannager(), "90"));
                return true;
            } else if (playerLucky > 90 && playerLucky < 100) {
                if (randomBol()) { //5 - 7 30%
                    player.sendMessage(WishGift.prefix + cm.getLangConfig().getWishSuccessPrefix());
                    isCmd(player, new ConfigMannager(), "90", getVauleItemName(new ConfigMannager(), "90"));
                    return true;
                } else {
                    player.sendMessage(WishGift.prefix + cm.getLangConfig().getWishLoseMsg());
                    return false;
                }
            } else if (playerLucky >=100) {
                player.sendMessage(WishGift.prefix +"§6幸运值满100 许愿成功！");
                if(valueMaxLuckyCommand(new ConfigMannager(),player));
                setPlayerLuckyInfoData(player, data, player.getUniqueId() + ".info.luckyValue", 0);
                bol = true;
                return true;

            }

        }catch (Exception e){
            clickButtonAddMoney(player,consume);
            player.sendMessage(WishGift.prefix +"§e请再来一次！");
        }
        return false;
    }
    //bool
    private static boolean randomBol(){
        double ran = Math.round(Math.random() * 10);
        if (ran >= 5 && ran <= 7) { //5 - 7 30%
            return true;
        }else{
            return false;
        }
    }


    //许愿成功奖励
    private static int  getVauleItemName(ConfigMannager cm,String name)
    {
        ConfigData data = cm.getConfigData(WishGift.plugin);
        int random = (int)Math.round(Math.random() * data.getVaultLucky().get(name).getPrizeItemImage().size());
        return (int)random;
    }

    //保底
    private static boolean valueMaxLuckyCommand(ConfigMannager cm,Player player){
        int random = (int)Math.round(Math.random()* cm.getConfigData(WishGift.plugin).getVaultMaxLuckyData().get("100").getCommands().size());
        if(random>cm.getConfigData(WishGift.plugin).getVaultMaxLuckyData().get("100").getCommands().size()){
            return false;
        }
        String cmd = cm.getConfigData(WishGift.plugin).getVaultMaxLuckyData().get("100").getCommands().get(random);
        if(isCmdPapi(cmd)){
            playerSendPapiCommand(cmd,player);
            return true;
        }else{
            player.chat(cmd);
            return true;
        }
    }

    private static  boolean isCmdPapi(String cmdString)
    {
        if (cmdString.contains("%")) {
            return true;
        }
        return false;
    }
    private static boolean isCmd(Player player,ConfigMannager cm,String name,int itemKey)
    {
        String cmd = cm.getConfigData(WishGift.plugin).getVaultLucky().get(name).getCommands().get(itemKey);
        //papi
        if(isCmdPapi(cmd)){
            playerSendPapiCommand(cmd,player);
            return true;
        }else{
            player.chat(cmd);
        }
        return false;
    }

    private static void playerSendPapiCommand(String cmd,Player player){
        String str = PlaceholderAPI.setPlaceholders(player, cmd);
        if(!player.isOp()){
            player.setOp(true);
            player.chat(str);
            player.setOp(false);
        }else{
            player.chat( str);
        }

    }
}
