package net.coderdan.mccourse.block.entity;

import net.coderdan.mccourse.MCCourseMod;
import net.coderdan.mccourse.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MCCourseMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<RodStoneBlockEntity>> ROD_STONE = BLOCK_ENTITIES.register("rod_stone", ()->
            BlockEntityType.Builder.of(RodStoneBlockEntity::new, ModBlocks.ROD_STONE.get()).build(null));








    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }
}
