package egov.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type"

)
@DiscriminatorValue(value = "user")

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	private String firstName;
	private String lastName;
	private Date BirthDate;
	private String job;
	private Date deathDate;
	private Blob photo;
	private Blob fingerPrint;
	private String birthPlace;
	private String login;
	private String email;
	private String pwd;
	private String status;
	private String gender;
	private String nationality;
	private int numCin;

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	private String fatherName;

	private String motherName;
	@OneToMany(mappedBy = "user")
	private List<JobRequest> jobRequests;

	@OneToMany(mappedBy = "user")
	private List<Establishment> establishment;
	@OneToMany(mappedBy = "user")
	private List<Work> work;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Account> accounts;

	
	@OneToMany(mappedBy = "user")
	private List<Bills_fines> bills;
	@OneToMany(mappedBy = "user")
	private List<Kase> kase;


	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Detail> detail;

	public List<Kase> getKase() {
		return kase;
	}

	public void setKase(List<Kase> kase) {
		this.kase = kase;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;

	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Blob getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(Blob fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public List<Establishment> getEstablishment() {
		return establishment;
	}

	public void setEstablishment(List<Establishment> establishment) {
		this.establishment = establishment;
	}

	public List<Work> getWork() {
		return work;
	}

	public void setWork(List<Work> work) {
		this.work = work;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}



	public List<Bills_fines> getBills() {
		return bills;
	}

	public void setBills(List<Bills_fines> bills) {
		this.bills = bills;
	}

	public User(String firstName, String lastName, Date birthDate, String job, Date deathDate, Blob photo,
			Blob fingerPrint, String birthPlace, String login, String email, String pwd, String status,
			List<Establishment> establishment, List<Work> work, List<Account> accounts,
			List<Bills_fines> bills, List<Kase> kase) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		BirthDate = birthDate;
		this.job = job;
		this.deathDate = deathDate;
		this.photo = photo;
		this.fingerPrint = fingerPrint;
		this.birthPlace = birthPlace;
		this.login = login;
		this.email = email;
		this.pwd = pwd;
		this.status = status;
		this.establishment = establishment;
		this.work = work;
		this.accounts = accounts;
		
		this.bills = bills;
		this.kase = kase;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStatus() {
		return status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User() {
		super();
	}

	public int getNumCin() {
		return numCin;
	}

	public void setNumCin(int numCin) {
		this.numCin = numCin;
	}

}
