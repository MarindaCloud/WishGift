package cn.marinda.wishgift.data;

import java.util.ArrayList;
import java.util.List;

public class PointsLuckyData {
    private List<String> prizeItemImage = new ArrayList<>();
    private List<String> commands = new ArrayList<>();
    public PointsLuckyData(List<String> prizeItemImage,List<String> commands){
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
