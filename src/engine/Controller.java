package engine;

import java.awt.Dimension;

import exceptions.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import model.cards.Card;
import model.cards.minions.Minion;
import model.cards.spells.*;
import model.heroes.*;

public class Controller implements ActionListener,GameListener {
	private GameView view;
	private Game model;
	private JButton selected;
	private ArrayList<JButton> buttons;
	private ArrayList<Object> all;
	private Hero hero1;
	private Hero hero2;
	private ArrayList<Card> deck1;
	private ArrayList<Card> deck2;
	private ArrayList<Card> hand1;
	private ArrayList<Card> hand2;
	private JButton zoomButton;
	private boolean zoomFlag;
	
	private Minion attacker;
	private ArrayList<FieldPanel> currentField;
	private ArrayList<FieldPanel> opponentField;
	private ArrayList<HandPanel> currentHand;
	private ArrayList<JPanel> opponentHand;
	private Spell spellSelected;
	boolean heroPowerPressed;
//	boolean currentHeroChosen;
	
	public Controller() throws IOException, CloneNotSupportedException, FullHandException
	{
		view = new GameView();
		all = new ArrayList<Object>();
		
		
		view.getbHunter().addActionListener(this);
		view.getbMage().addActionListener(this);
		view.getbPaladin().addActionListener(this);
		view.getbPriest().addActionListener(this);
		view.getbWarlock().addActionListener(this);
		buttons = new ArrayList<JButton>();
		buttons.add(view.getbHunter());
		buttons.add(view.getbMage());
		buttons.add(view.getbPaladin());
		buttons.add(view.getbPriest());
		buttons.add(view.getbWarlock());
						
		all.add(new Hunter());
		all.add(new Mage());
		all.add(new Paladin());
		all.add(new Priest());
		all.add(new Warlock());
		
		
		currentField = new ArrayList<FieldPanel>();
		currentField.add(view.getField1());
		currentField.add(view.getField2());
		currentField.add(view.getField3());
		currentField.add(view.getField4());
		currentField.add(view.getField5());
		currentField.add(view.getField6());
		currentField.add(view.getField7());
		
		for(int i=0;i<7;i++)
		{
			currentField.get(i).getButton().addActionListener(this);
			currentField.get(i).getButton().setActionCommand("opponentField");
		}
		
		opponentField= new ArrayList<FieldPanel>();
		opponentField.add(view.getField8());
		opponentField.add(view.getField9());
		opponentField.add(view.getField10());
		opponentField.add(view.getField11());
		opponentField.add(view.getField12());
		opponentField.add(view.getField13());
		opponentField.add(view.getField14());
		
		for(int i=0;i<7;i++)
		{
			opponentField.get(i).getButton().addActionListener(this);
			opponentField.get(i).getButton().setActionCommand("opponentField");
		}
		
		currentHand = new ArrayList<HandPanel>();
		currentHand.add(view.getCurrentHand1());
		currentHand.add(view.getCurrentHand2());
		currentHand.add(view.getCurrentHand3());
		currentHand.add(view.getCurrentHand4());
		currentHand.add(view.getCurrentHand5());
		currentHand.add(view.getCurrentHand6());
		currentHand.add(view.getCurrentHand7());
		currentHand.add(view.getCurrentHand8());
		currentHand.add(view.getCurrentHand9());
		currentHand.add(view.getCurrentHand10());
		
		
		opponentHand = new ArrayList<JPanel>();
		opponentHand.add(view.getOpponentHand1());
		opponentHand.add(view.getOpponentHand2());
		opponentHand.add(view.getOpponentHand3());
		opponentHand.add(view.getOpponentHand4());
		opponentHand.add(view.getOpponentHand5());
		opponentHand.add(view.getOpponentHand6());
		opponentHand.add(view.getOpponentHand7());
		opponentHand.add(view.getOpponentHand8());
		opponentHand.add(view.getOpponentHand9());
		opponentHand.add(view.getOpponentHand10());
		for(int i=0; i<opponentHand.size(); i++)
		{
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("CardBack.png").getImage().getScaledInstance(39,58 , Image.SCALE_FAST));
			JLabel k = new JLabel(imageIcon);
			opponentHand.get(i).add(k);
			opponentHand.get(i).setVisible(false);
		}
		zoomButton = new JButton();
		zoomButton.setActionCommand("zoomButton");
		zoomButton.setPreferredSize(new Dimension(200, 300));
		zoomButton.addActionListener(this);
		zoomButton.setOpaque(false);
		zoomButton.setContentAreaFilled(false);
		zoomButton.setBorderPainted(false);
		view.getZoomPanel().add(zoomButton);
		
		view.getEndturn().addActionListener(this);
		view.getHeroPower().addActionListener(this);
		
		view.getCloseException().addActionListener(this);
		view.getCloseChooseTarget().addActionListener(this);
		
		buttons.add(view.getCloseChooseTarget());
		all.add(view.getCloseChooseTarget());
		
		view.getOpponentButton().addActionListener(this);
		view.getOpponentButton().setActionCommand("opponentButton");
		buttons.add(view.getOpponentButton());
		all.add(view.getOpponentButton());
		
