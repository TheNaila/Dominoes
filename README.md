# Dominoes

![image](https://user-images.githubusercontent.com/63077056/227746986-59ea8a9f-be69-46be-9d17-451aaf5cb4b1.png)

Command-line two-player dominoes game. For each player, it keeps track of their set and what dominoes they have already used. Each time they use a domino, that domino is no longer usable


![image](https://user-images.githubusercontent.com/63077056/227746870-07dd8a51-91d2-4121-b76d-bbdef943cf70.png)

![image](https://user-images.githubusercontent.com/63077056/227746871-37b3fbab-fb52-4e82-84ba-497f752ec1ab.png)

For the game, it tracks which domino is currently in play. It checks that the selection that the players make is a valid selection based on the rules of the game and prompts them to re-select if otherwise. That is, the domino that they select must contain the same top or bottom value of the domino currently in play 

![image](https://user-images.githubusercontent.com/63077056/227746875-fe030529-8522-4bcd-a2f7-26f990976649.png)

The players take turns one after the other. It tracks possible moves in the game. If its a player's turn and they do not have any dominoes to play, they are skipped and the turn goes to the other player. A winner is decided based on who finishes their set first. 

![image](https://user-images.githubusercontent.com/63077056/227747437-9986bf27-184f-459b-9b3f-80afe70c0ec8.png)

If no one has dominoes to play, it ends in a stalemate 
![image](https://user-images.githubusercontent.com/63077056/227747433-5e3fa791-a716-4266-b30a-435097b97cd0.png)

