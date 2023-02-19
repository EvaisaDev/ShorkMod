package dev.evaisa.shorkmod.blocks;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;

import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CuddlyBlock extends HorizontalDirectionalBlock {
    // outline shape
    protected static final VoxelShape SHAPE_NORTH = Stream.of(
        Block.box(6, 1, 0, 10, 1, 1),
        Block.box(6, 0, 0, 10, 4, 9),
        Block.box(7, 1, 9, 9, 3, 16),
        Block.box(6.5, 0.5, 9, 9.5, 3.5, 11),
        Block.box(6, 0, 1, 10, 1, 1)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    protected static final VoxelShape SHAPE_EAST = Stream.of(
        Block.box(15, 1, 6, 16, 1, 10),
        Block.box(7, 0, 6, 16, 4, 10),
        Block.box(0, 1, 7, 7, 3, 9),
        Block.box(5, 0.5, 6.5, 7, 3.5, 9.5),
        Block.box(15, 0, 6, 15, 1, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    protected static final VoxelShape SHAPE_SOUTH = Stream.of(
        Block.box(6, 1, 15, 10, 1, 16),
        Block.box(6, 0, 7, 10, 4, 16),
        Block.box(7, 1, 0, 9, 3, 7),
        Block.box(6.5, 0.5, 5, 9.5, 3.5, 7),
        Block.box(6, 0, 15, 10, 1, 15)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    protected static final VoxelShape SHAPE_WEST = Stream.of(
        Block.box(0, 1, 6, 1, 1, 10),
        Block.box(0, 0, 6, 9, 4, 10),
        Block.box(9, 1, 7, 16, 3, 9),
        Block.box(9, 0.5, 6.5, 11, 3.5, 9.5),
        Block.box(1, 0, 6, 1, 1, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public CuddlyBlock(Properties settings) {
		super(settings.sound(SoundType.WOOL).noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        // set noOcclusion
		// TODO Auto-generated constructor stub
	}
	
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        // return rotated voxelshape based on facing
        switch (pState.getValue(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case EAST:
                return SHAPE_EAST;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }
}