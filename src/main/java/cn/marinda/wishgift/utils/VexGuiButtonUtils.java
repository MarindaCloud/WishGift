package cn.marinda.wishgift.utils;

import cn.marinda.wishgift.WishGift;
import cn.marinda.wishgift.data.ConfigData;
import cn.marinda.wishgift.data.PlayerInfoData;
import cn.marinda.wishgift.mannager.ConfigMannager;
import cn.marinda.wishgift.mannager.VexGuiMannager;
import lk.vexview.gui.VexGui;
import lk.vexview.gui.components.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VexGuiButtonUtils {

    /*
    关于 button click事件的工具类
     */


    public static boolean start(ConfigMannager cm, Player player, PlayerInfoData playerData) {
        ConfigData data = cm.getConfigData(WishGift.plugin);
        int consume_pointsNumber = data.getPoint_consume();
        int consume_vaultNumber = data.getVault_consume();
        int vault_lucky = data.getVault_addNumber();
        int points_lucky = data.getPoint_addNumber();
        int playerLucky = playerData.getLuckyValue();
        if (clickButtonTakeMoney(player, consume_vaultNumber)) {
            isLuckyControls(playerLucky, player,playerData);
            setPlayerLuckyInfoData(player, playerData, player.getUniqueId() + ".info.luckyValue", (playerLucky + vault_lucky));
            return true;
        } else {
            player.sendMessage("§c你没有足够的钱许愿");
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
    //写入幸运值
    private static boolean setPlayerLuckyInfoData(Player player, PlayerInfoData playerData, String path, int value) {
        String playerName = player.getName();
        final int[] index = {0};
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    playerData.getConfig().set(path, value);
                    playerData.getConfig().save(new File(WishGift.plugin.getDataFolder(), "players/" + playerName + ".yml"));
                    playerData.reloadConfig();
                    index[0] = 1;
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
    private static void isLuckyControls(int playerLucky, Player player,PlayerInfoData data) {
        if (playerLucky >= 0 && playerLucky < 30) {
            if (randomBol()) { //5 - 7 30%
                player.sendMessage("§6许愿成功！");
            } else {
                player.sendMessage("§7许愿失败！");
            }
        }
        else if(playerLucky == 30){
            player.sendMessage("§6幸运值满30 许愿成功！");
        }
        else if(playerLucky >30 && playerLucky<60 ){
            if (randomBol()) { //5 - 7 30%
                player.sendMessage("§6许愿成功！");
            } else {
                player.sendMessage("§7许愿失败！");
            }
        }
        else if(playerLucky == 60){
            player.sendMessage("§6幸运值满60 许愿成功！");
        }
        else if(playerLucky >60 && playerLucky<90 ){
            if (randomBol()) { //5 - 7 30%
                player.sendMessage("§6许愿成功！");
            } else {
                player.sendMessage("§7许愿失败！");
            }
        }
        else if(playerLucky == 90){
            player.sendMessage("§6幸运值满90 许愿成功！");
        }
        else if(playerLucky >90 && playerLucky<100 ){
            if (randomBol()) { //5 - 7 30%
                player.sendMessage("§6许愿成功！");
            } else {
                player.sendMessage("§7许愿失败！");
            }
        }

        else if(playerLucky >= 100 && playerLucky <=150){
            player.sendMessage("§6幸运值满100 许愿成功！");
            setPlayerLuckyInfoData(player,data,player.getUniqueId() + ".info.luckyValue",0);
        }
        System.out.println("randomBolL" + randomBol() );
        isCmd(player,new ConfigMannager(),"",1);
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
    private static int  getItemName(ConfigMannager cm,String name)
    {
        ConfigData data = cm.getConfigData(WishGift.plugin);
        double random = Math.round(Math.random() * data.getVaultLucky().get(name).getPrizeItemImage().size());
        return (int)random;
    }

    private static void executeCommand(int index,String name,ConfigMannager cm,Player player){
        ConfigData data = cm.getConfigData(WishGift.plugin);
        
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
            System.out.println("cmd:" + cmd);
        }
        return false;
    }
}
