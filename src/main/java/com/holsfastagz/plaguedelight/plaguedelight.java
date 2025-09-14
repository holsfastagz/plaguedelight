package com.holsfastagz.plaguedelight;

import com.holsfastagz.plaguedelight.registry.ModBlocks;
import com.holsfastagz.plaguedelight.registry.ModEffects;
import com.holsfastagz.plaguedelight.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(plaguedelight.MODID)
public class plaguedelight {
    public static final String MODID = "plaguedelight";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Creative tab registry 
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB, MODID);

    // Creative tab
    public static final RegistryObject<CreativeModeTab> PLAGUE_DELIGHT_TAB =
            CREATIVE_MODE_TABS.register("plague_delight_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.plaguedelight.plague_delight_tab"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> new ItemStack(ModItems.SYRINGE.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.PETRI_DISH_ITEM.get());
                        output.accept(ModItems.SYRINGE.get());
                        output.accept(ModItems.PENICILLIN.get());
                        output.accept(ModItems.INFERNICILLIN.get());
                        output.accept(ModItems.ANTIVIRUS.get());
                        output.accept(ModItems.CELL_LINE_ITEM.get());
                        output.accept(ModItems.JUNGLE_BARK.get());
                        output.accept(ModItems.QUININE.get());
                        output.accept(ModItems.TONIC.get());
                        output.accept(ModItems.ANTHRAX_SAMPLE.get());
                        output.accept(ModItems.ANTHRAX_CULTURE_ITEM.get());
                        output.accept(ModItems.ANTHRAX_VACCINE.get());
                        output.accept(ModItems.CORONAVIRUS_SAMPLE.get());
                        output.accept(ModItems.CORONAVIRUS_CULTURE_ITEM.get());
                        output.accept(ModItems.CORONAVIRUS_VACCINE.get());
                        output.accept(ModItems.DYSENTERY_SAMPLE.get());
                        output.accept(ModItems.DYSENTERY_CULTURE_ITEM.get());
                        output.accept(ModItems.DYSENTERY_VACCINE.get());
                        output.accept(ModItems.MALARIA_SAMPLE.get());
                        output.accept(ModItems.MALARIA_CULTURE_ITEM.get());
                        output.accept(ModItems.MALARIA_VACCINE.get());
                        output.accept(ModItems.RABIES_SAMPLE.get());
                        output.accept(ModItems.RABIES_CULTURE_ITEM.get());
                        output.accept(ModItems.RABIES_PROPHYLAXIS.get());
                        output.accept(ModItems.PLAGUE_SAMPLE.get());
                        output.accept(ModItems.PLAGUE_CULTURE_ITEM.get());
                        output.accept(ModItems.PLAGUE_VACCINE.get());
                        output.accept(ModItems.SALMONELLA_SAMPLE.get());
                        output.accept(ModItems.SALMONELLA_CULTURE_ITEM.get());
                        output.accept(ModItems.SALMONELLA_VACCINE.get());
                        output.accept(ModItems.SCARLET_FEVER_SAMPLE.get());
                        output.accept(ModItems.SCARLET_FEVER_CULTURE_ITEM.get());
                        output.accept(ModItems.SCARLET_FEVER_VACCINE.get());
                        output.accept(ModItems.SMALLPOX_SAMPLE.get());
                        output.accept(ModItems.SMALLPOX_CULTURE_ITEM.get());
                        output.accept(ModItems.SMALLPOX_VACCINE.get());
                        output.accept(ModItems.SWINE_FLU_SAMPLE.get());
                        output.accept(ModItems.SWINE_FLU_CULTURE_ITEM.get());
                        output.accept(ModItems.SWINE_FLU_VACCINE.get());
                    })
                    .build()
            );

    public plaguedelight(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register all your stuff from the registry classes
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEffects.EFFECTS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        // Setup events
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // Forge event bus
        MinecraftForge.EVENT_BUS.register(this);

        // Config
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Example: add items to vanilla tabs if you want
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModItems.PETRI_DISH_ITEM.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}

