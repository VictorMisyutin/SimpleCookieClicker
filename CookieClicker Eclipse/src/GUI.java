import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class GUI implements ActionListener {
	
	private double cookieValue = 1, cookiesPS = 0, clickerPrice = 10, grannyPrice = 50, factoryPrice = 100, farmPrice = 500;;
	private int totalMoney,clickers, grannies, factories, farms;
	private JLabel valueLabel, moneyLabel, PSLabel,displayLabel;
	private JPanel coock
		
		
		iePanel, moneyPanel, shopPanel, infoPanel, clickerInfoPanel, grannyInfoPanel, factoryInfoPanel, farmInfoPanel, displayPanel;
	private ImageIcon image;
	private JButton cookieButton, buyClicker, buyGranny, buyFactory, buyFarm, clickerInfo, grannyInfo, factoryInfo, farmInfo;
	private Font moneyFont;
	private Timer timer, panelTimer;
	
	public GUI() {
		
		// new font (font, style, size)
		
		moneyFont = new Font("Arial", Font.BOLD,13);
		//Create a JFrame Object
		JFrame frame = new JFrame();
	
		// set image
		try {
			image = new ImageIcon(getClass().getResource("Cookieee.jpg"));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Image Not Found");
		}   
		
		//create cookie button
		cookieButton = new JButton(image);

		
		// SHOP Buttons
		cookieButton.setSize(image.getIconWidth(), image.getIconHeight());
		cookieButton.addActionListener(this);
		
		buyClicker = new JButton("buy a clicker: $" + clickerPrice);
		buyClicker.addActionListener(this);
				
		buyGranny = new JButton("buy a Granny: $" + grannyPrice);
		buyGranny.addActionListener(this);
		buyGranny.setHorizontalAlignment(SwingConstants.CENTER);
		
		buyFactory = new JButton("buy a Factory: $" + factoryPrice);
		buyFactory.addActionListener(this);
		
		buyFarm = new JButton("buy a farm: $" + farmPrice);
		buyFarm.addActionListener(this);

		
		// info Buttons
		clickerInfo = new JButton("?");
		clickerInfo.addActionListener(this);
		
		grannyInfo = new JButton("?");
		grannyInfo.addActionListener(this);
		
		factoryInfo = new JButton("?");
		factoryInfo.addActionListener(this);
		
		farmInfo = new JButton("?");
		farmInfo.addActionListener(this);;
		
		//labels
		
		valueLabel = new JLabel("Each Cookie Click is Worth: " + cookieValue);
		moneyLabel = new JLabel("Cookies: $" + totalMoney);
		moneyLabel.setFont(moneyFont);
		PSLabel = new JLabel ("You are making $" + cookiesPS + " a second");
	    displayLabel = new JLabel();
		
		//Create JPanel object
		coockiePanel = new JPanel();
		moneyPanel = new JPanel();
		infoPanel = new JPanel();
		shopPanel = new JPanel();
		clickerInfoPanel = new JPanel();
		grannyInfoPanel = new JPanel();
		factoryInfoPanel = new JPanel();
		farmInfoPanel = new JPanel();
		displayPanel = new JPanel();
		
		
		//set up panels
		
		//panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		coockiePanel.setLayout(new GridLayout());
		coockiePanel.setBounds(50, 200, 300, 300);

		//coockiePanel.setBackground(Color.red);
		coockiePanel.add(cookieButton);
		
		moneyPanel.setLayout(new GridLayout());
		moneyPanel.setBounds(160, 50, 170, 50);
		moneyPanel.add(moneyLabel);
		
		infoPanel.setLayout(new GridLayout(2,1));
		infoPanel.setBounds(440, 90,250,45);
		//infoPanel.setBackground(Color.red);
		infoPanel.add(valueLabel);
		infoPanel.add(PSLabel);
		
		shopPanel.setLayout(new GridLayout(4,1));
		shopPanel.setBounds(400, 150, 250, 400);
		shopPanel.setBackground(Color.red);
	
		//panel.add(moneyLabel);	
		//shopPanel.add(label);
		shopPanel.add(buyClicker);
		shopPanel.add(buyGranny);
		shopPanel.add(buyFactory);
		shopPanel.add(buyFarm);
		
		clickerInfoPanel.setLayout(new GridLayout());
		clickerInfoPanel.setBounds(590, 150, 60, 40);
		clickerInfoPanel.add(clickerInfo);
		
		grannyInfoPanel.setLayout(new GridLayout());
		grannyInfoPanel.setBounds(590, 250, 60, 40);
		grannyInfoPanel.add(grannyInfo);
		
		factoryInfoPanel.setLayout(new GridLayout());
		factoryInfoPanel.setBounds(590, 350, 60, 40);
		factoryInfoPanel.add(factoryInfo);
		
		farmInfoPanel.setLayout(new GridLayout());
		farmInfoPanel.setBounds(590, 450, 60, 40);
		farmInfoPanel.add(farmInfo);
		
		displayPanel.setLayout(new GridLayout());
		displayPanel.setBounds(100, 100, 300, 50);
		displayPanel.add(displayLabel);
		//displayPanel.setBackground(Color.LIGHT_GRAY);
		displayPanel.setVisible(false);
		
		//what to do when closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set title of window
		frame.setTitle("Cookie Clicker: Victor Misyutin");
		frame.setLayout(null);
		frame.setSize(700,700);
		
		
		//add panel to frame
		frame.add(displayPanel);
		frame.add(coockiePanel);
		frame.add(moneyPanel);
		frame.add(clickerInfoPanel);
		frame.add(grannyInfoPanel);
		frame.add(factoryInfoPanel);
		frame.add(farmInfoPanel);
		frame.add(shopPanel);
		frame.add(infoPanel);

		frame.setVisible(true);
		
		
		setTimer();
		timer.start();
	}
	
	public void setTimer() {
		timer = new Timer(1000, new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					totalMoney+= cookiesPS;
					moneyLabel.setText("Cookies: $" + totalMoney);
				}
		});
		
		panelTimer = new Timer(6000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e ) {
				displayPanel.setVisible(false);
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		new GUI();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Cookie Clicked Event
		if(e.getSource() == cookieButton) {
			totalMoney+=cookieValue;
		}
		
		// Shop Events
		else if(e.getSource() == buyClicker) {
			if(totalMoney >= 10) {
				totalMoney-=10;
				clickers++;
				cookieValue+=1;
				cookiesPS+= 1.3;
				clickerPrice += (int)clickers*1.2;
				buyClicker.setText("buy a clicker: $" + clickerPrice);
			}
		}
		else if(e.getSource() == buyGranny) {
			if(totalMoney >= 50) {
				totalMoney-=50;
				grannies++;
				cookieValue+=5;
				cookiesPS+= 5.2;
				grannyPrice += (int)grannies*1.3;
				buyGranny.setText("buy a granny: $" + grannyPrice);
			}
		}
		else if(e.getSource() == buyFactory) {
			if(totalMoney >= 100) {
				totalMoney-=100;
				factories++;
				cookieValue+=10;
				cookiesPS+= 13.1;
				factoryPrice += (int)factories*1.4;
				buyFactory.setText("buy a factory: $" + factoryPrice);
			}
		}
		else if(e.getSource() == buyFarm) {
			if(totalMoney >= 500) {
				totalMoney-=500;
				farms++;
				cookieValue+=50;
				cookiesPS+= 24.7;
				farmPrice += (int)factories*1.4;
				buyFarm.setText("buy a farm: $" + farmPrice);
			}
		}
		
		// Info Events
		else if(e.getSource() == clickerInfo) {
			displayLabel.setText("<html>Clicker will increase your cookie Value by 1, and earn you 1.3 cookies per second for every clicker you own.</html>");
			displayPanel.setVisible(true);
			panelTimer.start();
		}
		else if(e.getSource() == grannyInfo) {
			displayLabel.setText("<html>Granny will increase your cookie Value by 5, and earn you 5.2 cookies per second for every granny you own</html>");
			displayPanel.setVisible(true);
			panelTimer.start();
		}
		else if(e.getSource() == factoryInfo) {
			displayLabel.setText("<html>factory will increase your cookie Value by 10, and earn you 13.1 cookies per second for every factory you own</html>");
			displayPanel.setVisible(true);
			panelTimer.start();
		}
		else if(e.getSource() == farmInfo) {
			displayLabel.setText("<html>Farm will increase your cookie Value by 50, and earn you 24.7 cookies per second for every farm you own</html>");
			displayPanel.setVisible(true);
			panelTimer.start();
		}
		
		
		
		moneyLabel.setText("Coockies: $" + totalMoney);
		PSLabel.setText("You are making $" + cookiesPS + " a second");
		valueLabel.setText("Each Cookie Click is Worth: " + cookieValue);
	}	
}
