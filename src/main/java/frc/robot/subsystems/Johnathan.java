package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Johnathan extends SubsystemBase{
    DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4,5);

    public Johnathan(){
       
    }

    public void startPosition() {
        exampleDoublePCM.set(Value.kReverse);
    }

// X Button - lock johnathan
// B Button - release johnathan
// Safety feature: Don't open John unless button held for 1 second
    public void controlxbox(XboxController xboxControl) {

        if (xboxControl.getBButton()) { 
            long targettime = System.currentTimeMillis() +  1000;
            while(System.currentTimeMillis() < targettime) {
                // we want to check that the button is held down;
                if(!xboxControl.getBButton()) {
                    // if button gets released, break out of loop early
                    break;
                }
            }

            if (System.currentTimeMillis() >= targettime ) {
                // Only after it's held down for 1 second, do call set forward (open)
                exampleDoublePCM.set(DoubleSolenoid.Value.kReverse);
            }
        }
        else if (xboxControl.getXButton()) {
            exampleDoublePCM.set(DoubleSolenoid.Value.kForward);
        }
        
        else{
            exampleDoublePCM.set(DoubleSolenoid.Value.kOff);
        }
    } 
}
    




