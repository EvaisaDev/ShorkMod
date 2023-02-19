package dev.evaisa.shorkmod.datagen;

import dev.evaisa.shorkmod.ShorkMain;
import dev.evaisa.shorkmod.util.ModItemTagsProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDatagen {

    @SubscribeEvent
    public static void datagen(GatherDataEvent event) {
        BlockTagsProvider blocktagsprovider = new BlockTagsProvider(event.getGenerator(), ShorkMain.MOD_ID, event.getExistingFileHelper());
        event.getGenerator().addProvider(new ModItemTagsProvider(event.getGenerator(), blocktagsprovider, event.getExistingFileHelper()));
    }

}