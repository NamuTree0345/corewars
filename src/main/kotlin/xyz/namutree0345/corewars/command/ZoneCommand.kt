package xyz.namutree0345.corewars.command

import com.destroystokyo.paper.block.TargetBlockInfo
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import xyz.namutree0345.corewars.plugin
import java.io.File

class ZoneCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender.isOp) {
            if(args.isNotEmpty()) {
                plugin.config.set(args[0], (sender as Player).getTargetBlock(4, TargetBlockInfo.FluidMode.NEVER)?.location)
                plugin.config.save(File("plugins/corewars-config.yml"))
                sender.sendMessage(Component.text("성공적으로 ", NamedTextColor.GREEN)
                    .append(Component.text(args[0], NamedTextColor.GOLD, TextDecoration.BOLD))
                    .append(Component.text(" 값이 설정되었습니다!", NamedTextColor.GREEN)))
            }
        }
        return true
    }

    companion object {
        class ZoneCommandTabCompleter : TabCompleter {
            override fun onTabComplete(
                sender: CommandSender,
                command: Command,
                alias: String,
                args: Array<out String>
            ): MutableList<String> {
                return mutableListOf("team1", "team2", "team3", "team4", "team1gen", "team2gen", "team3gen", "team4gen")
            }

        }
    }
}