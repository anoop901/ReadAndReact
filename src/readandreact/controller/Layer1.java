/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readandreact.controller;

import java.util.ArrayList;
import readandreact.model.Player;
import readandreact.model.PlayerPosition;
import readandreact.view.BasketballCourt;

/**
 *
 * @author anoop
 */
public class Layer1 extends Layer {
	
	private Player userControlledPlayer;
	private ArrayList<Player> cpuPlayers;
	private BasketballCourt court;
	
	public Layer1() {
		this.cpuPlayers = new ArrayList<Player>();
		for (PlayerPosition pos : PlayerPosition.values()) {
			if (pos == PlayerPosition.POINT_GUARD)
				userControlledPlayer = new Player(pos, false, true);
			else
				cpuPlayers.add(new Player(pos, false, false));
		}
		
		this.court = new BasketballCourt(this);
	}
	
	public BasketballCourt getCourt() {
		return court;
	}

	@Override
	public ArrayList<Player> getCpuPlayers() {
		return cpuPlayers;
	}

	@Override
	public Player getUserPlayer() {
		return userControlledPlayer;
	}
}
