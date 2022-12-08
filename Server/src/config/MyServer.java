package config;

import java.net.*;

import game.Player;
import gui.Gui;

import java.io.*;

public class MyServer {
	public static void main(String args[]) throws Exception {
        new Gui();
        new Var();
        new Player();

		ServerSocket ss = new ServerSocket(3333);
		Socket s = ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());

		String str = "", strx = "", stry = "";
		int vx=0, vy=0;
		char x = 'x';
		
		while (!strx.equals("stop")) {
			str = din.readUTF();
			if (x == str.charAt(0)) {
				
				strx = str.substring(1);
				vx=Integer.parseInt(strx);
				Var.x=vx;
				System.out.println("X: " + strx);
			} else {
				stry = str.substring(1);
				vy=Integer.parseInt(stry);
				Var.y=vy;
				System.out.println("Y: " + stry);
			}

		}
		din.close();
		s.close();
		ss.close();
	}
}
