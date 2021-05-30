# Hearthstone-Game
This is a java edition of Hearthstone: Heroes of Warcraft game

This is an implementation of the well-known game “Hearthstone: Heroes of Warcraft”. It was implemented in java using the Model-Controller-View architectural pattern. The main components of the game are:
1- The Heroes: A total of 5 heroes. They are chosen by the game player at the beginning of the game.
2- Minions: The play cards that are played in the game. They are controlled by the player who summoned them, and can be commanded to attack their opponent's minions, or even the opposing hero.
For more info about the game, visit https://hearthstone.fandom.com/wiki/Hero

Here are some instructions on how the game is to be played:
1.How to select the two heroes?
Once you open the game, the 5 heroes (with their photos) are displayed on the screen as buttons. 
1-Press on any of the hero buttons to select the first hero.
2-Press on any of the hero buttons to select the second hero. The game then starts.
 

2.How the current hero plays a minion?
1-Press on any minion in your hand.
2-Once you press, the card of the minion will be displayed in a larger scale (zoom panel) in order to see the properties of the card more clearly.
3-If you decided on playing the minion, press on the zoom panel itself. The minion will be added to the field; Otherwise, press on any other button and the zoom panel will disappear.
 

3. How the current hero casts all types of spells ( hero target, minion target etc.).
1-Press on any spell in your hand.
2- Once you press, the card of the spell will be displayed in a larger scale (zoom panel) in order to see the properties of the card more clearly.
3-If you decided on casting the spell, press on the zoom panel itself.
i.If the spell requires a target, a message saying “choose the target” will be displayed. Press on the target (either a minion or a hero) and you will see the effect of casting the spell.
ii.If the spell does not require a target, press on the zoom panel and you will see the effect of casting the spell.
Otherwise, press on any other button and the zoom panel will disappear.
4. How the current hero uses his minions to attack the opponent’s minion.

1-Press on any minion in your field to attack with.
2-A message will be displayed to instruct you to choose the target.
3-Choose the target and you will see the effect of the attack on both the attacker and the attacked.
 

5. How to end the turn?

Press the yellow “End Turn” at the right of the screen, Easy .


6. Specify the screen orientation (whether the current hero hand and field is at a fixed half i.e top/button or each hero has a fixed half).

The current Hero hand and field is at a fixed half (bottom half). The field of the opponent is at the top half. The hand of the opponent is not shown. This means that once you end the turn of the current hero, the opponent turns into a current hero, takes the bottom half, and his hand and field are displayed at the bottom.

7. Any other details that might be specific to your own implementation.

-The properties of the cards in the current hero hand are not very clear. That is why there is a zoom panel that zooms the card once you press on it before you decide to play it. If you finally decided to play it, then press on the zoom panel itself.

-If you want to use the hero power, just press on the hero power image. If the hero power requires a target, you have to press on the minion/hero that you want to apply the power on, and then you will see the effect.






