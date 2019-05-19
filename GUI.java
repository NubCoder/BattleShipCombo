import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;


public class GUI {
	
	private JFrame GUI;
	private boolean run;
	int startX = -1;
	int startY = -1;
	
	public GUI() {

		GUI = new JFrame("Battleship");
		
		GUI.setLayout(new GridLayout(10,10));
		
		GUI.setSize(1000, 1000);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.setVisible(true);

		
		
	}
	
	public String preQuestions() {
		
		JLabel label = new JLabel("Welcome to Battleship!");
		JLabel label2 = new JLabel("In this game, you will be playing against a computer and trying to hit its ships");
		JLabel label3 = new JLabel("Before we start playing the game, we need to set up your ships");
		JLabel label4 = new JLabel("What do you want your name to be? ");
		JTextField name = new JTextField(20);
		JButton submit = new JButton("Play");
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				run = true;
				
			}
		});
		
		GUI.add(label);
		GUI.add(label2);
		GUI.add(label3);
		GUI.add(label4);
		GUI.add(name);
		GUI.add(submit);
		GUI.setVisible(true);
		
		while (!run) {
			System.out.print("");
		}
		
		String text = name.getText();
		return text;
		
		

		
		
	}
	
	public String setShip(Ships s, String[][] field) {
		startX = -1;
		startY = -1;
		
		run = false;
		GUI.setLayout(null);
		//JPanel grid = new JPanel();
		//grid.setLayout(new GridLayout(10,10));
		JPanel z = new JPanel();
		z.setLayout(new GridLayout(10,10));
		z.setSize(500,500);
		z.setBackground(new Color(125, 200, 225));
		z.setBorder(BorderFactory.createLineBorder(new Color(25, 150, 200)));
		//z.setLayout(new GridLayout(10, 1));
		//z.setLayout(new BoxLayout(z, BoxLayout.CENTER));
		//z.setLayout(new GridLayout(10,10));
		
	    
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				JButton button;
				if (field[i][k] == "-") {
					button = new JButton(" ");
				}else {
					button = new JButton(field[i][k]);
				}
				
				button.setPreferredSize(new Dimension(50, 50));
				//c.gridx = i;
				//c.gridy = k;
				z.add(button);
				
				int x = i;
				int y = k;
				
				
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						startX = x;
						startY = y;
						run = true;
						//System.out.println(startX);
						//System.out.println(startY);

					}
				});
				
				
			}

			
		}
		
		
		JLabel label = new JLabel("Please click the starting/ending point of your " + s.getName() + " ship. It is " + s.getLength() + " squares long.");
		label.setBounds(0, 465, 1000, 100);
		
		GUI.setPreferredSize(new Dimension(515,575));
		GUI.setResizable(true);

		GUI.add(z);
		GUI.add(label);
		
		
		GUI.pack();
		GUI.setVisible(true);
		
		
		while (startX == -1 && startY == -1) {
			System.out.print("");
			
			
		}
		System.out.println("");
		System.out.println("done");
		GUI.getContentPane().removeAll();
		
		
		return startX + "" + startY;
	}
	
	
	
	public String printBoard(String[][] field, String[][] compField) {
		
		run = false;
		GUI.getContentPane().removeAll();
		GUI.repaint();
		GUI.setLayout(null);
		JPanel z = new JPanel();
		z.setLayout(new GridLayout(10,10));
		z.setSize(500,500);
		z.setBackground(new Color(125, 200, 225));
		z.setBorder(BorderFactory.createLineBorder(new Color(25, 150, 200)));
	    
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				JButton button;
				if (field[i][k] == "-") {
					button = new JButton(" ");
				}else {
					button = new JButton(field[i][k]);
				}
				
				
				button.setPreferredSize(new Dimension(50, 50));
				z.add(button);
				
				int x = i;
				int y = k;
				
				
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						
					}
				});
				
				
			}

			
		}
		
		JPanel c = new JPanel();
		c.setLayout(new GridLayout(10,10));
		c.setSize(500,500);
		c.setBackground(new Color(225, 200, 125));
		c.setBorder(BorderFactory.createLineBorder(new Color(25, 150, 200)));
	    
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				JButton button;
				if (compField[i][k] == "-") {
					button = new JButton(" ");
				}else {
					button = new JButton(compField[i][k]);
				}
				
				button.setPreferredSize(new Dimension(50, 50));
				c.add(button);
				
				int x = i;
				int y = k;
				
				
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						startX = x;
						startY = y;
						run = true;
						

					}
				});
				
				
			}

			
		}
		
		JLabel yours = new JLabel("Your side:");
		JLabel computers = new JLabel("Computers side:");
		
		
		GUI.setPreferredSize(new Dimension(1030,600));
		GUI.setResizable(true);

		


		z.setBounds(0, 0, 500, 500);
		c.setBounds(500, 0, 500, 500);

		
		GUI.add(yours);
		GUI.add(computers);
		GUI.add(z);
		GUI.add(c);
		GUI.pack();
		GUI.setVisible(true);
	
		while (!run) {
			System.out.print("");
		}
		return startX + "" + startY;
		
		
	}

	public void sendErrorMessage(String s) {
		JOptionPane.showMessageDialog(GUI, s);
	}
	
	
	
	
}
