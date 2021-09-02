//package com.pocker;

import java.util.ArrayList;
import java.util.Scanner;

public class Cards{
	
	public static ArrayList<String> list;
	public void createCardSet()
	{
		list=new ArrayList<>();
		String[] colour= {"R","B"};
		String[] suit= {"C","D","H","S"};
		String [] card = {"A","K","Q","J","1","9","8","7","6","5","4","3","2"};
		
		for(int i=0;i<colour.length;i++)
		{
			for(int j=0;j<suit.length;j++)
			{
				for(int k=0;k<card.length;k++)
				{
					if(i==0)
					{
						if(j==1 || j==2)
						{
							String str=card[k]+suit[j]+colour[i];
							list.add(str);
						}
					}
					else if(i==1)
					{
						if(j==0 || j==3)
						{
							String str=card[k]+suit[j]+colour[i];
							list.add(str);
						}
					}
				}
			}
		}
	
	}
	

}

