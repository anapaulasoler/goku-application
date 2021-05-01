package br.com.solertech.goku.application.domain;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.solertech.goku.application.enums.CustomerStatus;
import br.com.solertech.goku.application.enums.Gender;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -7442576522709707746L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = true, unique = false)
	private Long id;

	@NotEmpty(message = "Documento precisa ser informado")
	@Length(min = 8, max = 9, message = "O Campo deve conter entre 8 e 9 caracteres")
	@Column(nullable = false)
	private String document;

	@NotEmpty
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotEmpty
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NotEmpty
	@Column(name = "full_name", nullable = false)
	private String fullName;

	@NotEmpty
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotNull
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private CustomerStatus status;

	@NotEmpty
	@Column(name = "birth_date", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String birthDate;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime updatedAt;

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", targetEntity = Address.class, fetch = FetchType.LAZY)
	private List<Address> addresses = new ArrayList<>();

	@PrePersist
	public void initializeDates() {
		LocalDateTime dateNow = LocalDateTime.now();
		if (isNull(createdAt)) {
			createdAt = dateNow;
		}
		updatedAt = dateNow;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public CustomerStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerStatus status) {
		this.status = status;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer [document=" + document + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", email=" + email + ", gender=" + gender + ", status=" + status + ", birthDate="
				+ birthDate + ", addresses=" + addresses + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Customer))
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(getId(), customer.getId()) && Objects.equals(getDocument(), customer.getDocument())
				&& Objects.equals(getFirstName(), customer.getFirstName())
				&& Objects.equals(getLastName(), customer.getLastName())
				&& Objects.equals(getFullName(), customer.getFullName()) && getGender() == customer.getGender()
				&& Objects.equals(getBirthDate(), customer.getBirthDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getDocument(), getFirstName(), getLastName(), getFullName(), getGender(),
				getBirthDate());
	}

}
