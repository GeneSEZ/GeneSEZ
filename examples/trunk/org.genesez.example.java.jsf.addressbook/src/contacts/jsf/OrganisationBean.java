package contacts.jsf;

import java.util.ArrayList;
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

public class OrganisationBean {
	
	private FacadeBase facade;
	
	private CollectionDto orgas = new CollectionDto();
	private Long orgaSelection;
	private OrganisationDto organisation = new OrganisationDto();
	
	private Map<Long, String> members;
	private List<String> membersSelection;
	
	private Map<Long, String> parentOrganisation;
	private Long parentOrganisationSelection;
	
	private List<String> subsidiariesSelection;
	private Map<Long, String> subsidiaries;
	
	private PhoneDto phone;
	
	private AddressDto address;
	
	public OrganisationBean() {
	}
	
	public String newOrganisation() {
		organisation = new OrganisationDto();
		
		members = getUserFacade().getPersons().getElements();
		parentOrganisation = getUserFacade().getOrganisations().getElements();
		subsidiaries = getUserFacade().getOrganisations().getElements();
		phone = new PhoneDto();
		address = new AddressDto();
		
		return addDefaultSelections();
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
		
		phone.setId(getUserFacade().saveOrUpdatePhone(phone));
		getUserFacade().addPhone(phone, organisation);
		
		address.setId(getUserFacade().saveOrUpdateAddress(address));
		getUserFacade().addAddress(address, organisation);
		
		resetSelections();
		return listOrganisations();
	}
	
	private void resetSelections() {
		orgaSelection = parentOrganisationSelection = null;
		membersSelection = subsidiariesSelection = null;
	}
	
	public String showSelectedOrganisation() {
		return select() ? "oshow" : listOrganisations();
	}
	
	public String selectOrganisation() {
		return select() ? addDefaultSelections() : listOrganisations();
	}
	
	private boolean select() {
		if (orgaSelection != null && orgaSelection > 0) {
			organisation = getUserFacade().getOrganisation(orgaSelection);
			
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
			phone = phonesTemp.getElements().isEmpty() ? new PhoneDto() : getUserFacade().getPhone(phonesTemp.getElements().keySet().iterator().next());
			
			CollectionDto adrsTemp = getUserFacade().getAddresses(organisation);
			address = adrsTemp.getElements().isEmpty() ? new AddressDto() : getUserFacade().getAddress(adrsTemp.getElements().keySet().iterator().next());
			
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

	public String listOrganisations() {
		orgas = getUserFacade().getOrganisations();
		resetSelections();
		return "olist";
	}
	
	public String deleteOrganisation() {
		if (orgaSelection != null && orgaSelection > 0) {
			OrganisationDto dto = getUserFacade().getOrganisation(orgaSelection);
			
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
			orgas = getUserFacade().getOrganisations();
			resetSelections();
		}
		return listOrganisations();
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

	public OrganisationDto getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationDto organisation) {
		this.organisation = organisation;
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

	public CollectionDto getOrgas() {
		return orgas;
	}

	public void setOrgas(CollectionDto orgas) {
		this.orgas = orgas;
	}

	public Long getOrgaSelection() {
		return orgaSelection;
	}

	public void setOrgaSelection(Long orgaSelection) {
		this.orgaSelection = orgaSelection;
	}

	public PhoneDto getPhone() {
		return phone;
	}

	public void setPhone(PhoneDto phone) {
		this.phone = phone;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
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
	
}