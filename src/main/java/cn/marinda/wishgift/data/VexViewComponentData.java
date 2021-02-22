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
    private Map<String,VexViewTextFieldData> fieldMap = new HashMap<>();
    private YamlConfiguration config = new YamlConfiguration();

    public VexViewComponentData(){
        defaultConfig();
    }

    void defaultConfig(){
        try {
            config.load(new File(WishGift.plugin.getDataFolder(), "component.yml"));
            dataDefault();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    void dataDefault(){
        for(String key : config.getConfigurationSection("gui").getKeys(false)){
            guiMap.put(key,new VexViewGuiData(config.getString("gui." + key + ".localGui"),config.getInt("gui." + key + ".x"),config.getInt("gui." + key + ".y"),config.getInt("gui." + key + ".width"),config.getInt("gui." + key + ".height"),config.getStringList("gui." + key + ".vexText"),config.getStringList("gui." + key + ".vexImg"),config.getStringList("gui." + key + ".vexButton"),config.getString("gui." + key + ".vexTextField")));
        }
        for(String key : config.getConfigurationSection("vexTexts").getKeys(false)){
            textMap.put(key,new VexViewTextData(config.getInt("vexTexts." + key + ".x"),config.getInt("vexTexts." + key + ".y"),config.getStringList("vexTexts." + key + ".text"),config.getDouble("vexTexts." + key + ".scale")));
        }
        for(String key : config.getConfigurationSection("vexTextField").getKeys(false)){
            fieldMap.put(key,new VexViewTextFieldData(config.getInt("vexTextField." + key + ".x"),config.getInt("vexTextField." + key + ".y"),config.getInt("vexTextField." + key + ".width"),config.getInt("vexTextField." + key + ".height"),config.getInt("vexTextField." + key + ".maxLength"),config.getInt("vexTextField." + key + ".id"),config.getString("vexTextField." + key + ".defaultText")));
        }
        for(String key : config.getConfigurationSection("vexImg").getKeys(false)){
            imgMap.put(key,new VexViewImgData(config.getString("vexImg." + key + ".url"),config.getInt("vexImg." + key + ".x"),config.getInt("vexImg.." + key + ".y"),config.getInt("vexImg.." + key + ".width"),config.getInt("vexImg." + key + ".height"),config.getInt("vexImg." + key + ".xs"),config.getInt("vexImg.." + key + ".ys")));
        }
        for(String key : config.getConfigurationSection("vexButton").getKeys(false)){
            btnMap.put(key,new VexViewButtonData(config.getString("vexButton." + key),config.getString("vexButton." + key + ".text"),config.getString("vexButton." + key + ".url"),config.getInt("vexButton." + key + ".x"),config.getInt("vexButton." + key + ".y"),config.getInt("vexButton." + key + ".width"),config.getInt("vexButton." + key + ".height")));
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

    public Map<String, VexViewTextFieldData> getFieldMap() {
        return fieldMap;
    }
}
