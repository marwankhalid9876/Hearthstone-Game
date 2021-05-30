package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class FieldPanel extends JPanel{
	private JButton button;
	private JLabel hp;
	private JLabel attack;
	private JLabel sleep;
	private JLabel manacostImage;
	private JLabel manacost;
	private JLabel divine;

	public FieldPanel()
	{
		setPreferredSize(new Dimension (79,115));
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
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("sleep.png").getImage().getScaledInstance(75, 108, Image.SCALE_DEFAULT));
		sleep = new JLabel(imageIcon);
		sleep.setPreferredSize(new Dimension(75, 108));
		sleep.setVisible(false);
		sleep.setOpaque(false);
		this.add(sleep);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, sleep, 0, SpringLayout.HORIZONTAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, sleep, 0, SpringLayout.VERTICAL_CENTER, this);
		
		divine = new JLabel();
		divine.setText("Divine" + "Shield");
		divine.setForeground(Color.WHITE);
		divine.setFont(new Font("Bookman", Font.BOLD, 9));
		divine.setPreferredSize(new Dimension(60, 110));
		divine.setVisible(false);
		divine.setOpaque(false);
		this.add(divine);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, divine, 0, SpringLayout.HORIZONTAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, divine, 35, SpringLayout.VERTICAL_CENTER, this);
		
		
		hp = new JLabel();
		hp.setFont(new Font("Bookman", Font.BOLD, 18));
		hp.setForeground(Color.WHITE);
		this.add(hp);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hp, 25, SpringLayout.HORIZONTAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, hp, 45, SpringLayout.VERTICAL_CENTER, this);
		
		
		attack = new JLabel();
		attack.setFont(new Font("Bookman", Font.BOLD, 18));
		attack.setForeground(Color.WHITE);
		this.add(attack);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, attack, -30, SpringLayout.HORIZONTAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, attack, 45, SpringLayout.VERTICAL_CENTER, this);
		
		button = new JButton();
		button.setPreferredSize(new Dimension(75, 108));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		this.add(button);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, button, 0, SpringLayout.VERTICAL_CENTER, this);
		
		
		
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
	public JLabel getSleep() {
		return sleep;
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
