package contacts.jsf;

import java.util.ArrayList;
import java.util.List;

import jsf.util.FacesHelper;
import contacts.facade.FacadeBase;
import contacts.facade.UserFacade;
import contacts.facade.dto.AddressDto;
import contacts.facade.dto.CollectionDto;
import contacts.facade.dto.OrganisationDto;
import contacts.facade.dto.PersonDto;
import contacts.facade.dto.PhoneDto;


public class PersonBean {
	
	private FacadeBase facade;
	
	private CollectionDto persons = new CollectionDto();
	private Long personSelection;
	private PersonDto personDto = new PersonDto();
	
	private CollectionDto memberships;
	private List<String> membershipSelection;
	
	private AddressDto addressDto;
	
	private PhoneDto phoneDto;
	
	public PersonBean() {
	}
	
	public String newPerson() {
		personDto = new PersonDto();
		memberships = getUserFacade().getOrganisations();
		addressDto = new AddressDto();
		phoneDto = new PhoneDto();
		
		return "pedit";
	}
	
	public String savePerson() {
		personDto.setUid(getUserFacade().saveOrUpdatePerson(personDto));
		
		for(Long id : getUserFacade().getMemberships(personDto).getElements().keySet())
			if(!membershipSelection.contains(id.toString()))
				getUserFacade().removeMembership(personDto, getUserFacade().getOrganisation(id));
		
		for(String id : membershipSelection) {
			OrganisationDto orgDto = getUserFacade().getOrganisation(Long.valueOf(id));
			getUserFacade().addMembership(personDto, orgDto);
		}
		
		phoneDto.setId(getUserFacade().saveOrUpdatePhone(phoneDto));
		getUserFacade().addPhone(phoneDto, personDto);
		
		addressDto.setId(getUserFacade().saveOrUpdateAddress(addressDto));
		getUserFacade().addAddress(addressDto, personDto);
		
		resetSelections();
		return listPersons();
	}
	
	private void resetSelections() {
		personSelection = null;
		membershipSelection = null;
	}
	
	public String showSelectedPerson() {
		return select() ? "pshow" : listPersons();
	}
	
	public String selectPerson() {
		return select() ? "pedit" : listPersons();
	}
	
	/**
	 * Loads the selected Person with all its data for the edit form.
	 * @return
	 */
	private boolean select() {
		if (personSelection != null && personSelection > 0) {
			personDto = getUserFacade().getPerson(personSelection);
			
			memberships = getUserFacade().getOrganisations();
			membershipSelection = new ArrayList<String>();
			for(Long l : getUserFacade().getMemberships(personDto).getElements().keySet())
				membershipSelection.add(l.toString());  
			
			CollectionDto phonesTemp = getUserFacade().getPhones(personDto);
			phoneDto = phonesTemp.getElements().isEmpty() ? new PhoneDto() : getUserFacade().getPhone(phonesTemp.getElements().keySet().iterator().next());
			
			CollectionDto adrsTemp = getUserFacade().getAddresses(personDto);
			addressDto = adrsTemp.getElements().isEmpty() ? new AddressDto() : getUserFacade().getAddress(adrsTemp.getElements().keySet().iterator().next());
			
			return true;
		}
		return false;
	}

	public String listPersons() {
		persons = getUserFacade().getPersons();
		resetSelections();
		return "plist";
	}
	
	public String deletePerson() {
		if (personSelection != null && personSelection > 0) {
			PersonDto dto = getUserFacade().getPerson(personSelection);
			
			CollectionDto memberships = getUserFacade().getMemberships(dto);
			for(Long id : memberships.getElements().keySet()) getUserFacade().removeMembership(dto, getUserFacade().getOrganisation(id));
			
			CollectionDto phones = getUserFacade().getPhones(dto);
			for(Long id : phones.getElements().keySet()) getUserFacade().removePhone(getUserFacade().getPhone(id), dto);
			
			CollectionDto adrs = getUserFacade().getAddresses(dto);
			for(Long id : adrs.getElements().keySet()) getUserFacade().removeAddress(getUserFacade().getAddress(id), dto);
			
			getUserFacade().deletePerson(dto);
			persons = getUserFacade().getPersons();
			resetSelections();
		}
		return listPersons();
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
	
	public CollectionDto getPersons() {
		return persons;
	}

	public void setPersons(CollectionDto persons) {
		this.persons = persons;
	}

	public PersonDto getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDto personDto) {
		this.personDto = personDto;
	}

	public Long getPersonSelection() {
		return personSelection;
	}

	public void setPersonSelection(Long personSelection) {
		this.personSelection = personSelection;
	}
	
	public CollectionDto getMemberships() {
		return memberships;
	}

	public void setMemberships(CollectionDto memberships) {
		this.memberships = memberships;
	}
	
	public List<String> getMembershipSelection() {
		return membershipSelection;
	}

	public void setMembershipSelection(List<String> membershipSelection) {
		this.membershipSelection = membershipSelection;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public PhoneDto getPhoneDto() {
		return phoneDto;
	}

	public void setPhoneDto(PhoneDto phoneDto) {
		this.phoneDto = phoneDto;
	}
	
}