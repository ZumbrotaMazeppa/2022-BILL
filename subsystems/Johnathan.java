package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Johnathan extends SubsystemBase{
    Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    public Johnathan(){
        //DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 7, 6);
    }

// Right trigger - lock johnathan
// Right bumper - release johnathan

}