package cn.marinda.wishgift.utils;

import cn.marinda.wishgift.WishGift;
import org.bukkit.entity.Player;

import java.io.*;

public class PlayerFileUtils {

    public PlayerFileUtils(Player player){
        isPlayerExites(player);
    }

    private boolean isPlayerExites(Player player){
        if(!new File(WishGift.plugin.getDataFolder(),"players/" + player.getName() + ".yml").exists()){
            isPlayerFiles(player);
            writeFile(new File(WishGift.plugin.getDataFolder(),"players/" + player.getName() + ".yml").getPath(),fileUpload(new File(WishGift.plugin.getDataFolder(),"players/North_City_Q.yml"),player));
            return true;
        }
        return false;
    }

    private boolean isPlayerFiles(Player player) {
        File file = new File(WishGift.plugin.getDataFolder(),"players/" + player.getName() + ".yml");
        File source = new File(WishGift.plugin.getDataFolder(),"players/North_City_Q.yml");
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
    private String fileUpload(File oldFile,Player player){
        BufferedReader br = null;
        String line = null;
        StringBuffer bufAll = new StringBuffer();// 保存修改过后的所有内容
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile.getPath()), "UTF-8"));
            while ((line = br.readLine()) != null) {
                StringBuffer buf = new StringBuffer();
                // 修改内容核心代码
                if (line.startsWith("=")) {//判断条件根据自己的要求修改
                    buf.append(line);
                    int indexOf = line.indexOf("=");
                    buf.replace(indexOf, indexOf + line.substring(indexOf).length(), player.getUniqueId().toString()+":");// 修改内容
                    buf.append(System.getProperty("line.separator"));// 添加换行
                    bufAll.append(buf);
                } else {
                    buf.append(line);
                    buf.append(System.getProperty("line.separator"));
                    bufAll.append(buf);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    br = null;
                }
            }
        }
        return bufAll.toString();
    }
    // 写文件
    private boolean writeFile(String filePath, String content) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
            bw.write(content);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    bw = null;
                }
            }
        }
        return true;
    }
}
