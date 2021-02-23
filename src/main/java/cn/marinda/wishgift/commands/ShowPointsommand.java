package cn.marinda.wishgift.commands;

public class ShowPointsommand extends WishGiftCommands{
    @Override
    public boolean WishGiftCommands(String[] args) {
        if(args[0].equalsIgnoreCase("points")){
            if(args[1].equalsIgnoreCase("show")){
                return true;
            }
        }
        return false;
    }
}
