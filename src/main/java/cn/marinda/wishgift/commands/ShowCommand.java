package cn.marinda.wishgift.commands;

public class ShowCommand extends WishGiftCommands{


    @Override
    public boolean WishGiftCommands(String[] args, String label) {
        if(label.equalsIgnoreCase("show")){
            if(args[0].equalsIgnoreCase(label)){
                System.out.println("本次执行的是：show方法");
                return true;
            }
        }
        return false;
    }
}
