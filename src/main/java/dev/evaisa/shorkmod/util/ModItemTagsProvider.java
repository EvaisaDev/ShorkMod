package dev.evaisa.shorkmod.util;

import dev.evaisa.shorkmod.ShorkMain;
import dev.evaisa.shorkmod.init.ShorkInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
	
	public static TagKey<Item> SHORKS = ItemTags.create(new ResourceLocation(ShorkMain.MOD_ID, "shorks"));
	
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, ShorkMain.MOD_ID, existingFileHelper);
    }
    
	@Override
	protected void addTags() {
		ShorkInit.ITEMS.getEntries().forEach(item -> {
			this.tag(SHORKS).add(item.get());
		});
	}
}