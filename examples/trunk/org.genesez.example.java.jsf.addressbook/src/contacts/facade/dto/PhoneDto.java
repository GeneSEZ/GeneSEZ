package contacts.facade.dto;


public class PhoneDto extends EntityDto {
	private static final long serialVersionUID = 1L;
	
	private String extension;
	private String number;
	private Long id;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
}
