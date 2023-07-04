package com.Players.Player.Services;

import com.Players.Player.Model.Player;
import com.Players.Player.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PlayerService {


    private CopyOnWriteArrayList<Player> listOfPlayers = new CopyOnWriteArrayList<>();


    @Autowired
    private PlayerRepository playerRepository;



    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }


    public Player getPlayerInformation(String playerId) {
        Player foundPlayer = null;
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if (optionalPlayer.isPresent()) {
            foundPlayer = optionalPlayer.get();
        }
        return foundPlayer;
    }



    public  Player createPlayer(@RequestBody Player addPlayer) {
        playerRepository.save(addPlayer);
        return new Player();

    }


    public Player updatePlayerInformation(@PathVariable(name="id") String incomingId, @RequestBody Player incomingupdatePlayer) {
        Player currentPlayer = getPlayerInformation(incomingId);
        currentPlayer.name = incomingupdatePlayer.name;
        return  playerRepository.save(currentPlayer);
    }


      public Player deletePlayer(@PathVariable(name = "id")String id){
        Player currentPlayer = getPlayerInformation(id);
          playerRepository.delete(currentPlayer);
        return currentPlayer;

    }



}
