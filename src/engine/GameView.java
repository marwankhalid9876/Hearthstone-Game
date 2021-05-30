package engine;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
public class GameView extends JFrame {
	private JLabel opponentImage;
	private JLabel opponentName;
	private JLabel opponentHP;
	private JLabel opponentCurrentAndTotalManaCrystals;
	private JLabel currentName;
	private JLabel currentImage;
	private JLabel currentHP;
	private JLabel currentCurrentAndTotalManaCrystals;
	private JButton endturn;
	private JLabel heroPowerImage;
	private JButton heroPower;
	private JLabel currentCardsLeftOnDeck;
	private JLabel opponentCardsLeftOnDeck;
	
	private JPanel currentField;
	private JPanel currentHand;
	private JPanel opponentField;
	private JPanel opponentHand;
	
	private JButton bHunter;
	private JButton bMage;
	private JButton bPaladin;
	private JButton bPriest;
	private JButton bWarlock;
	
	private JButton opponentButton;
	private JButton currentButton;
	
	private FieldPanel field1;
    private FieldPanel field2;
    private FieldPanel field3;
    private FieldPanel field4;
    private FieldPanel field5;
    private FieldPanel field6;
    private FieldPanel field7;
    private FieldPanel field8;
    private FieldPanel field9;
    private FieldPanel field10;
    private FieldPanel field11;
    private FieldPanel field12;
    private FieldPanel field13;
    private FieldPanel field14;
    
    private HandPanel currentHand1;
    private HandPanel currentHand2;
    private HandPanel currentHand3;
    private HandPanel currentHand4;
    private HandPanel currentHand5;
    private HandPanel currentHand6;
    private HandPanel currentHand7;
    private HandPanel currentHand8;
    private HandPanel currentHand9;
    private HandPanel currentHand10;
    private JPanel opponentHand1;
    private JPanel opponentHand2;
    private JPanel opponentHand3;
    private JPanel opponentHand4;
    private JPanel opponentHand5;
    private JPanel opponentHand6;
    private JPanel opponentHand7;
    private JPanel opponentHand8;
    private JPanel opponentHand9;
    private JPanel opponentHand10;
    
    
    private JPanel zoomPanel;
    private JLabel zoomHP;
    private JLabel zoomAttack;
    private JLabel zoomManacostImage;
    private JLabel zoomManacost;
    private JLabel zoomDivine;

    
    private JLabel firstBoard;
    
    private JLabel exception;
    private JButton closeException;
    
    private JLabel chooseTarget;
    private JButton closeChooseTarget;
    
    private JLabel onGameOver;
    
    
	/*
	 * His current HP.
His current and total mana crystals.
How many cards are in his hand.
How many cards left in his deck.
	 */

	public GameView () {
		setSize(1280,720);
		/*
		 * background image
		 */
		JLabel background = new JLabel();
		SpringLayout springLayout = new SpringLayout();
		background.setLayout(springLayout);
		background.setIcon(new ImageIcon("LastBoard.jpg"));
		this.add(background);
		
		
		closeException = new JButton();
		closeException.setPreferredSize(new Dimension(80, 20));
		closeException.setOpaque(false);
		closeException.setContentAreaFilled(false);
		closeException.setVisible(false);
//		endturn.setBorderPainted(false);
		background.add(closeException);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, closeException, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, closeException, 3, SpringLayout.VERTICAL_CENTER, background);
		
		
		exception = new JLabel(new ImageIcon("Exceptions\\FullFieldException.png"));
		exception.setOpaque(false);
		exception.setVisible(false);
		background.add(exception);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, exception, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, exception, -20, SpringLayout.VERTICAL_CENTER, background);
	
		onGameOver = new JLabel(new ImageIcon("Exceptions\\FullFieldException.png"));
		onGameOver.setOpaque(false);
		onGameOver.setVisible(false);
		background.add(onGameOver);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, onGameOver, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, onGameOver, -20, SpringLayout.VERTICAL_CENTER, background);
	
		
		closeChooseTarget = new JButton();
		closeChooseTarget.setPreferredSize(new Dimension(80, 20));
		closeChooseTarget.setOpaque(false);
		closeChooseTarget.setContentAreaFilled(false);
		closeChooseTarget.setVisible(false);
