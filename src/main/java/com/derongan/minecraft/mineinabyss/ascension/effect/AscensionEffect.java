package com.derongan.minecraft.mineinabyss.ascension.effect;

import org.bukkit.entity.Player;

public interface AscensionEffect {
    void applyEffect(Player player, int ticks);
    boolean isDone();
    int getRemainingTicks();
    void setRemainingTicks(int remainingTicks);
    void cleanUp(Player player);
}
