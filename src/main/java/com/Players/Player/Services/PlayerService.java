package com.Players.Player.Services;

import com.Players.Player.Model.Player;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PlayerService {


    private CopyOnWriteArrayList<Player> listOfPlayers = new CopyOnWriteArrayList<>();

    public List<Player> getAllPlayers(){
        return listOfPlayers;
    }


    public Player getPlayerInformation(String playerId){
        Player currentPlayer = listOfPlayers.stream().filter((currPlayer) -> {
            return currPlayer.id.equals(playerId);
        }).findAny().get();
        return currentPlayer;
    }

    public  Player createPlayer(@RequestBody Player addPlayer) {
        listOfPlayers.add(addPlayer);
        return new Player();

    }


    public Player updatePlayerInformation(@PathVariable(name="id") String incomingId, @RequestBody Player incomingupdatePlayer) {
        Player currentPlayer = getPlayerInformation(incomingId);
        currentPlayer.name = incomingupdatePlayer.name;
        return new Player();
    }


      public Player deletePlayer(@PathVariable(name = "id")String id){
        Player currentPlayer = getPlayerInformation(id);
        listOfPlayers.remove(currentPlayer);
        return currentPlayer;

    }



}
