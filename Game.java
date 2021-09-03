

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;


public class Game {

	public List<String> ShuffleDeck(String[] cards) {
		List<String> list = new ArrayList<>();
		list = Arrays.asList(cards);
		Collections.shuffle(list);
		return list;
	}

	public void DispatchCards(List<String> newCards, int a, int mode) {
		TreeMap<Integer,String> map=new TreeMap<>();
		int index=0;
		for(int i=1;i<=a;i++)
		{
			String  str= newCards.get(index)+newCards.get(index+1)+newCards.get(index+2);
			index=index+3;
			map.put(i, str);
		}
		
		if(mode == 1)
			showCard(anyCardJoker(map,a));
		else if(mode == 2)
			showCard(highCardJoker(map,a));
		else if(mode == 3)
			showCard(lowCardJoker(map,a));
		else
			showCard(map);	
	}
	
	public void showCard(TreeMap<Integer,String> map)
	{
		Set<Integer> set=map.keySet();
		for(Integer x: set)
		{
		   
			System.out.println("Player"+x);
			System.out.println("Card ="+map.get(x));
			System.out.println("======================================");
		}
		//System.out.println(map);
		winnerOfGame(map);
	}
        
        /* anyCardJoker method will take the input as treemap and take the input from user side
        and replaces that character from the cards */

	public TreeMap<Integer,String> anyCardJoker(TreeMap<Integer,String> map,int p) {
		Set<Entry<Integer,String>> set=map.entrySet();
		 String[] str = new String[p];
	     int index = 0;
		for(Entry<Integer,String> e:set)
		{
			str[index]=e.getValue();
			Scanner sc = new Scanner(System.in);

                        /* the user will choose from the given cards and then we 
                           will replace it by user's choice*/
                    
			System.out.println("player "+(index+1)+" your card is : "+str[index]);
                        System.out.println("player "+(index+1)+" please choose and enter the character from given card : "+str[index].charAt(0)+" "+str[index].charAt(3)+" "+str[index].charAt(6));
			char choose = Character.toUpperCase(sc.next().charAt(0));
			char [] ch = str[index].toCharArray();
			if(choose == str[index].charAt(0) && str[index].charAt(3)>=str[index].charAt(6) )  
				ch[0] = str[index].charAt(3);//if player chooses 0th index character
			else if(choose == str[index].charAt(3) && str[index].charAt(0)>=str[index].charAt(6))
				ch[3] = str[index].charAt(0);
			else if(choose == str[index].charAt(6) && str[index].charAt(3)>=str[index].charAt(0))
				ch[6] = str[index].charAt(3);
			else if(choose == str[index].charAt(0) && str[index].charAt(3)<str[index].charAt(6))
				ch[0] = str[index].charAt(6);
			else if(choose == str[index].charAt(3) && str[index].charAt(0)<str[index].charAt(6))
				ch[3] = str[index].charAt(6);
			else if(choose == str[index].charAt(6) && str[index].charAt(3)<str[index].charAt(0))
				ch[6] = str[index].charAt(0);
			else if(choose == 'Q' || choose == 'K' || choose == 'J' || choose == 'A') {
				if(str[index].charAt(6) == choose)
					ch[6] = str[index].charAt(0);
				else if(str[index].charAt(3) == choose)
					ch[3] = str[index].charAt(0);
				else
					ch[0] = str[index].charAt(3);
			} 
			else
				System.out.println("you have not put the card from list");
			str[index] = new String(ch);
			System.out.println("you have choosen : "+str[index].charAt(0)+" "+str[index].charAt(3)+" "+str[index].charAt(6));
			index++;
		}
		
	     for(int i=1,j=0;i<p+1;i++,j++) 
	    	 map.put(i, str[j]);
	     return map;
	}
        /* Ranking function will take the arrays of character which are on 0th,3rd and 6th index
        and return the ranking according to the ranking*/

	public int []  ranking(char [] arr) {
		int [] arr1 = new int[3];
		for(int i=0;i<3;i++) {
			switch (arr[i])
			{
			case 'A' : arr1[i] =14; break;
			case 'K' : arr1[i] =13;break;
			case 'Q' : arr1[i] = 12;break;
			case 'J' : arr1[i] = 11;break;
			default : arr1[i] = (char) Integer.parseInt(arr[i]+"");
			}
		}
		return arr1;
	}
	
        /* lowCardJoker method will take cards and replaces the lower cards and gives 2
        combinations to user to select. Player select the given cards and play
        */

