package net.matees.mm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.random.*;

public class Game {

    private List<Player> normalPlayers = new ArrayList<>();
    private List<Player> spectators = new ArrayList<>();
    private List<Player> innocents = new ArrayList<>();
    private Player       murderer;
    private Player       detective;

    private boolean      gameStarted = false;

    private int          amountOfPlayers;

    public void startGame() {
        this.amountOfPlayers = Bukkit.getOnlinePlayers().size();
        this.gameStarted = true;
        this.normalPlayers.addAll(Bukkit.getOnlinePlayers());

        // Enough for innocents, murderers, and detectives
        if(amountOfPlayers >= 3) {

        }

        for(Player player : Bukkit.getOnlinePlayers()) {

        }
    }

    public void endGame() {

    }
}
