package com.holsfastagz.plaguedelight.effect;

import com.holsfastagz.plaguedelight.registry.ModEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SwineFluEffect extends MobEffect {
    public SwineFluEffect() {
        super(MobEffectCategory.HARMFUL, 0x06038D);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {

            // If antivirus is active, skip harmful logic
            if (entity.hasEffect(ModEffects.ANTIVIRUS.get())) {
                return;
            }

            // Deal half a heart every 5 seconds
            if (entity.tickCount % 100 == 0) {
                entity.hurt(entity.damageSources().magic(), 1.0F);
            }

            // Keep Weakness refreshed
            if (!entity.hasEffect(MobEffects.WEAKNESS)) {
                entity.addEffect(new MobEffectInstance(
                        MobEffects.WEAKNESS,
                        200,   // 10 seconds
                        amplifier,
                        false,
                        true,
                        false
                ));
            }

            // Keep Mining Fatigue refreshed
            if (!entity.hasEffect(MobEffects.DIG_SLOWDOWN)) {
                entity.addEffect(new MobEffectInstance(
                        MobEffects.DIG_SLOWDOWN,
                        200,   // 10 seconds
                        amplifier,
                        false,
                        true,
                        false 
                ));
            }

            // Slowdown effect
            if (!entity.hasEffect(MobEffects.DIG_SLOWDOWN)) {
                entity.addEffect(new MobEffectInstance(
                        MobEffects.DIG_SLOWDOWN,
                        200,
                        amplifier + 1,
                        false,
                        true,
                        false 
                ));
            }


            // Vanilla hunger effect
            entity.addEffect(new MobEffectInstance(
                        MobEffects.HUNGER,
                        200,                 // 10 seconds minutes
                        amplifier + 2,       // effect strength
                        false,               // ambient
                        false,               // show particles
                        false                // show icon
            ));
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Makes sure applyEffectTick is called every tick
        return true;
    }
}

