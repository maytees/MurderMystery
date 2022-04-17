package net.matees.mm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
            // Set the murderer
            prepareMurderer(choseRandomPlayer(normalPlayers));

            // Set the detective
            prepareDetective(choseRandomPlayer(normalPlayers));

            // Set the innocents
            prepareInnocents();
        }
    }

    public void endGame() {

    }

    private Player choseRandomPlayer(List<Player> listToChooseFrom) {
        Random rand = new Random();
        return listToChooseFrom.get(rand.nextInt(listToChooseFrom.size()));
    }

    private void prepareMurderer(Player murderer) {
        this.murderer = murderer;
        normalPlayers.remove(murderer);
    }

    private void prepareDetective(Player detective) {
        this.detective = detective;
        normalPlayers.remove(detective);
    }

    private void prepareInnocents() {
        this.innocents.addAll(this.normalPlayers);
    }
}
