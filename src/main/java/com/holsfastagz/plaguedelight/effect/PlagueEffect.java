package com.holsfastagz.plaguedelight.effect;

import com.holsfastagz.plaguedelight.registry.ModDamageTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class PlagueEffect extends MobEffect {
    public PlagueEffect() {
        super(MobEffectCategory.HARMFUL, 0x4B365F); // plague purple color
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide) return;
        if (!(entity.level() instanceof ServerLevel serverLevel)) return;
        if (!entity.isAlive()) return; // prevent crash when effect is removed on death

        // Deal plague damage
        entity.hurt(ModDamageTypes.plague(serverLevel), 1.0F);

        // Apply hunger
        entity.addEffect(new MobEffectInstance(
                MobEffects.HUNGER,
                200,     // 10 seconds
                amplifier,
                false,
                false,
                false 
        ));

        // Apply nausea
        entity.addEffect(new MobEffectInstance(
                MobEffects.CONFUSION,
                200, // 10 seconds
                0,
                false,
                false,
                false
        ));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Triggers every 200 ticks (10 seconds)
        return duration % 200 == 0;
    }
}

