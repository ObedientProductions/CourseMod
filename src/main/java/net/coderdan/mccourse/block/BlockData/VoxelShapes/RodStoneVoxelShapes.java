package net.coderdan.mccourse.block.BlockData.VoxelShapes;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class RodStoneVoxelShapes {

    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(7, 7, 5, 9, 16, 7),
            Block.box(1, 0, 1, 15, 5, 15),
            Block.box(3, 5, 3, 13, 7, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.box(5, 7, 7, 7, 16, 9),
            Block.box(1, 0, 1, 15, 5, 15),
            Block.box(3, 5, 3, 10, 7, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(7, 7, 9, 9, 16, 11),
            Block.box(1, 0, 1, 15, 5, 15),
            Block.box(3, 5, 6, 13, 7, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(9, 7, 7, 11, 16, 9),
            Block.box(1, 0, 1, 15, 5, 15),
            Block.box(6, 5, 3, 13, 7, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
