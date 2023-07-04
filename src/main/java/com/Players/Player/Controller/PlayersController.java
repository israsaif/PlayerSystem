package com.Players.Player.Controller;
import com.Players.Player.Model.Player;
import com.Players.Player.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "api/p1/Player")
public class PlayersController {

    @Autowired
    PlayerService playerService;


    @PostMapping//create
   public Player createPlayer(@RequestBody Player addPlayer) {

        return playerService.createPlayer(addPlayer);
    }

    @GetMapping//GetAll
    public List<Player> getPlayerInformation() {
        return playerService.getAllPlayers();
    }

    @GetMapping(path = "{id}")
    public Player getPlayerInformation(@PathVariable(name = "id") String id) { //

        return playerService.getPlayerInformation(id);
    }

    @PutMapping(path = "{id}")
    public Player updatePlayerInformation(@PathVariable(name="id") String id, @RequestBody Player incomingupdatePlayer){

        return playerService.updatePlayerInformation(id,incomingupdatePlayer);
    }

    @DeleteMapping(path = "{id}")
     public   Player deletePlayer(@PathVariable(name = "id")String id){

        return playerService.deletePlayer(id);

    }

}