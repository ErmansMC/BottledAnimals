package com.ermans.bottledanimals.block.generator;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyStorage;
import com.ermans.api.IEnergyBA;
import com.ermans.bottledanimals.block.TileInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

public abstract class TileEnergyProvider extends TileInventory implements IEnergyProvider, IEnergyBA {

    private static final int MAX_RF = 80;
    private static final int CAPACITY = 64000;

    public boolean[][] DF_VALID_SIDE = new boolean[][]{
            {false, true, true, true, true, true},
            {true, false, true, true, true, true},
            {true, true, false, true, true, true},
            {true, true, true, false, true, true},
            {true, true, true, true, false, true},
            {true, true, true, true, true, false},
    };

    protected EnergyStorage storage;

    protected int maxRF;
    protected int capacity;


    @Override
    public void initTile() {
        super.initTile();
        maxRF = MAX_RF;
        capacity = CAPACITY;
        this.storage = new EnergyStorage(capacity, capacity, maxRF);
    }


    protected void modifyEnergyStored(int energy) {
        storage.modifyEnergyStored(energy);
    }

    @Override
    public IEnergyStorage getEnergyStorage() {
        return storage;
    }

    @Override
    public boolean canConnectEnergy(EnumFacing from) {
        return DF_VALID_SIDE[from.ordinal()][facing.ordinal()];
    }

    @Override
    public int extractEnergy(EnumFacing from, int maxExtract, boolean simulate) {
        return storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(EnumFacing from) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(EnumFacing from) {
        return storage.getMaxEnergyStored();
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        storage.writeToNBT(nbt);
    }

    @Override
    public int getField(int id) {
        if (id == 100){
            return storage.getEnergyStored();
        }
        return super.getField(id);
    }

    @Override
    public void setField(int id, int value) {
        if (id == 100){
            storage.setEnergyStored(value);
            return;
        }
        super.setField(id, value);
    }

    @Override
    public int getFieldCount() {
        return super.getFieldCount() + 1;
    }
}