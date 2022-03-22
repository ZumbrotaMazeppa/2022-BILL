package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
public class Johnathan extends SubsystemBase{
    DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4,5);


    public Johnathan(){
        
    }

// A Button - lock johnathan
// B Button - release johnathan
    public void controlxbox(XboxController xboxControl) {

        if (xboxControl.getAButton()) { 
            long targettime = System.currentTimeMillis() +  1000;
            while(System.currentTimeMillis() < targettime) {
                // we want to check that the button is held down;
                if(!xboxControl.getAButton()) {
                    // if button gets released, break out of loop early
                    break;
                }
            }

            if (System.currentTimeMillis() >= targettime ) {
                // Only after it's held down for 1 second, do call set forward (open)
                exampleDoublePCM.set(DoubleSolenoid.Value.kReverse);
            }
        }
        else if (xboxControl.getBButton()) {
            exampleDoublePCM.set(DoubleSolenoid.Value.kForward);
        }
        
        else{
            exampleDoublePCM.set(DoubleSolenoid.Value.kOff);
        }
    } 
    long time = System.currentTimeMillis();
    
    long time2 = System.currentTimeMillis();
}
    // Safety feature John won't open unless button held (1 seconds)