//		endturn.setBorderPainted(false);
		background.add(closeChooseTarget);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, closeChooseTarget, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, closeChooseTarget, 3, SpringLayout.VERTICAL_CENTER, background);
		
		
		chooseTarget = new JLabel(new ImageIcon("Exceptions\\ChooseTarget.png"));
		chooseTarget.setOpaque(false);
		chooseTarget.setVisible(false);
		background.add(chooseTarget);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, chooseTarget, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, chooseTarget, -20, SpringLayout.VERTICAL_CENTER, background);
		
		
	
		zoomPanel = new JPanel();
		zoomPanel.setPreferredSize(new Dimension(200, 307));
		zoomPanel.setVisible(false);
		zoomPanel.setOpaque(false);
		/*
		 * for miro
		 */
		
		zoomDivine = new JLabel();
		zoomDivine.setText("Divine" + " "+ "Shield");
		zoomDivine.setForeground(Color.WHITE);
		zoomDivine.setFont(new Font("Bookman", Font.BOLD, 20));
		zoomDivine.setPreferredSize(new Dimension(151, 293));
		zoomDivine.setVisible(false);
		zoomDivine.setOpaque(false);
		background.add(zoomDivine);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, zoomDivine, 19, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, zoomDivine, 103, SpringLayout.VERTICAL_CENTER, background);
		
		SpringLayout zoomLayout = new SpringLayout(); 
		zoomPanel.setLayout(zoomLayout);
//		bHero3.setOpaque(false);
//		bHero3.setContentAreaFilled(false);
//		bHero3.setBorderPainted(false);
		background.add(zoomPanel);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, zoomPanel, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, zoomPanel, 0, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * for Miro
		 */
		zoomHP = new JLabel();
		zoomHP.setFont(new Font("Bookman", Font.BOLD, 35));
		zoomHP.setForeground(Color.WHITE);
		zoomPanel.add(zoomHP);
		zoomLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, zoomHP, 80, SpringLayout.HORIZONTAL_CENTER, zoomPanel);
		zoomLayout.putConstraint(SpringLayout.VERTICAL_CENTER, zoomHP, 120, SpringLayout.VERTICAL_CENTER, zoomPanel);
		
		
		zoomAttack = new JLabel();
		zoomAttack.setFont(new Font("Bookman", Font.BOLD, 35));
		zoomAttack.setForeground(Color.WHITE);
		zoomPanel.add(zoomAttack);
		zoomLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, zoomAttack, -67, SpringLayout.HORIZONTAL_CENTER, zoomPanel);
		zoomLayout.putConstraint(SpringLayout.VERTICAL_CENTER, zoomAttack, 120, SpringLayout.VERTICAL_CENTER, zoomPanel);
		
		zoomManacost = new JLabel();
		zoomManacost.setFont(new Font("Bookman", Font.BOLD, 35));
		zoomManacost.setForeground(Color.WHITE);
		zoomPanel.add(zoomManacost);
		zoomLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, zoomManacost, -67, SpringLayout.HORIZONTAL_CENTER, zoomPanel);
		zoomLayout.putConstraint(SpringLayout.VERTICAL_CENTER, zoomManacost, -120, SpringLayout.VERTICAL_CENTER, zoomPanel);
		
		zoomManacostImage = new JLabel();
		zoomManacostImage.setPreferredSize(new Dimension(51,53));
		zoomManacostImage.setIcon(new ImageIcon("manacost.png"));
		zoomManacostImage.setFont(new Font("Bookman", Font.BOLD, 18));
		zoomManacostImage.setForeground(Color.WHITE);
		zoomPanel.add(zoomManacostImage);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, zoomManacostImage, -67, SpringLayout.HORIZONTAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, zoomManacostImage, -120, SpringLayout.VERTICAL_CENTER, this);
		zoomManacostImage.setVisible(false);
		/*
		 * Hero Button game entry #1
		 */
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("Heros\\Hunter.png").getImage().getScaledInstance(200, 307, Image.SCALE_FAST));
		bHunter = new JButton(imageIcon);
		bHunter.setPreferredSize(new Dimension(200, 307));
		bHunter.setContentAreaFilled(false);
	//	bHunter.setBorderPainted(false);
		background.add(bHunter);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bHunter, 400, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, bHunter, 50, SpringLayout.VERTICAL_CENTER, background);
		/*
		 * #2
		 */ 
		imageIcon = new ImageIcon(new ImageIcon("Heros\\Mage.png").getImage().getScaledInstance(200, 307, Image.SCALE_FAST));
		bMage = new JButton(imageIcon);
		bMage.setPreferredSize(new Dimension(200, 307));
		bMage.setContentAreaFilled(false);
