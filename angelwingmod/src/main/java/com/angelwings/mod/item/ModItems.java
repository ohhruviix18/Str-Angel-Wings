package com.angelwings.mod.item;

import com.angelwings.mod.AngelWingsMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AngelWingsMod.MODID);

    // Durabilidad igual que un elytra vanilla (432). Cambiala aqui si quieres que aguanten mas o menos.
    private static final int DURABILITY = 432;

    private static RegistryObject<Item> register(String colorName) {
        return ITEMS.register(colorName + "_angel_wings", () -> new AngelWingsItem(colorName,
                new Item.Properties()
                        .stacksTo(1)
                        .durability(DURABILITY)
                        .rarity(Rarity.RARE)
                        .fireResistant()));
    }

    public static final RegistryObject<Item> WHITE_ANGEL_WINGS  = register("white");
    public static final RegistryObject<Item> RED_ANGEL_WINGS    = register("red");
    public static final RegistryObject<Item> BLUE_ANGEL_WINGS   = register("blue");
    public static final RegistryObject<Item> GREEN_ANGEL_WINGS  = register("green");
    public static final RegistryObject<Item> PURPLE_ANGEL_WINGS = register("purple");
    public static final RegistryObject<Item> BLACK_ANGEL_WINGS  = register("black");
    public static final RegistryObject<Item> GOLD_ANGEL_WINGS   = register("gold");
}
