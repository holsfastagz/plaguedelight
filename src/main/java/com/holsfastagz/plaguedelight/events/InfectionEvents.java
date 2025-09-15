package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.capability.ImmunityCapability;
import com.holsfastagz.plaguedelight.registry.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "plaguedelight")
public class InfectionEvents {

    private static final TagKey<Biome> IS_WET = TagKey.create(
            net.minecraft.core.registries.Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath("forge", "is_wet")
    );

    // --- Helper: Only apply effect server-side ---
    private static void applyDisease(Player player, MobEffectInstance effect) {
        if (!player.level().isClientSide) {
            player.addEffect(effect);
        }
    }

    // --- Animal Infection Events ---
    @SubscribeEvent
    public static void onSheepAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Sheep)) return;
        if (player.level().isClientSide) return;
        if (player.level().random.nextFloat() < 0.01F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToAnthrax() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*60*10, 0));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onSheepInteracted(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof Sheep)) return;
        if (player.level().isClientSide) return;
        if (player.level().random.nextFloat() < 0.01F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToAnthrax() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*60*10, 0));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onBatAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Bat)) return;
        if (player.level().isClientSide) return;
        if (player.level().random.nextFloat() < 0.10F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToCoronavirus() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.CORONAVIRUS.get(), 20*60*10, 0));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onVillagerAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Villager)) return;
        if (player.level().isClientSide) return;
        if (player.level().random.nextFloat() < 0.10F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToPlague() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onVillagerInteracted(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!(event.getTarget() instanceof Villager)) return;
        if (player.level().isClientSide) return;
        if (player.level().random.nextFloat() < 0.01F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToPlague() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPillagerHurtPlayer(LivingHurtEvent event) {
        if (!(event.getSource().getEntity() instanceof Pillager)) return;
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide) return;
        if (player.level().random.nextFloat() < 0.03F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToPlague() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPillagerAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Pillager)) return;
        if (player.level().isClientSide) return;
        if (player.level().random.nextFloat() < 0.03F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToPlague() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.PLAGUE.get(), 20*60*10, 0));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onChickenAttacked(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) return;
        if (!(event.getEntity() instanceof Chicken)) return;
        if (player.level().isClientSide) return;
        if (player.level().random.nextFloat() < 0.03F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToSalmonella() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.SALMONELLA.get(), 20*150, 0));
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
        if (level.getGameTime() % 100 != 0) return;
        if (!player.isInWaterOrBubble()) return;
        Holder<Biome> biomeHolder = level.getBiome(player.blockPosition());
        if (!biomeHolder.is(IS_WET)) return;
        if (player.level().random.nextFloat() < 0.01F) {
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                if (!cap.isImmuneToMalaria() || player.level().random.nextFloat() > 0.98F) {
                    applyDisease(player, new MobEffectInstance(ModEffects.MALARIA.get(), 20*180, 0));
                }
            });
        }
    }

    // --- Dysentery from drinking ---
    @SubscribeEvent
    public static void onDrink(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (player.level().isClientSide) return;
        ItemStack stack = event.getItem();
        if (stack.is(net.minecraft.world.item.Items.POTION)
                || stack.is(net.minecraft.world.item.Items.MILK_BUCKET)) {
            if (player.level().random.nextFloat() < 0.01F) {
                player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
                    if (!cap.isImmuneToDysentery() || player.level().random.nextFloat() > 0.98F) {
                        applyDisease(player, new MobEffectInstance(ModEffects.DYSENTERY.get(), 20*120, 0));
                    }
                });
            }
        }
    }

    // --- PVP INFECTIONS ---
    @SubscribeEvent
    public static void onPlayerPVPInfection(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof Player target)) return;
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (target.level().isClientSide) return;
        RandomSource random = target.level().random;

        // Transmission from attacker to target
        if (attacker.hasEffect(ModEffects.ANTHRAX.get()) && !target.hasEffect(ModEffects.ANTHRAX.get())) {
            applyDisease(target, new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*180, 0));
        }
        if (attacker.hasEffect(ModEffects.DYSENTERY.get()) && !target.hasEffect(ModEffects.DYSENTERY.get())) {
            applyDisease(target, new MobEffectInstance(ModEffects.DYSENTERY.get(), 20*180, 0));
        }
        if (attacker.hasEffect(ModEffects.PLAGUE.get()) && !target.hasEffect(ModEffects.PLAGUE.get())) {
            applyDisease(target, new MobEffectInstance(ModEffects.PLAGUE.get(), 20*180, 0));
        }
        // Repeat for other diseases...

        // Transmission from target to attacker
        if (target.hasEffect(ModEffects.ANTHRAX.get()) && !attacker.hasEffect(ModEffects.ANTHRAX.get())) {
            applyDisease(attacker, new MobEffectInstance(ModEffects.ANTHRAX.get(), 20*180, 0));
        }
        if (target.hasEffect(ModEffects.DYSENTERY.get()) && !attacker.hasEffect(ModEffects.DYSENTERY.get())) {
            applyDisease(attacker, new MobEffectInstance(ModEffects.DYSENTERY.get(), 20*180, 0));
        }
        if (target.hasEffect(ModEffects.PLAGUE.get()) && !attacker.hasEffect(ModEffects.PLAGUE.get())) {
            applyDisease(attacker, new MobEffectInstance(ModEffects.PLAGUE.get(), 20*180, 0));
        }
        // Repeat for other diseases...

        // Random infections (1% chance)
        target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> {
            if (random.nextFloat() < 0.01F) {
                if (!cap.isImmuneToCoronavirus() && !target.hasEffect(ModEffects.CORONAVIRUS.get()) && random.nextFloat() < 0.30F) {
                    applyDisease(target, new MobEffectInstance(ModEffects.CORONAVIRUS.get(), 20*60*10, 0));
                }
                // Repeat for other diseases...
            }
        });
    }
}
