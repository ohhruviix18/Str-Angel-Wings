package com.angelwings.mod.item;

import com.angelwings.mod.AngelWingsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * Alas de Angel: heredan de ElytraItem, por lo que el juego las trata exactamente
 * como un elytra vanilla en todo lo importante:
 *  - Vuelo planeado (LivingEntity#checkFallFlying comprueba "item instanceof ElytraItem")
 *  - Animación del modelo al volar
 *  - Pueden encantarse con Unbreaking y Mending igual que el elytra vanilla (categoria
 *    de encantamiento "rompible" por tener durabilidad, se aplican en yunque combinando
 *    con libro encantado, o en mesa de encantar)
 *  - Se desgastan (pierden durabilidad) igual que un elytra normal
 *
 * Lo unico que cambiamos es: la textura que se dibuja en la espalda (una por color),
 * el nombre/registro de cada variante y que se puedan reparar en el yunque con plumas.
 */
public class AngelWingsItem extends ElytraItem {

    private final String colorName;

    public AngelWingsItem(String colorName, Properties properties) {
        super(properties);
        this.colorName = colorName;
    }

    // Permite reparar las alas en el yunque usando plumas (ademas de Mending, que ya funciona solo)
    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Items.FEATHER);
    }

    // Textura que se renderiza en la espalda del jugador al volar/equipar.
    // Debe existir el archivo: assets/angelwings/textures/entity/elytra/<colorName>.png (64x32)
    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, Entity entity) {
        return new ResourceLocation(AngelWingsMod.MODID, "textures/entity/elytra/" + colorName + ".png");
    }

    public String getColorName() {
        return colorName;
    }
}