	public TreeMap<Integer,String> lowCardJoker(TreeMap<Integer,String> map,int p) {
		Set<Entry<Integer,String>> set=map.entrySet();
		 String[] str = new String[p];
	     int index = 0;
	     
		for(Entry<Integer,String> e:set)
		{
			
			str[index]=e.getValue();
			char []  ch1 = new char[3];
			System.out.println("player "+(index+1)+" has cards : "+str[index].charAt(0)+" "+str[index].charAt(3)+" "+str[index].charAt(6));
			ch1[0]=str[index].charAt(0);//char at 0 ranking
			ch1[1] = str[index].charAt(3);//char at 3 ranking
			ch1[2] = str[index].charAt(6);//char at 6 ranking
			int [] arr = ranking(ch1);
			
			String [] str1  = new String[2];
			char [] ch = str[index].toCharArray();
			
			for(int i=0;i<2;i++) {
				int replaced=0;
				int new_Number = 0;
			if(arr[1]<arr[0] && arr[1]<arr[2] )  { //it compares 3rd char is largest or not 
				if(arr[0]>arr[1] ) {
				   ch[3] = str[index].charAt(0);
				   new_Number = 0;//new_Number is for character which replaced the lower card
				}
				else {
					ch[3] = str[index].charAt(6);
					new_Number = 6;
				}
				replaced = 3;//replaced variable is the character which is replaced 
			}
			else if(arr[0]<arr[1] && arr[0]<arr[2]) {//it compares 0th char is largest or not 
				if(arr[1]>arr[2] ) {
					   ch[0] = str[index].charAt(3);
					   new_Number = 3;
				  }
					else {
						ch[0] = str[index].charAt(6);
						new_Number = 6;
					}
				replaced = 0;
			}
			else if(arr[2]<arr[0] && arr[2]<arr[1] ) {
				if(arr[0]>arr[1] ) {
					   ch[6] = str[index].charAt(0);
					   new_Number = 0;
				}
					else {
						ch[6] = str[index].charAt(3);
						new_Number = 3;
					}
				replaced = 6;
			}
			else if(arr[2]==arr[0] ) {
				ch[6] = str[index].charAt(3);
			}
			else if(arr[1]==arr[0]) {
				ch[3] = str[index].charAt(6);
			}
			else if(arr[2]==arr[0]) {
				ch[0] = str[index].charAt(3);
			}
			if(i==1) { // this is for player to choose lower combination cards
			  if(replaced==6 && new_Number==3)
				 ch[replaced] = ch[0];
			  else if(replaced==3 && new_Number==0)
				  ch[replaced] = ch[6];
			  else if(replaced==0 && new_Number==3)
				  ch[replaced] = ch[6];
			  else if(replaced==0 && new_Number==6)
				  ch[replaced] = ch[3];
			  else if(replaced==3 && new_Number==6)
				  ch[replaced] = ch[0];
			  else if(replaced==6 && new_Number==0)
					 ch[replaced] = ch[3];
			}
			   str1[i] = new String(ch);
			}
			   Scanner sc = new Scanner(System.in);
			   System.out.println("player "+(index+1)+"please chhose from cards combinations : ");
			   System.out.println("1. "+str1[0]);
			   System.out.println("2. "+str1[1]);
			   int choose = sc.nextInt();
			    if(choose == 1)
			    str[index] = str1[0];
			    else
			     str[index] = str1[1];
			// logic for 2 strings
			str[index] = new String(ch);
			
			System.out.println("By the rule low card will be choosen as joker and replaced : ");
			System.out.println("Now your cards are : "+str[index].charAt(0)+" "+str[index].charAt(3)+" "+str[index].charAt(6));
			System.out.println("------------------------------------------------------------------");
			index++;
		}
		
		 for(int i=1,j=0;i<p+1;i++,j++) 
	    	 map.put(i, str[j]);
	     return map;
	}

