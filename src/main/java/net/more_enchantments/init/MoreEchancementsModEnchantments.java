
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.more_enchantments.init;

import net.more_enchantments.enchantment.MinerEnchantment;
import net.more_enchantments.enchantment.CriticalStrikeEnchantment;
import net.more_enchantments.MoreEchancementsMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class MoreEchancementsModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MoreEchancementsMod.MODID);
	public static final RegistryObject<Enchantment> CURSE_OF_STONE = REGISTRY.register("curse_of_stone", () -> new MinerEnchantment());
	public static final RegistryObject<Enchantment> CRITICAL_STRIKE = REGISTRY.register("critical_strike", () -> new CriticalStrikeEnchantment());
}
