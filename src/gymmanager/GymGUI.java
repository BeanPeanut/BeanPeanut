package gymmanager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


interface Windows {
	int WINDOWS_WIDTH = 1320;
	int WINDOWS_HEIGHT = 800;
}

class FrameSetting extends JFrame implements Windows { // Frame Setting Class
	public FrameSetting() {
		setTitle("ManaGym");
		setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
}

class PanelsSetting extends JFrame { // Frame Setting Class
	private FrameSetting frame;
	public FileManager fm;
	//private CardLayout card = new CardLayout(0, 0);
	
	JPanel containerPanel = new JPanel();
	JPanel panelLogin = new JPanel();
	JPanel panelMain = new JPanel();
	
	public PanelsSetting(FileManager fm) {
		containerPanel.setLayout(new java.awt.CardLayout());
		this.fm = fm;
		new PanelLogin();
		new PanelMain();
		
		panelLogin.setLayout(null);
		panelMain.setLayout(null);
		
		frame = new FrameSetting();
		frame.add(containerPanel);
		containerPanel.add(panelLogin, "card1");
		containerPanel.add(panelMain, "card2");
	}
	
	private class PanelLogin implements Windows {
		private JButton jbtEnter;
		private JTextField jtfID;
		private ImageIcon img_enter = new ImageIcon("img_enter.png");
		private ImageIcon img_rov = new ImageIcon("img_enter_rov.png");
		
		public PanelLogin() {
			//panel.setPreferredSize(new Dimension(1320, 360));
			jbtEnter = new JButton(img_enter);
			jbtEnter.setRolloverIcon(img_rov);
	
			jtfID = new JTextField();
			jtfID.setBounds(WINDOWS_WIDTH/2-125, 300, 250, 30);
	
			//jbtAdd.setSize(291,139);
			
			jbtEnter.setBorderPainted(false);
			jbtEnter.setFocusPainted(false);
			jbtEnter.setContentAreaFilled(false);
	
			panelLogin.add(jbtEnter);
			panelLogin.add(jtfID);
			
			jbtEnter.setBounds(WINDOWS_WIDTH/2-img_enter.getIconWidth()/2, 560, 291, 139);
			ButtonListener listener = new ButtonListener();
			jbtEnter.addActionListener(listener);
		}
		
		class ButtonListener implements ActionListener { // click login button
			public void actionPerformed(ActionEvent e) {
				fm.readFile(jtfID.getText());
				
				for(int i=0; i<fm.IDList.size(); i++) // print all info (debug)
					System.out.print(fm.IDList.get(i)+",");
				System.out.println();
				CardLayout cl = (CardLayout)(containerPanel.getLayout());
		        cl.next(containerPanel);
			}
		}
	}
	
	private class PanelMain implements Windows {
		private JButton jbtTest;
		
		public PanelMain() {
			jbtTest = new JButton("Back");
			panelMain.add(jbtTest);
			
			jbtTest.setBounds(WINDOWS_WIDTH/2-200/2, 560, 200, 60);
			
			ButtonListener listener = new ButtonListener();
			jbtTest.addActionListener(listener);
		}
		
		class ButtonListener implements ActionListener { // click login button
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(containerPanel.getLayout());
		        cl.next(containerPanel);
			}
		}
	}
}
