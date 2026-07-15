package com.angelwings.mod;

import com.angelwings.mod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod(AngelWingsMod.MODID)
public class AngelWingsMod {

    public static final String MODID = "angelwings";

    public AngelWingsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registra todos los items (las 7 alas de colores) en el bus de eventos del mod
        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    // Añade nuestros items a la pestaña de creativo de "Combate" (junto a armaduras/elytra vanilla)
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            ModItems.ITEMS.getEntries().forEach(item -> event.accept(item.get()));
        }
    }
}
