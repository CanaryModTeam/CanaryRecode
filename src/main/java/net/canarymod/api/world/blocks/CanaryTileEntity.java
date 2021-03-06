package net.canarymod.api.world.blocks;

import net.canarymod.api.nbt.CanaryCompoundTag;
import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.world.World;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;

/**
 * TileEntity implementation
 *
 * @author Jason (darkdiplomat)
 */
public abstract class CanaryTileEntity implements TileEntity {

    protected net.minecraft.tileentity.TileEntity tileentity;
    protected IInventory inventory;

    /**
     * Constructs a new wrapper for TileEntityChest
     *
     * @param tileentity
     *         the TileEntityChest to be wrapped
     */
    public CanaryTileEntity(net.minecraft.tileentity.TileEntity tileentity) {
        this.tileentity = tileentity;
    }

    public CanaryTileEntity(IInventory inventory) {
        this.inventory = inventory;
        if (inventory instanceof net.minecraft.tileentity.TileEntity) {
            this.tileentity = (net.minecraft.tileentity.TileEntity) inventory;
        }
    }

    /**
     * Gets the TileEntity being wrapped
     *
     * @return the TileEntity
     */
    public abstract net.minecraft.tileentity.TileEntity getTileEntity();

    /** {@inheritDoc} */
    @Override
    public Block getBlock() {
        return getWorld().getBlockAt(getX(), getY(), getZ());
    }

    /** {@inheritDoc} */
    @Override
    public int getX() {
        return tileentity.c.n();
    }

    /** {@inheritDoc} */
    @Override
    public int getY() {
        return tileentity.c.o();
    }

    /** {@inheritDoc} */
    @Override
    public int getZ() {
        return tileentity.c.p();
    }

    /** {@inheritDoc} */
    @Override
    public World getWorld() {
        return tileentity.z().getCanaryWorld();
    }

    /** {@inheritDoc} */
    @Override
    public void update() {
        getWorld().markBlockNeedsUpdate(getX(), getY(), getZ());
    }

    /** {@inheritDoc} */
    @Override
    public CompoundTag getDataTag() {
        if (tileentity != null) {
            NBTTagCompound tag = new NBTTagCompound();
            tileentity.b(tag);
            return new CanaryCompoundTag(tag);
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public CompoundTag getMetaTag() {
        if (tileentity != null) {
            return tileentity.getMetaTag();
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public CompoundTag writeToTag(CompoundTag tag) {
        if (tileentity != null) {
            tileentity.a(((CanaryCompoundTag) tag).getHandle());
            return tag;
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public void readFromTag(CompoundTag tag) {
        if (tileentity != null) {
            tileentity.a(((CanaryCompoundTag) tag).getHandle());
        }
    }

    /**
     * Returns a semi-unique hashcode for this block
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;

        hash = 97 * hash + getX();
        hash = 97 * hash + getY();
        hash = 97 * hash + getZ();
        return hash;
    }

    /**
     * Tests the given object to see if it equals this object
     *
     * @param obj
     *         the object to test
     *
     * @return true if the two objects match
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TileEntity)) {
            return false;
        }
        final TileEntity other = (TileEntity) obj;

        if (getX() != other.getX()) {
            return false;
        }
        if (getY() != other.getY()) {
            return false;
        }
        if (getZ() != other.getZ()) {
            return false;
        }
        return true;
    }
}
