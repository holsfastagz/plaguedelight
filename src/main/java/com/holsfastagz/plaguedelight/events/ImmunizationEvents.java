package com.holsfastagz.plaguedelight.events;

import com.holsfastagz.plaguedelight.capability.ImmunityCapability;
import com.holsfastagz.plaguedelight.registry.ModEffects;
import com.holsfastagz.plaguedelight.registry.ModItems;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;

@Mod.EventBusSubscriber(modid = "plaguedelight")
public class ImmunizationEvents {

    // Self-immunization, anthrax
    @SubscribeEvent
    public static void onAnthraxVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for anthrax vaccine
        if (held.getItem() == ModItems.ANTHRAX_VACCINE.get()) {
            // Grant anthrax immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setAnthraxImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, anthrax
    @SubscribeEvent
    public static void onAnthraxVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for anthrax vaccine
        if (held.getItem() == ModItems.ANTHRAX_VACCINE.get()) {
            // Grant anthrax immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setAnthraxImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, coronavirus
    @SubscribeEvent
    public static void onCoronavirusVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for coronavirus vaccine
        if (held.getItem() == ModItems.CORONAVIRUS_VACCINE.get()) {
            // Grant coronavirus immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setCoronavirusImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, coronavirus
    @SubscribeEvent
    public static void onCoronavirusVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for coronavirus vaccine
        if (held.getItem() == ModItems.CORONAVIRUS_VACCINE.get()) {
            // Grant coronavirus immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setCoronavirusImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, dysentery
    @SubscribeEvent
    public static void onDysenteryVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for dysentery vaccine
        if (held.getItem() == ModItems.DYSENTERY_VACCINE.get()) {
            // Grant dysentery immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setDysenteryImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, dysentery
    @SubscribeEvent
    public static void onDysenteryVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for dysentery vaccine
        if (held.getItem() == ModItems.DYSENTERY_VACCINE.get()) {
            // Grant dysentery immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setDysenteryImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, malaria
    @SubscribeEvent
    public static void onMalariaVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for malaria vaccine
        if (held.getItem() == ModItems.MALARIA_VACCINE.get()) {
            // Grant malaria immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setMalariaImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, malaria
    @SubscribeEvent
    public static void onMalariaVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for malaria vaccine
        if (held.getItem() == ModItems.MALARIA_VACCINE.get()) {
            // Grant malaria immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setMalariaImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, plague
    @SubscribeEvent
    public static void onPlagueVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for plague vaccine
        if (held.getItem() == ModItems.PLAGUE_VACCINE.get()) {
            // Grant plague immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setPlagueImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, plague
    @SubscribeEvent
    public static void onPlagueVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for plague vaccine
        if (held.getItem() == ModItems.PLAGUE_VACCINE.get()) {
            // Grant plague immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setPlagueImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, rabies
    @SubscribeEvent
    public static void onRabiesVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for rabies vaccine
        if (held.getItem() == ModItems.RABIES_PROPHYLAXIS.get()) {
            // Grant rabies immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setRabiesImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, rabies
    @SubscribeEvent
    public static void onRabiesVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for rabies vaccine
        if (held.getItem() == ModItems.RABIES_PROPHYLAXIS.get()) {
            // Grant rabies immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setRabiesImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, salmonella
    @SubscribeEvent
    public static void onSalmonellaVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for salmonella vaccine
        if (held.getItem() == ModItems.SALMONELLA_VACCINE.get()) {
            // Grant salmonella immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setSalmonellaImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, salmonella
    @SubscribeEvent
    public static void onSalmonellaVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for salmonella vaccine
        if (held.getItem() == ModItems.SALMONELLA_VACCINE.get()) {
            // Grant salmonella immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setSalmonellaImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, scarlet_fever
    @SubscribeEvent
    public static void onScarletFeverVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for scarlet_fever vaccine
        if (held.getItem() == ModItems.SCARLET_FEVER_VACCINE.get()) {
            // Grant scarlet_fever immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setScarletFeverImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, scarlet_fever
    @SubscribeEvent
    public static void onScarletFeverVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for scarlet_fever vaccine
        if (held.getItem() == ModItems.SCARLET_FEVER_VACCINE.get()) {
            // Grant scarlet_fever immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setScarletFeverImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, smallpox
    @SubscribeEvent
    public static void onSmallpoxVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for smallpox vaccine
        if (held.getItem() == ModItems.SMALLPOX_VACCINE.get()) {
            // Grant smallpox immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setSmallpoxImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, smallpox
    @SubscribeEvent
    public static void onSmallpoxVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for smallpox vaccine
        if (held.getItem() == ModItems.SMALLPOX_VACCINE.get()) {
            // Grant smallpox immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setSmallpoxImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

    // Self-immunization, swine_flu
    @SubscribeEvent
    public static void onSwineFluVaccineUsed(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack held = event.getItemStack();

        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        // Check for swine_flu vaccine
        if (held.getItem() == ModItems.SWINE_FLU_VACCINE.get()) {
            // Grant swine_flu immunity
            player.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setSwineFluImmunity(true));

            // Consume vaccine
            held.shrink(1);

            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.SYRINGE.get()));
            }

            // Remove half a heart
            player.setHealth(Math.max(0.0F, player.getHealth() - 1.0F));

            // Give player vaccinated effect for 2 minutes
            player.addEffect(new MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0)); 
        }
    }
    // Other player immunization, swine_flu
    @SubscribeEvent
    public static void onSwineFluVaccineUsedOnOther(PlayerInteractEvent.EntityInteract event) {
        Player user = event.getEntity(); // The player using the item
        if (!(event.getTarget() instanceof Player target)) return; // The target must be a player
    
        ItemStack held = user.getItemInHand(event.getHand());
    
        // Only process if the player is using their main hand (prevents double-use with offhand)
        if (event.getHand() != net.minecraft.world.InteractionHand.MAIN_HAND) return;
    
        // Check for swine_flu vaccine
        if (held.getItem() == ModItems.SWINE_FLU_VACCINE.get()) {
            // Grant swine_flu immunity to the target
            target.getCapability(ImmunityCapability.IMMUNITY).ifPresent(cap -> cap.setSwineFluImmunity(true));
    
            // Remove half a heart from the target
            target.setHealth(Math.max(0.0F, target.getHealth() - 1.0F));
    
            // Give target vaccinated effect for 2 minutes
            target.addEffect(new net.minecraft.world.effect.MobEffectInstance(ModEffects.VACCINATED.get(), 20*120, 0));
    
            // Consume vaccine from user
            held.shrink(1);
    
            // Replace with syringe (only if item was actually consumed)
            if (held.isEmpty()) {
                user.setItemInHand(event.getHand(), new ItemStack(ModItems.SYRINGE.get()));
            }
        }
    }

}
