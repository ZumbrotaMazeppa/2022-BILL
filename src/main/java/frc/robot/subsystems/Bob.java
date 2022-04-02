package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Bob extends SubsystemBase{
    DoubleSolenoid verticalSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7); 
    DoubleSolenoid tipSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);  
    WPI_VictorSPX m_Winch = new WPI_VictorSPX(6);

    public Bob(){
        
    }

    public void startPosition() {
        verticalSolenoid.set(Value.kReverse);
        tipSolenoid.set(Value.kReverse);
        m_Winch.set(0);
    }

// 6, 7 extend bob 
// 0, 1 tilt bob 
 
    public void xboxControlPneumatics(XboxController xboxControl)
    {
        
        //if(xboxControl.getRightBumper())
     //   {
    //        verticalSolenoid.set(DoubleSolenoid.Value.kReverse);
    // }
     // else if(xboxControl.getRightTriggerAxis()==1)
     //  {
    //     verticalSolenoid.set(DoubleSolenoid.Value.kForward);
    //  }

        if (xboxControl.getRightTriggerAxis()==1 && xboxControl.getRightBumper()){
            m_Winch.set(0);
        }
        else if (xboxControl.getRightTriggerAxis()==0 && !xboxControl.getRightBumper()){
            m_Winch.set(0);
            verticalSolenoid.set(DoubleSolenoid.Value.kForward);
        }
        
        while (xboxControl.getRightTriggerAxis()==1){
            verticalSolenoid.set(DoubleSolenoid.Value.kForward);
            m_Winch.set (-0.6);
        }

        while (xboxControl.getRightBumper()){
            verticalSolenoid.set(DoubleSolenoid.Value.kReverse);
            m_Winch.set(0.5);
        }

        if(xboxControl.getLeftBumper())
        {
            tipSolenoid.set(DoubleSolenoid.Value.kReverse);
        }
        else if(xboxControl.getLeftTriggerAxis()==1)
        {
            tipSolenoid.set(DoubleSolenoid.Value.kForward);
        }
       
    }
}