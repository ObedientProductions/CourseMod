package net.coderdan.mccourse.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(pContext.getLevel().isClientSide){

            BlockPos posClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock =  false;


            for(int i = -64; i<= posClicked.getY() + 64; i++){
                Block blockBelow = pContext.getLevel().getBlockState(posClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)){
                    outputValuableCords(posClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }


            if(!foundBlock){
                player.sendMessage(new TranslatableComponent("item.mccourse.dowsing_rod.no_valuables"), player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player)-> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }









    private void outputValuableCords(BlockPos blockPos, Player player, Block blockBelow){
        player.sendMessage(new TextComponent(
                "Found " + blockBelow.asItem().getRegistryName().toString() + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"),
                player.getUUID());
    }


    private boolean isValuableBlock(Block block){
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE ||
                block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE;
    }
}
