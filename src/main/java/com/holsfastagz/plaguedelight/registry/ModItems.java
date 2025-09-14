package com.holsfastagz.plaguedelight.registry;

import com.holsfastagz.plaguedelight.registry.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "plaguedelight");


    // for registering block items
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    //   -------------
    //   GENERAL ITEMS
    //  -------------

    // Agar - forbidden lab gummy
    public static final RegistryObject<Item> AGAR =
            ITEMS.register("agar", () -> new Item(new Item.Properties()));

    // Jungle Bark - what happens if I cut it?
    public static final RegistryObject<Item> JUNGLE_BARK =
            ITEMS.register("jungle_bark", () -> new Item(new Item.Properties()));

    // Penicillium bottle - a shroomy antibiotic precursor
    public static final RegistryObject<Item> PENICILLIUM_BOTTLE =
            ITEMS.register("penicillium_bottle", () -> new Item(new Item.Properties().stacksTo(8)));

    // Quinine - it can treat malaria!
    public static final RegistryObject<Item> QUININE =
            ITEMS.register("quinine", () -> new Item(new Item.Properties()));


    //   ---------------
    //   DISEASE SAMPLES
    //  ---------------

    // Anthrax Sample
    public static final RegistryObject<Item> ANTHRAX_SAMPLE =
            ITEMS.register("anthrax_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Coronavirus Sample
    public static final RegistryObject<Item> CORONAVIRUS_SAMPLE =
            ITEMS.register("coronavirus_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Dysentery Sample
    public static final RegistryObject<Item> DYSENTERY_SAMPLE =
            ITEMS.register("dysentery_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Malaria Sample
    public static final RegistryObject<Item> MALARIA_SAMPLE =
            ITEMS.register("malaria_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Rabies Sample
    public static final RegistryObject<Item> RABIES_SAMPLE =
            ITEMS.register("rabies_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Plague Sample
    public static final RegistryObject<Item> PLAGUE_SAMPLE =
            ITEMS.register("plague_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Salmonella Sample
    public static final RegistryObject<Item> SALMONELLA_SAMPLE =
            ITEMS.register("salmonella_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Scarlet Fever Sample
    public static final RegistryObject<Item> SCARLET_FEVER_SAMPLE =
            ITEMS.register("scarlet_fever_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Smallpox Sample
    public static final RegistryObject<Item> SMALLPOX_SAMPLE =
            ITEMS.register("smallpox_sample", () -> new Item(new Item.Properties().stacksTo(1)));

    // Smallpox Sample
    public static final RegistryObject<Item> SWINE_FLU_SAMPLE =
            ITEMS.register("swine_flu_sample", () -> new Item(new Item.Properties().stacksTo(1)));


    //   -------------------
    //   SYRINGES & VACCINES
    //  -------------------

    // Syringe
    public static final RegistryObject<Item> SYRINGE =
            ITEMS.register("syringe", () -> new Item(new Item.Properties().stacksTo(1)));

    // Anthrax Vaccine
    public static final RegistryObject<Item> ANTHRAX_VACCINE =
            ITEMS.register("anthrax_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    // Coronavirus Vaccine
    public static final RegistryObject<Item> CORONAVIRUS_VACCINE =
           ITEMS.register("coronavirus_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    // Dysentery Vaccine
    public static final RegistryObject<Item> DYSENTERY_VACCINE =
           ITEMS.register("dysentery_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    // Malaria Vaccine
    public static final RegistryObject<Item> MALARIA_VACCINE =
           ITEMS.register("malaria_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    // Plague Vaccine
    public static final RegistryObject<Item> PLAGUE_VACCINE =
           ITEMS.register("plague_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    // Rabies Prophylaxis 
    public static final RegistryObject<Item> RABIES_PROPHYLAXIS =
           ITEMS.register("rabies_prophylaxis", () -> new Item(new Item.Properties().stacksTo(1)));

    // Salmonella Vaccine
    public static final RegistryObject<Item> SALMONELLA_VACCINE =
           ITEMS.register("salmonella_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    // Scarlet Fever Vaccine
    public static final RegistryObject<Item> SCARLET_FEVER_VACCINE =
           ITEMS.register("scarlet_fever_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    // Smallpox Vaccine
    public static final RegistryObject<Item> SMALLPOX_VACCINE =
           ITEMS.register("smallpox_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    // Swine Flu Vaccine
    public static final RegistryObject<Item> SWINE_FLU_VACCINE =
           ITEMS.register("swine_flu_vaccine", () -> new Item(new Item.Properties().stacksTo(1)));

    //   ---------
    //   MEDICINES
    //   ---------

    // Antivirus - not Norton
    public static final RegistryObject<Item> ANTIVIRUS =
            ITEMS.register("antivirus", () -> new Item(new Item.Properties()
                    .stacksTo(8)
                    .food(new FoodProperties.Builder()
                            .nutrition(0)
                            .saturationMod(0.0f)
                            .alwaysEat()
                            //.effect(() -> new MobEffectInstance(ModEffects.ANTIVIRUS, 20*60, 1), 0)
                            .build()
                    )));
    
    // Infernicillin - a hellish antibiotic
    public static final RegistryObject<Item> INFERNICILLIN =
            ITEMS.register("infernicillin", () -> new Item(new Item.Properties()
                    .stacksTo(8)
                    .food(new FoodProperties.Builder()
                            .nutrition(0)
                            .saturationMod(0.0f)
                            .alwaysEat()
                            .build()
                    )));
    
    // Penicillin - a shroomy antibiotic
    public static final RegistryObject<Item> PENICILLIN =
            ITEMS.register("penicillin", () -> new Item(new Item.Properties()
                    .stacksTo(8)
                    .food(new FoodProperties.Builder()
                            .nutrition(0)
                            .saturationMod(0.0f)
                            .alwaysEat()
                            .build()
                    )));

    // Tonic - where's the gin?
    public static final RegistryObject<Item> TONIC = ITEMS.register("tonic",
        () -> new Item(new Item.Properties()
            .stacksTo(8)
            .food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.2f)
                .alwaysEat()
                .build()
            )
        ) {
            @Override
            public UseAnim getUseAnimation(ItemStack stack) {
                return UseAnim.DRINK;
            }

            @Override
            public int getUseDuration(ItemStack stack) {
                return 32; // ticks
            }

            @Override
            public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
                ItemStack result = super.finishUsingItem(stack, level, entity);

                if (entity instanceof Player player && !player.getAbilities().instabuild) {
                    return new ItemStack(Items.GLASS_BOTTLE);
                }

                return result;
            }
        }
    );

    //   -----------
    //   BLOCK ITEMS
    //   -----------

    // Petri dish
    public static final RegistryObject<Item> PETRI_DISH_ITEM =
            registerBlockItem("petri_dish", ModBlocks.PETRI_DISH);

    // Cell Line 
    public static final RegistryObject<Item> CELL_LINE_ITEM =
            registerBlockItem("cell_line", ModBlocks.CELL_LINE);

    // Anthrax culture
    public static final RegistryObject<Item> ANTHRAX_CULTURE_ITEM =
            registerBlockItem("anthrax_culture", ModBlocks.ANTHRAX_CULTURE);

    // Coronavirus culture
    public static final RegistryObject<Item> CORONAVIRUS_CULTURE_ITEM =
            registerBlockItem("coronavirus_culture", ModBlocks.CORONAVIRUS_CULTURE);

    // Dysentery culture
    public static final RegistryObject<Item> DYSENTERY_CULTURE_ITEM =
            registerBlockItem("dysentery_culture", ModBlocks.DYSENTERY_CULTURE);

    // Malaria culture
    public static final RegistryObject<Item> MALARIA_CULTURE_ITEM =
            registerBlockItem("malaria_culture", ModBlocks.MALARIA_CULTURE);

    // Plague culture
    public static final RegistryObject<Item> PLAGUE_CULTURE_ITEM =
            registerBlockItem("plague_culture", ModBlocks.PLAGUE_CULTURE);

    // Rabies culture
    public static final RegistryObject<Item> RABIES_CULTURE_ITEM =
            registerBlockItem("rabies_culture", ModBlocks.RABIES_CULTURE);

    // Salmonella culture
    public static final RegistryObject<Item> SALMONELLA_CULTURE_ITEM =
            registerBlockItem("salmonella_culture", ModBlocks.SALMONELLA_CULTURE);

    // Scarlet fever culture
    public static final RegistryObject<Item> SCARLET_FEVER_CULTURE_ITEM =
            registerBlockItem("scarlet_fever_culture", ModBlocks.SCARLET_FEVER_CULTURE);

    // Smallpox culture
    public static final RegistryObject<Item> SMALLPOX_CULTURE_ITEM =
            registerBlockItem("smallpox_culture", ModBlocks.SMALLPOX_CULTURE);

    // Swine flu culture
    public static final RegistryObject<Item> SWINE_FLU_CULTURE_ITEM =
            registerBlockItem("swine_flu_culture", ModBlocks.SWINE_FLU_CULTURE);


    //   --------------------------------------------------------
    //   DISEASE ITEMS (UNOBTAINABLE; ONLY FOR ACHIEVEMENT ICONS)
    //   --------------------------------------------------------
    
    public static final RegistryObject<Item> ANTHRAX =
            ITEMS.register("anthrax", () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> CORONAVIRUS =
            ITEMS.register("coronavirus", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DYSENTERY =
            ITEMS.register("dysentery", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MALARIA =
            ITEMS.register("malaria", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PLAGUE =
            ITEMS.register("plague", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RABIES =
            ITEMS.register("rabies", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SALMONELLA =
            ITEMS.register("salmonella", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SCARLET_FEVER =
            ITEMS.register("scarlet_fever", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SMALLPOX =
            ITEMS.register("smallpox", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SWINE_FLU =
            ITEMS.register("swine_flu", () -> new Item(new Item.Properties().stacksTo(1)));

}

