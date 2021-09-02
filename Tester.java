//package com.pocker;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cards p=new Cards();
		p.createCardSet();
		Game g=new Game();
		ArrayList<String> list1 =g.ShuffleDeck(Cards.list);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of player :");
		int a=sc.nextInt();
		System.out.println("How many rounds do want to play : ");
		int round = sc.nextInt();
		//Mode to be played
	    
		//System.out.println(list1.size());
	    for(int i=0;i<round;i++) {
		   System.out.println("which mode do you want to play : ");
		   System.out.println("\n 1.Any Card Joker \n 2.High Card Joker \n 3.Low Card Joker \n 4.Normal Rules");
		    int mode = sc.nextInt();
		    g.DispatchCards(list1, a,mode);
	    }
		sc.close();

	}

}
