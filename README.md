# PockerGameProject
Assume-

No betting is involved. One Game just decides winner ,

we can play N number of rounds.

Card Priority is [A, King, Queen, Jack, 10,9 ,8,7,6,5,4,3,2]

All color has same priority.

 

Inputs

Number of players
   

 Mode ( Game will have few below Modes to play)
     Normal - Normal rules

    

     Any Card Joker (Player can assume any card as Joker and makes best combination)

      EX Player1 ( 7,3,3) => Then player can assume any card as Joker, here player will assume 7 as Jocker

                              and bet that he has 3,3,3

         

     Low Card Joker (Player needs to treat lowest card as Joker)

       EX Player1 ( 7,5,3) => Then 3 is Joker and Player can bet that he has 775 or 755

 

     High Card Joker (Player needs to treat high card as Joker)

       EX Player1 ( 7,5,3) => Then 7 is Joker and Player can bet that he has 5,5,3 or 3,5,3

       

Function

Shuffle Deck
Dispatch Cards
Show Cards and Find Out Winner
    

        1- All same number card

        2- Sequence with Color

        3- Sequence without Color

        4- Same color

        5- Pair

        6- Highest Cards Win
