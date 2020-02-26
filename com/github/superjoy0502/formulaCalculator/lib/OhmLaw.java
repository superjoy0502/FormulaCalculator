
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

package com.github.superjoy0502.formulaCalculator.lib;

public class OhmLaw {

    public double answer;
    public String unit;
    public String answerString;

    public double getVoltage(double I, double R){
        return I * R;
    }

    public double getCurrent(double V, double R){
        return V / R;
    }

    public double getResistance(double V, double I){
        return V / I;
    }


}
