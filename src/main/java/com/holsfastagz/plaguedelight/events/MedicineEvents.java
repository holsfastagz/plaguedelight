package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.registry.ModEffects;
import com.holsfastagz.plaguedelight.registry.ModItems;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;

@Mod.EventBusSubscriber(modid = "plaguedelight")
public class MedicineEvents {

    // Antivirus: Grants antivirus effect for 1 minute
    @SubscribeEvent
    public static void onAntivirusConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        ItemStack consumed = event.getItem();

        if (consumed.getItem() == ModItems.ANTIVIRUS.get()) {
            player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                ModEffects.ANTIVIRUS.get(), 20*60, 0));
        }
    }

    // Penicillin: grants penicillin effect for 20 minutes, 20% chance 
    @SubscribeEvent
    public static void onPenicillinConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        ItemStack consumed = event.getItem();

        if (consumed.getItem() == ModItems.PENICILLIN.get()) {
            player.addEffect(new net.minecraft.world.effectMobEffectInstance(
                ModEffects.PENICILLIN.get(), 20*60*20, 0));
        }
    }

    // Infernicillin: Cures more diseases for 30 minutes, 30% chance
    @SubscribeEvent
    public static void onInfernicillinConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        ItemStack consumed = event.getItem();

        if (consumed.getItem() == ModItems.INFERNICILLIN.get()) {
            player.addEffect(new net.minecraft.world.effectMobEffectInstance(
                ModEffects.INFERNICILLIN.get(), 20*60*30, 0));
        }
    }

    // Tonic: Cures malaria, 20% chance, 5 minutes
    @SubscribeEvent
    public static void onTonicConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        ItemStack consumed = event.getItem();

        if (consumed.getItem() == ModItems.TONIC.get()) {
            player.addEffect(new net.minecraft.world.effectMobEffectInstance(
                ModEffects.TONIC.get(), 20*60*5, 0));
        }
    }
}
