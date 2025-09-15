package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.capability.ImmunityCapability;
import com.holsfastagz.plaguedelight.registry.ModEffects;
import com.holsfastagz.plaguedelight.registry.ModItems;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

@Mod.EventBusSubscriber(modid = "plaguedelight")
public class MedicineEvents {

    // Confer antivirus effect for 1 minute when antivirus is consumed
    @SubscribeEvent
    public static void onAntivirusConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;

        ItemStack consumed = event.getItem();

        // Check if player ate Antivirus
        if (consumed.getItem() == ModItems.ANTIVIRUS.get()) {
            player.addEffect(new MobEffectInstance(ModEffects.ANTIVIRUS.get(), 20*60, 0));
        }
    }

    @SubscribeEvent
    public static void onPenicillinConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
    
        if (event.getItem().getItem() == ModItems.PENICILLIN.get()) {
            System.out.println("Penicillin consumed!");
    
            // 25% chance
            if (player.level().random.nextFloat() < 0.25F) {
                System.out.println("Penicillin success!");
    
                player.removeEffect(ModEffects.ANTHRAX.get());
                player.removeEffect(ModEffects.DYSENTERY.get());
                player.removeEffect(ModEffects.PLAGUE.get());
                player.removeEffect(ModEffects.SALMONELLA.get());
    
                // --- Force client sync for all removed effects ---
                if (player instanceof ServerPlayer serverPlayer) {
                    serverPlayer.onEffectRemoved(ModEffects.ANTHRAX.get());
                    serverPlayer.onEffectRemoved(ModEffects.DYSENTERY.get());
                    serverPlayer.onEffectRemoved(ModEffects.PLAGUE.get());
                    serverPlayer.onEffectRemoved(ModEffects.SALMONELLA.get());
                }
            }
        }
    }

    @SubscribeEvent
    public static void onInfernicillinConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
    
        if (event.getItem().getItem() == ModItems.INFERNICILLIN.get()) {
            System.out.println("Infernicillin consumed!");
    
            // 50% chance 
            if (player.level().random.nextFloat() < 0.50F) {
                System.out.println("Infernicillin success!");
    
                player.removeEffect(ModEffects.ANTHRAX.get());
                player.removeEffect(ModEffects.DYSENTERY.get());
                player.removeEffect(ModEffects.PLAGUE.get());
                player.removeEffect(ModEffects.SALMONELLA.get());
    
                // --- Force client sync for all removed effects ---
                if (player instanceof ServerPlayer serverPlayer) {
                    serverPlayer.onEffectRemoved(ModEffects.ANTHRAX.get());
                    serverPlayer.onEffectRemoved(ModEffects.DYSENTERY.get());
                    serverPlayer.onEffectRemoved(ModEffects.PLAGUE.get());
                    serverPlayer.onEffectRemoved(ModEffects.SALMONELLA.get());
                }
            }
        }
    }

    // Cure malaria with tonic 
    @SubscribeEvent
    public static void onTonicConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
    
        // Check infernicillin 
        if (event.getItem().getItem() == ModItems.TONIC.get()) {

            // 20% chance
            if (player.level().random.nextFloat() < 0.20F) {
                player.removeEffect(ModEffects.MALARIA.get());
            }
            
        }
    }
    
}
