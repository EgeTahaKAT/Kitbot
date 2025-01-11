package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;


public class Robot extends TimedRobot {
  
  private CANSparkMax leftMotor1 = new CANSparkMax(8, MotorType.kBrushless);
  private CANSparkMax leftMotor2 = new CANSparkMax(9, MotorType.kBrushless);
  private CANSparkMax rightMotor1 = new CANSparkMax(6, MotorType.kBrushless);
  private CANSparkMax rightMotor2 = new CANSparkMax(7, MotorType.kBrushless);
  private CANSparkMax rollermotor = new CANSparkMax(10, MotorType.kBrushless);
  private DifferentialDrive driveTrain = new DifferentialDrive(leftMotor1, rightMotor1);
  private PS5Controller joystick = new PS5Controller(0);
  Timer timer = new Timer();

  @Override
  public void robotInit() {

    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
    leftMotor2.follow(leftMotor1)
    rightMotor2.follow(rightMotor1)
  }


  @Override
  public void robotPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    timer.reset();
    timer.start();
  }

  @Override
  public void autonomousPeriodic() {
    if(timer.get() < 5){
      driveTrain.arcadeDrive(0.5 ,0.5);
    }
    else{
      driveTrain.arcadeDrive(0,0);
    }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    if(joystick.getCrossButtonPressed()){
      rollermotor.set(0.5);
    }
    double speed = joystick.getRightY();
    double rotation = joystick.getRightX();

    driveTrain.arcadeDrive(speed, rotation);
  }

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
