import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


public class WordPad extends JFrame implements ActionListener {
	
	JTextArea pad;
	JScrollPane scroll;
	JLabel textSizeLabel;
	JLabel fontLabel;
	JSpinner textSizeSpinner;
	JPanel iconPanel;
	
	JButton textColorButton;
	JButton backgroundColorButton;
	JButton boldButton;
	JButton italicizeButton;
	JButton uppercaseButton;
	JButton lowercaseButton;
	JComboBox fontBox;
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenu editMenu;
	JMenuItem newItem;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
	JMenuItem copyItem;
	JMenuItem pasteItem;
	JMenuItem cutItem;
	JMenuItem uppercaseItem;
	JMenuItem lowercaseItem;
	
	Icon textColorIcon;
	Icon backgroundColorIcon;
	Icon boldIcon;
	Icon italicizeIcon;
	Icon uppercaseIcon;
	Icon lowercaseIcon;
	
	ImageIcon newIcon;
	ImageIcon openIcon;
	ImageIcon saveIcon;
	ImageIcon exitIcon;
	ImageIcon copyItemIcon;
	ImageIcon pasteItemIcon;
	ImageIcon cutItemIcon;
	ImageIcon uppercaseItemIcon;
	ImageIcon lowercaseItemIcon;
		
	// Constructor
	WordPad() {
		
		// Frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setTitle("WordPad Clone");
		this.setSize(1000,1000);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		
		// TextArea "pad"
		pad = new JTextArea();
		pad.setBackground(Color.WHITE);
		pad.setLineWrap(true);
		pad.setWrapStyleWord(true);
		pad.setFont(new Font("Arial", Font.PLAIN,20));
		
		
		// KScrollPane "scroll"
		scroll = new JScrollPane(pad);
		scroll.setPreferredSize(new Dimension(923,683));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
		
		// JLabel "fontSizeLabel"
		textSizeLabel = new JLabel("Size:");
		
		// JLabel "fontLabel"
		fontLabel = new JLabel("Font:");

		
		// JSpinner "fontSizeSpinner"
		textSizeSpinner = new JSpinner();
		textSizeSpinner.setValue(15);
		textSizeSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				pad.setFont(new Font(pad.getFont().getFamily(),Font.PLAIN,(int) textSizeSpinner.getValue()));
			}
		});
		
		
		// ComboBox "fontComboBox"
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontBox = new JComboBox(fonts);
		fontBox.setSelectedItem("Times New Roman"); // Default Text
		fontBox.addActionListener(this);
		
		
		// JButton "textColorButton"
		textColorIcon = new ImageIcon ("src/Resources/TextColor.png"); // ImageIcon "textColorIcon"
		textColorButton = new JButton(textColorIcon); // Add ImageIcon to JButton
		textColorButton.setBounds(0, 0, 30, 30);
		textColorButton.addActionListener(this);

		
		// JButton "BackgroundColorButton"
		backgroundColorIcon = new ImageIcon ("src/Resources/BackgroundColor.png"); // ImageIcon "BackgroundColorIcon"
		backgroundColorButton = new JButton(backgroundColorIcon);
		backgroundColorButton.addActionListener(this);

		
		// JButton "boldButton"
		boldIcon = new ImageIcon ("src/Resources/Bold.png"); // ImageIcon "boldIcon"
		boldButton = new JButton(boldIcon);
		boldButton.addActionListener(this);

		
		// JButton italicizeButton;
		italicizeIcon = new ImageIcon ("src/Resources/Italic.png"); // ImageIcon "italicizeIcon"
		italicizeButton = new JButton(italicizeIcon);
		italicizeButton.addActionListener(this);
		
		
		// JButton "uppercaseButton"
		uppercaseIcon = new ImageIcon ("src/Resources/Uppercase.png"); // ImageIcon "uppercaseIcon"
		uppercaseButton = new JButton(uppercaseIcon);
		uppercaseButton.addActionListener(this);

		
		// JButton "lowercaseButton"		
		lowercaseIcon = new ImageIcon ("src/Resources/Lowercase.png"); // ImageIcon "uppercaseIcon"
		lowercaseButton = new JButton(lowercaseIcon);
		lowercaseButton.addActionListener(this);

		
		// JPanel "iconPanel"
		iconPanel = new JPanel();
		iconPanel.setBounds(0,0,1000,30);
		iconPanel.setBackground(Color.LIGHT_GRAY);
		iconPanel.add(textSizeLabel);
		iconPanel.add(textSizeSpinner);
		iconPanel.add(fontLabel);
		iconPanel.add(fontBox);
		iconPanel.add(textColorButton);
		iconPanel.add(backgroundColorButton);
		iconPanel.add(boldButton);
		iconPanel.add(italicizeButton);
		iconPanel.add(uppercaseButton);
		iconPanel.add(lowercaseButton);
		
		
		// JMenuItem "newItem"
		newItem = new JMenuItem("New");
		newIcon = new ImageIcon("src/Resources/NewFile.png"); // ImageIcon "newIcon"
		newItem.setIcon(newIcon);
		newItem.setMnemonic(KeyEvent.VK_N); // N for New + ALT + CTRL 
		newItem.addActionListener(this);

		
		// JMenuItem "openItem"
		openItem = new JMenuItem("Open");
		openIcon = new ImageIcon("src/Resources/OpenFile.png"); // ImageIcon "openIcon"
		openItem.setIcon(openIcon);
		openItem.setMnemonic(KeyEvent.VK_O); // O for Open + ALT + CTRL 
		openItem.addActionListener(this);

		
		// JMenuItem "saveItem"
		saveItem = new JMenuItem("Save");
		saveIcon = new ImageIcon("src/Resources/SaveFile.png"); // ImageIcon "saveIcon"
		saveItem.setIcon(saveIcon);
		saveItem.setMnemonic(KeyEvent.VK_S); // S for Save + ALT + CTRL 
		saveItem.addActionListener(this);


		// JMenuItem "exitItem"
		exitItem = new JMenuItem("Exit");
		exitIcon = new ImageIcon("src/Resources/Exit.png"); // ImageIcon "exitIcon"
		exitItem.setIcon(exitIcon);
		exitItem.setMnemonic(KeyEvent.VK_E); // E for Exit + ALT + CTRL 
		exitItem.addActionListener(this);

		
		// JMenuItem "copyItem"
		copyItem = new JMenuItem("Copy");
		copyItemIcon = new ImageIcon("src/Resources/Copy.png"); // ImageIcon "copyItemIcon"
		copyItem.setIcon(copyItemIcon);
		copyItem.setMnemonic(KeyEvent.VK_C); // C for Copy + ALT + CTRL 
		copyItem.addActionListener(this);

	
		// JMenuItem "pasteItem"
		pasteItem = new JMenuItem("Paste");
		pasteItemIcon = new ImageIcon("src/Resources/Paste.png"); // ImageIcon "pasteItemIcon"
		pasteItem.setIcon(pasteItemIcon);
		pasteItem.setMnemonic(KeyEvent.VK_P); // P for Paste + ALT + CTRL 
		pasteItem.addActionListener(this);

		
		// JMenuItem "cutItem"
		cutItem = new JMenuItem("Cut");
		cutItemIcon = new ImageIcon("src/Resources/Cut.png"); // ImageIcon "cutItemIcon"
		cutItem.setIcon(cutItemIcon);
		cutItem.setMnemonic(KeyEvent.VK_X); // X for Cut + ALT + CTRL (C already taken)
		cutItem.addActionListener(this);

	
		// JMenuItem "uppercase"
		uppercaseItem = new JMenuItem("Make Upercase");
		uppercaseItemIcon = new ImageIcon("src/Resources/Uppercase.png"); // ImageIcon "uppercaseItemIcon"
		uppercaseItem.setIcon(uppercaseItemIcon);
		uppercaseItem.setMnemonic(KeyEvent.VK_6); // 6 for Uppercase + ALT + CTRL (U already taken)
		uppercaseItem.addActionListener(this);

		
		// JMenuItem "lowercase"
		lowercaseItem = new JMenuItem("Make Lowercase");
		lowercaseItemIcon = new ImageIcon("src/Resources/Lowercase.png"); // ImageIcon "lowercaseItemIcon"
		lowercaseItem.setIcon(lowercaseItemIcon);
		lowercaseItem.setMnemonic(KeyEvent.VK_L); // L for Lowercase + ALT + CTRL
		lowercaseItem.addActionListener(this);

		
		// JMenu "fileMenu"
		fileMenu = new JMenu("File");
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		fileMenu.setMnemonic(KeyEvent.VK_F); // F for File + ALT + CTRL
			
		
		// JMenu "editMenu"
		editMenu = new JMenu("Edit");
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		editMenu.add(cutItem);
		editMenu.add(lowercaseItem);
		editMenu.add(uppercaseItem);
		editMenu.setMnemonic(KeyEvent.VK_E); // E for Edit + ALT + CTRL

		
		// JMenuBar "menuBar"
		menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		
		// Add to frame
		this.setJMenuBar(menuBar);
		this.add(iconPanel);
		this.add(scroll);
		this.setVisible(true);			
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		// Font Combo Box
		if(e.getSource()==fontBox) {
			pad.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,pad.getFont().getSize()));
		}
	
		
		
		// Text Color Button
		if(e.getSource()==textColorButton) {
			JColorChooser colorChooser = new JColorChooser();
			
			Color color = colorChooser.showDialog(null,"Choose a color",Color.BLACK);
			
			pad.setForeground(color);
		
		}
		
		
		
		// Background Color Button 
		if(e.getSource()==backgroundColorButton) {
			JColorChooser colorChooser = new JColorChooser();
			
			Color color = colorChooser.showDialog(null,"Choose a color",Color.BLACK);
			
			pad.setBackground(color);
		}
		
		
		
		// Bold Button 
		if(e.getSource()==boldButton) {
			Font currentFont = pad.getFont();
            int style = currentFont.getStyle();

            if ((style & Font.BOLD) == 0) {
                pad.setFont(currentFont.deriveFont(style | Font.BOLD));
            } else {
                pad.setFont(currentFont.deriveFont(style & ~Font.BOLD));
            }
        }							
									
		
		
		// Italic Button 
		if(e.getSource()==italicizeButton) {
			Font currentFont = pad.getFont();
            int style = currentFont.getStyle();

            if ((style & Font.BOLD) == 0) {
                pad.setFont(currentFont.deriveFont(style | Font.ITALIC));
            } else {
                pad.setFont(currentFont.deriveFont(style & ~Font.ITALIC));
            }
        							
									
		}
		
		
		// Uppercase Button 
		if(e.getSource()==uppercaseButton) {
			String currentText = pad.getText();
		    String uppercasedText = currentText.toUpperCase();
		    pad.setText(uppercasedText);										
															
		}
		
		
		
		// Lowercase Button 
		if(e.getSource()==lowercaseButton) {
			String currentText = pad.getText();
		    String lowercasedText = currentText.toLowerCase();
		    pad.setText(lowercasedText);												
																	
		}
		
		
		
		// New Menu Item  
		if(e.getSource()==newItem) {
			new WordPad().setVisible(true);			
		}
		
		
		
		// Open Menu Item 
		if(e.getSource()==openItem) {
			JFileChooser fileChooser = new JFileChooser();			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");// Only search for certain file extensions
			fileChooser.setFileFilter(filter);
			
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;
				
				try {
					fileIn = new Scanner(file);
					if(file.isFile()); {
						while(fileIn.hasNextLine());{
							String line = fileIn.nextLine()+"\n";
							pad.append(line);
						}
					}
					
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				finally{
					fileIn.close();
				}
			}
		}
		
		
		
		// Save Menu Item
		if(e.getSource()==saveItem) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(".")); // Sets directory to project folder
			
			int response = fileChooser.showSaveDialog(null);
			
			if (response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileOut = null;
				
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					fileOut = new PrintWriter(file);
					fileOut.println(pad.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				finally {
					fileOut.close();
				}
			}
		}
		
		
		
		// Exit Menu Item
		if(e.getSource()==exitItem) {
			System.exit(0);
		}
		
		
		
		// Copy Menu Item  
		if(e.getSource()==copyItem) {
			pad.copy();																	
																				
		}
		
		
		
		// Paste Menu Item  
		if(e.getSource()==pasteItem) {
				pad.paste();																		
																						
		}
		
		
		
		// Cut Menu Item  
		if(e.getSource()==cutItem) {
				pad.cut();																		
																						
		}
		
		
		
		// Uppercase Menu Item  
		if(e.getSource()==uppercaseItem) {
			String currentText = pad.getText();
		    String uppercasedText = currentText.toUpperCase();
		    pad.setText(uppercasedText);																				
																						
		}
		
		
		
		// Lowercase Menu Item  
		if(e.getSource()==lowercaseItem) {
			if(e.getSource()==lowercaseButton) {
				String currentText = pad.getText();
			    String lowercasedText = currentText.toLowerCase();
			    pad.setText(lowercasedText);																		
			}																			
		}
	}
}