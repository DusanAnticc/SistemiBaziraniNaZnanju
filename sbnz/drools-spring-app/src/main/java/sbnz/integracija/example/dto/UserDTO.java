package sbnz.integracija.example.dto;

public class UserDTO {
    private String dtype;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Boolean prosecuted;
    private Boolean deleted;
    private Integer penalty;
    
	public UserDTO() {
		super();
	}

	public UserDTO(String dtype, String firstName, String lastName, String email, String username, String password,
			Boolean prosecuted, Boolean deleted, Integer penalty) {
		super();
		this.dtype = dtype;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.prosecuted = prosecuted;
		this.deleted = deleted;
		this.penalty = penalty;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getProsecuted() {
		return prosecuted;
	}

	public void setProsecuted(Boolean prosecuted) {
		this.prosecuted = prosecuted;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getPenalty() {
		return penalty;
	}

	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}
    
}
