package com.derongan.minecraft.mineinabyss.World;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public abstract class ChunkEntityImpl implements ChunkEntity {
    private long expiration;
    private Entity theEntity;
    private int x;
    private int z;
    private int y;

    public ChunkEntityImpl(long duration, int x, int y, int z) {
        this.expiration = getCurrentTime() + duration;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public long getExpiration(){
        return expiration;
    }

    @Override
    public long getCurrentTime(){
        return System.currentTimeMillis();
    }

    @Override
    public void destroyEntity() {
        theEntity.remove();
    }

    // This is a dubious decision
    @Override
    public Entity createEntity(World world) {
        Location location = new Location(world, getX(), getY(), getZ());
        theEntity = makeEntity(location);

        return theEntity;
    }

    @Override
    public Entity getEntity() {
        return theEntity;
    }

    protected abstract Entity makeEntity(Location location);

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }
}
