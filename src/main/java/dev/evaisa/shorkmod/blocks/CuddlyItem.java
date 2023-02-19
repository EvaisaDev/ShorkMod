package dev.evaisa.shorkmod.blocks;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.network.chat.Component;

public class CuddlyItem extends BlockItem {
    public static final String OWNER_KEY = "Owner";

    // translatable subtitle
    public final Component subtitle;

    public CuddlyItem(Block block, Properties properties, String subtitle) {
        super(block, properties);
        this.subtitle = subtitle == null ? null : Component.translatable(subtitle);
    }
    
    @Override   
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flagIn) {
        if(this.subtitle != null) {
            tooltip.add(this.subtitle);
        }
       
        // check for nbt data with the key OWNER_KEY
        CompoundTag nbt = stack.getTag();
     
        if (nbt != null) {
			String owner = nbt.getString(OWNER_KEY);
			if (owner.isEmpty()) {
				return;
			}
            if(stack.hasCustomHoverName()) {
                tooltip.add(Component.translatable("tooltip.shorkmod.owner.rename", stack.getHoverName(), Component.literal(owner)));
            } else {
                tooltip.add(Component.translatable("tooltip.shorkmod.owner", Component.literal(owner)));
            }
        }
    }

    // on craft override
    @Override
    public void onCraftedBy(ItemStack stack, Level world, net.minecraft.world.entity.player.Player player) {
        if (player != null) {
            CompoundTag nbt = stack.getOrCreateTag();
            nbt.putString(OWNER_KEY, player.getName().getString());
        }
        
    }

    // mining speed multiplier
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return 0.25F;
    }
}