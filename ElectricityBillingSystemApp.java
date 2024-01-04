import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ElectricityBillingSystemApp extends JFrame {

    private JTextField unitsField, billAmountField;
    private JTextArea addressArea, nameArea;
    private JComboBox<String> billingPhaseDropdown;

    public ElectricityBillingSystemApp() {
        // Set up the frame
        setTitle("Electricity Billing System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create components
        JLabel unitsLabel = new JLabel("Units Consumed:");
        JLabel billAmountLabel = new JLabel("Bill Amount:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel billingPhaseLabel = new JLabel("Billing Phase:");
        JLabel nameLabel = new JLabel("Name:");

        unitsField = new JTextField();
        billAmountField = new JTextField();
        billAmountField.setEditable(false);

        addressArea = new JTextArea();
        nameArea = new JTextArea();

        billingPhaseDropdown = new JComboBox<>(new String[]{"2 Phase", "3 Phase"});

        JButton calculateButton = new JButton("Calculate Bill");
        JButton shareDataButton = new JButton("Share Data");
        JButton secureButton = new JButton("Secure Data");
        JButton viewBillButton = new JButton("View Bill");
        JButton editBillButton = new JButton("Edit Bill");

        // Set component positions and sizes
        unitsLabel.setBounds(10, 20, 120, 25);
        billAmountLabel.setBounds(10, 50, 120, 25);
        addressLabel.setBounds(10, 80, 120, 25);
        billingPhaseLabel.setBounds(10, 160, 120, 25);
        nameLabel.setBounds(10, 240, 120, 25);

        unitsField.setBounds(150, 20, 120, 25);
        billAmountField.setBounds(150, 50, 120, 25);
        addressArea.setBounds(150, 80, 300, 70);
        billingPhaseDropdown.setBounds(150, 160, 120, 25);
        nameArea.setBounds(150, 240, 300, 30);

        calculateButton.setBounds(280, 20, 150, 25);
        shareDataButton.setBounds(150, 300, 150, 25);
        secureButton.setBounds(310, 300, 140, 25);
        viewBillButton.setBounds(150, 200, 150, 25);
        editBillButton.setBounds(310, 200, 140, 25);

        // Add components to the frame
        add(unitsLabel);
        add(billAmountLabel);
        add(addressLabel);
        add(billingPhaseLabel);
        add(nameLabel);
        add(unitsField);
        add(billAmountField);
        add(addressArea);
        add(billingPhaseDropdown);
        add(nameArea);
        add(calculateButton);
        add(shareDataButton);
        add(secureButton);
        add(viewBillButton);
        add(editBillButton);

        // Set up action listeners
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBill();
            }
        });

        shareDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shareData();
            }
        });

        secureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secureData();
            }
        });

        viewBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBill();
            }
        });

        editBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBill();
            }
        });
    }

    private void calculateBill() {
        try {
            double unitsConsumed = Double.parseDouble(unitsField.getText());
            // Simplified calculation, replace with your billing formula
            double billAmount = unitsConsumed * 0.10; // Replace with your billing formula
            billAmountField.setText(String.format("%.2f", billAmount));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for units consumed.");
        }
    }

    private void shareData() {
        // Simulate data sharing, you would implement this based on your requirements
        JOptionPane.showMessageDialog(this, "Data shared with local electricity office.");
    }

    private void secureData() {
        // Simulate securing data, you would implement this based on your security measures
        JOptionPane.showMessageDialog(this, "Data secured to prevent tampering.");
    }

    private void viewBill() {
        String htmlContent = "<html><body>" +
                "<h2>Electricity Bill</h2>" +
                "<p><strong>Name:</strong> " + nameArea.getText() + "</p>" +
                "<p><strong>Address:</strong> " + addressArea.getText() + "</p>" +
                "<p><strong>Billing Phase:</strong> " + billingPhaseDropdown.getSelectedItem() + "</p>" +
                "<p><strong>Units Consumed:</strong> " + unitsField.getText() + "</p>" +
                "<p><strong>Bill Amount:</strong> $" + billAmountField.getText() + "</p>" +
                "</body></html>";

        try {
            saveToHTML(htmlContent, "ElectricityBill.html");
            JOptionPane.showMessageDialog(this, "HTML bill generated successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating HTML bill.");
        }
    }

    private void editBill() {
        // Add logic to allow the user to edit the bill information
        // For simplicity, you can show a new window or dialog for editing
        JOptionPane.showMessageDialog(this, "Edit Bill feature coming soon!");
    }

    private void saveToHTML(String content, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElectricityBillingSystemApp().setVisible(true);
            }
        });
    }
}
