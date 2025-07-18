package com.snackpirate.constructscasting.fluids;

import com.snackpirate.constructscasting.ConstructsCasting;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.fluid.UnplaceableFluid;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.tooltip.AbstractFluidTooltipProvider;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.fluids.data.FluidBucketModelProvider;
import slimeknights.tconstruct.library.recipe.FluidValues;

import java.util.concurrent.CompletableFuture;

public class CCFluids {
	public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(ConstructsCasting.MOD_ID);

	public static final FluidObject<UnplaceableFluid> arcaneEssence = essence("arcane_essence");
	public static final FluidObject<UnplaceableFluid> fireEssence = essence("fire_essence");
	public static final FluidObject<UnplaceableFluid> iceEssence = essence("ice_essence");
	public static final FluidObject<UnplaceableFluid> lightningEssence = essence("lightning_essence");
	public static final FluidObject<UnplaceableFluid> enderEssence = essence("ender_essence");
	public static final FluidObject<UnplaceableFluid> holyEssence = essence("holy_essence");
	public static final FluidObject<UnplaceableFluid> bloodEssence = essence("blood_essence");
	public static final FluidObject<UnplaceableFluid> evocationEssence = essence("evocation_essence");
	public static final FluidObject<UnplaceableFluid> natureEssence = essence("nature_essence");

	public static final FluidObject<UnplaceableFluid> liquidLightning = FLUIDS.register("liquid_lightning").type(FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)).unplacable();

	public static final FluidObject<UnplaceableFluid> liquidDivinity = FLUIDS.register("liquid_divinity").bucket().type(FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)).unplacable();

	public static FlowingFluidObject<ForgeFlowingFluid> potatoStew = FLUIDS.register("potato_stew").type(cool().temperature(400)).bucket().block(MapColor.WATER, 0).flowing();
	public static FlowingFluidObject<ForgeFlowingFluid> poisonousPotatoStew = FLUIDS.register("poisonous_potato_stew").type(cool().temperature(400)).bucket().block(MapColor.WATER, 0).flowing();

	public static FlowingFluidObject<ForgeFlowingFluid> moltenArcanium = FLUIDS.register("molten_arcanium").type(hot()).bucket().block(MapColor.COLOR_ORANGE, 12).flowing();
	public static FlowingFluidObject<ForgeFlowingFluid> moltenExilite = FLUIDS.register("molten_exilite").type(hot()).bucket().block(MapColor.COLOR_ORANGE, 12).flowing();
	public static final FluidObject<UnplaceableFluid> squidInk =    FLUIDS.register("squid_ink")   .type(cool().temperature(100)).commonTag("ink/squid")   .bucket().unplacable();
	public static final FluidObject<UnplaceableFluid> commonInk =    FLUIDS.register("common_ink")   .type(cool().temperature(100)).commonTag("ink/common")   .bucket().unplacable();
	public static final FluidObject<UnplaceableFluid> uncommonInk =  FLUIDS.register("uncommon_ink") .type(cool().temperature(100)).commonTag("ink/uncommon") .bucket().unplacable();
	public static final FluidObject<UnplaceableFluid> rareInk =      FLUIDS.register("rare_ink")     .type(cool().temperature(100)).commonTag("ink/rare")     .bucket().unplacable();
	public static final FluidObject<UnplaceableFluid> epicInk =      FLUIDS.register("epic_ink")     .type(cool().temperature(100)).commonTag("ink/epic")     .bucket().unplacable();
	public static final FluidObject<UnplaceableFluid> legendaryInk = FLUIDS.register("legendary_ink").type(cool().temperature(100)).commonTag("ink/legendary").bucket().unplacable();

	public static FluidObject<UnplaceableFluid> getInkFluidForRarity(SpellRarity rarity) {
		return switch (rarity) {
			case UNCOMMON -> uncommonInk;
			case RARE -> rareInk;
			case EPIC -> epicInk;
			case LEGENDARY -> legendaryInk;
			default -> commonInk;
		};
	}
	public static FluidObject<UnplaceableFluid> essence(String name) {
		return FLUIDS.register(name)
				.bucket()
				.type(FluidType.Properties.create()
						.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
						.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY))
				.unplacable();
	}

	private static FluidType.Properties cool() {
		return FluidType.Properties.create()
				.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
				.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY);
	}

	private static FluidType.Properties hot() {
		return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
				.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
				.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA);
	}
