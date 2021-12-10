package de.philgamer

import de.philgamer.listener.JoinListener
import de.philgamer.listener.QuitListener
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.extensions.pluginManager
import net.axay.kspigot.main.KSpigot
import org.bukkit.Bukkit

class Main : KSpigot() {
    override fun startup() {
        Bukkit.getConsoleSender().sendMessage("${KColors.GREEN}Plugin started")
        pluginManager.registerEvents(JoinListener(), this)
        pluginManager.registerEvents(QuitListener(), this)
    }

    override fun shutdown() {
        Bukkit.getConsoleSender().sendMessage("${KColors.RED}Plugin stopped")
    }
}