//		bHero2.setBorderPainted(false);
		background.add(bMage);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bMage, 200, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, bMage, 50, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * #3
		 */ 
		imageIcon = new ImageIcon(new ImageIcon("Heros\\Paladin.png").getImage().getScaledInstance(200, 307, Image.SCALE_FAST));
		bPaladin = new JButton(imageIcon);
		bPaladin.setPreferredSize(new Dimension(200, 307));
		bPaladin.setContentAreaFilled(false);
//		bHero3.setBorderPainted(false);
		background.add(bPaladin);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bPaladin, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, bPaladin, 50, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * #4
		 */ 
		
		imageIcon = new ImageIcon(new ImageIcon("Heros\\Priest.png").getImage().getScaledInstance(200, 307, Image.SCALE_FAST));
		bPriest = new JButton(imageIcon);
		bPriest.setPreferredSize(new Dimension(200, 307));
		bPriest.setContentAreaFilled(false);
//		bHero4.setBorderPainted(false);
		background.add(bPriest);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bPriest, -200, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, bPriest, 50, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * #5
		 */ 
		
		imageIcon = new ImageIcon(new ImageIcon("Heros\\Warlock.png").getImage().getScaledInstance(200, 307, Image.SCALE_FAST));
		bWarlock = new JButton(imageIcon);
		bWarlock.setPreferredSize(new Dimension(200, 307));;
		bWarlock.setContentAreaFilled(false);
//		bHero5.setBorderPainted(false);
		background.add(bWarlock);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bWarlock, -400, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, bWarlock, 50, SpringLayout.VERTICAL_CENTER, background);
		
		firstBoard = new JLabel(new ImageIcon("firstBoard.jpg"));
		background.add(firstBoard);
		
		/*
		 * Hp
		 */
		currentHP = new JLabel("30", JLabel.CENTER);
		currentHP.setFont(new Font("Bookman", Font.BOLD, 18));
		currentHP.setForeground(Color.WHITE);
		background.add(currentHP);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentHP, 39, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHP, 218, SpringLayout.VERTICAL_CENTER, background);
		
		
		
		opponentHP = new JLabel("30", JLabel.CENTER);
		opponentHP.setFont(new Font("Bookman", Font.BOLD, 18));
		opponentHP.setForeground(Color.WHITE);
		background.add(opponentHP);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, opponentHP, 39, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHP, -168, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * currentName
		 */
		currentName = new JLabel("Player 1", JLabel.CENTER);
		currentName.setFont(new Font("Bookman", Font.BOLD, 22));
		currentName.setForeground(Color.WHITE);
		background.add(currentName);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentName, -544, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentName, 204, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * opponentName
		 */
		opponentName = new JLabel("Player 2", JLabel.CENTER);
		opponentName.setFont(new Font("Bookman", Font.BOLD, 22));
		opponentName.setForeground(Color.WHITE);
		background.add(opponentName);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, opponentName, 544, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentName, -210, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * hero images
		 */
		opponentButton = new JButton();
		opponentButton.setPreferredSize(new Dimension(100, 100));;
		opponentButton.setContentAreaFilled(false);
//		opponentButton.setBorderPainted(false);
		background.add(opponentButton);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, opponentButton, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentButton, -210, SpringLayout.VERTICAL_CENTER, background);
		
		currentButton = new JButton();
		currentButton.setPreferredSize(new Dimension(100, 100));;
		currentButton.setContentAreaFilled(false);
//		opponentButton.setBorderPainted(false);
		background.add(currentButton);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentButton, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentButton, 180, SpringLayout.VERTICAL_CENTER, background);
		
		
	    currentImage= new JLabel();
