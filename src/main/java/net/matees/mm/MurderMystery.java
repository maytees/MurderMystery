package net.matees.mm;

import me.kodysimpson.simpapi.command.CommandManager;
import net.matees.mm.commands.game.StartGame;
import org.bukkit.plugin.java.JavaPlugin;

public final class MurderMystery extends JavaPlugin {

    private static MurderMystery plugin;
    private Game game;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        game = new Game();

        try {
            CommandManager.createCoreCommand(this,
                    "murdermystery",
                    "game i guess",
                    "/murdermystery <command>",
                    null,
                    StartGame.class);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MurderMystery getPlugin() {
        return plugin;
    }

    public Game getGame() {
        return this.game;
    }
}
