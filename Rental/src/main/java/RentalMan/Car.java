package RentalMan;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Car {
	@Id
	private int carid;
	private String carname;
	private String carmodel;
	private int carnumber;
	private String ownername;
	private String status = "available";
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public int getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(int carnumber) {
		this.carnumber = carnumber;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Car(int carid, String carname, String carmodel, int carnumber, String ownername) {
		super();
		this.carid = carid;
		this.carname = carname;
		this.carmodel = carmodel;
		this.carnumber = carnumber;
		this.ownername = ownername;
	}
	public Car() {
		super();
	}
	@Override
	public String toString() {
		return "Car [carid=" + carid + ", carname=" + carname + ", carmodel=" + carmodel + ", carnumber=" + carnumber
				+ ", ownername=" + ownername + ", status=" + status + "]";
	}
	
}
