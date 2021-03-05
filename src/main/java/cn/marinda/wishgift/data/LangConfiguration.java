package cn.marinda.wishgift.data;

import cn.marinda.wishgift.WishGift;
import com.google.common.base.Charsets;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LangConfiguration extends WishGiftConfigurations {
    private String wishSuccessPrefix;
    private String wishLoseMsg;
    private String wishTakeVaultPrefix;
    private List<String> help = new ArrayList<String>();
    private YamlConfiguration config = new YamlConfiguration();
    private File file = null;
    public LangConfiguration(File file) {
        super(file);
        defaultConfig(new File(WishGift.plugin.getDataFolder(),"lang.yml"));
    }

    @Override
    void defaultConfig(File file) {
        config = YamlConfiguration.loadConfiguration(file);
        file = new File(WishGift.plugin.getDataFolder(),"lang.yml");
        setWishLoseMsg(config.getString("wishLoseMsg"));
        setWishSuccessPrefix(config.getString("wishSuccessPrefix"));
        setHelp(config.getStringList("help"));


    }

    public String getWishSuccessPrefix() {
        return wishSuccessPrefix;
    }

    private void setWishSuccessPrefix(String wishSuccessPrefix) {
        this.wishSuccessPrefix = wishSuccessPrefix;
    }

    public String getWishLoseMsg() {
        return wishLoseMsg;
    }

    private void setWishLoseMsg(String wishLoseMsg) {
        this.wishLoseMsg = wishLoseMsg;
    }

    public String getWishTakeVaultPrefix() {
        return wishTakeVaultPrefix;
    }

    private void setWishTakeVaultPrefix(String wishTakeVaultPrefix) {
        this.wishTakeVaultPrefix = wishTakeVaultPrefix;
    }

    public List<String> getHelp() {
        return help;
    }

    private void setHelp(List<String> help) {
        this.help = help;
    }

    @Override
    public YamlConfiguration getConfig() {
        return config;
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);

        final InputStream defConfigStream = WishGift.plugin.getResource("lang.yml");
        if (defConfigStream == null) {
            return;
        }

        config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
    }
}
