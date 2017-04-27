package game;

import java.util.Random;

public class Pacman {

	private int xPosPacman;
	private int yPosPacman;
	private int xPosGhost;
	private int yPosGhost;
	private int numberOfCheeses;
	private State status;
	
	private static final int RADIUS = 15;
	private static final int GAME_SIZE = 250;
	
	public Pacman(int xPosition, int yPosition){
		Random rand = new Random();
		this.xPosPacman = xPosition;
		this.yPosPacman = yPosition;
		this.xPosGhost = rand.nextInt(GAME_SIZE) + xPosPacman + RADIUS;
		this.yPosGhost = rand.nextInt(GAME_SIZE) + yPosPacman + RADIUS;
		numberOfCheeses = 200;
		status = State.EAT;
	}
	
	public void eatingCheese(){
		if(cheeseIsOver()){
			status = State.SUCCESS;
			return;
		}
		if(haveGhostArround()){
			status = State.RUNNAWAY;
			return;
		}
		xPosPacman++;
		yPosPacman++;
		xPosGhost--;
		yPosGhost--;
		numberOfCheeses--;
	}
	
	public void runnawayFromGhost(){
		if(isGhostGotcha()){
			status = State.GAMEOVER;
			return;
		}
		if(!haveGhostArround()){
			status = State.EAT;
			return;
		}
		
		if(xPosPacman < 0){
			xPosPacman--;
		}
		else{
			xPosPacman = GAME_SIZE;
		}
		
		if(yPosPacman < 0){
			yPosPacman--;
		}
		else{
			yPosPacman = GAME_SIZE;
		}
		
	}
	
	private boolean cheeseIsOver(){
		if(numberOfCheeses > 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	private boolean haveGhostArround(){
		if(xPosPacman + RADIUS >= xPosGhost || yPosPacman + RADIUS >= yPosGhost){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean isGhostGotcha(){
		if(xPosPacman == xPosGhost && yPosPacman == yPosGhost){
			return true;
		}
		else{
			return false;
		}
	}
}
