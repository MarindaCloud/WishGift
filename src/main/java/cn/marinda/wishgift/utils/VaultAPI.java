package cn.marinda.wishgift.utils;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;

public class VaultAPI {
    private Economy economy = null;

    public VaultAPI(Economy economy) {
        this.economy = economy;
    }

    public Economy getEconomy() {
        return economy;
    }

    public void setEconomy(Economy economy) {
        this.economy = economy;
    }

    public boolean takeMoney(Player player, double value) {
        if (player != null && getEconomy() != null) {
            EconomyResponse er = getEconomy().withdrawPlayer(player, value);
            return er.transactionSuccess();
        }else {
            return false;
        }
    }

    public boolean giveMoney(Player player, double value) {
        if (player != null && getEconomy() != null) {
            EconomyResponse er = getEconomy().depositPlayer(player, value);
            return er.transactionSuccess();
        }else {
            return false;
        }
    }

    public double getMoney(Player player) {
        if (getEconomy() != null) {
            return getEconomy().getBalance(player);
        }
        return -1;
    }
}
