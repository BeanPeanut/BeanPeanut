package gymmanager;

import java.awt.event.*;
import javax.swing.*;


interface Windows {
	int WINDOWS_WIDTH = 1320;
	int WINDOWS_HEIGHT = 800;
}

class FrameSetting extends JFrame implements Windows { // Frame Setting Class
	public FrameSetting() {
		setTitle("Product GUI");
		setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
}

class PanelsSetting extends JFrame { // Frame Setting Class
	private FrameSetting frame;
	
	JPanel panel = new JPanel();
	
	public PanelsSetting(FileManager fm) {
		new SetPanels(panel, fm);
		
		panel.setLayout(null);
		
		frame = new FrameSetting();
		frame.add(panel);
	}
}

class SetPanels extends JFrame implements Windows {
	public FileManager fm;
	private JButton jbtAdd;
	private JTextField jtfID;
	private ImageIcon img_enter = new ImageIcon("img_enter.png");
	private ImageIcon img_rov = new ImageIcon("img_enter_rov.png");
	
	public SetPanels(JPanel panel, FileManager fm) {
		this.fm = fm;
		//panel.setPreferredSize(new Dimension(1320, 360));
		jbtAdd = new JButton(img_enter);
		jbtAdd.setRolloverIcon(img_rov);

		jtfID = new JTextField();
		jtfID.setBounds(WINDOWS_WIDTH/2-125, 300, 250, 30);

		//jbtAdd.setSize(291,139);
		
		jbtAdd.setBorderPainted(false);
		jbtAdd.setFocusPainted(false);
		jbtAdd.setContentAreaFilled(false);

		panel.add(jbtAdd);
		panel.add(jtfID);
		
		jbtAdd.setBounds(WINDOWS_WIDTH/2-img_enter.getIconWidth()/2, 560, 291, 139);
		ButtonListener listener = new ButtonListener();
		jbtAdd.addActionListener(listener);
	}
	
	class ButtonListener implements ActionListener { // click login button
		public void actionPerformed(ActionEvent e) {
			fm.readFile(jtfID.getText());
			
			for(int i=0; i<fm.IDList.size(); i++) // print all info (debug)
				System.out.print(fm.IDList.get(i)+",");
			System.out.println();
		}
	}
}
