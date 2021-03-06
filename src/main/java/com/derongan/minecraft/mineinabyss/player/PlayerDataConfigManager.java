package com.derongan.minecraft.mineinabyss.player;

import com.derongan.minecraft.mineinabyss.AbyssContext;
import com.derongan.minecraft.mineinabyss.MineInAbyss;
import com.derongan.minecraft.mineinabyss.configuration.ConfigurationConstants;
import com.derongan.minecraft.mineinabyss.whistles.WhistleType;
import com.derongan.minecraft.mineinabyss.world.AbyssWorldManager;
import com.google.common.annotations.VisibleForTesting;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

public class PlayerDataConfigManager {
    private static final String UUID_KEY = "uuid";
    private static final String AFFECTABLE_KEY = "affectable";
    private static final String ANCHORED_KEY = "anchored";
    private static final String ASCENDED_KEY = "ascended";
    private static final String WHISTLE_KEY = "whistle";

    private AbyssContext context;

    public PlayerDataConfigManager(AbyssContext context) {
        this.context = context;
    }

    public PlayerData loadPlayerData(Player player) {
        Path path = getPlayerDataPath(player);

        AbyssWorldManager manager = context.getWorldManager();

        if (path.toFile().exists()) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(path.toFile());
            PlayerData data = new PlayerDataImpl(player);
            data.setAffectedByCurse(config.getBoolean(AFFECTABLE_KEY));
            data.setAnchored(config.getBoolean(ANCHORED_KEY));
            data.setDistanceAscended(config.getDouble(ASCENDED_KEY));
            if (config.contains(WHISTLE_KEY))
                data.setWhistle(WhistleType.valueOf(config.getString(WHISTLE_KEY)));
            return data;
        } else {
            PlayerData data = new PlayerDataImpl(player);

            return data;
        }
    }

    public void savePlayerData(PlayerData playerData) throws IOException {
        Path path = getPlayerDataPath(playerData.getPlayer());

        // Recreate directories if missing
        path.toFile().getParentFile().mkdirs();

        YamlConfiguration config = new YamlConfiguration();
        config.set(UUID_KEY, playerData.getPlayer().getUniqueId().toString());
        config.set(AFFECTABLE_KEY, playerData.isAffectedByCurse());
        config.set(ANCHORED_KEY, playerData.isAnchored());
        config.set(ASCENDED_KEY, playerData.getDistanceAscended());
        config.set(WHISTLE_KEY, playerData.getWhistle().name());

        config.save(path.toFile());
    }

    @VisibleForTesting
    Path getPlayerDataPath(Player player) {
        UUID uuid = player.getUniqueId();
        return MineInAbyss.getInstance().getDataFolder()
                .toPath()
                .resolve(ConfigurationConstants.PLAYER_DATA_DIR)
                .resolve(uuid.toString() + ".yml");
    }
}
