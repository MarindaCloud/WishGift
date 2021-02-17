package cn.marinda.wishgift.data;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LangConfiguration extends WishGiftConfigurations {
    private String wishSuccessPrefix;
    private String wishLoseMsg;
    private String wishTakeVaultPrefix;
    private List<String> help = new ArrayList<String>();
    private YamlConfiguration config = new YamlConfiguration();

    public LangConfiguration(File file) {
        super(file);
        defaultConfig(file);
    }

    @Override
    void defaultConfig(File file) {
        config = YamlConfiguration.loadConfiguration(file);
        setWishLoseMsg(config.getString("wishLoseMsg"));
        setWishSuccessPrefix(config.getString("WishSuccessPrefix"));
        setWishTakeVaultPrefix(config.getString("WishTakeVaultPrefix"));
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
}
