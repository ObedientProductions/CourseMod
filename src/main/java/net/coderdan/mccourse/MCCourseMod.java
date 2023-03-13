package net.coderdan.mccourse;

import net.coderdan.mccourse.block.ModBlocks;
import net.coderdan.mccourse.enchantment.ModEnchantments;
import net.coderdan.mccourse.item.ModItems;
import net.coderdan.mccourse.sound.ModSounds;
import net.coderdan.mccourse.util.ModBlockRendering;
import net.coderdan.mccourse.util.ModItemProperties;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MCCourseMod.MOD_ID)
public class MCCourseMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mccourse";

    //YES
    public MCCourseMod() {
        // Register the setup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEnchantments.register(modEventBus);
        ModSounds.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()-> {
            ComposterBlock.COMPOSTABLES.put(ModItems.TURNIP.get(), 0.3f);

            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);
        });

    }

    private void clientSetup(final FMLClientSetupEvent event){
        ModBlockRendering.SetRenderLayersOfTransparentBlocks();
        ModItemProperties.addCustomItemProperties();
    }

}
