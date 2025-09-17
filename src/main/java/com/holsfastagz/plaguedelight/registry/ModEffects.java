package com.holsfastagz.plaguedelight.registry;

import com.holsfastagz.plaguedelight.plaguedelight;
import com.holsfastagz.plaguedelight.effect.AnthraxEffect;
import com.holsfastagz.plaguedelight.effect.AntivirusEffect;
import com.holsfastagz.plaguedelight.effect.CoronavirusEffect;
import com.holsfastagz.plaguedelight.effect.DysenteryEffect;
import com.holsfastagz.plaguedelight.effect.MalariaEffect;
import com.holsfastagz.plaguedelight.effect.PlagueEffect;
import com.holsfastagz.plaguedelight.effect.RabiesEffect;
import com.holsfastagz.plaguedelight.effect.SalmonellaEffect;
import com.holsfastagz.plaguedelight.effect.ScarletFeverEffect;
import com.holsfastagz.plaguedelight.effect.SmallpoxEffect;
import com.holsfastagz.plaguedelight.effect.SwineFluEffect;
import com.holsfastagz.plaguedelight.effect.VaccinatedEffect;
import com.holsfastagz.plaguedelight.effect.PenicillinEffect;
import com.holsfastagz.plaguedelight.effect.InfernicillinEffect;
import com.holsfastagz.plaguedelight.effect.TonicEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, plaguedelight.MODID);

    //   ----------------
    //   MEDICINE EFFECTS
    //   ----------------

    // Antivirus effect
    public static final RegistryObject<MobEffect> ANTIVIRUS =
            EFFECTS.register("antivirus", AntivirusEffect::new);

    // Penicillin effect
    public static final RegistryObject<MobEffect> PENICILLIN =
            EFFECTS.register("penicillin", PenicillinEffect::new);

    // Infernicillin effect
    public static final RegistryObject<MobEffect> INFERNICILLIN =
            EFFECTS.register("infernicillin", InfernicillinEffect::new);

    // Infernicillin effect
    public static final RegistryObject<MobEffect> TONIC =
            EFFECTS.register("tonic", TonicEffect::new);


    // Vaccinated effect
    public static final RegistryObject<MobEffect> VACCINATED =
            EFFECTS.register("vaccinated", VaccinatedEffect::new);


    //   --------
    //   DISEASES
    //   --------

    // Anthrax effect
    public static final RegistryObject<MobEffect> ANTHRAX =
            EFFECTS.register("anthrax", AnthraxEffect::new);

    // Coronavirus effect
    public static final RegistryObject<MobEffect> CORONAVIRUS =
            EFFECTS.register("coronavirus", CoronavirusEffect::new);

    // Dysentery effect
    public static final RegistryObject<MobEffect> DYSENTERY =
            EFFECTS.register("dysentery", DysenteryEffect::new);

    // Malaria effect
    public static final RegistryObject<MobEffect> MALARIA =
            EFFECTS.register("malaria", MalariaEffect::new);

    // Plague effect
    public static final RegistryObject<MobEffect> PLAGUE =
            EFFECTS.register("plague", PlagueEffect::new);

    // Rabies effect
    public static final RegistryObject<MobEffect> RABIES =
            EFFECTS.register("rabies", RabiesEffect::new);

    // Salmonella effect
    public static final RegistryObject<MobEffect> SALMONELLA =
           EFFECTS.register("salmonella", SalmonellaEffect::new);

    // Scarlet fever effect
    public static final RegistryObject<MobEffect> SCARLET_FEVER =
           EFFECTS.register("scarlet_fever", ScarletFeverEffect::new);

    // Smallpox effect
    public static final RegistryObject<MobEffect> SMALLPOX =
           EFFECTS.register("smallpox", SmallpoxEffect::new);

    // Swine flu effect
    public static final RegistryObject<MobEffect> SWINE_FLU =
           EFFECTS.register("swine_flu", SwineFluEffect::new);
}
