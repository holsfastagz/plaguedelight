package com.holsfastagz.plaguedelight;

import com.holsfastagz.plaguedelight.registry.ModBlocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

/**
 * Handles client-side setup for rendering transparent/cutout blocks.
 */
@Mod.EventBusSubscriber(modid = plaguedelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Apply cutout render type to all transparent/culture blocks
            setCutout(ModBlocks.PETRI_DISH);
            setCutout(ModBlocks.ANTHRAX_CULTURE);
            setCutout(ModBlocks.CORONAVIRUS_CULTURE);
            setCutout(ModBlocks.DYSENTERY_CULTURE);
            setCutout(ModBlocks.MALARIA_CULTURE);
            setCutout(ModBlocks.PLAGUE_CULTURE);
            setCutout(ModBlocks.RABIES_CULTURE);
            setCutout(ModBlocks.SALMONELLA_CULTURE);
            setCutout(ModBlocks.SCARLET_FEVER_CULTURE);
            setCutout(ModBlocks.SMALLPOX_CULTURE);
            setCutout(ModBlocks.SWINE_FLU_CULTURE);
        });
    }

    /**
     * Helper method to safely assign a block to the cutout render layer.
     */
    private static void setCutout(net.minecraftforge.registries.RegistryObject<net.minecraft.world.level.block.Block> block) {
        block.ifPresent(b -> ItemBlockRenderTypes.setRenderLayer(b, RenderType.cutout()));
    }
}