//datagen all below here
	public static class CCFluidTextures extends AbstractFluidTextureProvider {

		public CCFluidTextures(PackOutput generator, @Nullable String modId) {
			super(generator, modId);
		}

		@Override
		public void addTextures() {
			ResourceLocation potion = new ResourceLocation("tconstruct:fluid/potion/");
			texture(arcaneEssence).textures(potion, false, false).color(0xff79c0f3);
			texture(fireEssence).textures(potion, false, false).color(0xfffc9269);
			texture(iceEssence).textures(potion, false, false).color(0xff75f1ec);
			texture(lightningEssence).textures(potion, false, false).color(0xff8273e0);
			texture(enderEssence).textures(potion, false, false).color(0xffe073fc);
			texture(holyEssence).textures(potion, false, false).color(0xfffce969);
			texture(bloodEssence).textures(potion, false, false).color(0xffd67369);
			texture(evocationEssence).textures(potion, false, false).color(0xff75fc79);
			texture(natureEssence).textures(potion, false, false).color(0xffb0f869);

			texture(liquidLightning).textures(potion, false, false).color(0xffd7eef5);
			texture(liquidDivinity).textures(new ResourceLocation("tconstruct:fluid/slime/venom/"), false, false).color(0xfffce969);
			texture(potatoStew).textures(new ResourceLocation("tconstruct:fluid/food/stew/"), false, false).color(0xffe9ba61);
			texture(poisonousPotatoStew).textures(new ResourceLocation("tconstruct:fluid/food/stew/"), false, false).color(0xffedea61);
			texture(moltenArcanium).textures(new ResourceLocation("tconstruct:fluid/molten/"), false, false).color(0xff79c0f3);
			texture(moltenExilite) .textures(new ResourceLocation("tconstruct:fluid/molten/"), false, false).color(0xff5a5b5c);
			texture(squidInk)	 .textures(new ResourceLocation("tconstruct:fluid/slime/venom/"), false, false).color(0xff180030);
			texture(commonInk)   .textures(new ResourceLocation("tconstruct:fluid/slime/venom/"), false, false).color(0xff2d2d2d);
			texture(uncommonInk) .textures(new ResourceLocation("tconstruct:fluid/slime/venom/"), false, false).color(0xff124300);
			texture(rareInk)     .textures(new ResourceLocation("tconstruct:fluid/slime/venom/"), false, false).color(0xff0f3844);
			texture(epicInk)     .textures(new ResourceLocation("tconstruct:fluid/slime/venom/"), false, false).color(0xff442d5d);
			texture(legendaryInk).textures(new ResourceLocation("tconstruct:fluid/slime/venom/"), false, false).color(0xffd6a200);
		}

		@Override
		public String getName() {
			return "Construct's Casting's Fluid Textures";
		}
	}

	public static class CCBucketModels extends FluidBucketModelProvider {
		public CCBucketModels(PackOutput packOutput, String modId) {
			super(packOutput, modId);
		}
	}
	public static class Tags extends FluidTagsProvider {
		public Tags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
			super(pOutput, pProvider);
		}

		public static class CCFluidTooltipProvider extends AbstractFluidTooltipProvider {

			public CCFluidTooltipProvider(PackOutput generator, String modId) {
				super(generator, modId);
			}

			@Override
			protected void addFluids() {

				add("bottle", BOTTLE_TOOLTIP)
						.addUnit("bottle", FluidValues.BOTTLE);
			}

			@Override
			public String getName() {
				return "Construct's Casting Fluid Tooltips";
			}
		}

		public static final TagKey<Fluid> MOLTEN_ARCANIUM = FluidTags.create(ConstructsCasting.id( "molten_arcanium"));
		public static final TagKey<Fluid> MOLTEN_EXILITE = FluidTags.create(ConstructsCasting.id( "molten_exilite"));
		public static final TagKey<Fluid> POTATO_STEW = FluidTags.create(ConstructsCasting.id("potato_stew"));
		public static final TagKey<Fluid> POISONOUS_POTATO_STEW = FluidTags.create(ConstructsCasting.id("poisonous_potato_stew"));
		public static final TagKey<Fluid> LIQUID_LIGHTNING = FluidTags.create(ConstructsCasting.id("liquid_lightning"));
		public static final TagKey<Fluid> LIQUID_DIVINITY = FluidTags.create(ConstructsCasting.id("liquid_divinity"));
		public static final TagKey<Fluid> BLOOD_ESSENCE_INGREDIENTS = FluidTags.create(ConstructsCasting.id("blood_essence_ingredients"));
		public static final TagKey<Fluid> ARCANIUM_BASE = FluidTags.create(ConstructsCasting.id("arcanium_base"));
		public static final TagKey<Fluid> BOTTLE_TOOLTIP = FluidTags.create(ConstructsCasting.id("bottle_tooltip"));


		public static TagKey<Fluid> essenceOf(String type) {
			return FluidTags.create(new ResourceLocation(ConstructsCasting.MOD_ID, "essence/" + type));
		}
		public static TagKey<Fluid> ink(String rarity) {
			return FluidTags.create(new ResourceLocation(ConstructsCasting.MOD_ID, "ink/" + rarity));
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			tag(MOLTEN_ARCANIUM).add(moltenArcanium.get());
			tag(MOLTEN_EXILITE).add(moltenExilite.get());
			tag(POTATO_STEW).add(potatoStew.get());
			tag(POISONOUS_POTATO_STEW).add(poisonousPotatoStew.get());
			tag(LIQUID_LIGHTNING).add(liquidLightning.get());
			tag(LIQUID_DIVINITY).add(liquidDivinity.get());

			tag(ARCANIUM_BASE).add(TinkerFluids.moltenCopper.get()).add(TinkerFluids.moltenIron.get()).add(TinkerFluids.moltenGold.get());
			tag(essenceOf("arcane")).add(arcaneEssence.get());
			tag(essenceOf("fire")).add(fireEssence.get());
			tag(essenceOf("ice")).add(iceEssence.get());
			tag(essenceOf("lightning")).add(lightningEssence.get());
			tag(essenceOf("ender")).add(enderEssence.get());
			tag(essenceOf("holy")).add(holyEssence.get());
			tag(essenceOf("blood")).add(bloodEssence.get());
			tag(essenceOf("evocation")).add(evocationEssence.get());
			tag(essenceOf("nature")).add(natureEssence.get());
			tag(ink("squid")).add(squidInk.get());
			tag(TagKey.create(ResourceKey.createRegistryKey(new ResourceLocation("forge:fluid_type")),new ResourceLocation("forge:ink"))).add(squidInk.get());
			tag(ink("common")).add(commonInk.get()).addOptional(new ResourceLocation("create_wizardry:common_ink"));
			tag(ink("uncommon")).add(uncommonInk.get()).addOptional(new ResourceLocation("create_wizardry:uncommon_ink"));
			tag(ink("rare")).add(rareInk.get()).addOptional(new ResourceLocation("create_wizardry:rare_ink"));
			tag(ink("epic")).add(epicInk.get()).addOptional(new ResourceLocation("create_wizardry:epic_ink"));
			tag(ink("legendary")).add(legendaryInk.get()).addOptional(new ResourceLocation("create_wizardry:legendary_ink"));
			tag(BLOOD_ESSENCE_INGREDIENTS).add(TinkerFluids.meatSoup.get()).addOptional(new ResourceLocation("create_wizardry:blood"));
			//tooltips
			tag(TinkerTags.Fluids.METAL_TOOLTIPS).add(moltenArcanium.get()).add(moltenExilite.get());
			tag(BOTTLE_TOOLTIP)
					.add(arcaneEssence.get())
					.add(fireEssence.get())
					.add(iceEssence.get())
					.add(lightningEssence.get())
					.add(enderEssence.get())
					.add(holyEssence.get())
					.add(bloodEssence.get())
					.add(evocationEssence.get())
					.add(natureEssence.get())
					.add(liquidLightning.get())
					.add(liquidDivinity.get())
					.add(squidInk.get())
					.add(commonInk.get())
					.add(uncommonInk.get())
					.add(rareInk.get())
					.add(epicInk.get())
					.add(legendaryInk.get());
			tag(TinkerTags.Fluids.SOUP_TOOLTIPS).add(potatoStew.get()).add(poisonousPotatoStew.get());
		}
	}
}
