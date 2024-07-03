package net.more_enchantments.procedures;

import net.more_enchantments.init.MoreEchancementsModEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AdaptationEnchantmentProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		ItemStack ITEMSTACK = ItemStack.EMPTY;
		double HEALTH = 0;
		double DAMAGE = 0;
		ITEMSTACK = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		HEALTH = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
		DAMAGE = amount;
		if (EnchantmentHelper.getItemEnchantmentLevel(MoreEchancementsModEnchantments.ADAPTATION.get(), ITEMSTACK) != 0 && amount > 1 && ITEMSTACK.getItem() == Items.TOTEM_OF_UNDYING) {
			if (HEALTH > 2) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) (HEALTH + DAMAGE * 0.75));
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("more_echancements:you_can_see_it"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}
