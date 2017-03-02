package evpro.edu.esprit.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable {
	

	private Integer idUser;
	private String mail;
	private String firstName;
	private String lastName;
	private String nickName;
	private String password;
	private String phoneNumber;
	private String postalCode;
	private String company;
	private String cityAdress;	
	private String countryAdress;
	private String gender;
	private Date birthDate;
	
	

	
	

	public User(Integer idUser) {
		super();
		this.idUser = idUser;
	}




	public User(Integer idUser, String mail, String firstName, String lastName, String nickName, String password,
			String phoneNumber, String postalCode, String company, String cityAdress, String countryAdress,
			String gender, Date birthDate) {
		super();
		this.idUser = idUser;
		this.mail = mail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
		this.company = company;
		this.cityAdress = cityAdress;
		this.countryAdress = countryAdress;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	@Id
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	@JsonIgnore
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
  
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCityAdress() {
		return cityAdress;
	}

	public void setCityAdress(String cityAdress) {
		this.cityAdress = cityAdress;
	}

	public String getCountryAdress() {
		return countryAdress;
	}

	public void setCountryAdress(String countryAdress) {
		this.countryAdress = countryAdress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
   
}
