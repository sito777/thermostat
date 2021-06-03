package thermostaat;

public class thermo
{
    private boolean operational;
    private boolean progActive;
    private double minTemp;
    private double maxTemp;
    private double curTemp;
    private double stepSize;
    private double nightTemp;
    private double dayTemp;

    public thermo()
    {
	operational = false;
	progActive = false;
	minTemp = 0;
	maxTemp = 0;
	curTemp = 18;
	stepSize = 0;
	nightTemp = 0;
	dayTemp = 0;
    }

    public thermo(boolean operational, boolean progActive, double minTemp, double maxTemp, double curTemp, double stepSize,
	    double nightTemp, double dayTemp)
    {
	this.operational = operational;
	this.progActive = progActive;
	this.minTemp = minTemp;
	this.maxTemp = maxTemp;
	this.curTemp = curTemp;
	this.stepSize = stepSize;
	this.nightTemp = nightTemp;
	this.dayTemp = dayTemp;
    }

 
    /**
     * @return the operational
     */
    public boolean isOperational()
    {
        return operational;
    }

    /**
     * @param operational the operational to set
     */
    public void setOperational(boolean operational)
    {
        this.operational = operational;
    }

    /**
     * @return the progActive
     */
    public boolean isProgActive()
    {
        return progActive;
    }

    /**
     * @param progActive the progActive to set
     */
    public void setProgActive(boolean progActive)
    {
        this.progActive = progActive;
    }

    /**
     * @return the minTemp
     */
    public double getMinTemp()
    {
        return minTemp;
    }

    /**
     * @param minTemp the minTemp to set
     */
    public void setMinTemp(double minTemp)
    {
        this.minTemp = minTemp;
    }

    /**
     * @return the maxTemp
     */
    public double getMaxTemp()
    {
        return maxTemp;
    }

    /**
     * @param maxTemp the maxTemp to set
     */
    public void setMaxTemp(double maxTemp)
    {
        this.maxTemp = maxTemp;
    }

    /**
     * @return the curTemp
     */
    public double getCurTemp()
    {
        return curTemp;
    }

    /**
     * @param curTemp the curTemp to set
     */
    public void setCurTemp(double curTemp)
    {
        this.curTemp = curTemp;
    }

    /**
     * @return the stepSize
     */
    public double getStepSize()
    {
        return stepSize;
    }

    /**
     * @param stepSize the stepSize to set
     */
    public void setStepSize(double stepSize)
    {
        this.stepSize = stepSize;
    }

    /**
     * @return the nightTemp
     */
    public double getNightTemp()
    {
        return nightTemp;
    }

    /**
     * @param nightTemp the nightTemp to set
     */
    public void setNightTemp(double nightTemp)
    {
        this.nightTemp = nightTemp;
    }

    /**
     * @return the dayTemp
     */
    public double getDayTemp()
    {
        return dayTemp;
    }

    /**
     * @param dayTemp the dayTemp to set
     */
    public void setDayTemp(double dayTemp)
    {
        this.dayTemp = dayTemp;
    }

    @Override
    public String toString()
    {
	return "\n______________________________\n"+
		"\nThermostaat aan:\t" + operational + "\nTijdprogramma aan:\t" + progActive + "\nMininmale temperatuur:\t" + minTemp
		+ "\nMaximale temperatuur:\t" + maxTemp + "\nHuidige temperatuur:\t" + curTemp + "\nStapsgewijs:\t\t" + stepSize + "\nAvond temperatuur:\t"
		+ nightTemp + "\nDag temperatuur:\t" + dayTemp + "\n\n______________________________\n";
    }

}
