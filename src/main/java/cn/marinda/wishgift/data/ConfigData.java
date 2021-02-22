package cn.marinda.wishgift.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigData {
    private String prefix;
    private int keyUp;
    private int point_consume;
    private int point_addNumber;
    private List<String> totalWishPrizeImg = new ArrayList<>();
    private Map<String,PointsLuckyData> luckyData = new HashMap<>();
    public ConfigData(){
    }

}
