package de.philgamer.guis

import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class AdminGUI {
    val gui = kSpigotGUI(GUIType.FIVE_BY_NINE) {

        val glass = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
        val glassMeta = glass.itemMeta
        glassMeta.setDisplayName("§5")
        glass.itemMeta = glassMeta

        val next = ItemStack(Material.GREEN_STAINED_GLASS_PANE)
        val nextMeta = next.itemMeta
        nextMeta.setDisplayName("§aNächste Seite")
        next.itemMeta = nextMeta

        val stop = ItemStack(Material.REDSTONE)
        val stopMeta = stop.itemMeta
        stopMeta.setDisplayName("§cStop")
        stop.itemMeta = stopMeta
        page(0) {
            placeholder(Slots.All, glass)
            nextPage(Slots.RowOneSlotNine, next)
            button(Slots.RowThreeSlotFive, stop) {
                it.player.performCommand("stop")
            }
        }
    }
}