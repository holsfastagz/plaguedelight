package com.holsfastagz.plaguedelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SwineFluCultureBlock extends Block {

    // create doses property
    public static final IntegerProperty DOSES = IntegerProperty.create("doses", 0, 4);

    // set dimensions
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 2, 15);

    // set default doses to 4
    public SwineFluCultureBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DOSES, 0));
    }

    // set default doses to 4 
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(DOSES, 4);
    }

    // register doses definition
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DOSES);
    }

    // Shape for rendering
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    // random ticks if not full
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(DOSES) < 4;
    }

    // growth on random tick if not full
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int doses = state.getValue(DOSES);
        if (doses < 4) {
            level.setBlock(pos, state.setValue(DOSES, doses + 1), 3);
        }
    }

}

