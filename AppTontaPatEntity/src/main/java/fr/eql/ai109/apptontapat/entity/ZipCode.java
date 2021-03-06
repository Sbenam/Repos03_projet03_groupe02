package fr.eql.ai109.apptontapat.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zipcode")
public class ZipCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/******************************************************************************************/
	/*                              Variable declaration                                      */
	/*****************************************************************************************/
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "z_label")
	private String label;
	@Column(name = "code")
	private String code;
	@Column(name = "longitude")
	private Double longitude;
	@Column(name = "latitude")
	private Double latitude;
	@OneToMany(mappedBy = "zipcode", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Account> accounts;
	@OneToMany(mappedBy = "zipcode", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Herd> herds;
	@OneToMany(mappedBy = "zipcode", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Field> fields;

	/*****************************************************************************************/
	/*                                     Constructors                                      */
	/*****************************************************************************************/
	public ZipCode() {
		super();
	}
	
	public ZipCode(Integer id) {
		this.id = id;
	}



	public ZipCode(Integer id, String label, Double longitude, Double latitude, Set<Account> accounts, Set<Herd> herds,
			Set<Field> fields) {
		super();
		this.id = id;
		this.label = label;
		this.longitude = longitude;
		this.latitude = latitude;
		this.accounts = accounts;
		this.herds = herds;
		this.fields = fields;
	}

	public ZipCode(Integer id, String label, String code, Double longitude, Double latitude, Set<Account> accounts,
			Set<Herd> herds, Set<Field> fields) {
		super();
		this.id = id;
		this.label = label;
		this.code = code;
		this.longitude = longitude;
		this.latitude = latitude;
		this.accounts = accounts;
		this.herds = herds;
		this.fields = fields;
	}


	/******************************************************************************************/
	/*                             Getters and setters                                        */
	/******************************************************************************************/

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public Double getLongitude() {
		return longitude;
	}



	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}



	public Double getLatitude() {
		return latitude;
	}



	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}



	public Set<Account> getAccounts() {
		return accounts;
	}



	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}



	public Set<Herd> getHerds() {
		return herds;
	}



	public void setHerds(Set<Herd> herds) {
		this.herds = herds;
	}



	public Set<Field> getFields() {
		return fields;
	}



	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

	
}
