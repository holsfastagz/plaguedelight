package com.holsfastagz.plaguedelight.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraft.core.Direction;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * Capability for tracking disease immunities (Anthrax and Coronavirus).
 */
public class ImmunityCapability {

    // Capability interface
    public interface IImmunity {
        boolean isImmuneToAnthrax();
        void setAnthraxImmunity(boolean value);

        boolean isImmuneToCoronavirus();
        void setCoronavirusImmunity(boolean value);

        boolean isImmuneToDysentery();
        void setDysenteryImmunity(boolean value);

        boolean isImmuneToMalaria();
        void setMalariaImmunity(boolean value);

        boolean isImmuneToPlague();
        void setPlagueImmunity(boolean value);

        boolean isImmuneToRabies();
        void setRabiesImmunity(boolean value);

        boolean isImmuneToSalmonella();
        void setSalmonellaImmunity(boolean value);

        boolean isImmuneToScarletFever();
        void setScarletFeverImmunity(boolean value);

        boolean isImmuneToSmallpox();
        void setSmallpoxImmunity(boolean value);

        boolean isImmuneToSwineFlu();
        void setSwineFluImmunity(boolean value);

        void clear();
        CompoundTag serializeNBT();
        void deserializeNBT(CompoundTag nbt);
    }

    // Implementation 
    public static class Implementation implements IImmunity, INBTSerializable<CompoundTag> {

        private boolean anthraxImmune = false;
        private boolean coronavirusImmune = false;
        private boolean dysenteryImmune = false;
        private boolean malariaImmune = false;
        private boolean plagueImmune = false;
        private boolean rabiesImmune = false;
        private boolean salmonellaImmune = false;
        private boolean scarletFeverImmune = false;
        private boolean smallpoxImmune = false;
        private boolean swineFluImmune = false;

        @Override
        public boolean isImmuneToAnthrax() { return anthraxImmune; }
        @Override
        public void setAnthraxImmunity(boolean value) { anthraxImmune = value; }

        @Override
        public boolean isImmuneToCoronavirus() { return coronavirusImmune; }
        @Override
        public void setCoronavirusImmunity(boolean value) { coronavirusImmune = value; }

        @Override
        public boolean isImmuneToDysentery() { return dysenteryImmune; }
        @Override
        public void setDysenteryImmunity(boolean value) { dysenteryImmune = value; }

        @Override
        public boolean isImmuneToMalaria() { return malariaImmune; }
        @Override
        public void setMalariaImmunity(boolean value) { malariaImmune = value; }

        @Override
        public boolean isImmuneToPlague() { return plagueImmune; }
        @Override
        public void setPlagueImmunity(boolean value) { plagueImmune = value; }

        @Override
        public boolean isImmuneToRabies() { return rabiesImmune; }
        @Override
        public void setRabiesImmunity(boolean value) { rabiesImmune = value; }

        @Override
        public boolean isImmuneToSalmonella() { return salmonellaImmune; }
        @Override
        public void setSalmonellaImmunity(boolean value) { salmonellaImmune = value; }

        @Override
        public boolean isImmuneToScarletFever() { return scarletFeverImmune; }
        @Override
        public void setScarletFeverImmunity(boolean value) { scarletFeverImmune = value; }

        @Override
        public boolean isImmuneToSmallpox() { return smallpoxImmune; }
        @Override
        public void setSmallpoxImmunity(boolean value) { smallpoxImmune = value; }

        @Override
        public boolean isImmuneToSwineFlu() { return swineFluImmune; }
        @Override
        public void setSwineFluImmunity(boolean value) { swineFluImmune = value; }

        @Override
        public void clear() {
            anthraxImmune = false;
            coronavirusImmune = false;
            dysenteryImmune = false;
            malariaImmune = false;
            plagueImmune = false;
            rabiesImmune = false;
            salmonellaImmune = false;
            scarletFeverImmune = false;
            smallpoxImmune = false;
            swineFluImmune = false;
        }

        // NBT serialization for saving/loading
        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.putBoolean("anthraxImmune", anthraxImmune);
            tag.putBoolean("coronavirusImmune", coronavirusImmune);
            tag.putBoolean("dysenteryImmune", dysenteryImmune);
            tag.putBoolean("malariaImmune", malariaImmune);
            tag.putBoolean("plagueImmune", plagueImmune);
            tag.putBoolean("rabiesImmune", rabiesImmune);
            tag.putBoolean("salmonellaImmune", salmonellaImmune);
            tag.putBoolean("scarletFeverImmune", scarletFeverImmune);
            tag.putBoolean("smallpoxImmune", smallpoxImmune);
            tag.putBoolean("swineFluImmune", swineFluImmune);
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            anthraxImmune = nbt.getBoolean("anthraxImmune");
            coronavirusImmune = nbt.getBoolean("coronavirusImmune");
            dysenteryImmune = nbt.getBoolean("dysenteryImmune");
            malariaImmune = nbt.getBoolean("malariaImmune");
            plagueImmune = nbt.getBoolean("plagueImmune");
            rabiesImmune = nbt.getBoolean("rabiesImmune");
            salmonellaImmune = nbt.getBoolean("salmonellaImmune");
            scarletFeverImmune = nbt.getBoolean("scarletFeverImmune");
            smallpoxImmune = nbt.getBoolean("smallpoxImmune");
            swineFluImmune = nbt.getBoolean("swineFluImmune");
        }
    }

    // Capability registration
    public static final Capability<IImmunity> IMMUNITY = CapabilityManager.get(new CapabilityToken<>() {});
}
