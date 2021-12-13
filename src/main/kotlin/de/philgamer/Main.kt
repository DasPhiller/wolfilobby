package de.philgamer

import de.philgamer.commands.AdminCommand
import de.philgamer.commands.KickCommand
import de.philgamer.guis.AdminGUI
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
        getCommand("admin")?.setExecutor(AdminCommand())
        getCommand("kick")?.setExecutor(KickCommand())
    }

    override fun shutdown() {
        Bukkit.getConsoleSender().sendMessage("${KColors.RED}Plugin stopped")
    }
}