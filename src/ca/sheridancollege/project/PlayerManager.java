/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doria
 */
    public class PlayerManager {
    private static List<Player> players;
    private static PlayerManager instance;

    private PlayerManager() {
        this.players = new ArrayList<>();
    }
    public static PlayerManager getInstance() {
        if (instance == null) {
            instance = new PlayerManager();
        }
            return instance;
    }

    public static List<Player> getPlayers() {
        return players;
    }
    public void flush() {
        this.players = new ArrayList<>();
    }
    //adding new players to the list
    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static void removePlayer(String playerName) {
        // Remove player by name logic
        players.removeIf(p -> p.getName().equalsIgnoreCase(playerName));
    }
    
    public static Player getPlayer(int index) {
        if(index >= 0 && index < players.size()){
            return players.get(index);
        }
        return null;
    } 
}
