package com.holsfastagz.plaguedelight.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class PenicillinEffect extends MobEffect {
    public PenicillinEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x0C8E9E9);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false; 
    }
}

