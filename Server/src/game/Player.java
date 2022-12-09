package game;

import config.*;
import java.util.Timer;
import java.util.TimerTask;

//Bewegung des Spielers
public class Player {
	Timer move;

	public Player() {
		move = new Timer();
		move.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				if (Var.moveleft == true) {
					if (Var.serverx >= 1) {
						Var.serverx = Var.serverx - 1;
					}
				}
				else if (Var.moveright == true) {
					if (Var.serverx <= Var.screenwidth - 42) {
						Var.serverx = Var.serverx + 1; 
					}
				}
				else if (Var.moveup == true) {
					if (Var.servery >=1) {
						Var.servery = Var.servery - 1; 
					}
				}
				else if (Var.movedown == true) {
					if (Var.servery <= Var.screenheight - 66) {
						Var.servery = Var.servery + 1; 
					}
				}
			}

		}, 0, 6);

	}
}
