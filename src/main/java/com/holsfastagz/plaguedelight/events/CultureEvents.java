package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.plaguedelight;
import com.holsfastagz.plaguedelight.registry.ModBlocks;
import com.holsfastagz.plaguedelight.registry.ModEffects;
import com.holsfastagz.plaguedelight.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import com.holsfastagz.plaguedelight.block.AnthraxCultureBlock;
import com.holsfastagz.plaguedelight.block.CoronavirusCultureBlock;
import com.holsfastagz.plaguedelight.block.DysenteryCultureBlock;
import com.holsfastagz.plaguedelight.block.MalariaCultureBlock;
import com.holsfastagz.plaguedelight.block.PlagueCultureBlock;
import com.holsfastagz.plaguedelight.block.RabiesCultureBlock;
import com.holsfastagz.plaguedelight.block.SalmonellaCultureBlock;
import com.holsfastagz.plaguedelight.block.ScarletFeverCultureBlock;
import com.holsfastagz.plaguedelight.block.SmallpoxCultureBlock;
import com.holsfastagz.plaguedelight.block.SwineFluCultureBlock;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent.BlockToolModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = plaguedelight.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CultureEvents {
    private static final Logger LOGGER = LogUtils.getLogger();

    // make an anthrax vaccine when using a syringe on an anthrax culture
    @SubscribeEvent
    public static void onAnthraxCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.ANTHRAX_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(AnthraxCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.ANTHRAX_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(AnthraxCultureBlock.DOSES, doses - 1), 3);
    }
    // make an anthrax sample when using a potion on an anthrax culture
    @SubscribeEvent
    public static void onAnthraxCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.ANTHRAX_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(AnthraxCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.ANTHRAX_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(AnthraxCultureBlock.DOSES, doses - 1), 3);
    }
        // make an coronavirus vaccine when using a syringe on an coronavirus culture
    @SubscribeEvent
    public static void onCoronavirusCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.CORONAVIRUS_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(CoronavirusCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.CORONAVIRUS_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(CoronavirusCultureBlock.DOSES, doses - 1), 3);
    }

    // make an coronavirus sample when using a potion on an coronavirus culture
    @SubscribeEvent
    public static void onCoronavirusCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.CORONAVIRUS_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(CoronavirusCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.CORONAVIRUS_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(CoronavirusCultureBlock.DOSES, doses - 1), 3);
    }


    // make an dysentery vaccine when using a syringe on an dysentery culture
    @SubscribeEvent
    public static void onDysenteryCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.DYSENTERY_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(DysenteryCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.DYSENTERY_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(DysenteryCultureBlock.DOSES, doses - 1), 3);
    }
    // make an dysentery sample when using a potion on an dysentery culture
    @SubscribeEvent
    public static void onDysenteryCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.DYSENTERY_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(DysenteryCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.DYSENTERY_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(DysenteryCultureBlock.DOSES, doses - 1), 3);
    }


    // make an malaria vaccine when using a syringe on an malaria culture
    @SubscribeEvent
    public static void onMalariaCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.MALARIA_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(MalariaCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.MALARIA_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(MalariaCultureBlock.DOSES, doses - 1), 3);
    }
    // make an malaria sample when using a potion on an malaria culture
    @SubscribeEvent
    public static void onMalariaCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.MALARIA_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(MalariaCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.MALARIA_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(MalariaCultureBlock.DOSES, doses - 1), 3);
    }


    // make an plague vaccine when using a syringe on an plague culture
    @SubscribeEvent
    public static void onPlagueCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.PLAGUE_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(PlagueCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.PLAGUE_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(PlagueCultureBlock.DOSES, doses - 1), 3);
    }
    // make an plague sample when using a potion on an plague culture
    @SubscribeEvent
    public static void onPlagueCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.PLAGUE_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(PlagueCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.PLAGUE_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(PlagueCultureBlock.DOSES, doses - 1), 3);
    }


    // make an rabies prophylaxis when using a syringe on an rabies culture
    @SubscribeEvent
    public static void onRabiesCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.RABIES_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(RabiesCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.RABIES_PROPHYLAXIS.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(RabiesCultureBlock.DOSES, doses - 1), 3);
    }
    // make an rabies sample when using a potion on an rabies culture
    @SubscribeEvent
    public static void onRabiesCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.RABIES_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(RabiesCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.RABIES_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(RabiesCultureBlock.DOSES, doses - 1), 3);
    }


    // make an salmonella vaccine when using a syringe on an salmonella culture
    @SubscribeEvent
    public static void onSalmonellaCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.SALMONELLA_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(SalmonellaCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.SALMONELLA_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(SalmonellaCultureBlock.DOSES, doses - 1), 3);
    }
    // make an salmonella sample when using a potion on an salmonella culture
    @SubscribeEvent
    public static void onSalmonellaCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.SALMONELLA_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(SalmonellaCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.SALMONELLA_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(SalmonellaCultureBlock.DOSES, doses - 1), 3);
    }


    // make an scarlet_fever vaccine when using a syringe on an scarlet_fever culture
    @SubscribeEvent
    public static void onScarletFeverCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.SCARLET_FEVER_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(ScarletFeverCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.SCARLET_FEVER_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(ScarletFeverCultureBlock.DOSES, doses - 1), 3);
    }
    // make an scarlet_fever sample when using a potion on an scarlet_fever culture
    @SubscribeEvent
    public static void onScarletFeverCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.SCARLET_FEVER_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(ScarletFeverCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.SCARLET_FEVER_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(ScarletFeverCultureBlock.DOSES, doses - 1), 3);
    }


    // make an smallpox vaccine when using a syringe on an smallpox culture
    @SubscribeEvent
    public static void onSmallpoxCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.SMALLPOX_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(SmallpoxCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.SMALLPOX_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(SmallpoxCultureBlock.DOSES, doses - 1), 3);
    }
    // make an smallpox sample when using a potion on an smallpox culture
    @SubscribeEvent
    public static void onSmallpoxCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.SMALLPOX_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(SmallpoxCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.SMALLPOX_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(SmallpoxCultureBlock.DOSES, doses - 1), 3);
    }


    // make an swine_flu vaccine when using a syringe on an swine_flu culture
    @SubscribeEvent
    public static void onSwineFluCultureSyringe(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.SWINE_FLU_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(SwineFluCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check syringe in hand
        if (player.getItemInHand(event.getHand()).getItem() != ModItems.SYRINGE.get()) return;
    
        // Consume syringe
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop vaccine
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.SWINE_FLU_VACCINE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses 
        world.setBlock(pos, state.setValue(SwineFluCultureBlock.DOSES, doses - 1), 3);
    }
    // make an swine_flu sample when using a potion on an swine_flu culture
    @SubscribeEvent
    public static void onSwineFluCultureBottle(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return; 
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Level world = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = world.getBlockState(pos);

        // Check if right culture
        if (state.getBlock() != ModBlocks.SWINE_FLU_CULTURE.get()) return;

        // check if available doses
        int doses = state.getValue(SwineFluCultureBlock.DOSES);
        if (doses <= 0) return;
    
        // Check potion in hand
        if (player.getItemInHand(event.getHand()).getItem() != Items.POTION) return;
    
        // Consume potion 
        player.getItemInHand(event.getHand()).shrink(1);
    
        // Drop sample 
        if (world instanceof ServerLevel serverLevel) {
            ItemStack vaccine = new ItemStack(ModItems.SWINE_FLU_SAMPLE.get());
            serverLevel.addFreshEntity(new ItemEntity(
                serverLevel,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5,
                vaccine
            ));
        }
    
        // Lower doses
        world.setBlock(pos, state.setValue(SwineFluCultureBlock.DOSES, doses - 1), 3);
    }

}
