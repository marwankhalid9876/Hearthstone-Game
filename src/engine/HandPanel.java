package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class HandPanel extends JPanel{
		private JButton button;
		private JLabel hp;
		private JLabel attack;
		private JLabel manacostImage;
		private JLabel manacost;
		private JLabel divine;
		public HandPanel()
		{
			setPreferredSize(new Dimension (66,95));
			setOpaque(false);
			setVisible(true);
			SpringLayout springLayout = new SpringLayout(); 
			this.setLayout(springLayout);
			
			manacost = new JLabel();
			manacost.setFont(new Font("Bookman", Font.BOLD, 18));
			manacost.setForeground(Color.WHITE);
			this.add(manacost);
			springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, manacost, -29, SpringLayout.HORIZONTAL_CENTER, this);
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, manacost, -42, SpringLayout.VERTICAL_CENTER, this);
			
			manacostImage = new JLabel();
			manacostImage.setPreferredSize(new Dimension(20,20));
			manacostImage.setIcon(new ImageIcon("manacost.png"));
			manacostImage.setFont(new Font("Bookman", Font.BOLD, 18));
			manacostImage.setForeground(Color.WHITE);
			this.add(manacostImage);
			springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, manacostImage, -29, SpringLayout.HORIZONTAL_CENTER, this);
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, manacostImage, -42, SpringLayout.VERTICAL_CENTER, this);
			manacostImage.setVisible(false);
			
			divine = new JLabel();
			divine.setText("Divine" + "\n" + "Shield");
			divine.setForeground(Color.WHITE);
			divine.setFont(new Font("Bookman", Font.BOLD, 8));
			divine.setPreferredSize(new Dimension(60, 110));
			divine.setVisible(false);
			divine.setOpaque(false);
			this.add(divine);
			springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, divine, 5, SpringLayout.HORIZONTAL_CENTER, this);
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, divine, 25, SpringLayout.VERTICAL_CENTER, this);
			
			hp = new JLabel();
			hp.setFont(new Font("Bookman", Font.BOLD, 15));
			hp.setForeground(Color.WHITE);
			this.add(hp);
			springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hp, 23, SpringLayout.HORIZONTAL_CENTER, this);
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, hp, 37, SpringLayout.VERTICAL_CENTER, this);
			
			
			attack = new JLabel();
			attack.setFont(new Font("Bookman", Font.BOLD, 15));
			attack.setForeground(Color.WHITE);
			this.add(attack);
			springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, attack, -22, SpringLayout.HORIZONTAL_CENTER, this);
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, attack, 37, SpringLayout.VERTICAL_CENTER, this);
			
			button = new JButton();
			button.setPreferredSize(new Dimension(62, 89));
			button.setContentAreaFilled(false);
			button.setOpaque(false);
			this.add(button);
		}
		public JButton getButton() {
			return button;
		}
		public void setButton(JButton button) {
			this.button = button;
		}
		public String getHp() {
			return hp.getText();
		}
		public void setHp(String s) {
			this.hp.setText(s); 
		}
		public String getAttack() {
			return attack.getText();
		}
		public void setAttack(String s) {
			this.attack.setText(s);
		}
		public void setPlace(JLabel background,SpringLayout springLayout, int x , int y)
		{
			background.add(this);
			springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this, x, SpringLayout.HORIZONTAL_CENTER, background);
			springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, this, y, SpringLayout.VERTICAL_CENTER, background);
		}
		public JLabel getManacostImage() {
			return manacostImage;
		}
		public void setManacostImage(JLabel manacostImage) {
			this.manacostImage = manacostImage;
		}
		public JLabel getManacost() {
			return manacost;
		}
		public void setManacost(JLabel manacost) {
			this.manacost = manacost;
		}
		public JLabel getDivine() {
			return divine;
		}
		public void setDivine(JLabel divine) {
			this.divine = divine;
		}
	
	}


