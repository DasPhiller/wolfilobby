package de.philgamer.commands

import net.axay.kspigot.chat.KColors
import net.axay.kspigot.extensions.bukkit.heal
import net.axay.kspigot.extensions.bukkit.kick
import net.axay.kspigot.extensions.onlinePlayers
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class KickCommand : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            return true
        }
        val player:Player = sender
        if (args.size == 1) {
            val target = Bukkit.getPlayer(args[0])
            if (target == null) {
                player.sendMessage("${KColors.RED}Der Spieler ist nicht online")
            } else
            target.kickPlayer("${KColors.RED}Du wurdest gekickt")
            player.sendMessage("${KColors.GREEN}${target?.name} wurde gekickt!")
        } else {
            player.sendMessage("${KColors.RED}Bitte benutze /kick <player> <reason>")
        }
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>? {
        val list = ArrayList<String>()
        if (args.isEmpty()) return list

        if (args.size == 1) {

            onlinePlayers.forEach {
                list.add(it.name)
            }
        }
        val completer = ArrayList<String>()
        val current = args[args.size - 1]
        list.forEach() {
            if (it.startsWith(current))
                completer.add(it)
        }

        return completer
    }
}