//		currentImage.setIcon(new ImageIcon("hero images\\Hunter.png"));	
		background.add(currentImage);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentImage, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentImage, 175, SpringLayout.VERTICAL_CENTER, background);
		currentImage.setVisible(false);
		
		opponentImage= new JLabel();
		opponentImage.setIcon(new ImageIcon("hero images\\Mage.png"));	
		background.add(opponentImage);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, opponentImage, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentImage, -210, SpringLayout.VERTICAL_CENTER, background);
		opponentImage.setVisible(false);
		
		/*
		 * currentAndTotalManaCrystals
		 */
		
		currentCurrentAndTotalManaCrystals = new JLabel("10/10", JLabel.CENTER);
		currentCurrentAndTotalManaCrystals.setFont(new Font("Bookman", Font.BOLD, 17));
		currentCurrentAndTotalManaCrystals.setForeground(Color.WHITE);
		background.add(currentCurrentAndTotalManaCrystals);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentCurrentAndTotalManaCrystals, 180, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentCurrentAndTotalManaCrystals,282, SpringLayout.VERTICAL_CENTER, background);
		
		
		
		opponentCurrentAndTotalManaCrystals = new JLabel("10/10", JLabel.CENTER);
		opponentCurrentAndTotalManaCrystals.setFont(new Font("Bookman", Font.BOLD, 17));
		opponentCurrentAndTotalManaCrystals.setForeground(Color.WHITE);
		background.add(opponentCurrentAndTotalManaCrystals);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, opponentCurrentAndTotalManaCrystals, 158, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentCurrentAndTotalManaCrystals, -288, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * endturn
		 */
		
		endturn  = new JButton();
		endturn.setPreferredSize(new Dimension(75, 30));
		/*
		 * set the button to be invisible
		 */
		endturn.setOpaque(false);
		endturn.setContentAreaFilled(false);
		endturn.setBorderPainted(false);
		endturn.setActionCommand("endturn");
		/*
		 * 
		 */
		background.add(endturn);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, endturn, 367, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, endturn, -30, SpringLayout.VERTICAL_CENTER, background);
		
		
		
		/*
		 * hero power
		 */
		
	    heroPowerImage= new JLabel();
	    heroPowerImage.setIcon(null);	
		background.add(heroPowerImage);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, heroPowerImage, 120, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, heroPowerImage, 150 , SpringLayout.VERTICAL_CENTER, background);
		
		
		heroPower  = new JButton();
		heroPower.setPreferredSize(new Dimension(45, 45));
		/*
		 * set the button to be invisible
		 */
		heroPower.setOpaque(false);
		heroPower.setContentAreaFilled(false);
		heroPower.setBorderPainted(false);
		heroPower.setActionCommand("heroPower");
		/*
		 * 
		 */
		background.add(heroPower);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, heroPower, 120, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, heroPower, 150, SpringLayout.VERTICAL_CENTER, background);
		
		
		
		/*
		 * Cards left on the Deck
		 */
		
		currentCardsLeftOnDeck= new JLabel("X", JLabel.CENTER);
		currentCardsLeftOnDeck.setFont(new Font("Bookman", Font.BOLD, 25));
		currentCardsLeftOnDeck.setForeground(Color.WHITE);
		background.add(currentCardsLeftOnDeck);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, currentCardsLeftOnDeck, 542, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentCardsLeftOnDeck,170, SpringLayout.VERTICAL_CENTER, background);
		

		
		opponentCardsLeftOnDeck= new JLabel("X", JLabel.CENTER);
		opponentCardsLeftOnDeck.setFont(new Font("Bookman", Font.BOLD, 25));
		opponentCardsLeftOnDeck.setForeground(Color.WHITE);
		background.add(opponentCardsLeftOnDeck);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, opponentCardsLeftOnDeck, -531, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentCardsLeftOnDeck,-210, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * field Panels
		 */
		field1= new FieldPanel();
		field1.setPlace(background,springLayout,-240,40);
//		field1.setPreferredSize(new Dimension (79,115));
//		field1.setOpaque(false);
//		
//		background.add(field1);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field1, -240, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field1, 40, SpringLayout.VERTICAL_CENTER, background);
//		JLabel x = new JLabel();
//		x.setBackground(null);
//		imageIcon = new ImageIcon(new ImageIcon("Minions\\gooldshire footman.PNG").getImage().getScaledInstance(80, 100, Image.SCALE_FAST));
//		x.setIcon(imageIcon);
//		field1.add(x);
//		
		
		field2= new FieldPanel();
		field2.setPlace(background,springLayout,-160,40);
