
package net.mcreator.hatsmpcustomitemsandblocks.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.hatsmpcustomitemsandblocks.item.ChaosFuelItemItem;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;

@HatSmpModElements.ModElement.Tag
public class ChaosFuelFuel extends HatSmpModElements.ModElement {
	public ChaosFuelFuel(HatSmpModElements instance) {
		super(instance, 30);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(ChaosFuelItemItem.block, (int) (1)).getItem())
			event.setBurnTime(2000);
	}
}
