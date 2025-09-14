package com.holsfastagz.plaguedelight.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class MalariaEffect extends MobEffect {
    public MalariaEffect() {
        super(MobEffectCategory.HARMFUL, 0x5C3400);
    }

    // Called every tick the effect is active
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {

            // Deal half a heart of damage (time interval defined below)
            entity.hurt(entity.damageSources().magic(), 1.0F);

            // Vanilla hunger effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.HUNGER,
                    200,                 // trigger every 10 seconds 
                    amplifier,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));

            // Vanilla weakness effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.WEAKNESS,
                    200,                 // trigger every 10 seconds
                    amplifier,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));

            // Vanilla slowness effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    200,                 // trigger every 10 seconds
                    amplifier,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));

            // Vanilla bad luck effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.UNLUCK,
                    200,                 // trigger every 10 seconds
                    amplifier,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));


        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Makes health drop trigger every 200 ticks
        return duration % 200 == 0;
    }

}

