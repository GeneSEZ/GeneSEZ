package contacts.facade.dto;


public class OrganisationDto extends EntityDto {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Boolean nonprofit;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Boolean getNonprofit() {
        return nonprofit;
    }

    public void setNonprofit(Boolean nonprofit) {
        this.nonprofit = nonprofit;
    }
    
}
