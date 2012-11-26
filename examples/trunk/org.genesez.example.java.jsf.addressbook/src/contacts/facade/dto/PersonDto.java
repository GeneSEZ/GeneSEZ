package contacts.facade.dto;

import java.util.Date;

/**
 *
 * @author georg beier
 */
public class PersonDto extends EntityDto {
	private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthdate; 

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

    public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Long getId() {
        return id;
    }

    public void setUid(Long uid) {
        this.id = uid;
    }
}
