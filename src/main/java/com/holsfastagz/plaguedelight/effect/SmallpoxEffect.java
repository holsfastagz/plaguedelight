package com.holsfastagz.plaguedelight.effect;

import com.holsfastagz.plaguedelight.registry.ModEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SmallpoxEffect extends MobEffect {
    public SmallpoxEffect() {
        super(MobEffectCategory.HARMFUL, 0X006E37); 
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {

            // If antivirus is active, skip harmful logic
            if (entity.hasEffect(ModEffects.ANTIVIRUS.get())) {
                return;
            }

            // Deal 1.5 heart every 10 seconds
            if (entity.tickCount % 200 == 0) {
                entity.hurt(entity.damageSources().magic(), 3.0F);
            }

            // Weakness
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

            // Mining Fatigue
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

            // Hunger
            entity.addEffect(new MobEffectInstance(
                        MobEffects.HUNGER,
                        200,     // 10 seconds
                        amplifier,
                        false,
                        false,
                        false
            ));
            
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Makes sure applyEffectTick is called every tick
        return true;
    }
}

