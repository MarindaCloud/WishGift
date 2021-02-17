package cn.marinda.wishgift.commands;

import cn.marinda.wishgift.data.VexGuiTest;
import lk.vexview.api.VexViewAPI;
import lk.vexview.gui.VexGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WishGiftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("show")){
                    VexViewAPI.openGui(player,new VexGuiTest());
                    return true;
                }
            }
        }
        return false;
    }
}
