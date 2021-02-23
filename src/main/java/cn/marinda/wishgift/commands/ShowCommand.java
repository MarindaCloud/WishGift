package cn.marinda.wishgift.commands;

public class ShowCommand extends WishGiftCommands{


    @Override
    public boolean WishGiftCommands(String[] args) {
            if(args[0].equalsIgnoreCase("show")){
                return true;
            }
        return false;
    }
}
