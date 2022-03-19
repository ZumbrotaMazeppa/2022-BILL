package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
public class Johnathan extends SubsystemBase{
    DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);

    public Johnathan(){
        
    }

// A Button - lock johnathan
// B Button - release johnathan
    public void controlxbox(XboxController xboxControl) {
        if (xboxControl.getAButton()) { 
            exampleDoublePCM.set(kForward);
        }
        else if (xboxControl.getBButton()) {
            exampleDoublePCM.set(kReverse);
        }
    }
}
