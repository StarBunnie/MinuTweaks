package net.minu.minutweaks.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minu.minutweaks.MinuTweaks;
import net.minu.minutweaks.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinuTweaks.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MINUTWEAKS_TAB = CREATIVE_MODE_TABS.register("minutweaks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZEPHYRITE.get()))
                    .title(Component.translatable("creativetab.minutweaks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ZEPHYRITE.get());
                        output.accept(ModBlocks.STONE_ZEPHYRITE_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
