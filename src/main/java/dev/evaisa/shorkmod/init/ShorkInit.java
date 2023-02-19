package dev.evaisa.shorkmod.init;

import dev.evaisa.shorkmod.blocks.*;
import dev.evaisa.shorkmod.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ShorkInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ShorkMain.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ShorkMain.MOD_ID);

    private static <T extends Block>RegistryObject<T> registerCuddlyBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerCuddlyItem(name, toReturn, tab);
        return toReturn;
    };

    private static <T extends Block>RegistryObject<Item> registerCuddlyItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ITEMS.register(name, () -> new CuddlyItem(block.get(), new Item.Properties().tab(tab), "block.shorkmod.blahaj.tooltip"));
    };



    public static final RegistryObject<Block> BLUE_SHORK = registerCuddlyBlock("blue_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> RED_SHORK = registerCuddlyBlock("red_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> GREEN_SHORK = registerCuddlyBlock("green_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> YELLOW_SHORK = registerCuddlyBlock("yellow_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> ORANGE_SHORK = registerCuddlyBlock("orange_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> PURPLE_SHORK = registerCuddlyBlock("purple_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> PINK_SHORK = registerCuddlyBlock("pink_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> BLACK_SHORK = registerCuddlyBlock("black_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> WHITE_SHORK = registerCuddlyBlock("white_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> BROWN_SHORK = registerCuddlyBlock("brown_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> GRAY_SHORK = registerCuddlyBlock("gray_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> CYAN_SHORK = registerCuddlyBlock("cyan_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> BLUE2_SHORK = registerCuddlyBlock("blue2_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> LIME_SHORK = registerCuddlyBlock("lime_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> MAGENTA_SHORK = registerCuddlyBlock("magenta_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> LIGHT_GRAY_SHORK = registerCuddlyBlock("light_gray_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> TRANS_SHORK = registerCuddlyBlock("trans_shark", () -> new CuddlyBlock(BlockBehaviour.Properties.of(Material.WOOL).strength(0.8F)), CreativeModeTab.TAB_MISC);


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }

}


