package cn.marinda.wishgift.data;

import cn.marinda.wishgift.WishGift;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PlayerInfoData extends WishGiftConfigurations {
    private int luckyValue;
    private List<String> getGift;
    private YamlConfiguration config  = new YamlConfiguration();
    public PlayerInfoData(Player player) {
        super(player);
        defaultData(player);
    }

    @Override
    void defaultConfig(File file) {
        try {
            config.load(file);
        }catch (IOException | InvalidConfigurationException e){
        }
    }
    void defaultData(Player player){
        this.luckyValue = getConfig().getInt(player.getUniqueId() + ".info.luckyValue");
        this.getGift = getConfig().getStringList(player.getUniqueId() + ".info.getGift");
    }

    @Override
    YamlConfiguration getConfig() {
        return null;
    }

    public int getLuckyValue() {
        return luckyValue;
    }

    public List<String> getGetGift() {
        return getGift;
    }
}
