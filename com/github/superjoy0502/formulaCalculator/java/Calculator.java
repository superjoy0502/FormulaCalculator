
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

package com.github.superjoy0502.formulaCalculator.java;

import javax.swing.*;
import java.awt.*;

import com.github.superjoy0502.formulaCalculator.lib.OhmLaw;

public class Calculator {

    private static JFrame f = new JFrame("Result");
    private static OhmLaw ohmLaw = new OhmLaw();
    private static String o = JOptionPane.showInputDialog("Enter Calculation (V, I, R):");
    private static JLabel label1;
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private static String displayString;
    private static Font font = new Font("Roboto", Font.PLAIN, 48);

    public static void main(String[] args) {
        label1 = new JLabel("");

        if (o.equalsIgnoreCase("V")) {
            doVoltageCalculation();
        } else if (o.equalsIgnoreCase("I")) {
            doCurrentCalculation();
        } else if (o.equalsIgnoreCase("R")) {
            doResistanceCalculation();
        } else {
            return;
        }
        display();
    }

    private static void doResistanceCalculation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Voltage:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Current:"));
        ohmLaw.answer = ohmLaw.getResistance(a, b);
        ohmLaw.unit = "Ω";
        ohmLaw.answerString = "Ohms";
    }

    private static void doCurrentCalculation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Voltage:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Resistance:"));
        ohmLaw.answer = ohmLaw.getCurrent(a, b);
        ohmLaw.unit = "A";
        ohmLaw.answerString = "Amps";
    }

    private static void doVoltageCalculation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter Current:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter Resistance:"));
        ohmLaw.answer = ohmLaw.getVoltage(a, b);
        ohmLaw.unit = "V";
        ohmLaw.answerString = "Volts";
    }

    private static void display() {
        displayString = ohmLaw.answerString + ": " + ohmLaw.answer + ohmLaw.unit;
        configLabel();
        configFrame();
    }

    private static void configFrame() {
        f.setLocation((dim.width / 3 - f.getSize().width / 2), (dim.height / 4 - f.getSize().height / 2));
        f.setSize(600, 500);
        f.add(label1);
        f.setVisible(true);
    }

    private static void configLabel() {
        label1.setText(displayString);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);
        label1.setFont(font);
        label1.setOpaque(true);
    }

}
