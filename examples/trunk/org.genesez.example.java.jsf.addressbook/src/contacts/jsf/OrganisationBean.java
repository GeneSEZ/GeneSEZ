package contacts.jsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jsf.util.FacesHelper;
import contacts.facade.FacadeBase;
import contacts.facade.UserFacade;
import contacts.facade.dto.AddressDto;
import contacts.facade.dto.CollectionDto;
import contacts.facade.dto.OrganisationDto;
import contacts.facade.dto.PersonDto;
import contacts.facade.dto.PhoneDto;

public class OrganisationBean {
	
	private FacadeBase facade;
	
	private List<Entry<Long, String>> organisationCollection = new ArrayList<Entry<Long, String>>();
	private Long organisationSelection;
	private OrganisationDto organisation;
	
	private Map<Long, String> members;
	private List<String> membersSelection;
	
	private Map<Long, String> parentOrganisation;
	private Long parentOrganisationSelection;
	
	private List<String> subsidiariesSelection;
	private Map<Long, String> subsidiaries;
	
	private List<PhoneDto> phone = new ArrayList<PhoneDto>();
	private PhoneDto phoneRemove;
	private List<AddressDto> address = new ArrayList<AddressDto>();;
	private AddressDto addressRemove;
	
	public OrganisationBean() {
	}
	
	public String newOrganisation() {
		resetSelections();
		organisation = new OrganisationDto();
		phone = new ArrayList<PhoneDto>();
		phone.add(new PhoneDto());
		address = new ArrayList<AddressDto>();
		address.add(new AddressDto());
		members = getUserFacade().getPersons().getElements();
		parentOrganisation = getUserFacade().getOrganisations().getElements();
		subsidiaries = getUserFacade().getOrganisations().getElements();
		
		return addDefaultSelections();
	}
	
	public String addPhone() {
		phone.add(new PhoneDto());
		return null;
	}
	
	public String addAddress() {
		address.add(new AddressDto());
		return null;
	}
	
	public String removePhone() {
		phone.remove(phoneRemove);
		getUserFacade().removePhone(phoneRemove, organisation);
		return null;
	}
	
	public String removeAddress() {
		address.remove(addressRemove);
		getUserFacade().removeAddress(addressRemove, organisation);
		return null;
	}
	
	public String saveOrganisation() {
		organisation.setId(getUserFacade().saveOrUpdateOrganisation(organisation));
		
		for(Long id : getUserFacade().getMembers(organisation).getElements().keySet())
			if(!membersSelection.contains(id.toString()))
				getUserFacade().removeMembership(getUserFacade().getPerson(id), organisation);
		
		for(String id : membersSelection) {
			PersonDto persDto = getUserFacade().getPerson(Long.valueOf(id));
			getUserFacade().addMembership(persDto, organisation);
		}
		
		if(parentOrganisationSelection != null && parentOrganisationSelection > 0 &&
				!subsidiariesSelection.contains(String.valueOf(parentOrganisationSelection))) {
			OrganisationDto parentDto = getUserFacade().getOrganisation(Long.valueOf(parentOrganisationSelection));
			getUserFacade().setParent(organisation, parentDto);
		}
		
		if(parentOrganisationSelection != null && parentOrganisationSelection < 0)
			getUserFacade().removeParent(organisation);
		
		for(Long id : getUserFacade().getSubsidiaries(organisation).getElements().keySet())
			if(!subsidiariesSelection.contains(id.toString()))
				getUserFacade().removeSubsidiary(getUserFacade().getOrganisation(id), organisation);
		
		for(String id : subsidiariesSelection) {
			if(Long.valueOf(id) != parentOrganisationSelection) {
				OrganisationDto subDto = getUserFacade().getOrganisation(Long.valueOf(id));
				getUserFacade().addSubsidiary(subDto, organisation);
			}
		}
		
		for(PhoneDto p : phone) {
			p.setId(getUserFacade().saveOrUpdatePhone(p));
			getUserFacade().addPhone(p, organisation);
		}
		
		for(AddressDto a : address) {
			a.setId(getUserFacade().saveOrUpdateAddress(a));
			getUserFacade().addAddress(a, organisation);
		}
		
		emptyAssocs();
		resetSelections();
		return listOrganisation();
	}
	
