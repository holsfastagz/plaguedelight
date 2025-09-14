package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.registry.ModItems;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.TickEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "plaguedelight")
public class SamplingEvents {

    // 5% chance of dropping anthrax sample when interact with sheep with a potion
    @SubscribeEvent
    public static void onSheepInteracted(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        // Check if sheep 
        if (!(event.getTarget() instanceof Sheep)) return;

        // Check if potion in hand
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.POTION) return;

        // 5% chance
        if (player.level().random.nextFloat() < 0.05F) {

            // Set smallpox sample in player hand
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.ANTHRAX_SAMPLE.get()));
        }
    }

    // 5% chance of dropping coronavirus sample when interact with bat with a potion
    @SubscribeEvent
    public static void onBatInteracted(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        // Check if sheep 
        if (!(event.getTarget() instanceof Bat)) return;

        // Check if potion in hand
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.POTION) return;

        // 5% chance
        if (player.level().random.nextFloat() < 0.05F) {

            // Set smallpox sample in player hand
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.CORONAVIRUS_SAMPLE.get()));
        }
    }


    // 1% chance of dropping dysentery sample when bottle filled
    @SubscribeEvent
    public static void onBottleFillDysentery(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level world = player.level();
        BlockPos pos = event.getPos();

        // Check if player is holding an empty bottle
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.GLASS_BOTTLE) return;

        // Check if water
        if (!world.getBlockState(pos).is(Blocks.WATER)) return;

        if (player.level().random.nextFloat() < 0.01F) {
            heldItem.shrink(1); // remove bottle
            player.getInventory().add(new ItemStack(ModItems.DYSENTERY_SAMPLE.get())); // give player dysentery sample
        }

    }

    // Forge biome tag for wet biomes
    private static final TagKey<Biome> IS_WET = TagKey.create(
            net.minecraft.core.registries.Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath("forge", "is_wet")
    );
    // 5% chance of dropping malaria sample when bottle filled in wet biome
    // inherently exclusive of getting a smallpox bottle
    @SubscribeEvent
    public static void onBottleFillMalaria(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level world = player.level();
        BlockPos pos = event.getPos();

        // Check for wet biomes
        Holder<Biome> biomeHolder = world.getBiome(player.blockPosition());
        if (!biomeHolder.is(IS_WET)) return;

        // Check if player is holding an empty bottle
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.GLASS_BOTTLE) return;

        // Check if water
        if (!world.getBlockState(pos).is(Blocks.WATER)) return;

        if (player.level().random.nextFloat() > 0.95F) {
            heldItem.shrink(1); // remove bottle
            player.getInventory().add(new ItemStack(ModItems.MALARIA_SAMPLE.get())); // give player malaria sample
        }

    }

    // 5% chance of dropping plague sample when interact with villager with a potion
    @SubscribeEvent
    public static void onVillagerInteracted(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        // Check if villager 
        if (!(event.getTarget() instanceof Villager)) return;

        // Check if potion in hand
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.POTION) return;

        // 5% chance
        if (player.level().random.nextFloat() < 0.05F) {

            // Set smallpox sample in player hand
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.PLAGUE_SAMPLE.get()));
        }
    }

    // 5% chance of dropping rabies sample when interact with angry wolf with a potion
    @SubscribeEvent
    public static void onWolfInteracted(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        // Check if angry wolf 
        if (!(event.getTarget() instanceof Wolf wolf && wolf.isAngry())) return;

        // Check if potion in hand
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.POTION) return;

        // 5% chance
        if (player.level().random.nextFloat() < 0.05F) {

            // Set smallpox sample in player hand
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.RABIES_SAMPLE.get()));
        }
    }


    // 5% chance of dropping salmonella sample when interact with chicken with a potion
    @SubscribeEvent
    public static void onChickenInteracted(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        // Check if chicken
        if (!(event.getTarget() instanceof Chicken)) return;

        // Check if potion in hand
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.POTION) return;

        // 5% chance
        if (player.level().random.nextFloat() < 0.05F) {

            // Set smallpox sample in player hand
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SALMONELLA_SAMPLE.get()));
        }
    }

    // 5% chance of dropping scarlet fever sample when interact with piglin with a potion
    @SubscribeEvent
    public static void onPiglinInteracted(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        // Check if piglin 
        if (!(event.getTarget() instanceof Piglin)) return;

        // Check if potion in hand
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.POTION) return;

        // 5% chance
        if (player.level().random.nextFloat() < 0.05F) {

            // Set scarlet fever sample in player hand
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SCARLET_FEVER_SAMPLE.get()));
        }
    }

    // 5% chance of dropping smalpox sample when interact with cow with a potion
    @SubscribeEvent
    public static void onCowInteracted(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        // Check if cow 
        if (!(event.getTarget() instanceof Cow)) return;

        // Check if potion in hand
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.POTION) return;

        // 5% chance
        if (player.level().random.nextFloat() < 0.05F) {

            // Set smallpox sample in player hand
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SMALLPOX_SAMPLE.get()));
        }
    }

    // 5% chance of dropping swine flu sample when interact with pig with a potion
    @SubscribeEvent
    public static void onPigInteracted(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        // Check if pig 
        if (!(event.getTarget() instanceof Pig)) return;

        // Check if potion in hand
        ItemStack heldItem = player.getItemInHand(event.getHand());
        if (heldItem.getItem() != Items.POTION) return;

        // 5% chance
        if (player.level().random.nextFloat() < 0.05F) {

            // Set smallpox sample in player hand
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SWINE_FLU_SAMPLE.get()));
        }
    }

}
