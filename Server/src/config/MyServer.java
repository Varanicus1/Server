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
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  

		//Input
		String strenemy = "", strenemyx = "", strenemyy = "";
		char x = 'x';
		
		//Output
		String strserverx="",strservery="";
		int tmpserverx=0,tmpservery=0;
		
		while (!strenemy.equals("stop")) {
			
			//Input
			strenemy = din.readUTF();
			if (x == strenemy.charAt(0)) {
				
				strenemyx = strenemy.substring(1);
				Var.enemyx=Integer.parseInt(strenemyx);
				
				System.out.println("X: " + strenemyx);
			} else {
				strenemyy = strenemy.substring(1);
				Var.enemyy=Integer.parseInt(strenemyy);
				System.out.println("Y: " + strenemyy);
			}

			//Output
			strserverx = Integer.toString(Var.serverx);
			strserverx = "x" + strserverx;
			
			if(tmpserverx != Var.serverx) {
				dout.writeUTF(strserverx);
				dout.flush();
			}
			tmpserverx=Var.serverx;
			
			strservery = Integer.toString(Var.servery);
			strservery = "y" + strservery;
			
			if(tmpservery != Var.servery) {
			dout.writeUTF(strservery);
			dout.flush();
			}
			tmpservery=Var.servery;
			
		}
		din.close();
		dout.close();
		s.close();
		ss.close();
	}
}
