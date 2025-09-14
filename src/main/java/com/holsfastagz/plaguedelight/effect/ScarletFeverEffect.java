package com.holsfastagz.plaguedelight.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ScarletFeverEffect extends MobEffect {
    public ScarletFeverEffect() {
        super(MobEffectCategory.HARMFUL, 0xD62598);
    }

    // Called every tick the effect is active
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {

            // Deal half a heart of damage per tick
            entity.hurt(entity.damageSources().magic(), 1.0F);

            // Vanilla weakness effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.WEAKNESS,
                    200,                 // 10 seconds 
                    amplifier + 1,       // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));

            // Apply mining fatigue
            entity.addEffect(new MobEffectInstance(
                    MobEffects.DIG_SLOWDOWN,
                    200,                 // 10 seconds 
                    amplifier + 1,       // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Makes it trigger every 10 seconds
        return duration % 200 == 0;
    }

}

