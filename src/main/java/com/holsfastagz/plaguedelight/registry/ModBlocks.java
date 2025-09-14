package com.holsfastagz.plaguedelight.registry;

import com.holsfastagz.plaguedelight.block.PetriDishBlock;
import com.holsfastagz.plaguedelight.block.CellLineBlock;
import com.holsfastagz.plaguedelight.block.AnthraxCultureBlock;
import com.holsfastagz.plaguedelight.block.CoronavirusCultureBlock;
import com.holsfastagz.plaguedelight.block.DysenteryCultureBlock;
import com.holsfastagz.plaguedelight.block.MalariaCultureBlock;
import com.holsfastagz.plaguedelight.block.PlagueCultureBlock;
import com.holsfastagz.plaguedelight.block.RabiesCultureBlock;
import com.holsfastagz.plaguedelight.block.SalmonellaCultureBlock;
import com.holsfastagz.plaguedelight.block.ScarletFeverCultureBlock;
import com.holsfastagz.plaguedelight.block.SmallpoxCultureBlock;
import com.holsfastagz.plaguedelight.block.SwineFluCultureBlock;
import com.holsfastagz.plaguedelight.plaguedelight;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    // Registry for all your blocks
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, plaguedelight.MODID);
   

    //     -----------------------
    //     PETRI DISH AND CULTURES
    //    -----------------------

    // Petri Dish 
    public static final RegistryObject<Block> PETRI_DISH =
            BLOCKS.register("petri_dish",
                    () -> new PetriDishBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // Cell Line
    public static final RegistryObject<Block> CELL_LINE =
            BLOCKS.register("cell_line",
                    () -> new CellLineBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // Anthrax Culture 
    public static final RegistryObject<Block> ANTHRAX_CULTURE =
            BLOCKS.register("anthrax_culture",
                    () -> new AnthraxCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // Coronavirus Culture 
    public static final RegistryObject<Block> CORONAVIRUS_CULTURE =
            BLOCKS.register("coronavirus_culture",
                    () -> new CoronavirusCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    )); 

    // Dysentery Culture 
    public static final RegistryObject<Block> DYSENTERY_CULTURE =
            BLOCKS.register("dysentery_culture",
                    () -> new DysenteryCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // Malaria Culture 
    public static final RegistryObject<Block> MALARIA_CULTURE =
            BLOCKS.register("malaria_culture",
                    () -> new MalariaCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // Plague Culture 
    public static final RegistryObject<Block> PLAGUE_CULTURE =
            BLOCKS.register("plague_culture",
                    () -> new PlagueCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // Rabies Culture 
    public static final RegistryObject<Block> RABIES_CULTURE =
            BLOCKS.register("rabies_culture",
                    () -> new RabiesCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    )); 

    // Salmonella Culture 
    public static final RegistryObject<Block> SALMONELLA_CULTURE =
            BLOCKS.register("salmonella_culture",
                    () -> new SalmonellaCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // Scarlet Fever Culture
    public static final RegistryObject<Block> SCARLET_FEVER_CULTURE =
            BLOCKS.register("scarlet_fever_culture",
                    () -> new ScarletFeverCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // Smallpox Culture 
    public static final RegistryObject<Block> SMALLPOX_CULTURE =
            BLOCKS.register("smallpox_culture",
                    () -> new SmallpoxCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

    // SwineFlu Culture 
    public static final RegistryObject<Block> SWINE_FLU_CULTURE =
            BLOCKS.register("swine_flu_culture",
                    () -> new SwineFluCultureBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE)
                            .strength(0.5F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                    ));

}

