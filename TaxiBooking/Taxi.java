public class Taxi implements Cloneable{
    private char currentlocation='A';
    private int customerId;
    private int taxiId;
    private char pickuplocation;
    private char droplocation;
    private int pickuptime;
    private int droptime;
    private int earnings;

    protected Object clone() throws CloneNotSupportedException {
		return super.clone();}

    public int getdroptime(){
        return droptime;
    }

    public void setdroptime(int droptime){
        this.droptime=droptime;
    }

    public int gettaxiId(){
        return taxiId;
    }

    public void settaxiId(int taxiid){
        this.taxiId=taxiid;
    }

    public char getcurrentlocation(){
        return currentlocation;
    }

    public void setcurrentlocation(char currentlocation){
        this.currentlocation=currentlocation;
    }

    public int getcustomerId(){
        return customerId;
    }

    public void setcustomerId(int customerId){
        this.customerId=customerId;
    }

    public char getpickuplocation(){
        return pickuplocation;
    }

    public void setpickuplocation(char pickuplocation){
        this.pickuplocation=pickuplocation;
    }

    public char getdroplocation(){
        return droplocation;
    }

    public void setdroplocation(char droplocation){
        this.droplocation=droplocation;
    }

    public int getpickuptime(){
        return pickuptime;
    }

    public void setpickuptime(int pickuptime){
        this.pickuptime=pickuptime;
    }

    public int getearnings(){
        return earnings;
    }

    public void setearnings(int earnings){
        this.earnings=earnings;
    }

    public String toString(){
        return "Taxi "+gettaxiId()+"\ncurrentLocation=" + currentlocation + ", \ncustomerId=" + customerId + ", \npickupLocation="
				+ pickuplocation + ", \ndropLocation=" + droplocation + ", \npickupTime=" + pickuptime + ", \ndropTime="
				+ droptime + ", \nearnings=" + earnings + "]";
    }
}
