package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.plaguedelight;
import com.holsfastagz.plaguedelight.registry.ModBlocks;
import com.holsfastagz.plaguedelight.registry.ModEffects;
import com.holsfastagz.plaguedelight.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent.BlockToolModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = plaguedelight.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {
    private static final Logger LOGGER = LogUtils.getLogger();

    // Drop jungle bark when jungle logs are stripped
    @SubscribeEvent
    public static void onBlockToolModification(BlockToolModificationEvent event) {
        if (event.getLevel().isClientSide()) return;

        // Only trigger when using an axe to strip Jungle Log
        if (event.getToolAction() == ToolActions.AXE_STRIP &&
            event.getState().getBlock() == Blocks.JUNGLE_LOG &&
            event.getHeldItemStack().getItem() instanceof AxeItem) {

            ServerLevel serverLevel = (ServerLevel) event.getLevel();
            BlockPos pos = event.getPos();

            // Drop Jungle Bark
            ItemStack drop = new ItemStack(ModItems.JUNGLE_BARK.get());
            serverLevel.addFreshEntity(new ItemEntity(
                    serverLevel,
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    drop
            ));

            LOGGER.debug("Dropped Jungle Bark at {}", pos);
        }
    }

}
