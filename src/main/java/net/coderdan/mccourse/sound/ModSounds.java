package net.coderdan.mccourse.sound;

import net.coderdan.mccourse.MCCourseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCCourseMod.MOD_ID);

    public static RegistryObject<SoundEvent> DOWSING_ROD_FOUND_ORE =
            registerSoundEvents("dowsing_rod_found_ore");

    public static RegistryObject<SoundEvent> COBALT_LAMP_BREAK =
            registerSoundEvents("cobalt_lamp_break");

    public static RegistryObject<SoundEvent> COBALT_LAMP_STEP =
            registerSoundEvents("cobalt_lamp_step");

    public static RegistryObject<SoundEvent> COBALT_LAMP_PLACE =
            registerSoundEvents("cobalt_lamp_place");

    public static RegistryObject<SoundEvent> COBALT_LAMP_HIT =
            registerSoundEvents("cobalt_lamp_hit");

    public static RegistryObject<SoundEvent> COBALT_LAMP_FALL =
            registerSoundEvents("cobalt_lamp_fall");



    public static RegistryObject<SoundEvent> BAR_BRAWL =
            registerSoundEvents("bar_brawl");

    public static final SoundType COBALT_LAMP_SOUNDS = new ForgeSoundType(1f,1f,
            ModSounds.COBALT_LAMP_BREAK, ModSounds.COBALT_LAMP_STEP, ModSounds.COBALT_LAMP_PLACE,
            ModSounds.COBALT_LAMP_HIT, ModSounds.COBALT_LAMP_FALL);








    private static RegistryObject<SoundEvent> registerSoundEvents(String name){
        ResourceLocation id = new ResourceLocation(MCCourseMod.MOD_ID, name);

        return SOUND_EVENTS.register(name, ()-> new SoundEvent(id));
    }

    public static void register(IEventBus bus){
        SOUND_EVENTS.register(bus);
    }

}
