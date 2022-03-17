package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
public class Johnathan extends SubsystemBase{
    DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 7, 6);

    public Johnathan(){
        
    }

// Right trigger - lock johnathan
// Right bumper - release johnathan
// final JoystickButton r2 = new JoystickButton(xboxControl, 10);
// final JoystickButton r1 = new JoystickButton(xboxControl, 12);
public void controlwxbox(XboxController xboxControl) {
    final JoystickButton r1 = new JoystickButton(xboxControl, 12);
    final JoystickButton r2 = new JoystickButton(xboxControl, 10);
    if (r2.get() ){ 
        exampleDoublePCM.set(kForward);
        }
     if (r1.get() ){ 
        exampleDoublePCM.set(kReverse);
        }
    }
}
