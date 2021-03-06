package cn.marinda.wishgift.data;

import java.util.ArrayList;
import java.util.List;

public class VaultLuckyMaxData {
    private List<String> commands = new ArrayList<>();
//    private boolean isRepeat = false;
    public VaultLuckyMaxData(List<String> prizeItemImage,List<String> commands){
        this.commands = commands;
//        this.isRepeat = isRepeat;
    }


    public List<String> getCommands() {
        return commands;
    }

//    public boolean getIsRepeat() {
//        return isRepeat;
//    }
}
