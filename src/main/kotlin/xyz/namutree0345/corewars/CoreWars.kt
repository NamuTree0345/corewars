package xyz.namutree0345.corewars

import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.Team
import xyz.namutree0345.corewars.command.SetTeamCommand
import xyz.namutree0345.corewars.command.ZoneCommand
import xyz.namutree0345.corewars.listener.JoinListener

val plugin = JavaPlugin.getPlugin(CoreWars::class.java)

var sb: Scoreboard? = null
var team1: Team? = null
var team2: Team? = null
var team3: Team? = null
var team4: Team? = null

class CoreWars : JavaPlugin() {

    override fun onEnable() {
        sb = Bukkit.getScoreboardManager().newScoreboard
        team1 = sb?.registerNewTeam("team1")
        team1?.color(NamedTextColor.RED)
        team2 = sb?.registerNewTeam("team2")
        team2?.color(NamedTextColor.GOLD)
        team3 = sb?.registerNewTeam("team3")
        team3?.color(NamedTextColor.YELLOW)
        team4 = sb?.registerNewTeam("team4")
        team4?.color(NamedTextColor.GREEN)

        server.pluginManager.registerEvents(JoinListener(), this)

        getCommand("zone")?.apply {
            setExecutor(ZoneCommand())
            tabCompleter = ZoneCommand.Companion.ZoneCommandTabCompleter()
        }
        getCommand("setteam")?.setExecutor(SetTeamCommand())
    }

}