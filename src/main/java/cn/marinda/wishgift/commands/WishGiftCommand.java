package cn.marinda.wishgift.commands;

import cn.marinda.wishgift.WishGift;
import cn.marinda.wishgift.data.LangConfiguration;
import cn.marinda.wishgift.data.VexGuiTest;
import cn.marinda.wishgift.data.WishGiftConfigurations;
import cn.marinda.wishgift.mannager.ConfigMannager;
import cn.marinda.wishgift.mannager.VexGuiMannager;
import lk.vexview.api.VexViewAPI;
import lk.vexview.gui.VexGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class WishGiftCommand implements CommandExecutor {
    WishGiftCommands wgs;
    VexGuiMannager gm;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            gm = new VexGuiMannager();
            LangConfiguration lang = new LangConfiguration(new File(WishGift.plugin.getDataFolder(),"lang.yml"));
            if(args.length == 1){
                 wgs = new ShowCommand();
                if(wgs.WishGiftCommands(args,"show")) VexViewAPI.openGui(player,gm.getVexGui("menu"));return true;
            }
            if(args.length == 2){
                 wgs = new ShowVaultCommand();
                if(wgs.WishGiftCommands(args,"vault")) {
                    VexViewAPI.openGui(player, gm.getVexGui("money"));
                    return true;
                }
                if(wgs.WishGiftCommands(args,"points")) VexViewAPI.openGui(player,gm.getVexGui("points")) ;return true;
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
