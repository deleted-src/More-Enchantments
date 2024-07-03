package net.more_enchantments.procedures;

import net.more_enchantments.init.MoreEchancementsModEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CombustingEnchantProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer(), event.getExpToDrop());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double xpAmount) {
		execute(null, world, x, y, z, entity, xpAmount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double xpAmount) {
		if (entity == null)
			return;
		ItemStack ITEMUSED = ItemStack.EMPTY;
		ITEMUSED = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (xpAmount == 0 && EnchantmentHelper.getItemEnchantmentLevel(MoreEchancementsModEnchantments.COMBUSTING_MINER.get(), ITEMUSED) != 0) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(ITEMUSED.getItem(), 120);
		}
	}
}
