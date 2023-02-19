package dev.evaisa.shorkmod.util;

import dev.evaisa.shorkmod.*;
import dev.evaisa.shorkmod.init.ShorkInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ShorkMain.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		// loop through ShorkInit.BLOCKS
        // set the render layer of each block to cutout
        ShorkInit.BLOCKS.getEntries().forEach(block -> {
            ShorkMain.LOGGER.info("Registering render layer for " + block.get().getRegistryName());
            ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.cutout());
        });
	}
}