package P1;

public enum ViolationMoving {
    DistractedDriving,
    RecklessDriving,
    Speeding,
    DrivingUnderInfluence,
    FailureToRespectTrafficSigns,
    DrivingWithoutValidLicenseOrInsurance;

    public boolean isRecklessDriving()
    {
        return this.equals(ViolationMoving.RecklessDriving);
    }

    public boolean isSpeeding()
    {
        return this.equals(ViolationMoving.Speeding);
    }

    public boolean isDUI()
    {
        return this.equals(ViolationMoving.DrivingUnderInfluence);
    }

    public boolean isDrivingWithoutValidLicenseOrInsurance()
    {
        return this.equals(ViolationMoving.DrivingWithoutValidLicenseOrInsurance);
    }
}
