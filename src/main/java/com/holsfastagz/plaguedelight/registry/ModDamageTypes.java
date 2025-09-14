package com.holsfastagz.plaguedelight.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {
    // Define plague DamageType key
    public static final ResourceKey<DamageType> PLAGUE =
            ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("plaguedelight", "plague"));

    public static DamageSource plague(ServerLevel level) {
        Holder<DamageType> holder = level.registryAccess()
                .registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(PLAGUE);
        return new DamageSource(holder);
}
}
