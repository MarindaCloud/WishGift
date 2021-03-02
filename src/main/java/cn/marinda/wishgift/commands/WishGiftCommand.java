package cn.marinda.wishgift.commands;

import cn.marinda.wishgift.WishGift;
import cn.marinda.wishgift.data.LangConfiguration;
import cn.marinda.wishgift.data.VexGuiTest;
import cn.marinda.wishgift.data.WishGiftConfigurations;
import cn.marinda.wishgift.gui.VexMenuGui;
import cn.marinda.wishgift.gui.VexPointsGui;
import cn.marinda.wishgift.gui.VexVaultGui;
import cn.marinda.wishgift.gui.WishGiftViewGui;
import cn.marinda.wishgift.mannager.ConfigMannager;
import cn.marinda.wishgift.mannager.VexGuiMannager;
import cn.marinda.wishgift.utils.VexGuiComponentUtils;
import lk.vexview.api.VexViewAPI;
import lk.vexview.gui.VexGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class WishGiftCommand implements CommandExecutor {
    ConfigMannager cm;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            cm = new ConfigMannager();
            LangConfiguration lang = new LangConfiguration(new File(WishGift.plugin.getDataFolder(),"lang.yml"));
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("show")) {
                    WishGiftViewGui wish = new VexMenuGui(cm);

                    wish.openGui(player);
                    return true;
                }
            }
            if(args.length == 2) {
                if (args[0].equalsIgnoreCase("vault")) {
                    if (args[1].equalsIgnoreCase("show")) {
                        WishGiftViewGui wish = new VexVaultGui(cm);
                        wish.openGui(player);
                    }
                }
                if (args[0].equalsIgnoreCase("points")) {
                    if (args[1].equalsIgnoreCase("show")) {
                        WishGiftViewGui wish = new VexPointsGui(cm);
                        wish.openGui(player);
                        return true;
                    }
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
