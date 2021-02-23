package cn.marinda.wishgift.utils;

import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.event.PlayerPointsChangeEvent;
import org.black_ixx.playerpoints.storage.StorageHandler;

import java.util.UUID;

public class PlayerPointsAPI {
    /**
     * Plugin instance.
     */
    private final PlayerPoints plugin;

    /**
     * Constructor
     *
     * @param p - Player points plugin.
     */
    public PlayerPointsAPI(PlayerPoints p) {
        this.plugin = p;
    }

    public boolean give(UUID playerId, int amount) {
        if (playerId == null) {
            return false;
        }
        PlayerPointsChangeEvent event = new PlayerPointsChangeEvent(playerId,
                amount);
        plugin.getServer().getPluginManager().callEvent(event);
        if (!event.isCancelled()) {
            final int total = look(playerId)
                    + event.getChange();
            return plugin.getModuleForClass(StorageHandler.class).setPoints(
                    playerId.toString(), total);
        }
        return false;
    }

    @Deprecated
    public boolean give(String playerName, int amount) {
        boolean success = false;
        if (playerName != null) {
            success = give(plugin.translateNameToUUID(playerName), amount);
        }
        return success;
    }

    public boolean take(UUID playerId, int amount) {
        final int points = look(playerId);
        int take = amount;
        if (take > 0) {
            take *= -1;
        }
        if ((points + take) < 0) {
            return false;
        }
        return give(playerId, take);
    }

    @Deprecated
    public boolean take(String playerName, int amount) {
        boolean success = false;
        if (playerName != null) {
            success = take(plugin.translateNameToUUID(playerName), amount);
        }
        return success;
    }

    /**
     * Look up the current points of a player, if available. If player does not
     * exist in the config file, or if given a null UUID, then we default to 0.
     *
     * @param playerId Player UUID
     * @return Points that the player has
     */
    public int look(UUID playerId) {
        int amount = 0;
        if (playerId != null) {
            amount = plugin.getModuleForClass(StorageHandler.class).getPoints(playerId.toString());
        }
        return amount;
    }

    @Deprecated
    public int look(String playerName) {
        return look(plugin.translateNameToUUID(playerName));
    }
}