package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.capability.ImmunityCapability;
import com.holsfastagz.plaguedelight.registry.ModEffects;
import com.holsfastagz.plaguedelight.registry.ModItems;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.Random;
import net.minecraft.util.RandomSource;

@Mod.EventBusSubscriber(modid = "plaguedelight")
public class InfectionEvents {

    // Forge biome tag for wet biomes
    private static final TagKey<Biome> IS_WET = TagKey.create(
            net.minecraft.core.registries.Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath("forge", "is_wet")
    );

    // --- Infection Events ---

    // 1% chance of anthrax infection from attacking sheep
    @SubscribeEvent
    public static void onSheepAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Sheep)) return;

        if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToAnthrax()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // anthrax for 10 min
                        player.addEffect(new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*60*10, 0));
                    }
                }

                // if player is not immune
                else {
                    // anthrax for 10 min
                    player.addEffect(new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*60*10, 0));
                }
            });
        }
    }
    // 1% chance of anthrax infection from interacting with sheep
    @SubscribeEvent
    public static void onSheepInteracted(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof Sheep)) return;

        if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToAnthrax()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // anthrax for 10 min
                        player.addEffect(new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*60*10, 0));
                    }
                }

                // if player is not immune
                else {
                    // anthrax for 10 min
                    player.addEffect(new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*60*10, 0));
                }
            });
        }

    }

    // 10% chance of coronavirus infection from attacking bat
    @SubscribeEvent
    public static void onBatAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Bat)) return;

        if (player.level().random.nextFloat() < 0.10F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToCoronavirus()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // coronavirus for 10 min
                        player.addEffect(new MobEffectInstance(ModEffects.CORONAVIRUS.get(), 20*60*10, 0));
                    }
                }

                // if player is not immune
                else {
                    // coronavirus for 10 min
                    player.addEffect(new MobEffectInstance(ModEffects.CORONAVIRUS.get(), 20*60*10, 0));
                }
            });
        }

    }

    // 10% chance of plague infection from attacking a villager
    @SubscribeEvent
    public static void onVillagerAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Villager)) return;

        if (player.level().random.nextFloat() < 0.10F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToPlague()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // plague for 10 min
                        player.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                    }
                }

                // if player is not immune
                else {
                    // plague for 10 min
                    player.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                }
            });
        }

    }
    // 1% chance of plague infection from interacting with a villager
    @SubscribeEvent
    public static void onVillagerInteracted(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof Villager)) return;

        if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToPlague()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // plague for 10 min
                        player.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                    }
                }

                // if player is not immune
                else {
                    // plague for 10 min
                    player.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                }
            });
        }

    }
    // 3% chance of plague infection when attacked by a pillager
    @SubscribeEvent
    public static void onPillagerHurtPlayer(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Pillager pillager 
                && event.getEntity() instanceof Player player) {

            if (player.level().random.nextFloat() < 0.03F) {
    
                // check for immunity status
                player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                    if (cap.isImmuneToPlague()) {
                        // 98% vaccine efficacy
                        if (player.level().random.nextFloat() > 0.98F) {
                            // plague for 10 min
                            player.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                        }
                    }
    
                    // if player is not immune
                    else {
                        // plague for 10 min
                        player.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                    }
                });
            }
        }
    }
    // 3% chance of plague infection from attacking a pillager 
    @SubscribeEvent
    public static void onPillagerAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Pillager)) return;

        if (player.level().random.nextFloat() < 0.03F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToPlague()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // plague for 10 min
                        player.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                    }
                }

                // if player is not immune
                else {
                    // plague for 10 min
                    player.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                }
            });
        }

    }

    // 2% chance of salmonella infection from attacking a chicken
    @SubscribeEvent
    public static void onChickenAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Chicken)) return;

        if (player.level().random.nextFloat() < 0.03F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToSalmonella()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // salmonella for 2.5 in 
                        player.addEffect(new MobEffectInstance(ModEffects.SALMONELLA.get(), 20*150, 0));
                    }
                }

                // if player is not immune
                else {
                    // salmonella for 2.5 min
                    player.addEffect(new MobEffectInstance(ModEffects.SALMONELLA.get(), 20*150, 0));
                }
            });
        }

    }

    // rabies delay map 
    private static final Map<Player, Integer> rabiesDelay = new HashMap<>();
    // Rabies infection has a 12_000 tick delay
    private static final Map<UUID, Integer> rabiesTimers = new HashMap<>();
    // 25% chance of rabies delay from attacking a wolf
    @SubscribeEvent
    public static void onWolfAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Wolf)) return;

        if (player.level().random.nextFloat() < 0.25F) {
            rabiesTimers.put(player.getUUID(), 12_000);   // 10:00 delay
        }
    }
    // 25% chance of rabies delay from attacking a wolf
    @SubscribeEvent
    public static void onCatAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Cat)) return;

        if (player.level().random.nextFloat() < 0.25F) {
            rabiesTimers.put(player.getUUID(), 12_000);   // 10:00 delay
        }
    }
    // 25% chance of rabies delay from attacking an ocelot
    @SubscribeEvent
    public static void onOcelotAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Ocelot)) return;

        if (player.level().random.nextFloat() < 0.25F) {
            rabiesTimers.put(player.getUUID(), 12_000);   // 10:00 delay
        }
    }
    // 25% chance of rabies delay from attacking a bat
    @SubscribeEvent
    public static void onBatAttackedRabies(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Bat)) return;

        if (player.level().random.nextFloat() < 0.25F) {
            rabiesTimers.put(player.getUUID(), 12_000);   // 10:00 delay
        }
    }
    // 95% chance of rabies delay when player is attacked by angry wolf
    @SubscribeEvent
    public static void onWolfHurtPlayer(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Wolf wolf) {
            if (wolf.isAngry() && event.getEntity() instanceof Player player) {
                if (player.level().random.nextFloat() < 0.95F) {
                    rabiesTimers.put(player.getUUID(), 12_000);   // 10:00 delay
                }
            }
        }
    }
    // Rabies infection.
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        // Iterate over the map
        rabiesTimers.entrySet().removeIf(entry -> {
            int remaining = entry.getValue() - 1;
            UUID playerId = entry.getKey();

            if (remaining <= 0) {
                Player player = event.getServer().getPlayerList().getPlayer(playerId);
                if (player != null) {
                    // check for immunity status
                    player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                        if (cap.isImmuneToRabies()) {
                            // 98% vaccine efficacy
                            if (player.level().random.nextFloat() > 0.98F) {
                                // rabies for 10 min 
                                player.addEffect(new MobEffectInstance(ModEffects.RABIES.get(), 20*60*10, 0));
                            }
                        }
        
                        // if player is not immune
                        else {
                            // rabies for 2.5 min
                            player.addEffect(new MobEffectInstance(ModEffects.RABIES.get(), 20*60*10, 0));
                        }
                    });
                }
                return true; // remove from map
            } else {
                entry.setValue(remaining);
                return false;
            }
        });
    }

    // 3% chance of scarlet fever when interacting with a piglin
    @SubscribeEvent
    public static void onPiglinInteracted(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof Piglin)) return;

        if (player.level().random.nextFloat() < 0.03F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToScarletFever()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // scarlet fever for 2.5 in 
                        player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                    }
                }

                // if player is not immune
                else {
                    // scarlet fever for 2.5 min
                    player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                }
            });
        }

    }
    // 3% chance of scarlet fever when attacked by a piglin
    @SubscribeEvent
    public static void onPiglinHurtPlayer(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Piglin piglin
                && event.getEntity() instanceof Player player) {

            if (player.level().random.nextFloat() < 0.03F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToScarletFever()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // scarlet fever for 2.5 in 
                        player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                    }
                }

                // if player is not immune
                else {
                    // scarlet fever for 2.5 min
                    player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                }
            });
        }

        }
    }
    // 5% chance of scarlet fever when player attacks piglin
    @SubscribeEvent
    public static void onPiglinAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Piglin)) return;

        if (player.level().random.nextFloat() < 0.05F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToScarletFever()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // scarlet fever for 2.5 in 
                        player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                    }
                }

                // if player is not immune
                else {
                    // scarlet fever for 2.5 min
                    player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                }
            });
        }

    }
    // 1% chance of scarlet fever when attacked by a piglin brute
    @SubscribeEvent
    public static void onPiglinBruteHurtPlayer(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof PiglinBrute piglinBrute
                && event.getEntity() instanceof Player player) {

            if (player.level().random.nextFloat() < 0.05F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToScarletFever()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // scarlet fever for 2.5 in 
                        player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                    }
                }

                // if player is not immune
                else {
                    // scarlet fever for 2.5 min
                    player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                }
            });
        }

        }
    }
    // 5% chance of scarlet fever when player attacks piglin brute
    @SubscribeEvent
    public static void onPiglinBruteAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof PiglinBrute)) return;

        if (player.level().random.nextFloat() < 0.05F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToScarletFever()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // scarlet fever for 2.5 in 
                        player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                    }
                }

                // if player is not immune
                else {
                    // scarlet fever for 2.5 min
                    player.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*60*3, 0));
                }
            });
        }

    }

    // 1% chance of smallpox from interacting with a villager
    @SubscribeEvent
    public static void onVillagerInteractedSmallpox(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof Villager)) return;

        if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToSmallpox()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // smallpox for 3 min 
                        player.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
                    }
                }

                // if player is not immune
                else {
                    // smallpox for 3 min
                    player.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
                }
            });
        }

    }
    // 1% chance of smallpox from attacking a villager
    @SubscribeEvent
    public static void onVillagerAttackedSmallpox(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Villager)) return;

        if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToSmallpox()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // smallpox for 3 min 
                        player.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
                    }
                }

                // if player is not immune
                else {
                    // smallpox for 3 min
                    player.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
                }
            });
        }

    }

    // 1% chance of smallpox infection from attacking cow
    @SubscribeEvent
    public static void onCowAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Cow)) return;

        if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToSmallpox()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // smallpox for 3 min 
                        player.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
                    }
                }

                // if player is not immune
                else {
                    // smallpox for 3 min
                    player.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
                }
            });
        }

    }
    // 1% chance of smallpox infection from interacting with cow
    @SubscribeEvent
    public static void onCowInteracted(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof Cow)) return;

        if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToSmallpox()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // smallpox for 3 min 
                        player.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
                    }
                }

                // if player is not immune
                else {
                    // smallpox for 3 min
                    player.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
                }
            });
        }
    }

    // 1% chance of swine flu infection from attacking pig
    @SubscribeEvent
    public static void onPigAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Pig)) return;

        if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToSwineFlu()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // swine flu for 3 min 
                        player.addEffect(new MobEffectInstance(ModEffects.SWINE_FLU.get(), 20*180, 0));
                    }
                }

                // if player is not immune
                else {
                    // swine flu for 3 min
                    player.addEffect(new MobEffectInstance(ModEffects.SWINE_FLU.get(), 20*180, 0));
                }
            });
        }

    }
    // 1% chance of swine flu infection from interacting with pig
    @SubscribeEvent
    public static void onPigInteracted(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof Pig)) return;

        if (player.level().random.nextFloat() < 0.01F) {

        // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToSwineFlu()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // swine flu for 3 min 
                        player.addEffect(new MobEffectInstance(ModEffects.SWINE_FLU.get(), 20*180, 0));
                    }
                }

                // if player is not immune
                else {
                    // swine flu for 3 min
                    player.addEffect(new MobEffectInstance(ModEffects.SWINE_FLU.get(), 20*180, 0));
                }
            });
        }

    }


    // --- Malaria from swimming in wet biome ---
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Player player = event.player;
        Level level = player.level();

        if (level.isClientSide) return;

        // Only run every 5 seconds
        if (level.getGameTime() % 100 != 0) return;

        // Check for water
        if (!player.isInWaterOrBubble()) return;

        // Check for wet biomes
        Holder<Biome> biomeHolder = level.getBiome(player.blockPosition());
        if (!biomeHolder.is(IS_WET)) return;

        // 1% chance of malaria
        if (player.level().random.nextFloat() < 0.01F) {

        // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToMalaria()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // malaria for 3 min 
                        player.addEffect(new MobEffectInstance(ModEffects.MALARIA.get(), 20*180, 0));
                    }
                }

                // if player is not immune
                else {
                    // malaria for 3 min
                    player.addEffect(new MobEffectInstance(ModEffects.MALARIA.get(), 20*180, 0));
                }
            });
        }

    }

    // --- Dysentery from drinking ---
    @SubscribeEvent
    public static void onDrink(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;

        ItemStack stack = event.getItem();

        // if potion or milk bucket
        if (stack.is(net.minecraft.world.item.Items.POTION)
            || stack.is(net.minecraft.world.item.Items.MILK_BUCKET)) {

            if (player.level().random.nextFloat() < 0.01F) {

            // check for immunity status
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent( cap -> {
                if (cap.isImmuneToDysentery()) {
                    // 98% vaccine efficacy
                    if (player.level().random.nextFloat() > 0.98F) {
                        // dysentery for 3 min 
                        player.addEffect(new MobEffectInstance(ModEffects.DYSENTERY.get(), 20*120, 0));
                    }
                }

                // if player is not immune
                else {
                    // dysentery for 3 min
                    player.addEffect(new MobEffectInstance(ModEffects.DYSENTERY.get(), 20*120, 0));
                }
            });
        }

        }
    }

    //   --------------
    //   PVP INFECTIONS
    //   --------------
    //   PVP has a ~1% chance to infect a player with one of any of certain
    //   diseases. This is true of both perpetrator and victim.

    @SubscribeEvent
    public static void onPlayerPVPInfection(LivingHurtEvent event) {
    
        if (!(event.getEntity() instanceof Player target)) return;
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
    
        RandomSource random = target.level().random;
    
        // --- Transmission from attacker to target ---
        if (attacker.hasEffect(ModEffects.ANTHRAX.get()) && !target.hasEffect(ModEffects.ANTHRAX.get())) {
            target.addEffect(new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*180, 0));
        }
        if (attacker.hasEffect(ModEffects.DYSENTERY.get()) && !target.hasEffect(ModEffects.DYSENTERY.get())) {
            target.addEffect(new MobEffectInstance(ModEffects.DYSENTERY.get(), 20*180, 0));
        }
        if (attacker.hasEffect(ModEffects.PLAGUE.get()) && !target.hasEffect(ModEffects.PLAGUE.get())) {
            target.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*180, 0));
        }
        if (attacker.hasEffect(ModEffects.SMALLPOX.get()) && !target.hasEffect(ModEffects.SMALLPOX.get())) {
            target.addEffect(new MobEffectInstance(ModEffects.SMALLPOX.get(), 20*180, 0));
        }
        if (attacker.hasEffect(ModEffects.SCARLET_FEVER.get()) && !target.hasEffect(ModEffects.SCARLET_FEVER.get())) {
            target.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*180, 0));
        }
        if (attacker.hasEffect(ModEffects.SWINE_FLU.get()) && !target.hasEffect(ModEffects.SWINE_FLU.get())) {
            target.addEffect(new MobEffectInstance(ModEffects.SWINE_FLU.get(), 20*180, 0));
        }
        if (attacker.hasEffect(ModEffects.CORONAVIRUS.get()) && !target.hasEffect(ModEffects.CORONAVIRUS.get())) {
            target.addEffect(new MobEffectInstance(ModEffects.CORONAVIRUS.get(), 20*60*10, 0));
        }
    
        // --- Transmission from target to attacker ---
        if (target.hasEffect(ModEffects.ANTHRAX.get()) && !attacker.hasEffect(ModEffects.ANTHRAX.get())) {
            attacker.addEffect(new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*180, 0));
        }
        if (target.hasEffect(ModEffects.DYSENTERY.get()) && !attacker.hasEffect(ModEffects.DYSENTERY.get())) {
            attacker.addEffect(new MobEffectInstance(ModEffects.DYSENTERY.get(), 20*180, 0));
        }
        if (target.hasEffect(ModEffects.PLAGUE.get()) && !attacker.hasEffect(ModEffects.PLAGUE.get())) {
            attacker.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*180, 0));
        }
        if (target.hasEffect(ModEffects.PLAGUE.get()) && !attacker.hasEffect(ModEffects.SMALLPOX.get())) {
            attacker.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*180, 0));
        }
        if (target.hasEffect(ModEffects.SCARLET_FEVER.get()) && !attacker.hasEffect(ModEffects.SCARLET_FEVER.get())) {
            attacker.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*180, 0));
        }
        if (target.hasEffect(ModEffects.SWINE_FLU.get()) && !attacker.hasEffect(ModEffects.SWINE_FLU.get())) {
            attacker.addEffect(new MobEffectInstance(ModEffects.SWINE_FLU.get(), 20*180, 0));
        }
        if (target.hasEffect(ModEffects.CORONAVIRUS.get()) && !attacker.hasEffect(ModEffects.CORONAVIRUS.get())) {
            attacker.addEffect(new MobEffectInstance(ModEffects.CORONAVIRUS.get(), 20*60*10, 0));
        }
    
        // --- Random 1% chance infections (if not already infected) ---
        target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
            float diseaseRoll;
            if (random.nextFloat() < 0.01F) { 
                if (!cap.isImmuneToCoronavirus() && !target.hasEffect(ModEffects.CORONAVIRUS.get()) && random.nextFloat() < 0.30F) {
                    target.addEffect(new MobEffectInstance(ModEffects.CORONAVIRUS.get(), 20*60*10, 0));
                }
                else if (!cap.isImmuneToSwineFlu() && !target.hasEffect(ModEffects.SWINE_FLU.get()) && random.nextFloat() < 0.30F) {
                    target.addEffect(new MobEffectInstance(ModEffects.SWINE_FLU.get(), 20*180, 0));
                }
                else if (!cap.isImmuneToScarletFever() && !target.hasEffect(ModEffects.SCARLET_FEVER.get()) && random.nextFloat() < 0.30F) {
                    target.addEffect(new MobEffectInstance(ModEffects.SCARLET_FEVER.get(), 20*180, 0));
                }
                else if (!cap.isImmuneToPlague() && !target.hasEffect(ModEffects.PLAGUE.get()) && random.nextFloat() < 0.05F) {
                    target.addEffect(new MobEffectInstance(ModEffects.PLAGUE.get(), 20*180, 0));
                }
                else if (!cap.isImmuneToAnthrax() && !target.hasEffect(ModEffects.ANTHRAX.get()) && random.nextFloat() < 0.10F) {
                    target.addEffect(new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*180, 0));
                }
            }
        });
    }

    

}

