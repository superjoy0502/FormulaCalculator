
// Copyright (C) 2020  superjoy0502
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

// Package
package com.github.superjoy0502.formulaCalculator.java;

// Import Libraries
import javax.swing.*;
import java.awt.*;
import com.github.superjoy0502.formulaCalculator.lib.OhmLaw;

// Main Class
public class Calculator {

    // Variable Declarations
    private static JFrame f = new JFrame("Result"); // JFrame instance
    private static OhmLaw ohmLaw = new OhmLaw(); // Using OhmLaw library as an instance
    private static String o = JOptionPane.showInputDialog("Enter Calculation (V, I, R):"); // Getting calculation option from user
    private static JLabel label1; // Text in window
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Dimension of user's screen for centering window
    private static String displayString; // String that will be displayed as the result
    private static Font font = new Font("Roboto", Font.PLAIN, 48); // Font that will be used in the final window

    public static void main(String[] args) {
        label1 = new JLabel(""); // Assigning empty text to avoid NullPointerException

        if (o.equalsIgnoreCase("V")) { // Check if user option is "V"
            doVoltageCalculation(); // If user option is "V", do voltage calculation
        } else if (o.equalsIgnoreCase("I")) { // Check if user option is "I"
            doCurrentCalculation(); // If user option is "I", do voltage calculation
        } else if (o.equalsIgnoreCase("R")) { // Check if user option is "R"
            doResistanceCalculation(); // If user option is "R", do voltage calculation
        } else { // If user option is nothing, end program
            return;
        }
        display(); // Display final window
    } // Main Method

    private static void doResistanceCalculation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Voltage:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Current:"));
        ohmLaw.answer = ohmLaw.getResistance(a, b); // Calculate
        ohmLaw.unit = "Ω"; // Set unit to Ω
        ohmLaw.answerString = "Ohms"; // Set Answer string to "Ohms"
    } // Get input from user and do resistance calculation

    private static void doCurrentCalculation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Voltage:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Resistance:"));
        ohmLaw.answer = ohmLaw.getCurrent(a, b); // Calculate
        ohmLaw.unit = "A"; // Set unit to A
        ohmLaw.answerString = "Amps"; // Set Answer string to "Amps"
    } // Get input from user and do current calculation

    private static void doVoltageCalculation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Current:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Resistance:"));
        ohmLaw.answer = ohmLaw.getVoltage(a, b); // Calculate
        ohmLaw.unit = "V"; // Set unit to V
        ohmLaw.answerString = "Volts"; // Set Answer string to "Volts"
    } // Get input from user and do voltage calculation

    private static void display() {
        configLabel(); // Configure Text
        configFrame(); // Configure Window
    } // Display final window

    private static void configFrame() {
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Let process end when the window is closed
        f.setSize(800, 300); // Set window size
        f.setLocation((dim.width / 2 - f.getSize().width / 2), (dim.height / 2 - f.getSize().height / 2)); // Make window center in monitor
        f.add(label1); // Add text to window
        f.setVisible(true); // Make window visible
    } // Configure JFrame that makes the final window

    private static void configLabel() {
        displayString = ohmLaw.answerString + ": " + ohmLaw.answer + ohmLaw.unit; // Set text
        label1.setText(displayString); // Set label text
        label1.setHorizontalAlignment(SwingConstants.CENTER); // Center label
        label1.setVerticalAlignment(SwingConstants.CENTER); // Center label
        label1.setFont(font); // Set font for the text
        label1.setOpaque(true); // Make label visible
    } // Configure text in the final window

}
