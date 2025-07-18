package com.snackpirate.constructscasting;

import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.datagen.DamageTypeTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CCDamageTypes {
	public static ResourceKey<DamageType> register(String name) {
		return ResourceKey.create(Registries.DAMAGE_TYPE, ConstructsCasting.id(name));
	}
	public static final ResourceKey<DamageType> SLIME_MAGIC = register("slime_magic");

	public static class Tags extends DamageTypeTagsProvider {
		public static final TagKey<DamageType> SPELL_BASED = TagKey.create(Registries.DAMAGE_TYPE, ConstructsCasting.id("spell_based"));

		public Tags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
			super(pOutput, pLookupProvider, modId, existingFileHelper);
		}

		@Override
		protected void addTags(HolderLookup.Provider pProvider) {
			this.tag(SPELL_BASED).add(
					ISSDamageTypes.BLOOD_MAGIC,
					ISSDamageTypes.EVOCATION_MAGIC,
					ISSDamageTypes.NATURE_MAGIC,
					ISSDamageTypes.ELDRITCH_MAGIC,
					ISSDamageTypes.ENDER_MAGIC,
					ISSDamageTypes.FIRE_MAGIC,
					ISSDamageTypes.HOLY_MAGIC,
					ISSDamageTypes.ICE_MAGIC,
					ISSDamageTypes.LIGHTNING_MAGIC)
//					.add(CCDamageTypes.SLIME_MAGIC)
			;
		}
	}
}
