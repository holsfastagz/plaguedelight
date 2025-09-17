package com.holsfastagz.plaguedelight.effect;

import com.holsfastagz.plaguedelight.registry.ModEffects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class DysenteryEffect extends MobEffect {
    public DysenteryEffect() {
        super(MobEffectCategory.HARMFUL, 0xDD3224);
    }

    // Called every tick the effect is active
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {

            // If penicillin or infernicillin effect is active, skip harmful logic
            if (entity.hasEffect(ModEffects.PENICILLIN.get())
                || entity.hasEffect(ModEffects.INFERNICILLIN.get())) {
                return;
            }

            // Deal half a heart of damage 
            entity.hurt(entity.damageSources().magic(), 1.0F);

            // Vanilla hunger effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.HUNGER,
                    50,                  // 2.5 seconds
                    amplifier,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));

            // Vanilla weakness effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.HUNGER,
                    50,                  // 2.5 seconds 
                    amplifier,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));

            // Apply mining fatigue
            entity.addEffect(new MobEffectInstance(
                    MobEffects.DIG_SLOWDOWN,
                    50,                  // 2.5 seconds 
                    amplifier,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Makes it trigger every 2.5 seconds
        return duration % 50 == 0;
    }

}