        /* highCardJoker method will take cards and replaces the higher cards and gives 2
        combinations to user to select. Player select the given cards and play
        */
	public TreeMap<Integer,String> highCardJoker(TreeMap<Integer,String> map,int p) {
		Set<Entry<Integer,String>> set=map.entrySet();
		 String[] str = new String[p];
	     int index = 0;	
		for(Entry<Integer,String> e:set)
		{
			str[index]=e.getValue();
			char []  ch1 = new char[3];
			System.out.println("player "+(index+1)+" has cards : "+str[index].charAt(0)+" "+str[index].charAt(3)+" "+str[index].charAt(6));
			ch1[0]=str[index].charAt(0);//char at 0 ranking
			ch1[1] = str[index].charAt(3);//char at 3 ranking
			ch1[2] = str[index].charAt(6);//char at 6 ranking
			int [] arr = ranking(ch1);
			String [] str1  = new String[2];
			
			char [] ch = str[index].toCharArray();
			for(int i=0;i<2;i++) {
				int replaced=0;
				int new_Number = 0;
			if(arr[1]>arr[0] && arr[1]>arr[2] )  { //it compares 3rd char is largest or not 
				if(arr[0]>arr[1] ) {
				   ch[3] = str[index].charAt(0);
				   new_Number = 0;
				}
				else {
					ch[3] = str[index].charAt(6);
					new_Number = 6;
				}
				replaced = 3;
			}
			else if(arr[0]>arr[1] && arr[0]>arr[2]) {//it compares 0th char is largest or not 
				if(arr[1]>arr[2] ) {
					   ch[0] = str[index].charAt(3);
					   new_Number = 3;
				  }
					else {
						ch[0] = str[index].charAt(6);
						new_Number = 6;
					}
				replaced = 0;
			}
			else if(arr[2]>arr[0] && arr[2]>arr[1] ) {
				if(arr[0]>arr[1] ) {
					   ch[6] = str[index].charAt(0);
					   new_Number = 0;
				}
					else {
						ch[6] = str[index].charAt(3);
						new_Number = 3;
					}
				replaced = 6;
			}
			else if(arr[2]==arr[0] ) {
				ch[6] = str[index].charAt(3);
			}
			else if(arr[1]==arr[0]) {
				ch[3] = str[index].charAt(6);
			}
			else if(arr[2]==arr[0]) {
				ch[0] = str[index].charAt(3);
			}
			if(i==1) { // this is for player to choose lower combination cards
			  if(replaced==6 && new_Number==3)
				 ch[replaced] = ch[0];
			  else if(replaced==3 && new_Number==0)
				  ch[replaced] = ch[6];
			  else if(replaced==0 && new_Number==3)
				  ch[replaced] = ch[6];
			  else if(replaced==0 && new_Number==6)
				  ch[replaced] = ch[3];
			  else if(replaced==3 && new_Number==6)
				  ch[replaced] = ch[0];
			  else if(replaced==6 && new_Number==0)
					 ch[replaced] = ch[3];
			}
			   str1[i] = new String(ch);
			}
			   Scanner sc = new Scanner(System.in);
			   System.out.println("player "+(index+1)+"please chhose from cards combinations : ");
			   System.out.println("1. "+str1[0]);
			   System.out.println("2. "+str1[1]);
			   int choose = sc.nextInt();
			    if(choose == 1)
			    str[index] = str1[0];
			    else
			     str[index] = str1[1];
			// logic for 2 strings
			str[index] = new String(ch);
			
			System.out.println("By the rule high card will be choosen as joker and replaced : ");
			System.out.println("Now your cards are : "+str[index].charAt(0)+" "+str[index].charAt(3)+" "+str[index].charAt(6));
			System.out.println("------------------------------------------------------------------");
		
			index++;
		}
		
		 for(int i=1,j=0;i<p+1;i++,j++) 
	    	 map.put(i, str[j]);
	     return map;
	}

	private void winnerOfGame(TreeMap<Integer, String> map) {
        ArrayList<Integer> list =new ArrayList<>();
		
		Set<Entry<Integer,String>> set=map.entrySet();
		for(Entry<Integer,String> e:set)
		{
			int marks=0;
			String str=e.getValue();
			boolean flag=true;
			char ch [] = {str.charAt(0),str.charAt(3),str.charAt(6)};
			int [] arr = ranking(ch);
			marks = arr[0]+arr[1]+arr[2];
			if(str.charAt(0)==str.charAt(3) && str.charAt(0)==str.charAt(6))
			{
				System.out.println("Player"+e.getKey()+" have Same number ");
						
				marks=marks+600;
				
				flag=false;
			}
			 if (str.charAt(2)==str.charAt(5) && str.charAt(2)==str.charAt(8))
			{
				if((int)str.charAt(0)+1==(int)str.charAt(3) && (int)str.charAt(3)+1==(int)str.charAt(6))
				{
					System.out.println("Player"+e.getKey()+" have sequence with color ");
					marks=marks+500;
					flag=false;
				}
			}
			 if((int)str.charAt(0)+1==(int)str.charAt(3) && (int)str.charAt(3)+1==(int)str.charAt(6))
			{
				System.out.println("Player"+e.getKey()+" have Sequence without color ");
				marks=marks+400;
				flag=false;
			}
			 if((int)str.charAt(2)==(int)str.charAt(5) && (int)str.charAt(2)==(int)str.charAt(8)) 
			{
				System.out.println("Player"+e.getKey()+" have Same color ");
				marks=marks+300;
				flag=false;
			}
			 if(str.charAt(0)==str.charAt(3) || str.charAt(0)==str.charAt(6) ||str.charAt(3)==str.charAt(6))
			{
				System.out.println("Player"+e.getKey()+" have pair");
				marks=marks+200;
				flag=false;
			}
			if(flag)
			{
				System.out.println("Player"+e.getKey()+" have card "+str.charAt(0)+" "+str.charAt(3)+" "+str.charAt(6));
				marks=marks+100;
			}
			list.add(marks);
		}
			int max=list.get(0),count = 1;
			for(int i=0;i<list.size();i++)
			{
				if(max<list.get(i))
				{
					max=list.get(i);
					count=i+1;
				}
			}
			
			System.out.println("Winner of the game is player"+count);
	}
	

}
