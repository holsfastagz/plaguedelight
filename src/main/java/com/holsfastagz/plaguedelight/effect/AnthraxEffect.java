package com.holsfastagz.plaguedelight.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class AnthraxEffect extends MobEffect {
    public AnthraxEffect() {
        super(MobEffectCategory.HARMFUL, 0xF6BE00);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
         if (!entity.level().isClientSide) {
             System.out.println("AnthraxEffect ticked for: " + entity.getName().getString());
             //...rest of your code
         }
     }

    // Called every tick the effect is active
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {

            // Deal half a heart of damage per tick
            entity.hurt(entity.damageSources().magic(), 1.0F);

            // Vanilla hunger effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.HUNGER,
                    6000,                // 5 minutes
                    amplifier,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));

            // Vanilla weakness effect
            entity.addEffect(new MobEffectInstance(
                    MobEffects.WEAKNESS,
                    6000,                // 5 minutes
                    0,           // effect strength
                    false,               // ambient
                    false,               // show particles
                    false                // show icon
            ));


        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Makes it trigger every 200 ticks
        return duration % 200 == 0;
    }

}

