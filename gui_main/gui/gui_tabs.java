package gui;
/*
 * Gui class 
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class gui_tabs {
	
	
	/*
	 * GUI start method for mysqlIntegration
	 */
	static void GuiApp1()
	{
	SqlIntegration mytemp = new SqlIntegration();
	JFrame frame = new JFrame();
	frame.setSize(1000, 200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("MariaDB Insert Delete Interface");
	frame.setLocationRelativeTo(null);
	
	JTabbedPane tabbedPane = new JTabbedPane();
	/*
	 * Jframe panels for tabbed panel
	 */
	final JPanel insertPanel = new JPanel();
	insertPanel.setLayout(new FlowLayout());
	
	final JPanel deletePanel = new JPanel();
	deletePanel.setLayout(new FlowLayout());
	
	final JPanel showTable = (new JPanel());
	
	final JPanel insertPanel_books = new JPanel();
	insertPanel_books.setLayout(new FlowLayout());
	
	final JPanel deletePanel_books = new JPanel();
	deletePanel_books.setLayout(new FlowLayout());
	
	final JPanel showPanel_books = new JPanel();
	
	
	/*
	 * tabs of tabbed pane
	 */
	tabbedPane.addTab("Insert game", null, insertPanel, "Inset entry in games table");
	tabbedPane.addTab("Delete game", null, deletePanel, "Remove entry from games table");
	tabbedPane.addTab("Show table game", null, showTable, "Show games table");
	tabbedPane.addTab("Insert book", null, insertPanel_books, "Insert entry in books table");
	tabbedPane.addTab("Delete book", null, deletePanel_books, "delete entry from books table");
	tabbedPane.addTab("Show books table", null, showPanel_books, "Show books table");

	
	/*
	 * Create JFrame elements for games table
	 */
	JLabel index_insert = new JLabel("Please input data and click on ''Insert'' button");
	JLabel index_delete = new JLabel("Please input data and click on ''Delete'' button");
	JLabel namel = new JLabel("Insert Name:");
	JLabel jahrl = new JLabel("Jahr:");
	JLabel gernel = new JLabel("Gerne:");
	JLabel consolel = new JLabel("Console:");
	JTextField nameField = new JTextField(20);
	JTextField jahrField = new JTextField(4);
	JTextField gerneField = new JTextField(20);
	JTextField consoleField = new JTextField(20);
	JTextField delname = new JTextField(20);
	JLabel ldelname = new JLabel("Name:");
	JTextField delid = new JTextField(4);
	JLabel ldelid = new JLabel("Delete ID:");
	JButton insert_game = new JButton("Insert");
	JButton delete_game = new JButton("Delete");
	JTextArea output_games = new JTextArea(			
			mytemp.Return_table_games()
			);
	output_games.setEditable(false);
	JScrollPane outputscr = new JScrollPane(output_games);
	
	
	/*
	 * Create Jframe elements for books table
	 */
	JLabel index_insert_books = new JLabel("Please input data and click on ''Insert'' button");
	JLabel index_delete_books = new JLabel("Please input data and click on ''Delete'' button");
	JLabel lname_books = new JLabel("Insert Name:");
	JLabel ljahr_books = new JLabel("Jahr:");
	JLabel lauthor_books = new JLabel("Author:");
	JLabel lvolume = new JLabel("Vol:");
	JLabel llang = new JLabel("Lang");
	JLabel ldelname_books = new JLabel("Name");
	JLabel ldelid_books = new JLabel("Id");
	JTextField nameField_books = new JTextField(20);
	JTextField jahrField_books = new JTextField(4);
	JTextField authorField_books = new JTextField(20);
	JTextField volField_books = new JTextField(2);
	JTextField langField_books = new JTextField(10);
	JTextField delname_books = new JTextField(20);
	JTextField delid_books = new JTextField(4);
	JButton insert_book = new JButton("Insert");
	JButton delete_book = new JButton("Delete");
	
	JTextArea output_books = new JTextArea(			
			mytemp.Return_table_books()
			);
	output_books.setEditable(false);
	JScrollPane outputscr_book = new JScrollPane(output_books);
	
	/*
	 * Action listener implementation
	 * 
	 */
	
	
	
	/*
	 * Delete implementation after enter press (Games)
	 */
	consoleField.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
		String name = nameField.getText();
		String jahr = jahrField.getText();
		String gerne = gerneField.getText();
		String console = consoleField.getText();
		
		SqlIntegration mytemp = new SqlIntegration();
		mytemp.Insert_games(name, jahr, gerne, console);
		
		
				
	}
		
	});
	
	delid.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			String name = nameField.getText();
			String console = consoleField.getText();
			
			SqlIntegration my4 = new SqlIntegration();
			my4.Delete_games(name, console);
			
			
					
		}
			
		});
	/*
	 * Delete button implementation (Games)
	 */
	delete_game.addActionListener(new ActionListener()
	{	
	public void actionPerformed(ActionEvent event)
	{
	
	/*
	 * When Delete clicked use SqlIntegration.Delete()
	 */
	String name = delname.getText();
	String console = delid.getText();
	
	SqlIntegration mytemp = new SqlIntegration();

	mytemp.Delete_games(name, console);
	
				
	}		
		
	});
	
	/*
	 * Insert button implementation(Games)		
	 */
	insert_game.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent event)
	{
	/*
	 * When button clicked use SqlIntegration.input()
	 */
	String name = nameField.getText();
	String jahr = jahrField.getText();
	String gerne = gerneField.getText();
	String console = consoleField.getText();
	/*
	 * Create new object myO of SqlIntegration class	
	 */
	SqlIntegration mytemp = new SqlIntegration();
	
	/*
	 * Use methode Insert
	 */
	mytemp.Insert_games(name, jahr, gerne, console);
	
	
	
	
	}
	});
	/*
	 * Insert button implementation (Books)
	 */
	insert_book.addActionListener(new ActionListener()		
	{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		
		String name = nameField_books.getText();
		String author = authorField_books.getText();
		String jahr = jahrField_books.getText();
		String volume = volField_books.getText();
		String lang = langField_books.getText();
		
		SqlIntegration mytemp = new SqlIntegration();
		mytemp.Insert_books(name, jahr, author, volume, lang);
	}
	}
	);
	
	/*
	 * Insert after press of enter (Books)
	 */
	langField_books.addActionListener( new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		String name = nameField_books.getText();
		String author = authorField_books.getText();
		String jahr = jahrField_books.getText();
		String volume = volField_books.getText();
		String lang = langField_books.getText();
		
		SqlIntegration mytemp = new SqlIntegration();
		mytemp.Insert_books(name, jahr, author, volume, lang);
	}		
	}
	);
	
	
	/*
	 * Delete button implementation (Books)
	 */
	delete_book.addActionListener(new ActionListener()		
	{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		
		String id = delid_books.getText();
		String name = delname_books.getText();
		
		
		SqlIntegration mytemp = new SqlIntegration();
		mytemp.Delete_books(id, name);
	}
	}
	);
	
	/*
	 * delete implementation after press of enter
	 */
	delname_books.addActionListener(new ActionListener()		
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		String id = delid_books.getText();
		String name = delname_books.getText();
		
		
		SqlIntegration mytemp = new SqlIntegration();
		mytemp.Delete_books(id, name);
	}
	}
	);
	
	/*
	 * Add elements to Jframe.
	 */
	frame.add(tabbedPane,BorderLayout.CENTER);
	
	insertPanel.add(namel);
	insertPanel.add(nameField);
	insertPanel.add(jahrl);
	insertPanel.add(jahrField);
	insertPanel.add(gernel);
	insertPanel.add(gerneField);
	insertPanel.add(consolel);
	insertPanel.add(consoleField);
	insertPanel.add(insert_game);
	insertPanel.add(index_insert, BorderLayout.PAGE_END);
	
	deletePanel.add(ldelid);
	deletePanel.add(delid);
	deletePanel.add(ldelname);
	deletePanel.add(delname);
	deletePanel.add(delete_game);
	deletePanel.add(index_delete, BorderLayout.PAGE_END);
	showTable.add(outputscr);
	
	insertPanel_books.add(lname_books);
	insertPanel_books.add(nameField_books);
	insertPanel_books.add(lauthor_books);
	insertPanel_books.add(authorField_books);
	insertPanel_books.add(ljahr_books);
	insertPanel_books.add(jahrField_books);
	insertPanel_books.add(lvolume);
	insertPanel_books.add(volField_books);
	insertPanel_books.add(llang);
	insertPanel_books.add(langField_books);
	insertPanel_books.add(insert_book);
	insertPanel_books.add(index_insert_books, BorderLayout.PAGE_END);
	
	deletePanel_books.add(ldelid_books);
	deletePanel_books.add(delid_books);
	deletePanel_books.add(ldelname_books);
	deletePanel_books.add(delname_books);
	deletePanel_books.add(delete_book);
	deletePanel_books.add(index_delete_books, BorderLayout.PAGE_END);
	
	showPanel_books.add(outputscr_book);
	
	
	
	
	
	/*
	 * Frame must be set to be visible.
	 */
	frame.setVisible(true);
	}
	
	
	/*
	 * Message of success (Insert)
	 */
	public static void insert_success() {
		JOptionPane.showMessageDialog(null, "Entry Insert Succesfull");
	}
	
	/*
	 * Message of success (Delete)
	 */
	public static void delete_success() {
		JOptionPane.showMessageDialog(null, "Delete Succesfull");
	}
	
	/*
	 * Error message with text from exeption
	 */
	public static void error(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	
	

}
