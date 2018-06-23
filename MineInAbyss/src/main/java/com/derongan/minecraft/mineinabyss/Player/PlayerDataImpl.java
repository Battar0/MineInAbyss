package com.derongan.minecraft.mineinabyss.Player;

import com.derongan.minecraft.mineinabyss.Ascension.Effect.AscensionEffect;
import com.derongan.minecraft.mineinabyss.World.Layer;
import com.derongan.minecraft.mineinabyss.World.Section;
import org.bukkit.entity.Player;

import java.util.List;


public class PlayerDataImpl implements PlayerData {
    private Layer currentLayer;
    private Section currentSection;

    private boolean affectedByCurse;
    private boolean anchored;
    private boolean canSeeLootSpawns;

    private double distanceAscended;

    private Player player;

    public PlayerDataImpl(Player player) {
        this.player = player;
        this.affectedByCurse = true;
    }

    private List<AscensionEffect> effects;

    @Override
    public Layer getCurrentLayer() {
        return currentLayer;
    }

    @Override
    public void setCurrentLayer(Layer currentLayer) {
        this.currentLayer = currentLayer;
    }

    @Override
    public Section getCurrentSection() {
        return currentSection;
    }

    @Override
    public void setCurrentSection(Section currentSection) {
        this.currentSection = currentSection;
    }

    @Override
    public boolean isAffectedByCurse() {
        return affectedByCurse;
    }

    @Override
    public void setAffectedByCurse(boolean affectedByCurse) {
        this.affectedByCurse = affectedByCurse;
    }

    @Override
    public boolean isAnchored() {
        return anchored;
    }

    @Override
    public void setAnchored(boolean anchored) {
        this.anchored = anchored;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public List<AscensionEffect> getAscensionEffects() {
        return effects;
    }

    @Override
    public void addAscensionEffect(AscensionEffect effect) {
        effects.add(effect);
    }

    @Override
    public double getDistanceAscended() {
        return distanceAscended;
    }

    @Override
    public void setDistanceAscended(double distanceAscended) {
        this.distanceAscended = distanceAscended;
    }

    @Override
    public boolean canSeeLootSpawns() {
        return canSeeLootSpawns;
    }

    @Override
    public void setCanSeeLootSpawns(boolean canSeeLootSpawns) {
        this.canSeeLootSpawns = canSeeLootSpawns;
    }
}
