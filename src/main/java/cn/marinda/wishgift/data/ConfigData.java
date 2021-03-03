package cn.marinda.wishgift.data;

import cn.marinda.wishgift.WishGift;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigData extends WishGiftConfigurations {
    //config data
    private String prefix;

    private int keyUp;
    private int point_consume;
    private int point_addNumber;
    private List<String> pointsTotalWishPrizeImg = new ArrayList<>();
    private Map<String,PointsLuckyData> luckyData = new HashMap<>();
    private Map<String,PointsLuckyMaxData> maxLuckyData = new HashMap<>();
    private Map<String,VaultLuckyData> vaultLucky = new HashMap<>();
    private int vault_consume;
    private int vault_addNumber;
    private List<String> vaultTotalWishPrizeImg = new ArrayList<>();
    private Map<String,VaultLuckyMaxData> vaultMaxLuckyData = new HashMap<>();
    private YamlConfiguration config ;
    public ConfigData(File file) {
        super(file);
        defaultConfig(file);
    }

    @Override
    void defaultConfig(File file) {
        config = (YamlConfiguration) WishGift.plugin.getConfig();
        this.prefix = getConfig().getString("prefix");
        this.keyUp = getConfig().getInt("keyUp");
        this.point_addNumber = getConfig().getInt("points.addNumber");
        this.point_consume = getConfig().getInt("points.consume");
        this.pointsTotalWishPrizeImg = getConfig().getStringList("points.totalWishPrizeImg");
        for(String key : getConfig().getConfigurationSection("points.lucky").getKeys(false)){
            this.luckyData.put(key,new PointsLuckyData(config.getStringList("points.lucky." + key + "prizeItemImage"),config.getStringList("points.lucky." + key + "command")));
        }
        this.luckyData.remove("100");
        this.maxLuckyData.put("100",new PointsLuckyMaxData(config.getStringList("points.lucky.100.prizeItemImage"),config.getStringList("points.lucky.100.command"),config.getBoolean("points.lucky.100.isRepeat")));
        this.vault_consume = getConfig().getInt("vault.consume");
        this.vault_addNumber = getConfig().getInt("vault.addNumber");
        this.vaultTotalWishPrizeImg = getConfig().getStringList("vault.totalWishPrizeImg");
        for(String key : getConfig().getConfigurationSection("vault.lucky").getKeys(false)){
            this.vaultLucky.put(key,new VaultLuckyData(config.getStringList("vault.lucky." + key + "prizeItemImage"),config.getStringList("vault.lucky." + key + "command")));
        }
        this.vaultLucky.remove("100");
        this.vaultMaxLuckyData.put("100",new VaultLuckyMaxData(config.getStringList("vault.lucky.100.prizeItemImage"),config.getStringList("vault.lucky.100.command"),config.getBoolean("vault.lucky.100.isRepeat")));
    }

    public String getPrefix() {
        return prefix;
    }



    public int getKeyUp() {
        return keyUp;
    }

    public int getPoint_consume() {
        return point_consume;
    }

    public int getPoint_addNumber() {
        return point_addNumber;
    }

    public List<String> getPointsTotalWishPrizeImg() {
        return pointsTotalWishPrizeImg;
    }

    public Map<String, PointsLuckyData> getLuckyData() {
        return luckyData;
    }

    public Map<String, PointsLuckyMaxData> getMaxLuckyData() {
        return maxLuckyData;
    }

    public Map<String, VaultLuckyData> getVaultLucky() {
        return vaultLucky;
    }

    public int getVault_consume() {
        return vault_consume;
    }

    public int getVault_addNumber() {
        return vault_addNumber;
    }

    public List<String> getVaultTotalWishPrizeImg() {
        return vaultTotalWishPrizeImg;
    }


    public Map<String, VaultLuckyMaxData> getVaultMaxLuckyData() {
        return vaultMaxLuckyData;
    }

    @Override
    YamlConfiguration getConfig() {
        return config;
    }
}
