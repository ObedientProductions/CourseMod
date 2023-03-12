package net.coderdan.mccourse.item;

import net.coderdan.mccourse.MCCourseMod;
import net.coderdan.mccourse.item.custom.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);


    public static final RegistryObject<Item> COBALT_INGOT = createItem("cobalt_ingot",
            new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_NUGGET = createItem("cobalt_nugget",
            new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> RAW_COBALT = createItem("raw_cobalt",
            new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COAL_BIT = createItem("coal_bit",
            new CoalBitItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> TURNIP = createItem("turnip",
            new CoalBitItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).food(ModFoods.Turnip)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            ()-> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)
                    .durability(16)));




    public static final RegistryObject<Item> COBALT_SWORD = createItem("cobalt_sword",
            new LevitationSwordItem(ModTiers.COBALT,1, 1f,  new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_PICKAXE = createItem("cobalt_pickaxe",
            new PickaxeItem(ModTiers.COBALT,1, 1f,  new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_AXE = createItem("cobalt_axe",
            new AxeItem(ModTiers.COBALT,2, 1f,  new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_SHOVEL = createItem("cobalt_shovel",
            new ShovelItem(ModTiers.COBALT,1, 0,  new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_HOE = createItem("cobalt_hoe",
            new HoeItem(ModTiers.COBALT,1, 0,  new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_PAXEL = createItem("cobalt_paxel",
            new PaxelItem(ModTiers.COBALT,3, 1f,  new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));




    public static final RegistryObject<Item> COBALT_HELMET = createItem("cobalt_helmet",
            new ArmorItem(
                    ModArmorMaterials.COBALT,
                    EquipmentSlot.HEAD, new Item.Properties()
                    .tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_CHESTPLATE = createItem("cobalt_chestplate",
            new ArmorItem(
                    ModArmorMaterials.COBALT,
                    EquipmentSlot.CHEST, new Item.Properties()
                    .tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_LEGGINGS = createItem("cobalt_leggings",
            new ArmorItem(
                    ModArmorMaterials.COBALT,
                    EquipmentSlot.LEGS, new Item.Properties()
                    .tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_BOOTS = createItem("cobalt_boots",
            new ArmorItem(
                    ModArmorMaterials.COBALT,
                    EquipmentSlot.FEET, new Item.Properties()
                    .tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_HORSE_ARMOR = createItem("cobalt_horse_armor",
            new HorseArmorItem(12,"cobalt", new Item.Properties()
                    .tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> DATA_TABLET = createItem("data_tablet",
            new DataTabletItem( new Item.Properties()
                    .stacksTo(1)
                    .tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> PROGRAMMER = createItem("programmer",
            new ProgrammerItem( new Item.Properties()
                    .stacksTo(1)
                    .tab(ModCreativeModeTab.COURSE_TAB)));















    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }

    public static RegistryObject<Item> createItem(String name, Item item){
        return ITEMS.register(name, () -> item);
    }


}
