package contacts.jsf;

import jsf.util.FacesHelper;
import contacts.facade.FacadeBase;
import contacts.facade.UserFacade;
import contacts.facade.dto.CollectionDto;
import contacts.facade.dto.PhoneDto;

public class PhoneBean {
	private String prefix;
	private String number;
	
	private FacadeBase facade;
	private Long phoneSelection, countryRemoveSelection;
	private CollectionDto phoneCollection = new CollectionDto();
	private PhoneDto phoneDto;
	
	public PhoneBean(){
	}
	
	public UserFacade getUserFacade() {
		if (facade == null) {
			LoginBean loginBean = (LoginBean) FacesHelper.getBean("loginBean");
			if (loginBean != null) {
				facade = loginBean.getFacade();
			}
		}
		return (UserFacade) facade;
	}
	
	/**
	 * Anlegen eines neuen pobDto
	 * @return
	 */
	public String newPhoneAddress() {
		phoneDto = new PhoneDto();
		return "phedit";
	}
	
	/**
	 * Suchen eines Dto in der Datenbank
	 * @return
	 */
	public String findPhoneAdress() {
		PhoneDto findphoneDto = new PhoneDto();	
		findphoneDto.setNumber(number);
		findphoneDto.setExtension(prefix);
		
		phoneCollection = getUserFacade().findPhone(findphoneDto);
		return "phlist";
	}

	public String deletePhoneAdress() {
		if ( phoneSelection!= null && phoneSelection > 0) {
			PhoneDto dto = getUserFacade().getPhone(phoneSelection);
			if(!isReferenced(dto)) {
				getUserFacade().deletePhone(dto);
			}
			phoneCollection = getUserFacade().getPhones();
			phoneSelection = null;
		}
		return "phlist";
	}
	
	private boolean isReferenced(PhoneDto dto) {
		boolean isRef = false;
		for(Long id : getUserFacade().getPersons().getElements().keySet())
			for(Long id2 : getUserFacade().getContacts(getUserFacade().getPerson(id)).getElements().keySet())
				if(id2.equals(dto.getId())) isRef = true;
		for(Long id : getUserFacade().getOrganisations().getElements().keySet())
			for(Long id2 : getUserFacade().getContacts(getUserFacade().getOrganisation(id)).getElements().keySet())
				if(id2.equals(dto.getId())) isRef = true;
		return isRef;
	}
	
	public String savePhoneAdress() {
		phoneDto.setId(getUserFacade().saveOrUpdatePhone(phoneDto));
	
		resetSelections();
		return listPhones();
	}
	
	public String selectPhoneAdress() {
		if (phoneSelection != null && phoneSelection > 0) {
			phoneDto = getUserFacade().getPhone(phoneSelection);
			return "phedit";
		}
		return "phlist";
	}
	
	public String showPhoneAdress() {
		if (phoneSelection != null && phoneSelection > 0) {
			phoneDto = getUserFacade().getPhone(phoneSelection);
			return "phshow";
		}
		return "phlist";
	}
	
	public String listPhones() {
		phoneCollection = getUserFacade().getPhones();
		return "phlist";
	}
	
	private void resetSelections() {
		
	}
	
	public CollectionDto getPhoneList(){
		return phoneCollection;
	}

	public Long getCountryRemoveSelection() {
		return countryRemoveSelection;
	}

	public void setCountryRemoveSelection(Long countryRemoveSelection) {
		this.countryRemoveSelection = countryRemoveSelection;
	}
	
	public Long getPhoneSelection() {
		return phoneSelection;
	}

	public void setPhoneSelection(Long phoneSelection) {
		this.phoneSelection = phoneSelection;
	}
	
	public void setPhoneDto(PhoneDto phoneDto){
		this.phoneDto = phoneDto;
	}
	
	public PhoneDto getPhoneDto(){
		return phoneDto;
	}
	
	public CollectionDto getPhoneCollection() {
		return phoneCollection;
	}

	public void setPhoneCollection(CollectionDto phoneCollection) {
		this.phoneCollection = phoneCollection;
	}
	
	

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

}