	private void resetSelections() {
		organisationSelection = parentOrganisationSelection = null;
		membersSelection = subsidiariesSelection = null;
	}
	
	private void emptyAssocs() {
		phone.removeAll(phone);
		address.removeAll(address);
	}
	
	public String showOrganisation() {
		return selectForShow() ? "oshow" : listOrganisation();
	}
	
	public String selectOrganisation() {
		return select() ? addDefaultSelections() : listOrganisation();
	}
	
	private boolean selectForShow() {
		if (organisationSelection != null && organisationSelection > 0) {
			organisation = getUserFacade().getOrganisation(organisationSelection);
			
			members = getUserFacade().getMembers(organisation).getElements();
			membersSelection = new ArrayList<String>();
			for(Long l : getUserFacade().getMembers(organisation).getElements().keySet())
				membersSelection.add(l.toString()); 
			
			parentOrganisation = new HashMap<Long, String>(); 
			Long id = getUserFacade().getParentOrganisation(organisation).getId();
			String name = getUserFacade().getParentOrganisation(organisation).getName();
			if(id != null && name != null)parentOrganisation.put(id, name);
			parentOrganisationSelection = getUserFacade().getParentOrganisation(organisation).getId();
			
			subsidiaries = getUserFacade().getSubsidiaries(organisation).getElements();
			subsidiariesSelection = new ArrayList<String>();
			for(Long l : getUserFacade().getSubsidiaries(organisation).getElements().keySet()) {
				subsidiariesSelection.add(l.toString()); 
			}
			
			CollectionDto phonesTemp = getUserFacade().getPhones(organisation);
			for(Long l : phonesTemp.getElements().keySet())
				phone.add(getUserFacade().getPhone(l));
			if(phone.isEmpty()) phone.add(new PhoneDto());
			
			CollectionDto adrTemp = getUserFacade().getAddresses(organisation);
			for(Long l : adrTemp.getElements().keySet())
				address.add(getUserFacade().getAddress(l));
			if(address.isEmpty()) address.add(new AddressDto());
			
			return true;
		}
		
		return false;
	}
	
	private boolean select() {
		if (organisationSelection != null && organisationSelection > 0) {
			organisation = getUserFacade().getOrganisation(organisationSelection);
			
			members = getUserFacade().getPersons().getElements();
			membersSelection = new ArrayList<String>();
			for(Long l : getUserFacade().getMembers(organisation).getElements().keySet())
				membersSelection.add(l.toString()); 
			
			parentOrganisation = getUserFacade().getOrganisations().getElements();
			parentOrganisation.remove(organisation.getId());
			parentOrganisationSelection = getUserFacade().getParentOrganisation(organisation).getId();
			
			subsidiaries = getUserFacade().getOrganisations().getElements();
			subsidiaries.remove(organisation.getId());
			if(parentOrganisationSelection != null) 
				subsidiaries.remove(parentOrganisationSelection);
			subsidiariesSelection = new ArrayList<String>();
			for(Long l : getUserFacade().getSubsidiaries(organisation).getElements().keySet()) {
				subsidiariesSelection.add(l.toString()); 
				parentOrganisation.remove(l);
			}
			
			CollectionDto phonesTemp = getUserFacade().getPhones(organisation);
			for(Long l : phonesTemp.getElements().keySet())
				phone.add(getUserFacade().getPhone(l));
			if(phone.isEmpty()) phone.add(new PhoneDto());
			
			CollectionDto adrTemp = getUserFacade().getAddresses(organisation);
			for(Long l : adrTemp.getElements().keySet())
				address.add(getUserFacade().getAddress(l));
			if(address.isEmpty()) address.add(new AddressDto());
			
			return true;
		}
		
		return false;
	}
	
	private String addDefaultSelections() {
		Long defaultID = (long) -1;
		String defaultString = "keine";
		
		parentOrganisation.put(defaultID, defaultString);
		
		return "oedit";
	}
	
