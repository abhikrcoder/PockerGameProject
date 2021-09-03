

import java.util.List;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          String [] cards =new Cards().cardsDeck();
          Game game = new Game();
          //Shuffling cards
          List<String> newCards = game.ShuffleDeck(cards);
          Scanner sc=new Scanner(System.in);
  		System.out.println("Enter the number of player :  ");
  		int a=sc.nextInt();
                if(a==1 || a==2){
                    System.out.println("you have enter less than 2 so by default 2 player will play ");
                    a=2;
                }
  		System.out.println("How many rounds do want to play : ");
  		int round = sc.nextInt();
  		//Mode to be played
  	    
  	    for(int i=0;i<round;i++) {
  		   System.out.println("which mode do you want to play : ");
  		   System.out.println("\n 1.Any Card Joker \n 2.High Card Joker \n 3.Low Card Joker \n 4.Normal Rules");
  		    int mode = sc.nextInt();
  		    game.DispatchCards(newCards, a,mode);
  	    }
  		sc.close();
	}

}
