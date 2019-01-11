package com.codetaylor.mc.pyrotech.modules.pyrotech.compat.jei.category;

import com.codetaylor.mc.pyrotech.modules.pyrotech.ModulePyrotech;
import com.codetaylor.mc.pyrotech.modules.pyrotech.ModulePyrotechConfig;
import com.codetaylor.mc.pyrotech.modules.pyrotech.compat.jei.wrapper.JEIRecipeWrapperCrucibleStone;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.*;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class JEIRecipeCategoryCrucibleStone
    implements IRecipeCategory<JEIRecipeWrapperCrucibleStone> {

  private final IDrawableAnimated animatedFlame;
  private final IDrawableAnimated arrow;
  private final IDrawable background;

  private final String title;

  public JEIRecipeCategoryCrucibleStone(IGuiHelper guiHelper) {

    ResourceLocation resourceLocation = new ResourceLocation(ModulePyrotech.MOD_ID, "textures/gui/jei6.png");

    IDrawableStatic arrowDrawable = guiHelper.createDrawable(resourceLocation, 82, 14, 24, 17);
    IDrawableStatic staticFlame = guiHelper.createDrawable(resourceLocation, 82, 0, 14, 14);

    IDrawableAnimated.StartDirection left = IDrawableAnimated.StartDirection.LEFT;
    IDrawableAnimated.StartDirection top = IDrawableAnimated.StartDirection.TOP;

    this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, top, true);
    this.arrow = guiHelper.createAnimatedDrawable(arrowDrawable, 200, left, false);
    this.background = guiHelper.createDrawable(resourceLocation, 0, 0, 82, 54);

    this.title = Translator.translateToLocal("gui." + ModulePyrotech.MOD_ID + ".jei.category.crucible.stone");
  }

  @Nonnull
  @Override
  public String getUid() {

    return JEIRecipeCategoryUid.STONE_CRUCIBLE;
  }

  @Nonnull
  @Override
  public String getTitle() {

    return this.title;
  }

  @Nonnull
  @Override
  public String getModName() {

    return ModulePyrotech.MOD_ID;
  }

  @Nonnull
  @Override
  public IDrawable getBackground() {

    return this.background;
  }

  @Override
  public void drawExtras(Minecraft minecraft) {

    this.animatedFlame.draw(minecraft, 1, 27);
    this.arrow.draw(minecraft, 24, 18);
  }

  @Override
  public void setRecipe(IRecipeLayout recipeLayout, JEIRecipeWrapperCrucibleStone recipeWrapper, IIngredients ingredients) {

    IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
    itemStacks.init(0, true, 0, 8);
    itemStacks.set(ingredients);

    IGuiFluidStackGroup fluidStacks = recipeLayout.getFluidStacks();
    int capacity = ModulePyrotechConfig.STONE_CRUCIBLE.OUTPUT_TANK_SIZE;
    fluidStacks.init(1, false, 61, 19, 16, 16, capacity, true, null);
    fluidStacks.set(ingredients);
  }
}