//		field2= new JPanel();
//		field2.setPreferredSize(new Dimension (79,115));
//		field2.setOpaque(false);
//		background.add(field2);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field2, -160, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field2, 40, SpringLayout.VERTICAL_CENTER, background);
//		
		field3= new FieldPanel();
		field3.setPlace(background,springLayout,-80,40);
//		field3= new JPanel();
//		field3.setPreferredSize(new Dimension (79,115));
//		field3.setOpaque(false);
//		background.add(field3);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field3, -80, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field3, 40, SpringLayout.VERTICAL_CENTER, background);
//		
		
		field4= new FieldPanel();
		field4.setPlace(background,springLayout,0,40);
//		field4= new JPanel();
//		field4.setPreferredSize(new Dimension (79,115));
//		field4.setOpaque(false);
//		background.add(field4);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field4, 0, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field4, 40, SpringLayout.VERTICAL_CENTER, background);

		field5= new FieldPanel();
		field5.setPlace(background,springLayout,80,40);
//		field5= new JPanel();
//		field5.setPreferredSize(new Dimension (79,115));
//		field5.setOpaque(false);
//		background.add(field5);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field5, 80, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field5, 40, SpringLayout.VERTICAL_CENTER, background);
//		
		field6= new FieldPanel();
		field6.setPlace(background,springLayout,160,40);
//		field6= new JPanel();
//		field6.setPreferredSize(new Dimension (79,115));
//		field6.setOpaque(false);
//		background.add(field6);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field6, 160, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field6, 40, SpringLayout.VERTICAL_CENTER, background);
//		
		field7= new FieldPanel();
		field7.setPlace(background,springLayout,240,40);
//		field7= new JPanel();
//		field7.setPreferredSize(new Dimension (79,115));
//		field7.setOpaque(false);
//		background.add(field7);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field7, 240, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field7, 40, SpringLayout.VERTICAL_CENTER, background);
//		
		
		field8= new FieldPanel();
		field8.setPlace(background,springLayout,-240,-90);
//		field8= new JPanel();
//		field8.setPreferredSize(new Dimension (79,115));
//		field8.setOpaque(false);
//		background.add(field8);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field8, -240, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field8, -90, SpringLayout.VERTICAL_CENTER, background);
		
		field9= new FieldPanel();
		field9.setPlace(background,springLayout,-160,-90);
//		field9= new JPanel();
//		field9.setPreferredSize(new Dimension (79,115));
//		field9.setOpaque(false);
//		background.add(field9);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field9, -160, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field9, -90, SpringLayout.VERTICAL_CENTER, background);
//		
		field10= new FieldPanel();
		field10.setPlace(background,springLayout,-80,-90);
//		field10= new JPanel();
//		field10.setPreferredSize(new Dimension (79,115));
//		field10.setOpaque(false);
//		background.add(field10);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field10, -80, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field10, -90, SpringLayout.VERTICAL_CENTER, background);
//		
		field11= new FieldPanel();
		field11.setPlace(background,springLayout,0,-90);
//		field11= new JPanel();
//		field11.setPreferredSize(new Dimension (79,115));
//		field11.setOpaque(false);
//		background.add(field11);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field11, 0, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field11, -90, SpringLayout.VERTICAL_CENTER, background);

		field12= new FieldPanel();
		field12.setPlace(background,springLayout,80,-90);
//		field12= new JPanel();
//		field12.setPreferredSize(new Dimension (79,115));
//		field12.setOpaque(false);
//		background.add(field12);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field12, 80, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field12, -90, SpringLayout.VERTICAL_CENTER, background);
		
		field13= new FieldPanel();
		field13.setPlace(background,springLayout,160,-90);
//		field13= new JPanel();
//		field13.setPreferredSize(new Dimension (79,115));
//		field13.setOpaque(false);
//		background.add(field13);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field13, 160, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field13, -90, SpringLayout.VERTICAL_CENTER, background);
		
		field14= new FieldPanel();
		field14.setPlace(background,springLayout,240,-90);
//		field14= new JPanel();
//		field14.setPreferredSize(new Dimension (79,115));
//		field14.setOpaque(false);
//		background.add(field14);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, field14, 240, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, field14, -90, SpringLayout.VERTICAL_CENTER, background);
		/*
		* currentHand1
		 */
		currentHand1 = new HandPanel();
		currentHand1.setPlace(background, springLayout, 100, 290);
