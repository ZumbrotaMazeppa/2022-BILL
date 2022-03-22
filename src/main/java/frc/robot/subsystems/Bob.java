package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
public class Bob extends SubsystemBase{
    DoubleSolenoid verticalSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7); 
    DoubleSolenoid tipSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1); 

    public Bob(){

    }

// Left trigger - move Bob clockwise
// Left bumper - move bob counter clockwise
// A - Extend Bob up
// B - Retract bob
// start to turn on back to stop compressor 

 
 
public void xboxControlPneumatics(XboxController xboxControl) 
    {
            
        if(xboxControl.getRightBumper()==true)
        {
            verticalSolenoid.set(DoubleSolenoid.Value.kForward);
        }
        else if(xboxControl.getRightTriggerAxis()==1)
        {
            verticalSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
        else
        {
            verticalSolenoid.set(DoubleSolenoid.Value.kOff);
        }

        if(xboxControl.getLeftBumper()==true)
        {
            tipSolenoid.set(DoubleSolenoid.Value.kForward);
        }
        else if(xboxControl.getLeftTriggerAxis()==1)
        {
            tipSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
        else
        {
            tipSolenoid.set(DoubleSolenoid.Value.kOff);
        }
    }
}