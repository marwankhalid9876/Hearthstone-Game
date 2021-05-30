package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ZoomPanel extends JPanel{
	private JButton button;
	private JLabel hp;
	private JLabel attack;
	
	
	public ZoomPanel()
	{
		setPreferredSize(new Dimension (220,320));
		setOpaque(false);
		setVisible(true);
		SpringLayout springLayout = new SpringLayout(); 
		this.setLayout(springLayout);
		
		
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
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, attack, 100, SpringLayout.VERTICAL_CENTER, this);
		
		button = new JButton();
		button.setPreferredSize(new Dimension(200, 300));
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
}
