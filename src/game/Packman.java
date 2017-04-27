package game;

public class Packman {

	private int xPosPacman;
	private int yPosPacman;
	private int xPosGhost;
	private int yPosGhost;
	private int numberOfCheeses;
	private static final int RADIUS = 15;
	private State status;
	
	public Packman(int xPosition, int yPosition){
		this.xPosPacman = xPosition;
		this.yPosPacman = yPosition;
		numberOfCheeses = 200;
		status = State.EAT;
	}
	
	public void eatingCheese(){
		if(cheeseIsOver()){
			status = State.SUCCESS;
			return;
		}		
		xPosPacman++;
		yPosPacman++;
		numberOfCheeses--;
	}
	
	public void runnawayFromGhost(){
		
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
		return false;
	}
	
	public void goRight(){
		System.out.println("eat eat eat right");
	}
	
	public void goLeft(){
		System.out.println("eat eat eat left");
	}
	
	public void goUp(){
		System.out.println("eat eat eat up");
	}
	
	public void goDown(){
		System.out.println("eat eat eat down");
	}
}
