package net.coderdan.mccourse.block.custom;

import net.coderdan.mccourse.item.ModItems;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

public class ArtifactBlock extends Block {

    public static final BooleanProperty PROGRAMMED = BooleanProperty.create("programmed");

    public static boolean NBTDataHasBeenCreated = false;

    public ArtifactBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(this.defaultBlockState().setValue(PROGRAMMED, false));
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {



        if(pPlayer.getItemInHand(pHand).getItem() == ModItems.PROGRAMMER.get().asItem()) {

            //CHANGE BLOCK STATE
            boolean currentBlockState = pState.getValue(PROGRAMMED);
            pLevel.setBlock(pPos, pState.setValue(PROGRAMMED, !currentBlockState), 3);

            currentBlockState = pState.getValue(PROGRAMMED);

            //CHANGE NBT DATA FOR ITEM
            ItemStack ItemInHand = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);

            if(ItemInHand.hasTag()) {

                if(currentBlockState){
                    ItemInHand.removeTagKey("mccourse.programmed");

                    //PLAYS DE-ACTIVATION SOUND
                    pLevel.playSound(pPlayer, pPos, SoundEvents.WITHER_SPAWN, SoundSource.BLOCKS, 1,-1);
                }
            }
            else{
                if(!currentBlockState){
                    CreateNBTDataForItem(ItemInHand, true);

                    //PLAYS ACTIVATION SOUND
                    pLevel.playSound(pPlayer, pPos, SoundEvents.WITHER_SPAWN, SoundSource.BLOCKS, 1,1);
                }
            }



        }
        return InteractionResult.SUCCESS;
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(PROGRAMMED);
    }


    static void CreateNBTDataForItem(ItemStack item, boolean tagValue){
        CompoundTag programmerNbtData = new CompoundTag();
        programmerNbtData.putBoolean("mccourse.programmed", tagValue);
        item.setTag(programmerNbtData);

        NBTDataHasBeenCreated = true;
    }
}
