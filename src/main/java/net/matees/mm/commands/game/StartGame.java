package net.matees.mm.commands.game;

import me.kodysimpson.simpapi.command.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class StartGame extends SubCommand {
    @Override
    public String getName() {
        return "startgame";
    }

    @Override
    public List<String> getAliases() {
        return List.of("start");
    }

    @Override
    public String getDescription() {
        return "Start the game";
    }

    @Override
    public String getSyntax() {
        return "/startgame";
    }

    @Override
    public void perform(CommandSender commandSender, String[] strings) {

    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] strings) {
        return null;
    }
}