	private void mapToList(Map<Long, String> map, List<Entry<Long, String>> list) {
		list.removeAll(list);
		list.addAll(map.entrySet());
	}

	public String listOrganisation() {
		mapToList(getUserFacade().getOrganisations().getElements(), organisationCollection);
		emptyAssocs();
		resetSelections();
		return "olist";
	}

	public String deleteOrganisation() {
		if (organisationSelection != null && organisationSelection > 0) {
			OrganisationDto dto = getUserFacade().getOrganisation(organisationSelection);
			
			CollectionDto members = getUserFacade().getMembers(dto);
			for(Long id : members.getElements().keySet()) getUserFacade().removeMembership(getUserFacade().getPerson(id), dto);
			
			getUserFacade().removeParent(dto);
			
			CollectionDto subs = getUserFacade().getSubsidiaries(dto);
			for(Long id : subs.getElements().keySet()) getUserFacade().removeSubsidiary(getUserFacade().getOrganisation(id), dto);
			
			CollectionDto phones = getUserFacade().getPhones(dto);
			for(Long id : phones.getElements().keySet()) getUserFacade().removePhone(getUserFacade().getPhone(id), dto);
			
			CollectionDto adrs = getUserFacade().getAddresses(dto);
			for(Long id : adrs.getElements().keySet()) getUserFacade().removeAddress(getUserFacade().getAddress(id), dto);
			
			getUserFacade().deleteOrganisation(dto);
			mapToList(getUserFacade().getOrganisations().getElements(), organisationCollection);
			resetSelections();
		}
		return listOrganisation();
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
	
	public Map<Long, String> getMembers() {
		return members;
	}

	public void setMembers(Map<Long, String> members) {
		this.members = members;
	}
	
	public List<String> getMembersSelection() {
		return membersSelection;
	}

	public void setMembersSelection(List<String> membersSelection) {
		this.membersSelection = membersSelection;
	}

	public List<Entry<Long, String>> getOrganisationCollection() {
		return organisationCollection;
	}

	public void setOrganisationCollection(List<Entry<Long, String>> organisationCollection) {
		this.organisationCollection = organisationCollection;
	}

	public Long getOrganisationSelection() {
		return organisationSelection;
	}

	public void setOrganisationSelection(Long organisationSelection) {
		this.organisationSelection = organisationSelection;
	}

	public Long getParentOrganisationSelection() {
		return parentOrganisationSelection;
	}

	public void setParentOrganisationSelection(Long parentOrganisationSelection) {
		this.parentOrganisationSelection = parentOrganisationSelection;
	}

	public Map<Long, String> getParentOrganisation() {
		return parentOrganisation;
	}

	public void setParentOrganisation(Map<Long, String> parentOrganisation) {
		this.parentOrganisation = parentOrganisation;
	}

	public List<String> getSubsidiariesSelection() {
		return subsidiariesSelection;
	}

	public void setSubsidiariesSelection(List<String> subsidiariesSelection) {
		this.subsidiariesSelection = subsidiariesSelection;
	}

	public Map<Long, String> getSubsidiaries() {
		return subsidiaries;
	}

	public void setSubsidiaries(Map<Long, String> subsidiaries) {
		this.subsidiaries = subsidiaries;
	}

	public OrganisationDto getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationDto organisation) {
		this.organisation = organisation;
	}

	public List<PhoneDto> getPhone() {
		return phone;
	}

	public void setPhone(List<PhoneDto> phone) {
		this.phone = phone;
	}

	public List<AddressDto> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDto> address) {
		this.address = address;
	}

	public PhoneDto getPhoneRemove() {
		return phoneRemove;
	}

	public void setPhoneRemove(PhoneDto phoneRemove) {
		this.phoneRemove = phoneRemove;
	}

	public AddressDto getAddressRemove() {
		return addressRemove;
	}

	public void setAddressRemove(AddressDto addressRemove) {
		this.addressRemove = addressRemove;
	}
	
}