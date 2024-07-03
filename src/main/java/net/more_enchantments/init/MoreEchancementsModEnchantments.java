
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.more_enchantments.init;

import net.more_enchantments.enchantment.MinerEnchantment;
import net.more_enchantments.enchantment.FreezingHitEnchantment;
import net.more_enchantments.enchantment.CriticalStrikeEnchantment;
import net.more_enchantments.enchantment.CombustingMinerEnchantment;
import net.more_enchantments.enchantment.AdaptationEnchantment;
import net.more_enchantments.MoreEchancementsMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class MoreEchancementsModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MoreEchancementsMod.MODID);
	public static final RegistryObject<Enchantment> CURSE_OF_STONE = REGISTRY.register("curse_of_stone", () -> new MinerEnchantment());
	public static final RegistryObject<Enchantment> CRITICAL_STRIKE = REGISTRY.register("critical_strike", () -> new CriticalStrikeEnchantment());
	public static final RegistryObject<Enchantment> FREEZING_HIT = REGISTRY.register("freezing_hit", () -> new FreezingHitEnchantment());
	public static final RegistryObject<Enchantment> ADAPTATION = REGISTRY.register("adaptation", () -> new AdaptationEnchantment());
	public static final RegistryObject<Enchantment> COMBUSTING_MINER = REGISTRY.register("combusting_miner", () -> new CombustingMinerEnchantment());
}
