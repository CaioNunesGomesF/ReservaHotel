package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkout;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){

    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkout = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Integer getRoomnumber() {
        return roomNumber;
    }

    public void setRoomnumber(Integer roomnumber) {
        this.roomNumber = roomnumber;
    }
    public long duration(){
        long diff = checkout.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(checkIn)){
            throw new IllegalArgumentException("Reservation dates for update must be future dates");
        }
        if(!checkOut.after(checkIn)){
            throw new IllegalArgumentException("check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkout = checkOut;

    }

    @Override
    public String toString() {
        return "Room: "
                + roomNumber
                +", check-in: "
                + sdf.format(checkIn)
                +", check-out: "
                +  sdf.format(checkIn)
                +", "
                +duration()
                +" nights";
    }
}