		view.getCurrentButton().addActionListener(this);
		view.getCurrentButton().setActionCommand("currentButton");
//		buttons.add(view.getOpponentButton());
//		all.add(view.getOpponentButton());
		
		buttons.add(view.getCloseException());
		all.add(view.getCloseException());
		
	}
	public void removeFromView(Object o)
	{
		int i = all.indexOf(o);
		all.remove(i);
		buttons.remove(i);
	}

	public void removeFromView(JButton b)
	{
		int i = buttons.indexOf(b);
		all.remove(i);
		buttons.remove(b);
	}

	@Override
	public void onGameOver() {
		ImageIcon player1 = new ImageIcon("player1Won.png");
		ImageIcon player2= new ImageIcon("player2Won.png");
		
		if(model.getCurrentHero().getCurrentHP()==0 && view.getCurrentName().getText().equals("Player 1"))
			view.getOnGameOver().setIcon(player2);
		if(model.getCurrentHero().getCurrentHP()==0 && view.getCurrentName().getText().equals("Player 2"))
			view.getOnGameOver().setIcon(player1);
		if(model.getOpponent().getCurrentHP()==0 && view.getCurrentName().getText().equals("Player 1"))
			view.getOnGameOver().setIcon(player1);
		if(model.getOpponent().getCurrentHP()==0 && view.getCurrentName().getText().equals("Player 2"))
			view.getOnGameOver().setIcon(player2);
		view.getOnGameOver().setVisible(true);
		view.getCloseException().setVisible(true);
		
		if(zoomFlag)
		{
		zoomFlag=false;
		view.getZoomPanel().setVisible(false);
		int r = buttons.indexOf(zoomButton);
		buttons.remove(zoomButton);
		all.remove(r);
		zoomButton.setIcon(null);
		}
	}


	
	@Override
	public void actionPerformed(ActionEvent event){
		
		JButton b=(JButton) event.getSource();
		
		int r = buttons.indexOf(b);
		if(!b.getActionCommand().equals("endturn") && (!b.getActionCommand().equals("heroPower"))
		  && (!b.getActionCommand().equals("currentButton")))
		{	Object o = all.get(r);
		if(o instanceof Hero)
			try {
				chooseHero((Hero)o,b);
			} catch (FullHandException e) {
				e.printStackTrace();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(o instanceof Card && model.getCurrentHero().getHand().contains(o) && !zoomFlag)
		{
			updateview();
			addingToZoom((Card)o);
			selected=b;
		}
		else
			if(o instanceof Card && model.getCurrentHero().getHand().contains(o) && r !=all.size()-1)
			{
				updateview();
				editingtheZoom((Card)o);
				selected=b;
			}
			else
				if(o instanceof Card && model.getCurrentHero().getHand().contains(o) && r ==all.size()-1)
				{
					if(o instanceof Minion)
					{
						try {
							addingToField((Card)o);
						} catch (NotYourTurnException | NotEnoughManaException | FullFieldException e) {
							throwException(e);
						}
					}
					else
					{
						if(o instanceof MinionTargetSpell || o instanceof LeechingSpell || o instanceof HeroTargetSpell)
						{
							spellSelected= (Spell) o;
							view.getChooseTarget().setVisible(true);
							view.getCloseChooseTarget().setVisible(true);
							killZoom();
						}
						if(o instanceof FieldSpell)
						{
							try {
								model.getCurrentHero().castSpell((FieldSpell) o);
								reconstructCurrentHand();
								reconstructOpponentField();
								reconstructCurrentField();
								killZoom();
							} catch (NotYourTurnException | NotEnoughManaException e) {
								throwException(e);
							}
							
						}
						if(o instanceof AOESpell)
						{
							try {
								model.getCurrentHero().castSpell((AOESpell) o, model.getOpponent().getField());
								reconstructCurrentHand();
								reconstructOpponentField();
								reconstructCurrentField();
								killZoom();
							} catch (NotYourTurnException | NotEnoughManaException e) {
								// TODO Auto-generated catch block
								throwException(e);
							}
							
						}
											
					}
				}
		if(o instanceof JButton && view.getException().isVisible())
		{
			view.getException().setVisible(false);
			view.getCloseException().setVisible(false);
			updateview();
		}
		if(o instanceof JButton && view.getChooseTarget().isVisible())
		{
			view.getChooseTarget().setVisible(false);
			view.getCloseChooseTarget().setVisible(false);
			updateview();
		}
		if(o instanceof JButton && view.getOnGameOver().isVisible())
		{
	        System.exit(0);
		}
		
		if(o instanceof JButton && ((JButton) o).getActionCommand().equals("opponentButton") && spellSelected !=null)
		{
			try {
				model.getCurrentHero().castSpell((HeroTargetSpell) spellSelected,model.getOpponent());
			} catch (NotYourTurnException | NotEnoughManaException e) {
				throwException(e);
			}						
			reconstructCurrentHand();
			reconstructOpponentField();
			reconstructCurrentField();
			
			updateview();
			spellSelected=null;
		}
		else
		{
			if(spellSelected !=null && (b.getActionCommand().equals("opponentField")|| b.getActionCommand().equals("currentField")) )
			{
				int i;
				Minion m;
				if(spellSelected instanceof DivineSpirit || spellSelected instanceof SealOfChampions)
				{
					i=0;
					for(;i<currentField.size();i++)
					{
						if(currentField.get(i).getButton().equals(b))
							break;
					}
					m = model.getCurrentHero().getField().get(i);
				}
				else
				{
					i=0;
					for(;i<opponentField.size();i++)
					{
						if(opponentField.get(i).getButton().equals(b))
							break;
					}
					m = model.getOpponent().getField().get(i);
				}
				if(spellSelected instanceof LeechingSpell)
				{
					
					try {
						model.getCurrentHero().castSpell((LeechingSpell) spellSelected,m);
					} catch (NotYourTurnException | NotEnoughManaException e) {
						throwException(e);
					}
				}
				for(;i<currentField.size();i++)
				{
					if(currentField.get(i).getButton().equals(b))
						break;
				}
				if(spellSelected instanceof MinionTargetSpell)
				{					
					try {
						model.getCurrentHero().castSpell((MinionTargetSpell) spellSelected,m);
					} catch (NotYourTurnException | NotEnoughManaException | InvalidTargetException e) {
						throwException(e);
					}
				}
				reconstructCurrentHand();
				reconstructOpponentField();
				reconstructCurrentField();
				
				updateview();
				spellSelected=null;
				
			}
		}
		if(b.getActionCommand().equals("currentField") && spellSelected==null && !heroPowerPressed)
		{
			attacker=(Minion) o;
			view.getChooseTarget().setVisible(true);
			view.getCloseChooseTarget().setVisible(true);
		}
		else
		{
			
			if(spellSelected==null && attacker != null && o instanceof Minion && (b.getActionCommand().equals("currentField")|| b.getActionCommand().equals("opponentField")))
			{
				try {
					model.getCurrentHero().attackWithMinion(attacker, (Minion) o);
					reconstructOpponentField();	
					reconstructCurrentField();
				} catch (CannotAttackException | NotYourTurnException | TauntBypassException | InvalidTargetException
						| NotSummonedException e) {
					throwException(e);			
				}
				attacker=null;
			}
			if(spellSelected==null && attacker != null && b.getActionCommand().equals("opponentButton"))
			{
				try {
					model.getCurrentHero().attackWithMinion(attacker, model.getOpponent());
					view.getOpponentHP().setText(model.getOpponent().getCurrentHP()+"");
				} catch (CannotAttackException | NotYourTurnException | TauntBypassException | InvalidTargetException
						| NotSummonedException e) {
					throwException(e);			
				}
				attacker=null;
			}
		}
		}		
		else
		{
			if(b.getActionCommand().equals("endturn"))
			{try {
				
				model.endTurn();
			} catch (FullHandException | CloneNotSupportedException e) {
				throwException(e);
				
			}
			endTurn();
			}
		}
		if(b.getActionCommand().equals("heroPower"))
		{
			if(model.getCurrentHero() instanceof Hunter ||
			   model.getCurrentHero() instanceof Warlock ||
			   model.getCurrentHero() instanceof Paladin)
			{
				try{
					
					model.getCurrentHero().useHeroPower();
					useHeroPower();
					}
				catch (NotEnoughManaException | HeroPowerAlreadyUsedException
						| NotYourTurnException | FullHandException
						| FullFieldException | CloneNotSupportedException e) {
					throwException(e);}
			}
			else
			{
				heroPowerPressed=true;
				selected=b;
			}
		}
		if(model !=null && model.getCurrentHero() instanceof Mage &&
		   !b.getActionCommand().equals("heroPower") &&
		   heroPowerPressed)
		{	
			int x = buttons.indexOf(b);
			if(b.getActionCommand().equals("opponentButton"))
			{
				try {
					((Mage)model.getCurrentHero()).useHeroPower(model.getOpponent());
					updateview();
				} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
						| NotYourTurnException | FullHandException
						| FullFieldException | CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throwException(e);
				}
			}
			else
			{
				Object o;
				if(x!=-1)
				{
					o = all.get(x);

					try {
						powerMage(o);
					} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
							| NotYourTurnException | FullHandException
							| FullFieldException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throwException(e);
					}


				}
				else
					heroPowerPressed=false;
				}
		}
		
		if(model !=null && model.getCurrentHero() instanceof Priest &&
				   !b.getActionCommand().equals("heroPower") &&
				   heroPowerPressed)
				{	
					if(b.getActionCommand().equals("currentButton"))
					{
						try {
							((Priest)model.getCurrentHero()).useHeroPower(model.getCurrentHero());
							updateview();
						} catch (NotEnoughManaException | HeroPowerAlreadyUsedException
								| NotYourTurnException | FullHandException
								| FullFieldException | CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throwException(e);
						}
					}
					else
					{
						int x = buttons.indexOf(b);
						Object o;
						if(x!=-1)
						{
							o=all.get(x);
							try {
								powerPriest(o);
							} catch (NotEnoughManaException
									| HeroPowerAlreadyUsedException
									| NotYourTurnException | FullHandException
									| FullFieldException
									| CloneNotSupportedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								throwException(e);
							}
						}
						else
							heroPowerPressed=false;
					}
				}
		

				
	}
	public void useHeroPower() throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException
	{
		
		view.getCurrentCurrentAndTotalManaCrystals().setText(model.getCurrentHero().getCurrentManaCrystals()+ "/" + model.getCurrentHero().getTotalManaCrystals());
		
		if(model.getCurrentHero() instanceof Hunter)
			powerHunter();
//		if(hero1 instanceof Mage)
//			powerMage();
		if(model.getCurrentHero() instanceof Paladin)
			powerPaladin();
//		if(hero1 instanceof Priest)
//			powerPriest();
		if(model.getCurrentHero() instanceof Warlock)
			powerWarlock();
	}
	

	private void powerWarlock() {
		view.getCurrentHP().setText(model.getCurrentHero().getCurrentHP()+"");
		reconstructCurrentHand();
		reconstructCurrentField();
	}
	private void powerPriest(Object o) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException {
		if(o instanceof Minion)
			((Priest)model.getCurrentHero()).useHeroPower((Minion)o);
		
		updateview();
		heroPowerPressed=false;		
	}
	private void powerPaladin() {
		reconstructCurrentHand();
		reconstructCurrentField();
	}
	private void powerMage(Object o) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException {
		if(o instanceof Minion)
			((Mage)model.getCurrentHero()).useHeroPower((Minion)o);
		updateview();
		heroPowerPressed=false;
	}
	private void powerHunter() {
		view.getOpponentHP().setText(model.getOpponent().getCurrentHP()+"");
	}
	public void endTurn() 
	{
		if(zoomFlag)
			killZoom();
		Hero temp = hero1;
		hero1=hero2;
		hero2=temp;

		ImageIcon tempImage = (ImageIcon) view.getCurrentImage().getIcon();
		view.getCurrentImage().setIcon(view.getOpponentImage().getIcon());
		view.getOpponentImage().setIcon(tempImage);
		JLabel t = new JLabel(view.getCurrentHP().getText());
		view.getCurrentHP().setText(view.getOpponentHP().getText());
		view.getCurrentHP().setText(t.getText());
		for(int i=0; i<7; i++)
		{
			FieldPanel p = new FieldPanel();
			FieldPanel curr = currentField.get(i);
			FieldPanel opp = opponentField.get(i);
			p.setHp(curr.getHp());
			p.setAttack(curr.getAttack());
			p.getButton().setIcon(curr.getButton().getIcon());
			curr.setHp(opp.getHp());
			curr.setAttack(opp.getAttack());
			if(opp.getButton().getIcon()!=null)
			{	int r = buttons.indexOf(opp.getButton());
				buttons.remove(r);
				Card c = (Card) all.get(r);
				all.remove(c);
				buttons.add(curr.getButton());
				all.add(c);
			}
			if(curr.getButton().getIcon()!=null)
			{	int r = buttons.indexOf(curr.getButton());
				buttons.remove(r);
				Card c = (Card) all.get(r);
				all.remove(c);
				buttons.add(opp.getButton());
				all.add(c);
			}
			
			curr.getButton().setIcon(opp.getButton().getIcon());
			opp.setHp(p.getHp());
			opp.setAttack(p.getAttack());
			opp.getButton().setIcon(p.getButton().getIcon());
			if(curr.isOpaque())
				p.setOpaque(true);
			else
				p.setOpaque(false);
			if(opp.isOpaque())
				curr.setOpaque(true);
			else
				curr.setOpaque(false);
			if(p.isOpaque())
				opp.setOpaque(true);
			else
				opp.setOpaque(false);
			
		}
		
		
		for(int i=0; i<currentHand.size(); i++)
		{
			HandPanel p = currentHand.get(i);
			if(p.getButton().getIcon()!=null)
			{
				int r = buttons.indexOf(p.getButton());
				buttons.remove(p.getButton());
				all.remove(r);
			}
			p.getButton().setIcon(null);
			p.setHp(null);
			p.setAttack(null);
		}
//		ArrayList <Card> tempHand = hand1;
		hand1=model.getCurrentHero().getHand();
		hand2=model.getOpponent().getHand();
		deck1=model.getCurrentHero().getDeck();
		deck2=model.getOpponent().getDeck();
		for(int i=0; i<hand1.size(); i++)
		{
			Card c = hand1.get(i);
			ImageIcon imageIcon;
			if(c instanceof Minion)
				imageIcon = new ImageIcon(new ImageIcon("Minions\\"+ c.getName() + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));
			else
				imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ c.getName() + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));
			if(c instanceof ShadowWordDeath)
				imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ "ShadowWordDeath" + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));

				if(c instanceof Minion)
				{
					currentHand.get(i).setHp(((Minion) c).getCurrentHP() + "");
					currentHand.get(i).setAttack(((Minion) c).getAttack() + "");
				}
				JButton k = currentHand.get(i).getButton();
				all.add(c);
				k.setIcon(imageIcon);
				buttons.add(k);
				k.addActionListener(this);
				k.setOpaque(false);
				k.setContentAreaFilled(false);
				k.setBorderPainted(false);
		}
	
		for(int i=0; i<opponentHand.size(); i++)
			opponentHand.get(i).setVisible(false);

		for(int i=0; i<hand2.size(); i++)
			opponentHand.get(i).setVisible(true);
		for(int i=0; i<currentField.size();i++)
			currentField.get(i).getSleep().setVisible(false);
		for(int i=0; i<opponentField.size();i++)
			opponentField.get(i).getSleep().setVisible(false);

		
		view.getCurrentCurrentAndTotalManaCrystals().setText(model.getCurrentHero().getCurrentManaCrystals() + "/" + model.getCurrentHero().getTotalManaCrystals());
		view.getOpponentCurrentAndTotalManaCrystals().setText(model.getOpponent().getCurrentManaCrystals() + "/" + model.getOpponent().getTotalManaCrystals());
		view.getCurrentCardsLeftOnDeck().setText(deck1.size()+"");
		view.getOpponentCardsLeftOnDeck().setText(deck2.size()+"");
		updateview();
		