//		currentHand1 = new JPanel();
//		background.add(currentHand1);
//		currentHand1.setOpaque(false);
//		currentHand1.setPreferredSize(new Dimension(66,95));
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand1, 100, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand1,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * currentHand2
		 */
		currentHand2 = new HandPanel();
		currentHand2.setPlace(background, springLayout, 30, 290);
//		currentHand2 = new JPanel();
//		background.add(currentHand2);
//		currentHand2.setPreferredSize(new Dimension(66,95));
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand2, 30, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand2,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * currentHand3
		 */
		currentHand3 = new HandPanel();
		currentHand3.setPlace(background, springLayout, -40, 290);
//		currentHand3 = new JPanel();
//		background.add(currentHand3);
//		currentHand3.setPreferredSize(new Dimension(66,95));
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand3, -40, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand3,290, SpringLayout.VERTICAL_CENTER, background);
		/*
		 * currentHand4
		 */
		currentHand4 = new HandPanel();
		currentHand4.setPlace(background, springLayout, -110, 290);
//		currentHand4 = new JPanel();
//		background.add(currentHand4);
//		currentHand4.setPreferredSize(new Dimension(66,95));
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand4, -110, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand4,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * currentHand5
		 */
		currentHand5 = new HandPanel();
		currentHand5.setPlace(background, springLayout, -180, 290);
//		currentHand5 = new JPanel();
//		background.add(currentHand5);
//		currentHand5.setPreferredSize(new Dimension(66,95));
//		currentHand5.setBackground(Color.white);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand5, -180, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand5,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * currentHand6
		 */
		currentHand6 = new HandPanel();
		currentHand6.setPlace(background, springLayout, -250, 290);
//		currentHand6 = new JPanel();
//		background.add(currentHand6);
//		currentHand6.setPreferredSize(new Dimension(66,95));
//		currentHand6.setBackground(Color.red);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand6, -250, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand6,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * currentHand7
		 */
		currentHand7 = new HandPanel();
		currentHand7.setPlace(background, springLayout, -320, 290);
//		currentHand7 = new JPanel();
//		background.add(currentHand7);
//		currentHand7.setPreferredSize(new Dimension(66,95));
//		currentHand7.setBackground(Color.white);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand7, -320, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand7,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * currentHand8
		 */
		currentHand8 = new HandPanel();
		currentHand8.setPlace(background, springLayout, -390, 290);
//		currentHand8 = new JPanel();
//		background.add(currentHand8);
//		currentHand8.setPreferredSize(new Dimension(66,95));
//		currentHand8.setBackground(Color.red);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand8, -390, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand8,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * currentHand9
		 */
		currentHand9 = new HandPanel();
		currentHand9.setPlace(background, springLayout, -460, 290);
//		currentHand9 = new JPanel();
//		background.add(currentHand9);
//		currentHand9.setPreferredSize(new Dimension(66,95));
//		currentHand9.setBackground(Color.white);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand9, -460, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand9,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * currentHand10
		 */
		currentHand10 = new HandPanel();
		currentHand10.setPlace(background, springLayout, -530, 290);
