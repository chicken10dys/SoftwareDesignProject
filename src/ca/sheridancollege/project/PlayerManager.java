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
    private List<Player> players;

    public PlayerManager() {
        this.players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }
    //adding new players to the list
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        // Remove player by name logic
        players.removeIf(p -> p.getName().equalsIgnoreCase(playerName));
    }
    
    public Player getPlayer(int index) {
        if(index >= 0 && index < players.size()){
            return players.get(index);
        }
        return null;
    } 
}
