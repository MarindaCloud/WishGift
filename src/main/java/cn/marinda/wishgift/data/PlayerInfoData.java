package cn.marinda.wishgift.data;

import cn.marinda.wishgift.WishGift;
import com.google.common.base.Charsets;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class PlayerInfoData {
    private int luckyValue;
    private List<String> getGift;
    private YamlConfiguration config  = new YamlConfiguration();
    private File file = null;
    public PlayerInfoData(Player player) {
        defaultData(player);
    }


    void defaultData(Player player){
        file = new File(WishGift.plugin.getDataFolder(), "players/" + player.getName() + ".yml");
        this.config = YamlConfiguration.loadConfiguration(file);
        this.luckyValue = getConfig().getInt(player.getUniqueId() + ".info.luckyValue");
        this.getGift = getConfig().getStringList(player.getUniqueId() + ".info.getGift");
    }
    public void reloadConfig(Player player) {
        config = YamlConfiguration.loadConfiguration(file);

        final InputStream defConfigStream = WishGift.plugin.getResource("players/" + player.getName() + ".yml");
        if (defConfigStream == null) {
            return;
        }

        config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
    }
    public YamlConfiguration getConfig() {
        return config;
    }

    public int getLuckyValue() {
        return luckyValue;
    }

    public List<String> getGetGift() {
        return getGift;
    }
}
