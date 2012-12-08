package contacts.jsf;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private Map<Long, String> personCollection = new HashMap<Long, String>();
	private Long personSelection;
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	
	
	private Map<Long, String> memberships;
	private List<String> membershipSelection;
	
	private Long phoneID;
	private String extension;
	private String number;
	
	private Long addressID;
	private String street;
	private String zip;
	private String town;
	private String country;
	
	public PersonBean() {
	}
	
	public String newPerson() {
		memberships = getUserFacade().getOrganisations().getElements();
		
		return "pedit";
	}
	
	public String savePerson() {
		PersonDto person = assemblePersonDto();
		person.setUid(getUserFacade().saveOrUpdatePerson(person));
		
		for(Long id : getUserFacade().getMemberships(person).getElements().keySet())
			if(!membershipSelection.contains(id.toString()))
				getUserFacade().removeMembership(person, getUserFacade().getOrganisation(id));
		
		for(String id : membershipSelection) {
			OrganisationDto orgDto = getUserFacade().getOrganisation(Long.valueOf(id));
			getUserFacade().addMembership(person, orgDto);
		}
		
		PhoneDto phone = assemblePhoneDto();
		phone.setId(getUserFacade().saveOrUpdatePhone(phone));
		getUserFacade().addPhone(phone, person);
		
		AddressDto address = assembleAddressDto();
		address.setId(getUserFacade().saveOrUpdateAddress(address));
		getUserFacade().addAddress(address, person);
		
		resetSelections();
		return listPersons();
	}
	
	private AddressDto assembleAddressDto() {
		AddressDto a = new AddressDto();
		a.setId(addressID);
		a.setCountry(country);
		a.setStreet(street);
		a.setTown(town);
		a.setZip(zip);
		return a;
	}

	private PhoneDto assemblePhoneDto() {
		PhoneDto p = new PhoneDto();
		p.setId(phoneID);
		p.setExtension(extension);
		p.setNumber(number);
		return p;
	}

	private PersonDto assemblePersonDto() {
		PersonDto p = new PersonDto();
		p.setUid(id);
		p.setBirthdate(birthdate);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		return p;
	}
	
	private void savePersonDto(PersonDto p) {
		id = p.getId();
		firstName = p.getFirstName();
		lastName = p.getLastName();
		birthdate = p.getBirthdate();
	}
	
	private void savePhoneDto(PhoneDto p) {
		phoneID = p.getId();
		extension = p.getExtension();
		number = p.getNumber();
	}
	
	private void saveAddressDto(AddressDto a) {
		addressID = a.getId();
		street = a.getStreet();
		town = a.getTown();
		zip = a.getZip();
		country = a.getCountry();
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
			PersonDto person = getUserFacade().getPerson(personSelection);
			savePersonDto(person);
			
			memberships = getUserFacade().getOrganisations().getElements();
			membershipSelection = new ArrayList<String>();
			for(Long l : getUserFacade().getMemberships(person).getElements().keySet())
				membershipSelection.add(l.toString());  
			
			CollectionDto phonesTemp = getUserFacade().getPhones(person);
			PhoneDto phone = phonesTemp.getElements().isEmpty() ? new PhoneDto() : getUserFacade().getPhone(phonesTemp.getElements().keySet().iterator().next());
			savePhoneDto(phone);
			
			CollectionDto adrsTemp = getUserFacade().getAddresses(person);
			AddressDto address = adrsTemp.getElements().isEmpty() ? new AddressDto() : getUserFacade().getAddress(adrsTemp.getElements().keySet().iterator().next());
			saveAddressDto(address);
			
			return true;
		}
		return false;
	}

	public String listPersons() {
		personCollection = getUserFacade().getPersons().getElements();
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
			personCollection = getUserFacade().getPersons().getElements();
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
	
	public Map<Long, String> getPersonCollection() {
		return personCollection;
	}

	public void setPersonCollection(Map<Long, String> persons) {
		this.personCollection = persons;
	}

	public Long getPersonSelection() {
		return personSelection;
	}

	public void setPersonSelection(Long personSelection) {
		this.personSelection = personSelection;
	}
	
	public Map<Long, String> getMemberships() {
		return memberships;
	}

	public void setMemberships(Map<Long, String> memberships) {
		this.memberships = memberships;
	}
	
	public List<String> getMembershipSelection() {
		return membershipSelection;
	}

	public void setMembershipSelection(List<String> membershipSelection) {
		this.membershipSelection = membershipSelection;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}