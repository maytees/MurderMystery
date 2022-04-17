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
        System.out.println("prepared murderer");
    }

    public List<Player> getNormalPlayers() {
        return normalPlayers;
    }

    public void setNormalPlayers(List<Player> normalPlayers) {
        this.normalPlayers = normalPlayers;
    }

    public List<Player> getSpectators() {
        return spectators;
    }

    public void setSpectators(List<Player> spectators) {
        this.spectators = spectators;
    }

    public List<Player> getInnocents() {
        return innocents;
    }

    public void setInnocents(List<Player> innocents) {
        this.innocents = innocents;
    }

    public Player getMurderer() {
        return murderer;
    }

    public void setMurderer(Player murderer) {
        this.murderer = murderer;
    }

    public Player getDetective() {
        return detective;
    }

    public void setDetective(Player detective) {
        this.detective = detective;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    private void prepareDetective(Player detective) {
        this.detective = detective;
        normalPlayers.remove(detective);
        System.out.println("Prepared detective");
    }

    private void prepareInnocents() {
        this.innocents.addAll(this.normalPlayers);
        System.out.println("Prepared innocents");
    }
}
