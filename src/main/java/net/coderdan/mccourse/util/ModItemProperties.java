package net.coderdan.mccourse.util;

import net.coderdan.mccourse.MCCourseMod;
import net.coderdan.mccourse.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        ItemProperties.register(ModItems.DATA_TABLET.get(), new ResourceLocation(MCCourseMod.MOD_ID, "on"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0));

        ItemProperties.register(ModItems.PROGRAMMER.get(), new ResourceLocation(MCCourseMod.MOD_ID, "programmed"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0));
    }
}
