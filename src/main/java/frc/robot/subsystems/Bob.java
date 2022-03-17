package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
 import edu.wpi.first.wpilibj2.command.button.JoystickButton;
public class Bob extends SubsystemBase{

    //public static Object ButtonA;
    public Bob(){

    }

// Left trigger - move Bob clockwise
// Left bumper - move bob counter clockwise
// A - Extend Bob up
// B - Retract bob
// start to turn on back to stop compressor 

 
 
public void xboxControlPneumatics(XboxController xboxControl) {
            //boolean enabled = pcmCompressor.enabled();
           // boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
           // DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
          //  DoubleSolenoid exampleDoublePCM1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5){

                //public void xboxControlPneumatics(XboxController XboxController)}
                   //boolean BobCounterClockwise = xboxControl.getRawButtonPressed(5);
                   //boolean stopBobCounterClockwise = xboxControl.getRawButtonReleased(5);
                   //boolean BobClockwise = xboxControl.getRawButtonPressed(5);
                   
                    //if (xboxControl.getRawButtonPressed(8))
                    //{
                       /*DoubleSolenoid exampleSolenoidPCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
                
                        pcmCompressor.enableDigital();
                        exampleSolenoidPCM.set(kOff);
                        exampleSolenoidPCM.set(kForward);
                        exampleSolenoidPCM.set(kReverse);*/
                    //}

                    //if(xboxControl.getRawButtonPressed(5))
                    //{
                    //    //BobCounterClockwise
            
                    final JoystickButton l2 = new JoystickButton(xboxControl, 9);
                    final JoystickButton r2 = new JoystickButton(xboxControl, 10);
                    final JoystickButton l1 = new JoystickButton(xboxControl, 11);
                    final JoystickButton r1 = new JoystickButton(xboxControl, 12);
                    //}
            

                
                //}
            
            }
  
    }