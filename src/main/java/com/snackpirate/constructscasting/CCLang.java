package com.snackpirate.constructscasting;

import com.snackpirate.constructscasting.fluids.CCFluids;
import com.snackpirate.constructscasting.items.CCItems;
import com.snackpirate.constructscasting.materials.CCMaterials;
import com.snackpirate.constructscasting.modifiers.CCModifiers;
import com.snackpirate.constructscasting.spells.CCSpells;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

import java.util.function.Supplier;

public class CCLang extends LanguageProvider {


	public CCLang(PackOutput output, String modid, String locale) {
		super(output, modid, locale);
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.constructs_casting.constructs_casting", "Construct's Casting");
		addMaterial(CCMaterials.arcanium, "Arcanium", "Yer a wizard, Harry!", "Gives the wielder +25 max mana per part.");
		addMaterial(CCMaterials.exilite, "Exilite", "#1 Wizard Hater", "Deals greater damage to magic-wielding enemies.");
		addMaterial(CCMaterials.arcaneCloth, "Arcane Cloth", "Mage essential!", "Empowers the wielder with greater spell power.");
		addMaterial(CCMaterials.frozenBone, "Frozen Bone", "Ice, ice, baby", "Deals greater damage to frozen enemies");
		addMaterial(CCMaterials.frostRod, "Frosted", "Cold, cold heart", "Empowers ice-based magic");
		add("material.constructs_casting.exilite.armor", "Protects against damage inflicted by spells.");
		addMaterial(CCMaterials.hogskin, "Arcane Hide", "", "");
		addMaterial(CCMaterials.rainbowSlime, "Rainbowslime", "How are you seeing this?", "Happy pride month!");
		addModifier(CCModifiers.CASTING.getId(), "Casting", "Not for fish, unfortunately.", "Allows the tool to cast spells on right click.");
		addModifier(CCModifiers.SWIFTCASTING, "Swiftcasting", "Run 'n' Gun!", "Allows the user to retain their full movement speed while casting spells.");
		add("constructs_casting.modifier.swiftcasting.requirement", "Requires the Casting ability to be applied first.");
		addModifier(CCModifiers.IMBUED.getId(), "Imbued", "", "Allows the tool to be imbued with a spell. Disallowed on swords, since they can already be imbued.");
		addModifier(CCModifiers.ENCYCLOPEDIC.getId(), "Encyclopedic", "Well read", "Allows the Slimy Spell Book to function as an encyclopedia.");

		addModifier(CCModifiers.ARCANE, "Arcane" ,"Mana-licious!", "Grants +25 max mana.");
		addModifier(CCModifiers.ANTIMAGIC.getId(), "Antimagic", "Self-explanatory.", "Grants +2 damage against magic users.");
		add("modifier.constructs_casting.antimagic.damage_boost", "Antimagic Damage");
		addModifier(CCModifiers.SPELL_PROTECTION, "Spell Protection", "Diabolical!", "Grants +10% resistance against spells. (Different from Magic Protection)");
		add("modifier.constructs_casting.spell_protection.resistance", "Spell Resistance");
		addModifier(CCModifiers.ANTIFROST.getId(), "Antifrost", "Don't drink it!", "Grants +3 damage per level to frozen targets.");
		add("modifier.constructs_casting.antifrost.damage_boost", "Antifrost Damage");
		addModifier(CCModifiers.SPELLBOUND, "Spellbound", "Jack of all trades!", "Grants +7.5% power to all types of spells.");

		addModifier(CCModifiers.MANA_UPGRADE, "Mana Upgrade", "Mana-rific!", "Grants +80 max mana.");
		addModifier(CCModifiers.COOLDOWN_UPGRADE, "Cooldown Upgrade", "I am speed!", "Grants +8% Cooldown Reduction.");
		addModifier(CCModifiers.FIRE_UPGRADE, "Fire Upgrade", "Hot hot hot!", "Grants +5% Fire Spell Power.");
		addModifier(CCModifiers.ICE_UPGRADE, "Ice Upgrade", "Ice ice baby!", "Grants +5% Ice Spell Power.");
		addModifier(CCModifiers.LIGHTNING_UPGRADE, "Lightning Upgrade", "Electrifying!", "Grants +5% Lightning Spell Power.");
		addModifier(CCModifiers.ENDER_UPGRADE, "Ender Upgrade", "Space-y!", "Grants +5% Ender Spell Power.");
		addModifier(CCModifiers.HOLY_UPGRADE, "Holy Upgrade", "Great heavens!", "Grants +5% Holy Spell Power.");
		addModifier(CCModifiers.BLOOD_UPGRADE, "Blood Upgrade", "Bloody hell!", "Grants +5% Blood Spell Power.");
		addModifier(CCModifiers.EVOCATION_UPGRADE, "Evocation Upgrade", "Hrmmm?", "Grants +5% Evocation Spell Power.");
		addModifier(CCModifiers.NATURE_UPGRADE, "Nature Upgrade", "All natural!", "Grants +5% Nature Spell Power.");
		addModifier(CCModifiers.ELDRITCH_UPGRADE, "Eldritch Upgrade", "Man-made modifiers beyond your comprehension", "Grants +5% Eldritch Spell Power");



		addFluid(CCFluids.arcaneEssence, "Arcane Essence");
		addFluid(CCFluids.fireEssence, "Fire Essence");
		addFluid(CCFluids.iceEssence, "Ice Essence");
		addFluid(CCFluids.lightningEssence, "Lightning Essence");
		addFluid(CCFluids.enderEssence, "Ender Essence");
		addFluid(CCFluids.holyEssence, "Holy Essence");
		addFluid(CCFluids.bloodEssence, "Blood Essence");
		addFluid(CCFluids.evocationEssence, "Evocation Essence");
		addFluid(CCFluids.natureEssence, "Nature Essence");


		addFluid(CCFluids.liquidLightning, "Lightning");
		addFluid(CCFluids.liquidDivinity, "Divinity");
		addFluid(CCFluids.potatoStew, "Potato Stew");
		addFluid(CCFluids.poisonousPotatoStew, "Poisonous Potato Stew");
		addFluid(CCFluids.moltenArcanium, "Molten Arcanium");
		addFluid(CCFluids.moltenExilite, "Molten Exilite");

		addFluid(CCFluids.squidInk, "Squid Ink");
		addFluid(CCFluids.commonInk, "Common Ink");
		addFluid(CCFluids.uncommonInk, "Uncommon Ink");
		addFluid(CCFluids.rareInk, "Rare Ink");
		addFluid(CCFluids.epicInk, "Epic Ink");
		addFluid(CCFluids.legendaryInk, "Legendary Ink");

		addItem(CCItems.potatoStewBowl, "Potato Stew");
		addItem(CCItems.poisonousPotatoStewBowl, "Poisonous Potato Stew");

		addItem(CCItems.exiliteIngot, "Exilite Ingot");
		addItem(CCItems.exiliteNugget, "Exilite Nugget");
		addItem(CCItems.exiliteReinforcement, "Exilite Reinforcement");

		addItem(CCItems.travellersSpellbook, "Traveller's Spell Book");
		addItem(CCItems.platedSpellbook, "Plated Spell Book");
		addItem(CCItems.slimySpellbook, "Slimy Spell Book");
		addItem(CCItems.eldritchStaff, "Sculk Staff");
//		addItem(CCItems.arcaniumApple, "Arcanium Apple");

		add("gui.constructs_casting.fluid.bottle", "%s Bottles");

		addItem(CCItems.wizardslimeBall, "Wizardslime Ball");
		add("school.constructs_casting.slime", "Slime");
		addSpell(CCSpells.FREEZE_SPELL, "Freeze", "Rapidly cools down the targeted Casting Table or Basin, instantly finishing the casting process. Only works on molten metals.");
		add("spell.constructs_casting.freeze.invalid_target", "Invalid target!");
//		addSpell(CCSpells.SLIMEBALL_SPELL, "Slimeball", "Lobs a random slimeball, capable of bouncing off of blocks and enemies alike. The higher level, the bouncier.");
		add("ui.constructs_casting.slimeball.max_bounces", "%s Bounces");
		add("ui.constructs_casting.enderference_anti_teleport", "Your current affliction prevents you from teleporting...");
//		addSpell(CCSpells.SLING_SPELL, "Sling", "Launches player in the opposite direction that they are looking.");

	}

	public void addMaterial(MaterialId material, String name, String flavour, String desc) {
		String id = material.getPath();
		add("material.constructs_casting." + id, name);
		if (!flavour.isEmpty())
			add("material.constructs_casting." + id + ".flavor", flavour);
		if (!desc.isEmpty())
			add("material.constructs_casting." + id + ".encyclopedia", desc);
	}

	public void addModifier(ModifierId modifier, String name, String flavour, String desc) {
		String id = modifier.getPath();
		add("modifier.constructs_casting." + id, name);
		add("modifier.constructs_casting." + id + ".flavor", flavour);
		add("modifier.constructs_casting." + id + ".description", desc);
	}

	public void addFluid(FluidObject<?> fluid, String name) {
		add("fluid_type.constructs_casting." + fluid.getId().getPath(), name);
		add("item.constructs_casting." + fluid.getId().getPath() + "_bucket", name + " Bucket");
	}
	public void addSpell(Supplier<AbstractSpell> spell, String name, String desc) {
		add("spell.constructs_casting." + spell.get().getSpellName(), name);
		add("spell.constructs_casting." + spell.get().getSpellName() + ".guide", desc);
	}
}
