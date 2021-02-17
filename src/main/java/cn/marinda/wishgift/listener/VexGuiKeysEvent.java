package cn.marinda.wishgift.listener;

import lk.vexview.api.VexViewAPI;
import lk.vexview.event.ButtonClickEvent;
import lk.vexview.event.KeyBoardPressEvent;
import lk.vexview.gui.components.VexImage;
import lk.vexview.tag.TagDirection;
import lk.vexview.tag.components.VexImageTag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VexGuiKeysEvent implements Listener {
    @EventHandler
    public void onKeyUp(KeyBoardPressEvent e){
        if(e.getKey() == 36){
            TagDirection td = new TagDirection(0,0,0,false,true);

            VexImageTag loginImg = new VexImageTag("id_s",0,3,0,"[local]login.png",10,10,1,1,td);
            VexViewAPI.addPlayerTag(e.getPlayer(),loginImg);

        }
    }

    @EventHandler
    public void  onClick(ButtonClickEvent e){
        e.getPlayer().sendMessage("当前点击的按钮" + e.getButton().getName());
    }
}
