package com.codetaylor.mc.pyrotech.modules.storage.block;

import com.codetaylor.mc.pyrotech.modules.storage.ModuleStorageConfig;
import com.codetaylor.mc.pyrotech.modules.storage.block.spi.BlockTankBase;
import com.codetaylor.mc.pyrotech.modules.storage.tile.TileTankStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockTankStone
    extends BlockTankBase {

  public static final String NAME = "stone_tank";

  // ---------------------------------------------------------------------------
  // - Accessors
  // ---------------------------------------------------------------------------

  @Override
  public int getCapacity() {

    return ModuleStorageConfig.STONE_TANK.CAPACITY;
  }

  @Override
  protected boolean canHoldHotFluids() {

    return ModuleStorageConfig.STONE_TANK.HOLDS_HOT_FLUIDS;
  }

  @Override
  protected boolean canHoldContentsWhenBroken() {

    return ModuleStorageConfig.STONE_TANK.HOLDS_CONTENTS_WHEN_BROKEN;
  }

  // ---------------------------------------------------------------------------
  // - Tile Entity
  // ---------------------------------------------------------------------------

  @Nullable
  @Override
  public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState state) {

    return new TileTankStone();
  }
}
