package xyz.namutree0345.corewars.command

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import xyz.namutree0345.corewars.team1
import xyz.namutree0345.corewars.team2
import xyz.namutree0345.corewars.team3
import xyz.namutree0345.corewars.team4

class SetTeamCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(args.size >= 2) {
            when(args[0]) {
                "team1" -> team1?.addEntry(args[1]);
                "team2" -> team2?.addEntry(args[1]);
                "team3" -> team3?.addEntry(args[1]);
                "team4" -> team4?.addEntry(args[1]);
            }
sender.sendMessage(Component.text("${args[0]}, ${args[1]}"))
        }
        return true
    }
}