//package com.pocker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Game{
	public ArrayList<String> ShuffleDeck(ArrayList<String> list)
	{
		Collections.shuffle(list);
		return list;
	}
	
	public TreeMap<Integer,String> anyCardJoker(TreeMap<Integer,String> map,int p) {
		Set<Entry<Integer,String>> set=map.entrySet();
		 String[] str = new String[p];
	     int index = 0;
		for(Entry<Integer,String> e:set)
		{
			str[index]=e.getValue();
			Scanner sc = new Scanner(System.in);
            
			System.out.println("player "+(index+1)+" please choose from given card"+str[index].charAt(0)+" "+str[index].charAt(3)+" "+str[index].charAt(6));
			int choose = sc.next().charAt(0);
			char [] ch = str[index].toCharArray();
			if(choose == str[index].charAt(0) && str[index].charAt(3)>=str[index].charAt(6) )  
				ch[0] = str[index].charAt(3);
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
			
			
			char [] ch = str[index].toCharArray();
			if(arr[1]<arr[0] && arr[1]<arr[2] )  {
				if(arr[0]>arr[1])
				   ch[3] = str[index].charAt(0);
				else
					ch[3] = str[index].charAt(6);
			}
			else if(arr[0]<arr[1] && arr[0]<arr[2]) {
				if(arr[1]>arr[2])
					   ch[0] = str[index].charAt(3);
					else
						ch[0] = str[index].charAt(6);
			}
			else if(arr[2]<arr[0] && arr[2]<arr[1]) {
				if(arr[0]>arr[1])
					   ch[6] = str[index].charAt(0);
					else
						ch[6] = str[index].charAt(3);
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
			
			
			char [] ch = str[index].toCharArray();
			if(arr[1]>arr[0] && arr[1]>arr[2] )  {
				if(arr[0]>arr[1])
				   ch[3] = str[index].charAt(0);
				else
					ch[3] = str[index].charAt(6);
			}
			else if(arr[0]>arr[1] && arr[0]>arr[2]) {
				if(arr[1]>arr[2])
					   ch[0] = str[index].charAt(3);
					else
						ch[0] = str[index].charAt(6);
			}
			else if(arr[2]>arr[0] && arr[2]>arr[1]) {
				if(arr[0]>arr[1])
					   ch[6] = str[index].charAt(0);
					else
						ch[6] = str[index].charAt(3);
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
	
	public void DispatchCards(ArrayList<String> list,int p,int mode)
	{
		TreeMap<Integer,String> map=new TreeMap<>();
		int index=0;
		for(int i=1;i<=p;i++)
		{
			String  str= list.get(index)+list.get(index+1)+list.get(index+2);
			index=index+3;
			map.put(i, str);
		}
		
		if(mode == 1)
			showCard(anyCardJoker(map,p));
		else if(mode == 2)
			showCard(highCardJoker(map,p));
		else if(mode == 3)
			showCard(lowCardJoker(map,p));
		else
			showCard(map);
		
	}
	public void showCard(TreeMap<Integer,String> map)
	{
		Set<Entry<Integer,String>> set=map.entrySet();
		for(Entry<Integer,String> x: set)
		{
			System.out.println("Player"+x.getKey());
			System.out.println("Card ="+x.getValue());
			System.out.println("======================================");
		}
		//System.out.println(map);
		winnerOfGame(map);
	}
	
	public void winnerOfGame(TreeMap<Integer,String> map)
	{
		ArrayList<Integer> list =new ArrayList<>();
		
		Set<Entry<Integer,String>> set=map.entrySet();
		//Set<Integer> s1=map.keySet();
		/*for(Integer x:s1)
		{
			System.out.println(x);
		}*/
		for(Entry<Integer,String> e:set)
		{
			int a=0;
			String str=e.getValue();
			boolean flag=true;
			
			if(str.charAt(0)=='A'||str.charAt(3)=='A'||str.charAt(6)=='A')
			{
				a=a+14;
			}
			if(str.charAt(0)=='K'||str.charAt(3)=='K'||str.charAt(6)=='K')
			{
				a=a+13;
			}
			if(str.charAt(0)=='Q'||str.charAt(3)=='Q'||str.charAt(6)=='Q')
			{
				a=a+12;
			}
			if(str.charAt(0)=='J'||str.charAt(3)=='J'||str.charAt(6)=='J')
			{
				a=a+11;
			}
			if(str.charAt(0)=='1'||str.charAt(3)=='1'||str.charAt(6)=='1')
			{
				a=a+10;
			}
			if(str.charAt(0)==str.charAt(3) && str.charAt(0)==str.charAt(6))
			{
				System.out.println("Player"+e.getKey()+" have Same number ");
						
				a=a+600;
				
				flag=false;
			}
			 if (str.charAt(2)==str.charAt(5) && str.charAt(2)==str.charAt(8))
			{
				if((int)str.charAt(0)+1==(int)str.charAt(3) && (int)str.charAt(3)+1==(int)str.charAt(6))
				{
					System.out.println("Player"+e.getKey()+" have sequence with color ");
					a=a+500;
					flag=false;
				}
			}
			 if((int)str.charAt(0)+1==(int)str.charAt(3) && (int)str.charAt(3)+1==(int)str.charAt(6))
			{
				System.out.println("Player"+e.getKey()+" have Sequence without color ");
				a=a+400;
				flag=false;
			}
			 if((int)str.charAt(2)==(int)str.charAt(5) && (int)str.charAt(2)==(int)str.charAt(8)) 
			{
				System.out.println("Player"+e.getKey()+" have Same color ");
				a=a+300;
				flag=false;
			}
			 if(str.charAt(0)==str.charAt(3) || str.charAt(0)==str.charAt(6) ||str.charAt(3)==str.charAt(6))
			{
				System.out.println("Player"+e.getKey()+" have pair");
				a=a+200;
				flag=false;
			}
			if(flag)
			{
				System.out.println("Player"+e.getKey()+" have card "+str.charAt(0)+" "+str.charAt(3)+" "+str.charAt(6));
				a=a+100;
			}
			list.add(a);
			
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
		/*for(Integer x:list)
		{
			System.out.println(x);
		}*/
		System.out.println("Winner of the game is player"+count);
	}
		
}



