package cn.marinda.wishgift.data;

import java.util.ArrayList;
import java.util.List;

public class VaultLuckyData {
    private List<String> prizeItemImage = new ArrayList<>();
    private List<String> commands = new ArrayList<>();
    public VaultLuckyData(List<String> prizeItemImage,List<String> commands){
        this.prizeItemImage = prizeItemImage;
        this.commands = commands;
    }

    public List<String> getPrizeItemImage() {
        return prizeItemImage;
    }

    public List<String> getCommands() {
        return commands;
    }
}
