package com.holsfastagz.plaguedelight.effect;

import com.holsfastagz.plaguedelight.registry.ModEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CoronavirusEffect extends MobEffect {
    public CoronavirusEffect() {
        super(MobEffectCategory.HARMFUL, 0xDD3224);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {

            // If antivirus is active, skip harmful logic
            if (entity.hasEffect(ModEffects.ANTIVIRUS.get())) {
                return;
            }

            // Deal half a heart every 10 seconds
            if (entity.tickCount % 200 == 0) {
                entity.hurt(entity.damageSources().magic(), 1.0F);
            }

            // Keep Weakness refreshed
            if (!entity.hasEffect(MobEffects.WEAKNESS)) {
                entity.addEffect(new MobEffectInstance(
                        MobEffects.WEAKNESS,
                        20*10,   // 10 seconds
                        0,       // Weakness I
                        false,
                        true,
                        false
                ));
            }

            // Keep Mining Fatigue refreshed
            if (!entity.hasEffect(MobEffects.DIG_SLOWDOWN)) {
                entity.addEffect(new MobEffectInstance(
                        MobEffects.DIG_SLOWDOWN,
                        20*10,   // 10 seconds
                        0,       // Mining Fatigue I
                        false,
                        true,
                        false 
                ));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Makes sure applyEffectTick is called every tick
        return true;
    }
}

