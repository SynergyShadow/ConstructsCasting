package com.snackpirate.constructscasting.materials;

import com.snackpirate.constructscasting.ConstructsCasting;
import com.snackpirate.constructscasting.modifiers.CCModifiers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.stats.*;

import java.awt.*;

public class CCMaterials extends AbstractMaterialDataProvider {

	public static final MaterialId arcanium = createMaterial("arcanium"); //trait: arcane
	public static final MaterialId exilite = createMaterial("exilite"); //trait: damage to magic users? pyromancers etc. also people who are casting spells
	//armor trait: spell protection (also makes the reinforcement)
	//needs nugget/ingot/blocks, this is the stuff that makes the magehunter
	public static final MaterialId arcaneCloth = createMaterial("arcane_cloth"); //trait: mana regen, maille/binding only
	public static final MaterialId frozenBone = createMaterial("frozen_bone");
	public static final MaterialId frostRod = createMaterial("frosted_rod");
	public static final MaterialId hogskin = createMaterial("hogskin");
	public static final MaterialId dragonskin = createMaterial("dragonskin");
	public static final MaterialId rainbowSlime = createMaterial("rainbowslime");
	public CCMaterials(PackOutput gen) {
		super(gen);
	}

	private static MaterialId createMaterial(String name) {
		return new MaterialId(ConstructsCasting.id(name));
	}

	@Override
	protected void addMaterials() {
		addMaterial(frozenBone, 2, 0, true);
		addMaterial(arcaneCloth, 2, 0, true);
		addMaterial(arcanium, 3, 0, false);
		addMaterial(exilite, 3, 0, false);
		addMaterial(frostRod, 3, 0, true);
		addMaterial(rainbowSlime, 3, 0, false);
//		addMaterial(hogskin, 3, 0, true);
//		addMaterial(dragonskin, 4, 0, true);
	}

	@Override
	public String getName() {
		return "Construct's Casting Materials";
	}

	public static class CCMaterialStats extends AbstractMaterialStatsDataProvider {

		public CCMaterialStats(PackOutput gen, AbstractMaterialDataProvider materials) {
			super(gen, materials);
		}

		@Override
		protected void addMaterialStats() {
			addMaterialStats(arcanium,
					new HeadMaterialStats(380, 7.0f, Tiers.DIAMOND, 2.0f),
					new HandleMaterialStats(0.05f, 0.1f, -0.05f, -0.15f),
					StatlessMaterialStats.BINDING,
					//about worse than amethyst bronze
					new PlatingMaterialStats(PlatingMaterialStats.HELMET, 288, 2, 2, 0.1f),
					new PlatingMaterialStats(PlatingMaterialStats.CHESTPLATE, 428, 6, 2, 0.1f),
					new PlatingMaterialStats(PlatingMaterialStats.LEGGINGS, 400, 5, 2, 0.1f),
					new PlatingMaterialStats(PlatingMaterialStats.BOOTS, 344, 2, 2, 0.1f),
					new PlatingMaterialStats(PlatingMaterialStats.SHIELD, 484, 1, 2, 0.1f),
					StatlessMaterialStats.MAILLE);
			addMaterialStats(exilite,
					new HeadMaterialStats(480, 7.5f, Tiers.DIAMOND, 2.5f),
					new HandleMaterialStats(-0.05f, -0.15f, 0.15f, 0.1f),
					StatlessMaterialStats.BINDING,
					new PlatingMaterialStats(PlatingMaterialStats.HELMET, 318, 2, 2, 0.15f),
					new PlatingMaterialStats(PlatingMaterialStats.CHESTPLATE, 458, 6, 2, 0.15f),
					new PlatingMaterialStats(PlatingMaterialStats.LEGGINGS, 430, 6, 2, 0.15f),
					new PlatingMaterialStats(PlatingMaterialStats.BOOTS, 374, 2, 2, 0.15f),
					new PlatingMaterialStats(PlatingMaterialStats.SHIELD, 514, 1, 2, 0.15f),
					StatlessMaterialStats.MAILLE);
			addMaterialStats(frozenBone,
					new HeadMaterialStats(175, 4, Tiers.IRON, 2.5f),
					new HandleMaterialStats(0.1f, -0.05f, -0.1f, 0.1f),
					StatlessMaterialStats.BINDING);
			addMaterialStats(frostRod,
					new HandleMaterialStats(0.1f, -0.1f, -0.15f, 0.15f));
			addMaterialStats(arcaneCloth, StatlessMaterialStats.BINDING, StatlessMaterialStats.MAILLE);
			addMaterialStats(hogskin, StatlessMaterialStats.BINDING, StatlessMaterialStats.MAILLE);
			addMaterialStats(dragonskin, StatlessMaterialStats.BINDING, StatlessMaterialStats.MAILLE);
			addMaterialStats(rainbowSlime);
		}

		@Override
		public String getName() {
			return "Construct's Casting Material Stats";
		}
	}
	public static class CCMaterialTraits extends AbstractMaterialTraitDataProvider {

		public CCMaterialTraits(PackOutput gen, AbstractMaterialDataProvider materials) {
			super(gen, materials);
		}

		@Override
		protected void addMaterialTraits() {
			addTraits(arcanium, MaterialRegistry.MELEE_HARVEST, CCModifiers.ARCANE);
			addTraits(arcanium, MaterialRegistry.ARMOR, new ModifierEntry(CCModifiers.ARCANE, 2));
			addDefaultTraits(arcaneCloth, CCModifiers.SPELLBOUND);
			addDefaultTraits(hogskin, CCModifiers.ARCANE);
			addDefaultTraits(frozenBone, CCModifiers.ANTIFROST);
			addDefaultTraits(dragonskin, CCModifiers.ENDER_UPGRADE);
			addTraits(frostRod, HandleMaterialStats.ID, new ModifierEntry(CCModifiers.ICE_UPGRADE, 1));
			addTraits(exilite, MaterialRegistry.MELEE_HARVEST, CCModifiers.ANTIMAGIC);
			addTraits(exilite, MaterialRegistry.ARMOR, CCModifiers.SPELL_PROTECTION);
			noTraits(rainbowSlime);
		}

		@Override
		public String getName() {
			return "Construct's Casting Material Traits";
		}
	}

	public static class CCMaterialRenderInfo extends AbstractMaterialRenderInfoProvider {

		public CCMaterialRenderInfo(PackOutput gen, @Nullable AbstractMaterialSpriteProvider materialSprites, ExistingFileHelper fileHelper) {
			super(gen, materialSprites, fileHelper);
		}

		@Override
		protected void addMaterialRenderInfo() {
			buildRenderInfo(arcanium).color(0x73abde);
			buildRenderInfo(arcaneCloth).color(0x73abde).fallbacks("cloth");
			buildRenderInfo(hogskin).color(0xFF0000).fallbacks("cloth", "primitive");
			buildRenderInfo(exilite).color(0x47494b);
			buildRenderInfo(frozenBone).color(0xd0e5e4).fallbacks("bone", "rock");
			buildRenderInfo(rainbowSlime).color(0xFFFF00);
			buildRenderInfo(frostRod).color(0xc8ecec).fallbacks("metal", "primitive");
		}

		@Override
		public String getName() {
			return "Construct's Casting Material Render Info";
		}
	}
}
