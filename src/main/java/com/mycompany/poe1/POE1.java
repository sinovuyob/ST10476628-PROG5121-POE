/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe1;
import javax.swing.JOptionPane;

public class POE1 {
    public static void main(String[] args) {

        // === Registration ===
        JOptionPane.showMessageDialog(null, "=== Register a New User ===");

        String username = JOptionPane.showInputDialog("Enter username (must include '_' and be max 5 characters):");
        if (username == null) return;

        String password = JOptionPane.showInputDialog("Enter password (min 8 chars, 1 uppercase, 1 number, 1 special char):");
        if (password == null) return;

        String firstName = JOptionPane.showInputDialog("Enter first name:");
        if (firstName == null) return;

        String lastName = JOptionPane.showInputDialog("Enter last name:");
        if (lastName == null) return;

        String cellNumber = JOptionPane.showInputDialog("Enter cell number (+27XXXXXXXXX):");
        if (cellNumber == null) return;

        Login login = new Login(username, password, firstName, lastName, cellNumber);
        String registrationResult = login.registerUser();
        JOptionPane.showMessageDialog(null, registrationResult);

        if (!registrationResult.equals("User has been registered successfully.")) {
            JOptionPane.showMessageDialog(null, "Exiting program due to invalid registration.");
            return;
        }

        // === Login ===
        JOptionPane.showMessageDialog(null, "=== Log In ===");
        String loginUsername = JOptionPane.showInputDialog("Enter username:");
        if (loginUsername == null) return;

        String loginPassword = JOptionPane.showInputDialog("Enter password:");
        if (loginPassword == null) return;

        if (!login.loginUser(loginUsername, loginPassword)) {
            JOptionPane.showMessageDialog(null, "Username or password incorrect. Exiting...");
            return;
        }

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");

        // === Message Menu ===
        int choice = -1;
        while (choice != 3) {
            String input = JOptionPane.showInputDialog(
                "Choose an option:\n" +
                "1) Send Message\n" +
                "2) Show Recently Sent Messages\n" +
                "3) Quit"
            );
            if (input == null) break;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid choice. Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    String recipient = JOptionPane.showInputDialog("Enter recipient cell number (+27XXXXXXXXX):");
                    if (recipient == null) break;
                    if (!Message.checkRecipientCell(recipient)) {
                        JOptionPane.showMessageDialog(null, "Invalid recipient number.");
                        break;
                    }

                    String content = JOptionPane.showInputDialog("Enter your message (max 250 chars):");
                    if (content == null) break;
                    if (content.length() > 250) {
                        JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
                        break;
                    }

                    Message newMessage = new Message(recipient, content);
                    JOptionPane.showMessageDialog(null, "Message sent successfully!");
                    break;

                case 2:
                    Message.printMessages();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting. Total messages sent: " + Message.returnTotalMessages());
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Try again.");
            }
        }
    }
}
