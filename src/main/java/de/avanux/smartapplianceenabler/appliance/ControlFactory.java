/*
 * Copyright (C) 2015 Axel Müller <axel.mueller@avanux.de>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package de.avanux.smartapplianceenabler.appliance;

import java.util.ArrayList;
import java.util.List;

import de.avanux.smartapplianceenabler.modbus.ModbusSwitch;

public class ControlFactory {
    
    public List<Control> getControls(Appliance appliance, RunningTimeController runningTimeController) {
        List<Control> controls = new ArrayList<Control>();
        if(appliance.getSwitches() != null) {
            for(Switch zwitch : appliance.getSwitches()) {
                zwitch.setRunningTimeController(runningTimeController);
                controls.add(zwitch);
            }
        }
        if(appliance.getModbusSwitches() != null) {
            for(ModbusSwitch zwitch : appliance.getModbusSwitches()) {
                zwitch.setRunningTimeController(runningTimeController);
                controls.add(zwitch);
            }
        }
        if(appliance.getHttpSwitches() != null) {
            for(HttpSwitch zwitch : appliance.getHttpSwitches()) {
                zwitch.setRunningTimeController(runningTimeController);
                controls.add(zwitch);
            }
        }
        return controls;
    }

}
