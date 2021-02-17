package cn.marinda.wishgift.commands;

import cn.marinda.wishgift.WishGift;
import cn.marinda.wishgift.data.LangConfiguration;
import cn.marinda.wishgift.data.VexGuiTest;
import cn.marinda.wishgift.data.WishGiftConfigurations;
import lk.vexview.api.VexViewAPI;
import lk.vexview.gui.VexGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class WishGiftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            LangConfiguration lang = new LangConfiguration(new File(WishGift.plugin.getDataFolder(),"lang.yml"));
            if(args.length == 1){
                WishGiftCommands wgs = new ShowCommand();
                if(wgs.WishGiftCommands(args,"show")){
                    VexViewAPI.openGui(player,new VexGuiTest());
                    return true;
                }
            }
            help(lang,player);
            return true;

        }
        return false;
    }

    private void help(LangConfiguration lang,Player player){
        for(String str : lang.getHelp()){
            player.sendMessage(str);
        }
        lang = null;
    }
}
