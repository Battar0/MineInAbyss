package com.derongan.minecraft.mineinabyss.World;

import org.bukkit.Location;
import org.bukkit.World;

public interface Section {
    /**
     * Gets the index of this Section. Higher sections have lower index
     * @return The index of this section
     */
    int getIndex();

    /**
     * Gets the reference location between this section and the one above it.
     *
     * This method and the section above's {@link Section#getReferenceLocationBottom()}
     * represent the same location in the abyss.
     * @return The top reference point
     */
    Location getReferenceLocationTop();

    /**
     * Gets the reference location between this section and the one below it.
     *
     * This method and the section below's {@link Section#getReferenceLocationTop()} ()}
     * represent the same location in the abyss.
     * @return The bottom reference point
     */
    Location getReferenceLocationBottom();

    /**
     * Get the layer this section belongs to
     * @return the layer this section belongs to
     */
    Layer getLayer();


    /**
     * Gets the Bukkit World for this section
     * @return The world this section is in
     */
    World getWorld();

    /**
     * Gets the name of the world this layer is in
     * @return The name of the world
     */
    String getWorldName();

    /**
     * Get the area that this section covers
     * @return The area, or null if not defined
     */
    SectionArea getArea();
}
