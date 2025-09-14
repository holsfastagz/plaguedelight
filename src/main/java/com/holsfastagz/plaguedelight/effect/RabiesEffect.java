package com.holsfastagz.plaguedelight.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class RabiesEffect extends MobEffect {
    public RabiesEffect() {
        super(MobEffectCategory.HARMFUL, 0x1F2022);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide) return;

        // Apply Wither for 1 second each tick
        entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20, 4, false, false, false));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}


