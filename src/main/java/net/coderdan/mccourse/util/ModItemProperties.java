package net.coderdan.mccourse.util;

import net.coderdan.mccourse.MCCourseMod;
import net.coderdan.mccourse.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        ItemProperties.register(ModItems.DATA_TABLET.get(), new ResourceLocation(MCCourseMod.MOD_ID, "on"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0));

        ItemProperties.register(ModItems.PROGRAMMER.get(), new ResourceLocation(MCCourseMod.MOD_ID, "programmed"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0));

        makeBow(ModItems.COBALT_BOW.get());
    }



    private static void makeBow(Item item){
        ItemProperties.register(item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(item, new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        });
    }
}
