package cn.marinda.wishgift.data;

import cn.marinda.wishgift.WishGift;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VexViewComponentData {
    private HashMap<String,VexViewGuiData> guiMap = new HashMap();
    private Map<String, VexViewTextData> textMap = new HashMap<>();
    private Map<String,VexViewImgData> imgMap = new HashMap<>();
    private Map<String,VexViewButtonData> btnMap = new HashMap<>();
    private YamlConfiguration config = new YamlConfiguration();

    public VexViewComponentData(){
        defaultConfig();
    }

    void defaultConfig(){
        try {
            config.load(new File(WishGift.plugin.getDataFolder(), "component"));
            for(String key : config.getConfigurationSection("gui").getKeys(false)){
                guiMap.put(key,new VexViewGuiData(config.getString("gui." + key + ".localGui"),config.getInt("gui." + key + ".x"),config.getInt("gui." + key + ".y"),config.getInt("gui." + key + ".width"),config.getInt("gui." + key + ".height"),config.getStringList("gui." + key + ".vexText"),config.getStringList("gui." + key + ".vexImg"),config.getStringList("gui." + key + ".vexButton"),config.getString("gui." + key + ".vexTextField")));
            }
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, VexViewGuiData> getGuiMap() {
        return guiMap;
    }

    public Map<String, VexViewTextData> getTextMap() {
        return textMap;
    }

    public Map<String, VexViewImgData> getImgMap() {
        return imgMap;
    }

    public Map<String, VexViewButtonData> getBtnMap() {
        return btnMap;
    }

    public YamlConfiguration getConfig() {
        return config;
    }
}
