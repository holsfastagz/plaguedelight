package com.holsfastagz.plaguedelight.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class InfernicillinEffect extends MobEffect {
    public InfernicillinEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xE10600);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false; 
    }
}

