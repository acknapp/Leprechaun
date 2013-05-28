/**
 * A interface for users to interact with.
 * @author Andrew Knapp
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class leprechaunView implements ActionListener{

	public static void main(String[] args) {
		leprechaunView window = new leprechaunView();
	}
	
	private JFrame frame;
	private JTextField urlField;
	private JTextField hops;
	private JButton crawlButton;
	private JLabel leprechaunLabel; //DEBUG
	
	public leprechaunView (){
		//Components
		urlField = new JTextField(10);
		hops = new JTextField(2);
		crawlButton = new JButton("Collect Content");
		leprechaunLabel = new JLabel("Collectin' the Gold!");
		
		// attach event listener to button
		crawlButton.addActionListener(this);
		
		// Layout
		JPanel north = new JPanel(new GridLayout(2, 2));
		north.add(new JLabel("Base Website: "));
		north.add(urlField);
		north.add(new JLabel("Link Hops: "));
		north.add(hops);
		
		//overall frame
		frame = new JFrame("Leprechaun");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(north, BorderLayout.NORTH);
		frame.add(leprechaunLabel, BorderLayout.CENTER);
		frame.add(crawlButton, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Handles clicks on the crawlButton by crawling from the root
	 * website given.
	 * @param event
	 */
	public void actionPerformed(ActionEvent event){
		try { 
			String rootURL = urlField.getText();
			String linkDepth = hops.getText();
			int depth = Integer.parseInt(linkDepth);
			pageDescent p = new pageDescent(rootURL, depth);
		} catch (NumberFormatException n) {
			leprechaunLabel.setText("Link Hops needs a number");
		}
		
	}
	
}
