package cn.marinda.wishgift.commands;

public class ShowCommand extends WishGiftCommands{


    @Override
    public boolean WishGiftCommands(String[] args, String label) {
            if(args[0].equalsIgnoreCase(label)){
                return true;
            }
        return false;
    }
}
