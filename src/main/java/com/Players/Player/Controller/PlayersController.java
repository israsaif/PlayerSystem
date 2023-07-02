package com.Players.Player.Controller;
import com.Players.Player.Model.Player;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(value = "api/p1/Player")
public class PlayersController {


    CopyOnWriteArrayList<Player> listOfPlayers = new CopyOnWriteArrayList<>();

    @PostMapping//create
    Player createPlayer(@RequestBody Player addPlayer) {
        listOfPlayers.add(addPlayer);
        return new Player();
    }

    @GetMapping//GetAll
    List<Player> getPlayerInformation() {
        return listOfPlayers;
    }

    @GetMapping(path = "{id}")
    Player getPlayerInformation(@PathVariable(name = "id") String incomingId) { //
        Player currentPlayer = listOfPlayers.stream().filter((currPlayer) -> {
            return currPlayer.id.equals(incomingId);
        }).findAny().get();
        return currentPlayer;
    }

    @PutMapping(path = "{id}")
    Player updatePlayerInformation(@PathVariable(name="id") String incomingId, @RequestBody Player incomingupdatePlayer){
        Player currentPlayer =getPlayerInformation(incomingId);
        currentPlayer.name = incomingupdatePlayer.name;
        return new Player();
    }

    @DeleteMapping(path = "{id}")
    Player deletePlayer(@PathVariable(name = "id")String id){
        Player currentPlayer = getPlayerInformation(id);
        listOfPlayers.remove(currentPlayer);
        return currentPlayer;

    }
}