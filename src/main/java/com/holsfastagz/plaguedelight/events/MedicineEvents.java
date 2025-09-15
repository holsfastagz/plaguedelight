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
                ModEffects.ANTIVIRUS.get(), 20 * 60, 0));
        }
    }

    // Penicillin: Cures bacterial infections (except scarlet fever)
    @SubscribeEvent
    public static void onPenicillinConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (event.getItem().getItem() == ModItems.PENICILLIN.get()) {
            // For testing, always cure (set to < 1.0F for 100% chance)
            if (player.level().random.nextFloat() < 1.0F) {
                player.removeEffect(ModEffects.ANTHRAX.get());
                player.removeEffect(ModEffects.DYSENTERY.get());
                player.removeEffect(ModEffects.PLAGUE.get());
                player.removeEffect(ModEffects.SALMONELLA.get());
            }
        }
    }

    // Infernicillin: Cures more diseases, 75% chance
    @SubscribeEvent
    public static void onInfernicillinConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (event.getItem().getItem() == ModItems.INFERNICILLIN.get()) {
            if (player.level().random.nextFloat() < 0.75F) {
                player.removeEffect(ModEffects.ANTHRAX.get());
                player.removeEffect(ModEffects.DYSENTERY.get());
                player.removeEffect(ModEffects.PLAGUE.get());
                player.removeEffect(ModEffects.SALMONELLA.get());
                player.removeEffect(ModEffects.MALARIA.get());
            }
        }
    }

    // Tonic: Cures malaria, 20% chance
    @SubscribeEvent
    public static void onTonicConsumed(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (event.getItem().getItem() == ModItems.TONIC.get()) {
            if (player.level().random.nextFloat() < 0.20F) {
                player.removeEffect(ModEffects.MALARIA.get());
            }
        }
    }
}
