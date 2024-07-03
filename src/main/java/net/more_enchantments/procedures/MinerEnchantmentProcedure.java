package net.more_enchantments.procedures;

import net.more_enchantments.init.MoreEchancementsModEnchantments;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MinerEnchantmentProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		ItemStack CurrentItemInHand = ItemStack.EMPTY;
		CurrentItemInHand = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (EnchantmentHelper.getItemEnchantmentLevel(MoreEchancementsModEnchantments.CURSE_OF_STONE.get(), CurrentItemInHand) != 0) {
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Blocks.COBBLESTONE).copy();
				_setstack.setCount((int) Mth.nextDouble(RandomSource.create(), 12, 24));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
