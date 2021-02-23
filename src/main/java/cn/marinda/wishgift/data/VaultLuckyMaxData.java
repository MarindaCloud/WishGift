package cn.marinda.wishgift.data;

import java.util.ArrayList;
import java.util.List;

public class VaultLuckyMaxData {
    private List<String> prizeItemImage = new ArrayList<>();
    private List<String> commands = new ArrayList<>();
    private boolean isRepeat = false;
    public VaultLuckyMaxData(List<String> prizeItemImage,List<String> commands,boolean isRepeat){
        this.prizeItemImage = prizeItemImage;
        this.commands = commands;
        this.isRepeat = isRepeat;
    }

    public List<String> getPrizeItemImage() {
        return prizeItemImage;
    }

    public List<String> getCommands() {
        return commands;
    }

    public boolean getIsRepeat() {
        return isRepeat;
    }
}
