package cn.marinda.wishgift.commands;

public class ShowVaultCommand extends WishGiftCommands{
    @Override
    public boolean WishGiftCommands(String[] args, String label) {
        if(args[0].equalsIgnoreCase(label)){
            if(args[1].equalsIgnoreCase("show")){
                return true;
            }
        }
        return false;
    }
}
