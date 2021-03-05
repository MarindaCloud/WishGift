package cn.marinda.wishgift.data;

import java.util.ArrayList;
import java.util.List;

public class PointsLuckyMaxData {
    private List<String> commands = new ArrayList<>();
    private boolean isRepeat = false;
    public PointsLuckyMaxData(List<String> prizeItemImage,List<String> commands,boolean isRepeat){
        this.commands = commands;
        this.isRepeat = isRepeat;
    }

    public List<String> getCommands() {
        return commands;
    }

    public boolean getIsRepeat() {
        return isRepeat;
    }
}
