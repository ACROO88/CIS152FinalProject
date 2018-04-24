import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class TheFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtAccessCode;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JComboBox cmbBoxState;
	private JTextField txtCreditCard;
	private JTextField txtZip;
	private JComboBox cmbBoxTickets;
	private JLabel lblPrompt;
	
	
	Account newAcct;
	Stack theStack = new Stack();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheFrame frame = new TheFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TheFrame() {
		setTitle("FINAL PROJECT");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	theStack.bubbleSort();
		    	theStack.display();
				System.exit(0);
		    }
		});
		setBounds(500, 500, 630, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		/*
		 * Create NORTH Panel
		 * Components: AccessCode lbl/txtField
		 */
		JPanel panelNORTH = new JPanel();
		contentPane.add(panelNORTH, BorderLayout.NORTH);
			JLabel lblAccessCode = new JLabel("Access Code:");
			panelNORTH.add(lblAccessCode);
			txtAccessCode = new JTextField();
			panelNORTH.add(txtAccessCode);
			txtAccessCode.setColumns(6);
		
		/*
		 * Create CENTER Panel
		 * Components: First/Lane Name lbl/txtField, address lbl/txtField, city lbl/txtField, state lbl/comboBox, zip lbl/txtField,
		 * Credit Card lbl/txtField, ticketAmt lbl/comboBox
		 * 
		 */
		JPanel panelCENTER = new JPanel();
		contentPane.add(panelCENTER, BorderLayout.CENTER);
		
			JLabel lblFirstName = new JLabel("First Name:");
			panelCENTER.add(lblFirstName);
			txtFirstName = new JTextField();
			panelCENTER.add(txtFirstName);
			txtFirstName.setColumns(10);
		
			JLabel lblLastName = new JLabel("Last Name:");
			panelCENTER.add(lblLastName);
			txtLastName = new JTextField();
			panelCENTER.add(txtLastName);
			txtLastName.setColumns(10);
		
			JLabel lblAddress = new JLabel("Street Address:");
			panelCENTER.add(lblAddress);
			txtAddress = new JTextField();
			panelCENTER.add(txtAddress);
			txtAddress.setColumns(10);
		
			JLabel lblCity = new JLabel("City:");
			panelCENTER.add(lblCity);
			txtCity = new JTextField();
			panelCENTER.add(txtCity);
			txtCity.setColumns(10);
		
			String[] stateList = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL",
					"GA", "HI", "ID", "IL", "IN", "IA", "KA", "KY", "LA", "ME", "MD", "MS", "MO", 
					"MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", 
					"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WN", "WV", "WS", "WY"};
		
			JLabel lblState = new JLabel("State:");
			panelCENTER.add(lblState);
			cmbBoxState = new JComboBox(stateList);
			panelCENTER.add(cmbBoxState);
			
			JLabel lblZipCode = new JLabel("Zip Code:");
			panelCENTER.add(lblZipCode);
			txtZip = new JTextField();
			panelCENTER.add(txtZip);
			txtZip.setColumns(5);
			
			JLabel lblCreditCard = new JLabel("Credit Card:");
			panelCENTER.add(lblCreditCard);
			txtCreditCard = new JTextField();
			panelCENTER.add(txtCreditCard);
			txtCreditCard.setColumns(10);
			
			JLabel lblTickets = new JLabel("Tickets:");
			panelCENTER.add(lblTickets);
			cmbBoxTickets = new JComboBox();
			cmbBoxTickets.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
			panelCENTER.add(cmbBoxTickets);
		/*
		 * Creates SOUTH Panel
		 * Components: PURCHASE Button, CANCEL Button
		 */
		JPanel panelSOUTH = new JPanel();
		contentPane.add(panelSOUTH, BorderLayout.SOUTH);
			JButton btnPurchase = new JButton("PURCHASE");
			btnPurchase.setEnabled(true);
			PurchaseClickListener p = new PurchaseClickListener();
			btnPurchase.addActionListener(p);
			panelSOUTH.add(btnPurchase);
			
			JButton btnCancel = new JButton("CANCEL");
			CancelClickListener c = new CancelClickListener();
			btnCancel.addActionListener(c);
			panelSOUTH.add(btnCancel);
			
			lblPrompt = new JLabel("Purchase Tickets!");
			panelSOUTH.add(lblPrompt);
			
}
	
	/**
	 * 
	 * @author Alex Rooney CIS 152 Final Project
	 * Purchase button listener that creates account for each purchase and adds to the stack
	 */
	class PurchaseClickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String code = txtAccessCode.getText();
			int accessCode = Integer.parseInt(code);
			String fName = txtFirstName.getText();
			String lName =  txtLastName.getText();
			String address = txtAddress.getText();
			String city =  txtCity.getText();
			String state = cmbBoxState.getSelectedItem().toString();
			String creditCard = txtCreditCard.getText();
			String zip = txtZip.getText();
			String ticket = cmbBoxTickets.getSelectedItem().toString();
			int ticketAmt = Integer.parseInt(ticket);
			try{
				
				if (code.length() ==6 && !fName.equals("") && !lName.equals("") && !address.equals("") && !city.equals("") && !zip.equals("")) {
					newAcct = new Account(accessCode, fName, lName, address, city, state, zip, creditCard, ticketAmt);
					theStack.push(newAcct);
					//Clear Inputs
					lblPrompt.setText("Successful Purchase");
					txtAccessCode.setText("");
					txtFirstName.setText("");
					txtLastName.setText("");
					txtAddress.setText("");
					txtCity.setText("");
					cmbBoxState.setSelectedIndex(0);
					txtCreditCard.setText("");
					txtZip.setText("");
					cmbBoxTickets.setSelectedIndex(0);
					
				}
				else {
					lblPrompt.setText("Make sure all fields are filled");
				}
				
				
			}
			catch (Exception err){
				System.out.println(err.getMessage());
			}
		
	}

}
	/**
	 * 
	 * @author Alex Rooney
	 * Cancel button listener that displays the contents of the stack, sorted, and then closes the application
	 */
	class CancelClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theStack.bubbleSort();
			theStack.display();
			System.exit(0);
		}
		
	}
	
}
