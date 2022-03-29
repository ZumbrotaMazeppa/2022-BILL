package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Bob extends SubsystemBase{
    DoubleSolenoid verticalSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7); 
    DoubleSolenoid tipSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1); 
    DoubleSolenoid brakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3); 

    public Bob(){
        
    }

    public void startPosition() {
        verticalSolenoid.set(Value.kReverse);
        tipSolenoid.set(Value.kReverse);
        brakeSolenoid.set(Value.kReverse);
    }

// 6, 7 extend bob 
// 0, 1 tilt bob 
 
    public void xboxControlPneumatics(XboxController xboxControl)
    {
        
        if(xboxControl.getRightBumper()==true)
        {
            verticalSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
        else if(xboxControl.getRightTriggerAxis()==1)
        {
            verticalSolenoid.set(DoubleSolenoid.Value.kForward);
            // Set brakeSolenoid to forward while the trigger is being pressed
            brakeSolenoid.set(DoubleSolenoid.Value.kForward);
            while(xboxControl.getRightTriggerAxis()==1) {

            }
            // Set brakeSolenoid to reverse when the trigger is let go
            brakeSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
        else
        {
            brakeSolenoid.set(DoubleSolenoid.Value.kOff);
            verticalSolenoid.set(DoubleSolenoid.Value.kOff);
        }

        if(xboxControl.getLeftBumper()==true)
        {
            tipSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
        else if(xboxControl.getLeftTriggerAxis()==1)
        {
            tipSolenoid.set(DoubleSolenoid.Value.kForward);
        }
        else
        {
            tipSolenoid.set(DoubleSolenoid.Value.kOff);
        }
    }
}