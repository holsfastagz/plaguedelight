package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.capability.ImmunityCapability;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "plaguedelight")
public class PlayerDeathEvents {

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(ImmunityCapability.IMMUNITY).ifPresent(oldCap -> {
            event.getEntity().getCapability(ImmunityCapability.IMMUNITY).ifPresent(newCap -> {
                newCap.clear(); // Reset immunity on death
            });
        });
    }
}