//		currentHand10 = new JPanel();
//		background.add(currentHand10);
//		currentHand10.setPreferredSize(new Dimension(66,95));
//		currentHand10.setBackground(Color.red);
//		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,currentHand10, -530, SpringLayout.HORIZONTAL_CENTER, background);
//		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, currentHand10,290, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * opponentHand1
		 */
		
		opponentHand1 = new JPanel();
		background.add(opponentHand1);
		opponentHand1.setOpaque(false);
		opponentHand1.setPreferredSize(new Dimension(41,63));
		opponentHand1.setBackground(Color.red);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand1, -315, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand1,-305, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * opponentHand2
		 */
		
		opponentHand2 = new JPanel();
		background.add(opponentHand2);
		opponentHand2.setOpaque(false);
		opponentHand2.setPreferredSize(new Dimension(41,63));
		opponentHand2.setBackground(Color.white);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand2, -270, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand2,-305, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * opponentHand3
		 */
		
		opponentHand3 = new JPanel();
		background.add(opponentHand3);
		opponentHand3.setOpaque(false);
		opponentHand3.setPreferredSize(new Dimension(41,63));
		opponentHand3.setBackground(Color.red);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand3, -225, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand3,-305, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * opponentHand4
		 */
		
		opponentHand4 = new JPanel();
		background.add(opponentHand4);
		opponentHand4.setOpaque(false);
		opponentHand4.setPreferredSize(new Dimension(41,63));
		opponentHand4.setBackground(Color.white);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand4, -180, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand4,-305, SpringLayout.VERTICAL_CENTER, background);
		
		
		/*
		 * opponentHand5
		 */
		
		opponentHand5 = new JPanel();
		background.add(opponentHand5);
		opponentHand5.setOpaque(false);
		opponentHand5.setPreferredSize(new Dimension(41,63));
		opponentHand5.setBackground(Color.red);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand5, -135, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand5,-305, SpringLayout.VERTICAL_CENTER, background);
		
		/*
		 * opponentHand6
		 */
		
		opponentHand6 = new JPanel();
		background.add(opponentHand6);
		opponentHand6.setOpaque(false);
		opponentHand6.setPreferredSize(new Dimension(41,63));
		opponentHand6.setBackground(Color.white);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand6, -90, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand6,-305, SpringLayout.VERTICAL_CENTER, background);
		

		/*
		 * opponentHand7
		 */
		
		opponentHand7 = new JPanel();
		background.add(opponentHand7);
		opponentHand7.setOpaque(false);
		opponentHand7.setPreferredSize(new Dimension(41,63));
		opponentHand7.setBackground(Color.red);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand7, -45, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand7,-305, SpringLayout.VERTICAL_CENTER, background);
		

		/*
		 * opponentHand8
		 */
		
		opponentHand8 = new JPanel();
		background.add(opponentHand8);
		opponentHand8.setOpaque(false);
		opponentHand8.setPreferredSize(new Dimension(41,63));
		opponentHand8.setBackground(Color.white);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand8, 0, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand8,-305, SpringLayout.VERTICAL_CENTER, background);
		

		/*
		 * opponentHand9
		 */
		
		opponentHand9 = new JPanel();
		background.add(opponentHand9);
		opponentHand9.setOpaque(false);
		opponentHand9.setPreferredSize(new Dimension(41,63));
		opponentHand9.setBackground(Color.red);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand9, 45, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand9,-305, SpringLayout.VERTICAL_CENTER, background);
		

		/*
		 * opponentHand10
		 */
		
		opponentHand10 = new JPanel();
		background.add(opponentHand10);
		opponentHand10.setOpaque(false);
		opponentHand10.setPreferredSize(new Dimension(41,63));
		opponentHand10.setBackground(Color.white);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,opponentHand10, 90, SpringLayout.HORIZONTAL_CENTER, background);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, opponentHand10,-305, SpringLayout.VERTICAL_CENTER, background);
		
		
		
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.revalidate();
		this.repaint();


	
	}

	public JLabel getOpponentImage() {
		return opponentImage;
	}

	public JLabel getOpponentName() {
		return opponentName;
	}

	public JLabel getOpponentHP() {
		return opponentHP;
	}

	public JLabel getOpponentCurrentAndTotalManaCrystals() {
		return opponentCurrentAndTotalManaCrystals;
	}

	public JLabel getCurrentName() {
		return currentName;
	}

	public JLabel getCurrentImage() {
		return currentImage;
	}

	public JLabel getCurrentHP() {
		return currentHP;
	}

	public JLabel getCurrentCurrentAndTotalManaCrystals() {
		return currentCurrentAndTotalManaCrystals;
	}

	public JButton getEndturn() {
		return endturn;
	}

	public JLabel getHeroPowerImage() {
		return heroPowerImage;
	}

	public JButton getHeroPower() {
		return heroPower;
	}

	public JLabel getCurrentCardsLeftOnDeck() {
		return currentCardsLeftOnDeck;
	}

	public JLabel getOpponentCardsLeftOnDeck() {
		return opponentCardsLeftOnDeck;
	}

	public JPanel getCurrentField() {
		return currentField;
	}

	public JPanel getCurrentHand() {
		return currentHand;
	}

	public JPanel getOpponentField() {
		return opponentField;
	}

	public JPanel getOpponentHand() {
		return opponentHand;
	}

	public JButton getbHunter() {
		return bHunter;
	}

	public JButton getbMage() {
		return bMage;
	}

	public JButton getbPaladin() {
		return bPaladin;
	}

	public JButton getbPriest() {
		return bPriest;
	}

	public JButton getbWarlock() {
		return bWarlock;
	}

	public FieldPanel getField1() {
		return field1;
	}

	public FieldPanel getField2() {
		return field2;
	}

	public FieldPanel getField3() {
		return field3;
	}

	public FieldPanel getField4() {
		return field4;
	}

	public FieldPanel getField5() {
		return field5;
	}

	public FieldPanel getField6() {
		return field6;
	}

	public FieldPanel getField7() {
		return field7;
	}

	public FieldPanel getField8() {
		return field8;
	}

	public FieldPanel getField9() {
		return field9;
	}

	public FieldPanel getField10() {
		return field10;
	}

	public FieldPanel getField11() {
		return field11;
	}

	public FieldPanel getField12() {
		return field12;
	}

	public FieldPanel getField13() {
		return field13;
	}

	public FieldPanel getField14() {
		return field14;
	}

	public HandPanel getCurrentHand1() {
		return currentHand1;
	}

	public HandPanel getCurrentHand2() {
		return currentHand2;
	}

	public HandPanel getCurrentHand3() {
		return currentHand3;
	}

	public HandPanel getCurrentHand4() {
		return currentHand4;
	}

	public HandPanel getCurrentHand5() {
		return currentHand5;
	}

	public HandPanel getCurrentHand6() {
		return currentHand6;
	}

	public HandPanel getCurrentHand7() {
		return currentHand7;
	}

	public HandPanel getCurrentHand8() {
		return currentHand8;
	}

	public HandPanel getCurrentHand9() {
		return currentHand9;
	}

	public HandPanel getCurrentHand10() {
		return currentHand10;
	}

	public JPanel getOpponentHand1() {
		return opponentHand1;
	}

	public JPanel getOpponentHand2() {
		return opponentHand2;
	}

	public JPanel getOpponentHand3() {
		return opponentHand3;
	}

	public JPanel getOpponentHand4() {
		return opponentHand4;
	}

	public JPanel getOpponentHand5() {
		return opponentHand5;
	}

	public JPanel getOpponentHand6() {
		return opponentHand6;
	}

	public JPanel getOpponentHand7() {
		return opponentHand7;
	}

	public JPanel getOpponentHand8() {
		return opponentHand8;
	}

	public JPanel getOpponentHand9() {
		return opponentHand9;
	}

	public JPanel getOpponentHand10() {
		return opponentHand10;
	}

	public JPanel getZoomPanel() {
		return zoomPanel;
	}

	public JLabel getFirstBoard() {
		return firstBoard;
	}

	public JLabel getZoomHP() {
		return zoomHP;
	}

	public JLabel getZoomAttack() {
		return zoomAttack;
	}

	public JLabel getException() {
		return exception;
	}

	public JButton getCloseException() {
		return closeException;
	}

	public JButton getOpponentButton() {
		return opponentButton;
	}

	public JLabel getChooseTarget() {
		return chooseTarget;
	}

	public JButton getCloseChooseTarget() {
		return closeChooseTarget;
	}

	public JButton getCurrentButton() {
		return currentButton;
	}

	public void setCurrentButton(JButton currentButton) {
		this.currentButton = currentButton;
	}

	public JLabel getOnGameOver() {
		return onGameOver;
	}

	public void setOnGameOver(JLabel onGameOver) {
		this.onGameOver = onGameOver;
	}

	public JLabel getZoomManacostImage() {
		return zoomManacostImage;
	}

	public void setZoomManacostImage(JLabel zoomManacostImage) {
		this.zoomManacostImage = zoomManacostImage;
	}

	public JLabel getZoomManacost() {
		return zoomManacost;
	}

	public void setZoomManacost(JLabel zoomManacost) {
		this.zoomManacost = zoomManacost;
	}

	public JLabel getZoomDivine() {
		return zoomDivine;
	}

	public void setZoomDivine(JLabel zoomDivine) {
		this.zoomDivine = zoomDivine;
	}
	
	


}
