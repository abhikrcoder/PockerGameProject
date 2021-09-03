

import java.util.Arrays;

public class Cards {

	public String [] cardsDeck() {
	 String [] colors = {"CB","DR","HR","SB"};
	 String [] numbers = {"A","K","Q","J","1","9","8","7","6","5","4","3","2"};
	 String [] cards = new String[52];
	 int index=0;
	 for(int i=0;i<colors.length;i++) {
		 for(int j=0;j<numbers.length;j++) {
			 cards[index] = numbers[j]+colors[i];
			 index++;
		 }
	 }
	// System.out.println(Arrays.toString(cards));
	 return cards;
	}
}
