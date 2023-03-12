package net.coderdan.mccourse.item.custom;

import net.coderdan.mccourse.block.ModBlocks;
import net.coderdan.mccourse.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ItemSteerable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ProgrammerItem extends Item {

    public boolean NBTDataHasBeenCreated = false;

    public ProgrammerItem(Properties pProperties) {
        super(pProperties);

    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {


        return super.useOn(pContext);
    }
}
