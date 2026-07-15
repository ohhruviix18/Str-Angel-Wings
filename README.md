# Angel Wings (mod de Minecraft Forge 1.20.1)

Alas de ángel craftables con **plumas + diamante** (+ tinte para el color), que
funcionan exactamente como un elytra vanilla: se equipan en el pecho, planeas
igual, se desgastan con el uso, y se pueden encantar con **Unbreaking** y
**Mending** en el yunque (igual que el elytra normal).

## Qué incluye

- 7 variantes de color: blanca, roja, azul, verde, morada, negra y dorada.
- Cada una es su propio ítem (`angelwings:<color>_angel_wings`).
- Durabilidad 432 (igual que el elytra vanilla). Se puede ajustar en
  `ModItems.java` (constante `DURABILITY`).
- Reparables con **plumas** en el yunque, además de con **Mending**.
- Recetas de crafteo en `src/main/resources/data/angelwings/recipes/`.
- Texturas placeholder generadas por mí (ícono + textura de espalda). Están
  pensadas para que el mod funcione y se vea razonable; si quieres arte más
  detallado, solo hay que reemplazar los PNG (ver más abajo).

## Cómo funciona técnicamente

`AngelWingsItem` extiende `net.minecraft.world.item.ElytraItem` en vez de
reimplementar el vuelo a mano. Por eso:

- El chequeo de vuelo planeado de Minecraft (`item instanceof ElytraItem`)
  detecta a las alas automáticamente y activa el planeo real de elytra.
- La categoría de encantamiento "objeto con durabilidad" (la que usan
  Unbreaking y Mending) también se aplica automáticamente.
- Solo tuve que sobreescribir `getElytraTexture(...)` para que cada color
  cargue su propio PNG, y `isValidRepairItem(...)` para permitir reparar con
  plumas en el yunque.

## Receta (ejemplo, alas rojas)

```
F Y F      F = pluma
F D F      D = diamante
F F F      Y = tinte rojo
```

La blanca es igual pero sin el tinte (la casilla de arriba queda vacía).

## Opción rápida: compilar en la nube con GitHub (recomendado, no instalas nada)

Este proyecto ya incluye `.github/workflows/build.yml`, que compila el mod
automáticamente. Pasos:

1. Crea un repositorio nuevo en https://github.com (puede ser privado, es gratis).
2. Sube TODO el contenido de esta carpeta a ese repositorio (arrastra los
   archivos en la web de GitHub, o con `git init && git add . && git commit -m "mod" && git push`).
3. Entra a la pestaña **Actions** del repo. Se disparará solo un workflow
   llamado "Build Angel Wings mod" (tarda unos 3-5 minutos).
4. Cuando termine (tilde verde), entra al run, baja hasta **Artifacts** y
   descarga `angelwings-mod-jar`. Ahí dentro está el `.jar` compilado.
5. Copia ese `.jar` a la carpeta `mods` de tu servidor Forge 1.20.1 y reinicia.

## Compilar en tu propia máquina (necesitas internet en TU máquina, aquí no tengo acceso)

1. Instala **JDK 17** (Forge 1.20.1 lo requiere).
2. Abre esta carpeta con IntelliJ IDEA o VSCode, o desde terminal:
   ```
   ./gradlew build
   ```
   (En Windows: `gradlew.bat build`). La primera vez tarda porque Gradle
   descarga Forge y Minecraft — necesitas conexión a internet.
3. El .jar compilado queda en `build/libs/angelwings-1.0.0.jar`.
4. Cópialo a la carpeta `mods` de tu instalación de Forge 1.20.1.

> Nota: este proyecto no incluye el wrapper de Gradle (`gradlew`/`gradle-wrapper.jar`)
> porque no tengo acceso a internet para descargarlo. Dos opciones:
> - Abre la carpeta con IntelliJ IDEA + plugin de Forge/MDK y deja que genere el wrapper solo, o
> - Descarga el "Forge MDK 1.20.1" desde https://files.minecraftforge.net/,
>   copia su `gradlew`, `gradlew.bat` y carpeta `gradle/` a esta carpeta
>   (sin pisar mis archivos `build.gradle`/`settings.gradle`/`src`), y luego
>   corre `./gradlew build`.

## Personalizar

- **Más colores**: agrega una línea en `ModItems.java`, un JSON de receta,
  un modelo de ítem y una textura de elytra (mismo patrón que las demás).
- **Durabilidad**: cambia `DURABILITY` en `ModItems.java`.
- **Receta**: edita los JSON en `data/angelwings/recipes/`.
- **Arte mejor**: reemplaza los PNG en `assets/angelwings/textures/item/`
  (ícono 16x16) y `assets/angelwings/textures/entity/elytra/` (textura de
  espalda 64x32, mismo layout que `textures/entity/elytra.png` vanilla).
