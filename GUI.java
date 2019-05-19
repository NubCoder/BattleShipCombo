import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
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
	ImageIcon boat = new ImageIcon("src/Boat.png");
	ImageIcon fire = new ImageIcon("src/fire.png");
	ImageIcon splash = new ImageIcon("src/splash.png");
	
	
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
	
	public String setShip(Ships s, String[][] field, String status) {
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
				}else if (field[i][k].equals("D") || field[i][k].equals("C") || field[i][k].equals("S")) {
					button = new JButton(boat);
				}
				else {
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
		
		
		JLabel label = new JLabel("Please click the " + status + " point of your " + s.getName() + " ship. It is " + s.getLength() + " squares long.");
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
		/**
		
		
		run = false;
		
		GUI.getContentPane().removeAll();
		GUI.repaint();
		z.setLayout(new GridLayout(10,10));
		z.setSize(500,500);
		z.setBackground(new Color(125, 200, 225));
		z.setBorder(BorderFactory.createLineBorder(new Color(25, 150, 200)));
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				JButton button;
				if (i == startX && k == startY) {
					button = new JButton(s.getName());
				}else {
					button = new JButton(" ");
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
						System.out.print(startX + " " + startY);
					}
				});
				
				
			}

			
		}
		
		GUI.setVisible(true);
		*/
		/**
		run = false;
		label = new JLabel("Please click the starting and ending point of your " + s.getName() + " ship. It is " + s.getLength() + " squares long");
		
		
		
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				JButton button = new JButton("-");
				GUI.add(button);
				int x = i;
				int y = k;
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						endX = x;
						endY = y;
						run = true;
						
					}
				});
			}
		}
		
		while (!run) {
			System.out.print("");
		}
		
		System.out.print(startX + startY + endX + endY);
		
		
		*/
	}
	
	
	
	public String printBoard(String[][] field, String[][] compField) {
		GUI.setBackground(Color.gray);
		run = false;
		GUI.getContentPane().removeAll();
		GUI.repaint();
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
				}else if (field[i][k].equals("X")){
					button = new JButton(fire);					
				}
				else if (field[i][k].equals("D") || field[i][k].equals("C") || field[i][k].equals("S")) {
					button = new JButton(boat);
				}else if (field[i][k].equals("O")) {
					button = new JButton(splash);
				}
				else {
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
						
					}
				});
				
				
			}

			
		}
		
		JPanel c = new JPanel();
		c.setLayout(new GridLayout(10,10));
		c.setSize(500,500);
		c.setBackground(new Color(225, 200, 125));
		c.setBorder(BorderFactory.createLineBorder(new Color(25, 150, 200)));
		//z.setLayout(new GridLayout(10, 1));
		//z.setLayout(new BoxLayout(z, BoxLayout.CENTER));
		//z.setLayout(new GridLayout(10,10));
		
	    
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				JButton button;
				if (compField[i][k].equals("-")) {
					button = new JButton(" ");
				}else if (compField[i][k].equals("X")) {
					button = new JButton(fire);
				}else if (compField[i][k].equals("D") || field[i][k].equals("S") || field[i][k].equals("C")) {
					button = new JButton(boat);
				}else if (compField[i][k].equals("O")) {
					button = new JButton(splash);
				}
				else {
					button = new JButton(compField[i][k]);
				}
				
				button.setPreferredSize(new Dimension(50, 50));
				//c.gridx = i;
				//c.gridy = k;
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
		
		JLabel yours = new JLabel("Home Base:");
		yours.setBounds(0,0,500,50);
		yours.setFont(new Font("Serif", Font.PLAIN, 50));
		
		JLabel computers = new JLabel("Enemy Base:");
		computers.setBounds(500,0,500,50);
		computers.setFont(new Font("Serif", Font.PLAIN, 50));
		
		JLabel messageToUser = new JLabel("Choose a location to attack");
		messageToUser.setBounds(0,550,1000,50);
		messageToUser.setFont(new Font("Serif", Font.PLAIN, 30));
		
		GUI.setPreferredSize(new Dimension(1000,650));
		GUI.setResizable(true);

		


		z.setBounds(0, 50, 500, 500);
		c.setBounds(500, 50, 500, 500);

		//GUI.add(z, BorderLayout.WEST);
		//GUI.add(c, BorderLayout.EAST);
		
		GUI.add(yours);
		GUI.add(computers);
		GUI.add(z);
		GUI.add(c);
		GUI.add(messageToUser);
		GUI.pack();
		GUI.setVisible(true);
		GUI.setResizable(false);
	
		while (!run) {
			System.out.print("");
		}
		return startX + "" + startY;
		
		
	}

	public void sendErrorMessage(String s) {
		JOptionPane.showMessageDialog(GUI, s);
	}
	
	public void sendEndMessage(String s) {
		int answer = JOptionPane.showConfirmDialog(null, "Would you like to play another time?", "Game Over", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
		
		if (answer == JOptionPane.YES_OPTION) {
			GUI.getContentPane().removeAll();
			GUI.repaint();
			System.out.println("true");
			closeWindow();
			PlayGameWithGui pg = new PlayGameWithGui();
			
		}
		if (answer == JOptionPane.NO_OPTION) {
			GUI.setVisible(false);
			GUI.dispose();
		}
		
	}
	
	public void closeWindow() {
		GUI.setVisible(false);
		GUI.dispose();
	}
	
	
	
}
