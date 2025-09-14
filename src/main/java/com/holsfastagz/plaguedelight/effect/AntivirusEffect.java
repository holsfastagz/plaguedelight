package com.holsfastagz.plaguedelight.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class AntivirusEffect extends MobEffect {
    public AntivirusEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x00C8FF);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false; 
    }
}

