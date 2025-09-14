package com.holsfastagz.plaguedelight.effect;

import com.holsfastagz.plaguedelight.registry.ModDamageTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class VaccinatedEffect extends MobEffect {
    public VaccinatedEffect() {
        super(MobEffectCategory.HARMFUL, 0x4B365F);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide) return;
        if (!(entity.level() instanceof ServerLevel serverLevel)) return;
        if (!entity.isAlive()) return; 

        // Deal effect damage
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

        // Apply mining fatigue 
        entity.addEffect(new MobEffectInstance(
                MobEffects.DIG_SLOWDOWN,
                200,     // 10 seconds
                amplifier,
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