//		JLabel s = new JLabel(view.getCurrentCardsLeftOnDeck().getText());
//		view.getCurrentCardsLeftOnDeck().setText(view.getOpponentCardsLeftOnDeck().getText());
//		view.getOpponentCardsLeftOnDeck().setText(s.getText());
		if(hero1 instanceof Hunter)
		{
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Hunter.png"));
		}
		if(hero1 instanceof Mage)
		{
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Mage.png"));
		}
		if(hero1 instanceof Paladin)
		{
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Paladin.png"));
		}
		if(hero1 instanceof Priest)
		{
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Priest.png"));
		}
		if(hero1 instanceof Warlock)
		{
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Warlock.png"));
		}
		
		reconstructCurrentField();
		reconstructCurrentHand();
		reconstructOpponentField();
		
		String name = view.getCurrentName().getText();
		view.getCurrentName().setText(view.getOpponentName().getText());
		view.getOpponentName().setText(name);

	}
	
	
	

	public void addingToField(Card c) throws NotYourTurnException, NotEnoughManaException, FullFieldException
	{
		model.getCurrentHero().playMinion((Minion)c);
		reconstructCurrentHand();
		reconstructCurrentField();
		
		view.getCurrentCurrentAndTotalManaCrystals().setText(model.getCurrentHero().getCurrentManaCrystals() + "/" + model.getCurrentHero().getTotalManaCrystals());
		zoomFlag=false;
		view.getZoomDivine().setVisible(false);
		view.getZoomHP().setVisible(false);
		view.getZoomAttack().setVisible(false);
		int r = buttons.indexOf(zoomButton);
		buttons.remove(zoomButton);
		all.remove(r);
		zoomButton.setIcon(null);
	
		for(int i=0; i<hand1.size(); i++)
		{
			Card l = hand1.get(i);
			if(l.getManaCost()==0)
			{
				currentHand.get(i).getManacostImage().setVisible(true);
				currentHand.get(i).getManacost().setText("0");
			}
			else
			{
				currentHand.get(i).getManacostImage().setVisible(false);
				currentHand.get(i).getManacost().setText("");
			}
		}
		for(int i=0; i<model.getCurrentHero().getField().size(); i++)
		{
			Card l = model.getCurrentHero().getField().get(i);
			if(l.getManaCost()==0)
			{
				currentField.get(i).getManacostImage().setVisible(true);
				currentField.get(i).getManacost().setText("0");
			}
			else
			{
				currentField.get(i).getManacostImage().setVisible(false);
				currentField.get(i).getManacost().setText("");
			}
		}
		for(int i=0; i<model.getOpponent().getField().size(); i++)
		{
			Card l = model.getOpponent().getField().get(i);
			if(l.getManaCost()==0)
			{
				opponentField.get(i).getManacostImage().setVisible(true);
				opponentField.get(i).getManacost().setText("0");
			}
			else
			{
				opponentField.get(i).getManacostImage().setVisible(false);
				opponentField.get(i).getManacost().setText("");
			}
		}
		
		
		

		
	}
	
	
	public void editingtheZoom(Card c) {
		ImageIcon imageIcon;
		if(c instanceof Minion)
			imageIcon = new ImageIcon(new ImageIcon("Minions\\"+ c.getName() + ".png").getImage().getScaledInstance(200, 300, Image.SCALE_FAST));
		else
			imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ c.getName() + ".png").getImage().getScaledInstance(200, 300, Image.SCALE_FAST));
		if(c instanceof ShadowWordDeath)
			imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ "ShadowWordDeath" + ".png").getImage().getScaledInstance(200, 300, Image.SCALE_FAST));
		zoomButton.setIcon(imageIcon);
		int r = buttons.indexOf(zoomButton);
		if(c instanceof Minion)
		{
			Minion m = (Minion) c;
			view.getZoomHP().setText(m.getCurrentHP()+"");
			view.getZoomAttack().setText(m.getAttack()+"");
			if(m.getManaCost()==0)
			{
				view.getZoomManacostImage().setVisible(true);
				view.getZoomManacost().setText("0");
			}
			if(m.isDivine())
				view.getZoomDivine().setVisible(true);
		}
		else
		{
			view.getZoomHP().setText("");
			view.getZoomAttack().setText("");
		}
		all.remove(r);
		all.add(c);		
	}
	public void addingToZoom(Card c)
	{
		ImageIcon imageIcon;
		if(c instanceof Minion)
			imageIcon = new ImageIcon(new ImageIcon("Minions\\"+ c.getName() + ".png").getImage().getScaledInstance(200, 300, Image.SCALE_FAST));
		else
			imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ c.getName() + ".png").getImage().getScaledInstance(200, 300, Image.SCALE_FAST));
		if(c instanceof ShadowWordDeath)
			imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ "ShadowWordDeath" + ".png").getImage().getScaledInstance(200, 300, Image.SCALE_FAST));
		zoomButton.setIcon(imageIcon);
		
		all.add(c);
		buttons.add(zoomButton);
		view.getZoomPanel().setVisible(true);
		if(c instanceof Minion)
		{
			Minion m = (Minion) c;
			view.getZoomHP().setText(m.getCurrentHP()+"");
			view.getZoomAttack().setText(m.getAttack()+"");
			if(m.getManaCost()==0)
			{
				view.getZoomManacostImage().setVisible(true);
				view.getZoomManacost().setText("0");
			}
			if(m.isDivine())
				view.getZoomDivine().setVisible(true);
		}
		zoomFlag=true;
	}
	
	public void chooseHero(Hero h , JButton b) throws FullHandException, CloneNotSupportedException, IOException
	{
		if(selected == null){
			view.getCurrentImage().setVisible(true);
			hero1=h;
			selected = b;
		}
		else
		{
			
			view.getOpponentImage().setVisible(true);
			if(h instanceof Hunter)
				hero2 = new Hunter();
			if(h instanceof Mage)
				hero2 = new Mage();
			if(h instanceof Paladin)
				hero2 = new Paladin();
			if(h instanceof Priest)
				hero2 = new Priest();
			if(h instanceof Warlock)
				hero2 = new Warlock();
			removeFromView(view.getbHunter());
			removeFromView(view.getbMage());
			removeFromView(view.getbPaladin());
			removeFromView(view.getbPriest());
			removeFromView(view.getbWarlock());
			view.getbHunter().setVisible(false);
			view.getbMage().setVisible(false);
			view.getbPaladin().setVisible(false);
			view.getbPriest().setVisible(false);
			view.getbWarlock().setVisible(false);
			view.getFirstBoard().setVisible(false);
			model=new Game(hero1,hero2);
			model.setListener(this);
			hero1=model.getCurrentHero();
			hero2=model.getOpponent();
			deck1 = model.getCurrentHero().getDeck();
			deck2 = model.getOpponent().getDeck();
			view.getCurrentCardsLeftOnDeck().setText(deck1.size()+"");
			view.getOpponentCardsLeftOnDeck().setText(deck2.size()+"");
			hand1 = model.getCurrentHero().getHand();
			hand2 = model.getOpponent().getHand();
			view.getCurrentCurrentAndTotalManaCrystals().setText(model.getCurrentHero().getCurrentManaCrystals() + "/" + model.getCurrentHero().getTotalManaCrystals());
			view.getOpponentCurrentAndTotalManaCrystals().setText(model.getOpponent().getCurrentManaCrystals() + "/" + model.getOpponent().getTotalManaCrystals());
			for(int i=0; i<hand1.size(); i++)
			{
				Card c = hand1.get(i);
				ImageIcon imageIcon;
				if(c instanceof Minion)
					imageIcon = new ImageIcon(new ImageIcon("Minions\\"+ c.getName() + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));
				else
					imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ c.getName() + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));
				if(c instanceof ShadowWordDeath)
					imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ "ShadowWordDeath" + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));

				JButton k = currentHand.get(i).getButton();
				if(c instanceof Minion)
				{
					Minion m = (Minion) c;
					currentHand.get(i).setHp(m.getCurrentHP()+"");
					currentHand.get(i).setAttack(m.getAttack()+"");
				}
				all.add(c);
				k.setIcon(imageIcon);
				buttons.add(k);
				k.addActionListener(this);
				k.setOpaque(false);
				k.setContentAreaFilled(false);
				k.setBorderPainted(false);

			}
			for(int i=0; i<hand2.size(); i++)
			{

				opponentHand.get(i).setVisible(true);

				
			}
				
		}
		if(hero1 instanceof Hunter)
		{
			view.getCurrentImage().setIcon(new ImageIcon("hero images\\Hunter.png"));
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Hunter.png"));
		}
		if(hero2 instanceof Hunter)
			view.getOpponentImage().setIcon(new ImageIcon("hero images\\Hunter.png"));
		if(hero1 instanceof Mage)
		{
			view.getCurrentImage().setIcon(new ImageIcon("hero images\\Mage.png"));
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Mage.png"));
		}
		if(hero2 instanceof Mage)
			view.getOpponentImage().setIcon(new ImageIcon("hero images\\Mage.png"));
		if(hero1 instanceof Paladin)
		{
			view.getCurrentImage().setIcon(new ImageIcon("hero images\\Paladin.png"));
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Paladin.png"));
		}
		if(hero2 instanceof Paladin)
			view.getOpponentImage().setIcon(new ImageIcon("hero images\\Paladin.png"));
		if(hero1 instanceof Priest)
		{
			view.getCurrentImage().setIcon(new ImageIcon("hero images\\Priest.png"));
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Priest.png"));
		}
		if(hero2 instanceof Priest)
			view.getOpponentImage().setIcon(new ImageIcon("hero images\\Priest.png"));
		if(hero1 instanceof Warlock)
		{
			view.getCurrentImage().setIcon(new ImageIcon("hero images\\Warlock.png"));
			view.getHeroPowerImage().setIcon(new ImageIcon("Hero Powers\\Warlock.png"));
		}
		if(hero2 instanceof Warlock)
			view.getOpponentImage().setIcon(new ImageIcon("hero images\\Warlock.png"));
	}
	
	
	public void throwException(Exception x)
	{
		ImageIcon imageIcon= new ImageIcon();
		if(x instanceof CannotAttackException)
			imageIcon=new ImageIcon("Exceptions\\CannotAttackException.png");
		if(x instanceof FullFieldException)
			imageIcon=new ImageIcon("Exceptions\\FullFieldException.png");
		if(x instanceof FullHandException)
			imageIcon=new ImageIcon("Exceptions\\FullHandException.png");
		if(x instanceof InvalidTargetException)
			imageIcon=new ImageIcon("Exceptions\\InvalidTargetException.png");
		if(x instanceof NotEnoughManaException)
			imageIcon=new ImageIcon("Exceptions\\NotEnoughManaException.png");
		if(x instanceof NotSummonedException)
			imageIcon=new ImageIcon("Exceptions\\NotSummonedException.png");
		if(x instanceof NotYourTurnException)
			imageIcon=new ImageIcon("Exceptions\\NotYourTurnException.png");
		if(x instanceof TauntBypassException)
			imageIcon=new ImageIcon("Exceptions\\TauntBypassException.png");
		if(x instanceof HeroPowerAlreadyUsedException)
			imageIcon=new ImageIcon("Exceptions\\HeroPowerAlreadyUsedException.png");
		
		view.getException().setIcon(imageIcon);
		view.getException().setVisible(true);
		view.getCloseException().setVisible(true);
		if(zoomFlag)
		{
		zoomFlag=false;
		view.getZoomPanel().setVisible(false);
		int r = buttons.indexOf(zoomButton);
		buttons.remove(zoomButton);
		all.remove(r);
		zoomButton.setIcon(null);
		}
		
		
	}

	public void reconstructCurrentField ()
	{
		for(int i=0; i<currentField.size(); i++)
		{
			FieldPanel p = currentField.get(i);
			if(p.getButton().getIcon()!=null)
			{
				int r = buttons.indexOf(p.getButton());
				buttons.remove(p.getButton());
				all.remove(r);
			}
			currentField.get(i).getManacostImage().setVisible(false);
			currentField.get(i).getManacost().setText("");
			currentField.get(i).getDivine().setVisible(false);
			p.getButton().setIcon(null);
			p.setHp(null);
			p.setAttack(null);
			
		}
		for(int i=0; i<model.getCurrentHero().getField().size(); i++)
		{
			Card l = model.getCurrentHero().getField().get(i);
			ImageIcon imageIcon;
			imageIcon = new ImageIcon(new ImageIcon("Minions\\"+ l.getName() + ".png").getImage().getScaledInstance(view.getField1().getWidth()-4, view.getField1().getHeight()-4, Image.SCALE_DEFAULT));
			currentField.get(i).setHp(((Minion) l).getCurrentHP() + "");
			currentField.get(i).setAttack(((Minion) l).getAttack() + "");
			currentField.get(i).getSleep().setVisible(((Minion) l).isSleeping());
			if(l.getManaCost()==0)
			{
				currentField.get(i).getManacostImage().setVisible(true);
				currentField.get(i).getManacost().setText("0");
			}
			if(l instanceof Minion && ((Minion)l).isDivine())
				currentField.get(i).getDivine().setVisible(true);
			JButton k = currentField.get(i).getButton();
			k.setActionCommand("currentField");
			
			k.setIcon(imageIcon);
			
			k.addActionListener(this);
			k.setOpaque(false);
			k.setContentAreaFilled(false);
			k.setBorderPainted(false);
			
			all.add(l);
			buttons.add(k);
		}
		
	}
	public void reconstructOpponentField()
	{
		for(int i=0; i<opponentField.size(); i++)
		{
			FieldPanel p = opponentField.get(i);
			if(p.getButton().getIcon()!=null)
			{
				int r = buttons.indexOf(p.getButton());
				buttons.remove(p.getButton());
				all.remove(r);
			}
			opponentField.get(i).getManacostImage().setVisible(false);
			opponentField.get(i).getManacost().setText("");
			opponentField.get(i).getDivine().setVisible(false);
			p.getButton().setIcon(null);
			p.setHp(null);
			p.setAttack(null);
		}
		for(int i=0; i<model.getOpponent().getField().size(); i++)
		{
			Card l = model.getOpponent().getField().get(i);
			ImageIcon imageIcon;
			imageIcon = new ImageIcon(new ImageIcon("Minions\\"+ l.getName() + ".png").getImage().getScaledInstance(view.getField1().getWidth()-4, view.getField1().getHeight()-4, Image.SCALE_DEFAULT));
			opponentField.get(i).setHp(((Minion) l).getCurrentHP() + "");
			opponentField.get(i).setAttack(((Minion) l).getAttack() + "");
			opponentField.get(i).getSleep().setVisible(((Minion) l).isSleeping());
			if(l.getManaCost()==0)
			{
				opponentField.get(i).getManacostImage().setVisible(true);
				opponentField.get(i).getManacost().setText("0");
			}
			if(l instanceof Minion && ((Minion)l).isDivine())
				opponentField.get(i).getDivine().setVisible(true);
			JButton k = opponentField.get(i).getButton();
			k.setActionCommand("opponentField");
			
			k.setIcon(imageIcon);
			
			k.addActionListener(this);
			k.setOpaque(false);
			k.setContentAreaFilled(false);
			k.setBorderPainted(false);
			
			all.add(l);
			buttons.add(k);
		}
		
	}
	
	public void reconstructCurrentHand()
	{
		for(int i=0; i<currentHand.size(); i++)
		{
			HandPanel p = currentHand.get(i);
			if(p.getButton().getIcon()!=null)
			{
				int r = buttons.indexOf(p.getButton());
				buttons.remove(p.getButton());
				all.remove(r);
			}
			currentHand.get(i).getManacostImage().setVisible(false);
			currentHand.get(i).getManacost().setText("");
			currentHand.get(i).getDivine().setVisible(false);
			p.getButton().setIcon(null);
			p.setHp(null);
			p.setAttack(null);
		}
		for(int i=0; i<hand1.size(); i++)
		{
			Card c = hand1.get(i);
			ImageIcon imageIcon;
			if(c instanceof Minion)
				imageIcon = new ImageIcon(new ImageIcon("Minions\\"+ c.getName() + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));
			else
				imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ c.getName() + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));
			if(c instanceof ShadowWordDeath)
				imageIcon = new ImageIcon(new ImageIcon("Spells\\"+ "ShadowWordDeath" + ".png").getImage().getScaledInstance(view.getCurrentHand1().getWidth()-4, view.getCurrentHand1().getHeight()-4, Image.SCALE_FAST));
			
			JButton k = currentHand.get(i).getButton();
			if(c instanceof Minion)
			{
				Minion m = (Minion) c;
				currentHand.get(i).setHp(m.getCurrentHP()+"");
				currentHand.get(i).setAttack(m.getAttack()+"");
			}
			if(c.getManaCost()==0)
			{
				currentHand.get(i).getManacostImage().setVisible(true);
				currentHand.get(i).getManacost().setText("0");
			}
			if(c instanceof Minion && ((Minion)c).isDivine())
				currentHand.get(i).getDivine().setVisible(true);
			all.add(c);
			k.setIcon(imageIcon);
			k.addActionListener(this);
			k.setOpaque(false);
			k.setContentAreaFilled(false);
			k.setBorderPainted(false);

			buttons.add(k);
		
		}
		
	}
	public void updateview()
	{
		view.getCurrentHP().setText(model.getCurrentHero().getCurrentHP()+"");
		view.getOpponentHP().setText(model.getOpponent().getCurrentHP()+"");
		
		view.getCurrentCurrentAndTotalManaCrystals().setText(model.getCurrentHero().getCurrentManaCrystals()+ "/" + model.getCurrentHero().getTotalManaCrystals());
		view.getOpponentCurrentAndTotalManaCrystals().setText(model.getOpponent().getCurrentManaCrystals()+ "/" + model.getOpponent().getTotalManaCrystals());
		for(int i=0;i<model.getCurrentHero().getField().size();i++)
		{
			currentField.get(i).setAttack(model.getCurrentHero().getField().get(i).getAttack()+ "");
			currentField.get(i).setHp(model.getCurrentHero().getField().get(i).getCurrentHP()+ "");
		}
		for(int i=0;i<model.getOpponent().getField().size();i++)
		{
			opponentField.get(i).setAttack(model.getOpponent().getField().get(i).getAttack()+ "");
			opponentField.get(i).setHp(model.getOpponent().getField().get(i).getCurrentHP()+ "");
		}
	}
	public void killZoom()
	{
		zoomFlag=false;
		view.getZoomPanel().setVisible(false);
		int r = buttons.indexOf(zoomButton);
		buttons.remove(zoomButton);
		all.remove(r);
		zoomButton.setIcon(null);
		view.getZoomHP().setVisible(false);
		view.getZoomAttack().setVisible(false);
		view.getZoomDivine().setVisible(false);
	
	}
	public static void main(String[] args) throws IOException, CloneNotSupportedException, FullHandException {
		new Controller();
	}



	


	
	
	

}
