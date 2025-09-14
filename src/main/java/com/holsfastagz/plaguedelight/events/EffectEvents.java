package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.registry.ModEffects;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.MobEffectEvent;

@Mod.EventBusSubscriber(modid = "plaguedelight")
public class EffectEvents {

    // Plague
    @SubscribeEvent
    public static void onPlagueRemoved(MobEffectEvent.Remove event) {
        if (event.getEffectInstance() != null &&
            event.getEffectInstance().getEffect() == ModEffects.PLAGUE.get()) {
            // Cancel removal by milk, /effect clear, etc.
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlagueExpired(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null &&
            event.getEffectInstance().getEffect() == ModEffects.PLAGUE.get()) {
            // Expired cannot be canceled! Just run logic here
            if (event.getEntity() != null && event.getEntity().isAlive()) {
                // Example: apply damage or re-apply plague
                // event.getEntity().hurt(ModDamageTypes.plague(event.getEntity().level()), 2.0F);
            }
        }
    }

    // Anthrax
    @SubscribeEvent
    public static void onAnthraxRemoved(MobEffectEvent.Remove event) {
        if (event.getEffectInstance() != null &&
            event.getEffectInstance().getEffect() == ModEffects.ANTHRAX.get()) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onAnthraxExpired(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null &&
            event.getEffectInstance().getEffect() == ModEffects.ANTHRAX.get()) {
            // Do logic here, but do NOT cancel
            if (event.getEntity() != null && event.getEntity().isAlive()) {
                // Example: deal stronger damage or spawn particles
            }
        }
    }
}

