package net.coderdan.mccourse.item;

import net.coderdan.mccourse.MCCourseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);


    public static final RegistryObject<Item> COBALT_INGOT = createItem("cobalt_ingot",
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> COBALT_NUGGET = createItem("cobalt_nugget",
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));













    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }

    public static RegistryObject<Item> createItem(String name, Item item){
        return ITEMS.register(name, () -> item);
    }
}
