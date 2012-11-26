package contacts.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.genesez.examples.java.jsf.addressbook.domain.Address;
import org.genesez.examples.java.jsf.addressbook.domain.Contact;
import org.genesez.examples.java.jsf.addressbook.domain.Organisation;
import org.genesez.examples.java.jsf.addressbook.domain.Person;
import org.genesez.examples.java.jsf.addressbook.domain.Phone;

import contacts.facade.dto.AddressDto;
import contacts.facade.dto.CollectionDto;
import contacts.facade.dto.OrganisationDto;
import contacts.facade.dto.PersonDto;
import contacts.facade.dto.PhoneDto;

public class UserFacade extends FacadeBase {

	/**
	 * Wird sinnvollerweise nur aus der AnonymousFacade aufgerufen
	 * 
	 * @param m
	 *            der dem aktuellen User zugeordnete Member
	 */
	UserFacade() {
		super();
	}

	/**
	 * hole Collection aller Persons
	 * 
	 * @return alle Persons als CollectionDto
	 */
	public CollectionDto getPersons() {
		CollectionDto persons = new CollectionDto();
		for (Person person : personDao.fetchAll()) {
			persons.addElement(person.getId(), person.getFirstName() + " " + person.getLastName());
		}
		return persons;
	}

	/**
	 * hole Person
	 * 
	 * @param uid
	 *            Person Datenbankschluessel
	 * @return Person als DTO oder null
	 */
	public PersonDto getPerson(Long uid) {
		if(uid != null) {
			PersonDto dto = new PersonDto();
			Person person = personDao.fetch(uid);
			if (person != null) {
				dto.setUid(uid);
				dto.setFirstName(person.getFirstName());
				dto.setLastName(person.getLastName());
				dto.setBirthdate(person.getBirthdate());
				return dto;
			}
		}
		return new PersonDto();
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto findPerson(PersonDto dto){
		CollectionDto coll = new CollectionDto();
		 Map<String, Object> params = new HashMap<String, Object>();
	     params.put("Birthdate", dto.getBirthdate());
	     params.put("FirstName", dto.getFirstName());
	     params.put("LastName", dto.getLastName());
	     
		List<Person> per = personDao.find("From Person Where " +
                "Birthdate = :Birthdate OR " +
                "FirstName = :FirstName OR " +
                "LastName = :LastName", 
                params);
		if(per != null)
			for(Person pers : per)
				coll.addElement(pers.getId(), pers.getLastName() + ", " + pers.getFirstName());
		return coll;
	}
	
	/**
	 * Aktualisiere Person-Daten oder lege neue Person an
	 * 
	 * @param dto
	 * @return uid des Objekts, wichtig, wenn neu angelegt.
	 */
	public Long saveOrUpdatePerson(PersonDto dto) {
		Person person;
		if (dto.getId() == null) {
			person = new Person();
		} else {
			person = personDao.fetch(dto.getId());
		}
		person.setFirstName(dto.getFirstName());
		person.setLastName(dto.getLastName());
		person.setBirthdate(dto.getBirthdate());
		personDao.save(person);
		personDao.commit();
		return person.getId();
	}
	
	/**
	 * Loescht Personen-Daten
	 * 
	 * @param dto
	 */
	public boolean deletePerson(PersonDto dto) {
		if(dto.getId() != null) {
			Person person = personDao.fetch(dto.getId());
			if(person != null) {
				personDao.delete(person);
				personDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto getMemberships(PersonDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Person pers = personDao.fetch(dto.getId());
			if(pers != null) 
				for(Organisation org : pers.getMembership())
					coll.addElement(org.getId(), org.getName());
			return coll;
		}
		return new CollectionDto();
	}
	
	/**
	 * 
	 * @param persDto
	 * @param orgDto
	 */
	public boolean addMembership(PersonDto persDto, OrganisationDto orgDto) {
		if(persDto != null && persDto.getId() != null && orgDto != null && orgDto.getId() != null) {
			Person pers = personDao.fetch(persDto.getId());
			Organisation org = organisationDao.fetch(orgDto.getId());
			if(pers != null && org != null) {
				pers.insertInMembership(org);
				personDao.save(pers);
				personDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param persDto
	 * @param orgDto
	 */
	public boolean removeMembership(PersonDto persDto, OrganisationDto orgDto) {
		if(persDto != null && persDto.getId() != null && orgDto != null && orgDto.getId() != null) {
			Person pers = personDao.fetch(persDto.getId());
			Organisation org = organisationDao.fetch(orgDto.getId());
			if(pers != null && org != null) {
				pers.removeFromMembership(org);
				personDao.save(pers);
				personDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * hole Collection aller Organisations
	 * 
	 * @return alle Organisations als CollectionDto
	 */
	public CollectionDto getOrganisations() {
		CollectionDto organisations = new CollectionDto();
		for (Organisation org : organisationDao.fetchAll()) {
			organisations.addElement(org.getId(), org.getName());
		}
		return organisations;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto findOrganisations(OrganisationDto dto){
		CollectionDto coll = new CollectionDto();
		 Map<String, Object> params = new HashMap<String, Object>();
	     params.put("Name", dto.getName());
	     
		List<Organisation> orgs = organisationDao.find("From Organisation Where " +
                "Name = :Name", 
                params);
		if(orgs != null)
			for(Organisation org : orgs)
				coll.addElement(org.getId(), org.getName());
		return coll;
	}
	

	/**
	 * hole Organisation
	 * 
	 * @param id
	 *            Organisation Datenbankschluessel
	 * @return Organisation als DTO oder null
	 */
	public OrganisationDto getOrganisation(Long id) {
		if(id != null) {
			OrganisationDto dto = new OrganisationDto();
			Organisation org = organisationDao.fetch(id);
			if (org != null) {
				dto.setId(id);
				dto.setName((org.getName()));
				dto.setNonprofit(org.getNonprofit());
				return dto;
			}
		}
		return new OrganisationDto();
	}

	/**
	 * Aktualisiere Organisation-Daten oder lege neue Organisation an
	 * 
	 * @param dto
	 * @return id des Objekts, wichtig, wenn neu angelegt.
	 */
	public Long saveOrUpdateOrganisation(OrganisationDto dto) {
		Organisation org;
		if (dto.getId() == null) {
			org = new Organisation();
		} else {
			org = organisationDao.fetch(dto.getId());
		}
		org.setName(dto.getName());
		org.setNonprofit(dto.getNonprofit());
		organisationDao.save(org);
		organisationDao.commit();
		return org.getId();
	}
	
	/**
	 * Loescht Organisation-Daten
	 * 
	 * @param dto
	 */
	public boolean deleteOrganisation(OrganisationDto dto) {
		if(dto.getId() != null) {
			Organisation org = organisationDao.fetch(dto.getId());
			if(org != null) {
				organisationDao.delete(org);
				organisationDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto getMembers(OrganisationDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Organisation org = organisationDao.fetch(dto.getId());
			if(org != null)
				for(Person pers : org.getMembers())
					coll.addElement(pers.getId(), pers.getLastName() + ", " + pers.getFirstName());
			return coll;
		}
		return new CollectionDto();
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto getSubsidiaries(OrganisationDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Organisation org = organisationDao.fetch(dto.getId());
			if(org != null)
				for(Organisation sub : org.getSubsidiaries())
					coll.addElement(sub.getId(), sub.getName());
			return coll;
		}
		return new CollectionDto();
	}
	
	/**
	 * 
	 * @param subDto
	 * @return
	 */
	public OrganisationDto getParentOrganisation(OrganisationDto subDto) {
		if(subDto.getId() != null) {
			OrganisationDto parentDto = new OrganisationDto();
			Organisation subOrg = organisationDao.fetch(subDto.getId());
			if(subOrg != null) {
				Organisation parentOrg = subOrg.getParentOrganisation();
				if(parentOrg != null) {
					parentDto.setName(parentOrg.getName());
					parentDto.setId(parentOrg.getId());
					parentDto.setNonprofit(parentOrg.getNonprofit());
					return parentDto;
				}
			}
		}
		return new OrganisationDto();
	}
	
	/**
	 * 
	 * @param subDto
	 * @param parentDto
	 */
	public boolean setParent(OrganisationDto subDto, OrganisationDto parentDto) {
		if(subDto != null && subDto.getId() != null && parentDto != null && parentDto.getId() != null) {
			Organisation sub = organisationDao.fetch(subDto.getId());
			Organisation parent = organisationDao.fetch(parentDto.getId());
			if(sub != null && parent != null) {
				sub.setParentOrganisation(parent);
				organisationDao.save(sub);
				organisationDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param subDto
	 * @param parentDto
	 */
	public boolean addSubsidiary(OrganisationDto subDto, OrganisationDto parentDto) {
		if(subDto != null && subDto.getId() != null && parentDto != null && parentDto.getId() != null) {
			Organisation sub = organisationDao.fetch(subDto.getId());
			Organisation parent = organisationDao.fetch(parentDto.getId());
			if(sub != null && parent != null) {
				parent.insertInSubsidiaries(sub);
				organisationDao.save(parent);
				organisationDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param subDto
	 */
	public boolean removeParent(OrganisationDto subDto) {
		if(subDto != null && subDto.getId() != null) {
			Organisation sub = organisationDao.fetch(subDto.getId());
			if(sub != null && sub.getParentOrganisation() != null) {
				sub.setParentOrganisation(null);
				organisationDao.save(sub);
				organisationDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param subDto
	 * @param parentDto
	 */
	public boolean removeSubsidiary(OrganisationDto subDto, OrganisationDto parentDto) {
		if(subDto != null && subDto.getId() != null && parentDto != null && parentDto.getId() != null) {
			Organisation sub = organisationDao.fetch(subDto.getId());
			Organisation parent = organisationDao.fetch(parentDto.getId());
			if(sub != null && parent != null) {
				parent.removeFromSubsidiaries(sub);
				organisationDao.save(parent);
				organisationDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public Long saveOrUpdateAddress(AddressDto dto) {
		Address address;
		if (dto.getId() == null) {
			address = new Address();
		} else {
			address = addressDao.fetch(dto.getId());
		}
		address.setStreet(dto.getStreet());
		address.setTown(dto.getTown());
		address.setZip(dto.getZip());
		address.setCountry(dto.getCountry());
		addressDao.save(address);
		addressDao.commit();
		return address.getId();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public AddressDto getAddress(Long id) {
		if(id != null) {
			AddressDto dto = new AddressDto();
			Address address = addressDao.fetch(id);
			if (address != null) {
				dto.setId(id);
				dto.setStreet(address.getStreet());
				dto.setTown(address.getTown());
				dto.setZip(address.getZip());
				dto.setCountry(address.getCountry());
				return dto;
			}
		}
		return new AddressDto();
	}
	
	/**
	 * 
	 * @return
	 */
	public CollectionDto getAddresses() {
		CollectionDto addresses = new CollectionDto();
		for (Address adr : addressDao.fetchAll()) {
			addresses.addElement(adr.getId(), adr.getTown() + " " + adr.getStreet());
		}
		return addresses;
	}
	
	/**
	 * 
	 * @param dto
	 */
	public boolean deleteAddress(AddressDto dto){
		if(dto.getId() != null) {
			Address address = addressDao.fetch(dto.getId());
			if(dto != null) {
				addressDao.delete(address);
				addressDao.commit();
				return true;
			}
		}
		return false;
	}
	
	public CollectionDto findAddress(AddressDto dto) {
		CollectionDto coll = new CollectionDto();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("street", dto.getStreet());
		params.put("zip", dto.getZip());
		params.put("town", dto.getTown());
		params.put("country", dto.getCountry());
		
		List<Address> list = addressDao.find("from Address where " +
														"street = :street OR " +
														"zip = :zip OR " + 
														"town = :town OR " +
														"country = :country",
														params);
		
		for(Address adr : list) {
			String str = "";
			if(adr.getStreet() != null) str += adr.getStreet();
			if(adr.getStreet() != null && adr.getZip() != null) str += " ";
			if(adr.getZip() != null) str += adr.getZip();
			if(adr.getZip() != null && adr.getTown() != null) str += " ";
			if(adr.getTown() != null) str += adr.getTown();
			if(adr.getTown() != null && adr.getCountry() != null) str += " ";
			if(adr.getCountry() != null) str += adr.getCountry();
			coll.addElement(adr.getId(), str);
		}
		
		return coll;
	}
	
	/**
	 * 
	 * @param adrDto
	 * @param orgDto
	 */
	public boolean addAddress(AddressDto adrDto, OrganisationDto orgDto) {
		if(adrDto != null && adrDto.getId() != null && orgDto != null && orgDto.getId() != null) {
			Address adr = addressDao.fetch(adrDto.getId());
			Organisation org = organisationDao.fetch(orgDto.getId());
			if(adr != null && org != null) {
				org.insertInContacts(adr);
				addressDao.save(adr);
				addressDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param adrDto
	 * @param persDto
	 */
	public boolean addAddress(AddressDto adrDto, PersonDto persDto) {
		if(adrDto != null && adrDto.getId() != null && persDto != null && persDto.getId() != null) {
			Address adr = addressDao.fetch(adrDto.getId());
			Person pers = personDao.fetch(persDto.getId());
			if(adr != null && pers != null) {
				pers.insertInContacts(adr);
				addressDao.save(adr);
				addressDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param adrDto
	 * @param orgDto
	 */
	public boolean removeAddress(AddressDto adrDto, OrganisationDto orgDto) {
		if(adrDto != null && adrDto.getId() != null && orgDto != null && orgDto.getId() != null) {
			Address adr = addressDao.fetch(adrDto.getId());
			Organisation org = organisationDao.fetch(orgDto.getId());
			if(adr != null && org != null) {
				org.removeFromContacts(adr);
				addressDao.save(adr);
				addressDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param adrDto
	 * @param persDto
	 */
	public boolean removeAddress(AddressDto adrDto, PersonDto persDto) {
		if(adrDto != null && adrDto.getId() != null && persDto != null && persDto.getId() != null) {
			Address adr = addressDao.fetch(adrDto.getId());
			Person pers = personDao.fetch(persDto.getId());
			if(adr != null && pers != null) {
				pers.removeFromContacts(adr);
				addressDao.save(adr);
				addressDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto getAddresses(PersonDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Person pers = personDao.fetch(dto.getId());
			if(pers != null)
				for(Contact con : pers.getContacts())
					if(con instanceof Address) {
						Address adr = (Address) con;
						coll.addElement(adr.getId(), adr.getTown() + " " + adr.getStreet());
					}
			return coll;
		}
		return new CollectionDto();
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto getAddresses(OrganisationDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Organisation org = organisationDao.fetch(dto.getId());
			if(org != null)
				for(Contact con : org.getContacts())
					if(con instanceof Address) {
						Address adr = (Address) con;
						coll.addElement(adr.getId(), adr.getTown() + " " + adr.getStreet());
					}
			return coll;
		}
		return new CollectionDto();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public CollectionDto getContacts(OrganisationDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Organisation orga = organisationDao.fetch(dto.getId());
			if(orga != null) 
				for(Contact con : orga.getContacts())
					coll.addElement(con.getId(), con.getClass().toString());
			return coll;
		}
		return new CollectionDto();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public CollectionDto getContacts(PersonDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Person pers = personDao.fetch(dto.getId());
			if(pers != null) 
				for(Contact con : pers.getContacts())
					coll.addElement(con.getId(), con.getClass().toString());
			return coll;
		}
		return new CollectionDto();
	}

	/**
	 * @param dto
	 */
	public Long saveOrUpdatePhone(PhoneDto dto){
		Phone phone;
		if(dto.getId() == null){
			phone = new Phone();
		}else{
			phone = phoneDao.fetch(dto.getId());
		}
		phone.setNumber(dto.getNumber());
		phone.setExtension(dto.getExtension());
		phoneDao.save(phone);
		phoneDao.commit();
		return phone.getId();	
	}
	
	/**
	 * @param id
	 * @return
	 */
	public PhoneDto getPhone(Long id) {
		if(id != null) {
			PhoneDto dto = new PhoneDto();
			Phone phone = phoneDao.fetch(id);
			if (phone != null) {
				dto.setId(id);
				dto.setNumber(phone.getNumber());
				dto.setExtension(phone.getExtension());
				return dto;
			}
		}
		return new PhoneDto();
	}
	
	/**
	 * 
	 * @return
	 */
	public CollectionDto getPhones() {
		CollectionDto phones = new CollectionDto();
		for (Phone phone : phoneDao.fetchAll()) {
			phones.addElement(phone.getId(), phone.getExtension() + " " + phone.getNumber());
		}
		return phones;
	}
	
	/**
	 * 
	 * @param dto
	 */
	public boolean deletePhone(PhoneDto dto){
		if(dto.getId() != null) {
			Phone phone = phoneDao.fetch(dto.getId());
			if(dto != null) {
				phoneDao.delete(phone);
				phoneDao.commit();
				return true;
			}
		}
		return false;
	}
	
	public CollectionDto findPhone(PhoneDto dto) {
		CollectionDto coll = new CollectionDto();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("number", dto.getNumber());
		params.put("extension", dto.getExtension());
		
		List<Phone> list = phoneDao.find("from Phone where " +
							"number = :number OR " +
							"extension = :extension", params);
		
		for(Phone phone : list) {
			String str = "";
			if(phone.getExtension() != null) str += phone.getExtension();
			if(phone.getExtension() != null && phone.getNumber() != null) str += " ";
			if(phone.getNumber() != null) str += phone.getNumber();
			coll.addElement(phone.getId(), str);
		}
		
		return coll;
	}
	
	/**
	 * 
	 * @param phoneDto
	 * @param persDto
	 */
	public boolean addPhone(PhoneDto phoneDto, PersonDto persDto) {
		if(phoneDto != null && phoneDto.getId() != null && persDto != null && persDto.getId() != null) {
			Phone phone = phoneDao.fetch(phoneDto.getId());
			Person pers = personDao.fetch(persDto.getId());
			if(phone != null && pers != null) {
				pers.insertInContacts(phone);
				personDao.save(pers);
				personDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param phoneDto
	 * @param orgDto
	 */
	public boolean addPhone(PhoneDto phoneDto, OrganisationDto orgDto) {
		if(phoneDto != null && phoneDto.getId() != null && orgDto != null && orgDto.getId() != null) {
			Phone phone = phoneDao.fetch(phoneDto.getId());
			Organisation org = organisationDao.fetch(orgDto.getId());
			if(phone != null && org != null) {
				org.insertInContacts(phone);
				organisationDao.save(org);
				organisationDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param phoneDto
	 * @param orgDto
	 */
	public boolean removePhone(PhoneDto phoneDto, OrganisationDto orgDto) {
		if(orgDto != null && orgDto.getId() != null && phoneDto != null && phoneDto.getId() != null) {
			Organisation org = organisationDao.fetch(orgDto.getId());
			Phone phone = phoneDao.fetch(phoneDto.getId());
			if(org != null && phone != null) {
				org.removeFromContacts(phone);
				organisationDao.save(org);
				organisationDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param phoneDto
	 * @param persDto
	 */
	public boolean removePhone(PhoneDto phoneDto, PersonDto persDto) {
		if(persDto != null && persDto.getId() != null && phoneDto != null && phoneDto.getId() != null) {
			Person pers = personDao.fetch(persDto.getId());
			Phone phone = phoneDao.fetch(phoneDto.getId());
			if(pers != null && phone != null) {
				pers.removeFromContacts(phone);
				personDao.save(pers);
				personDao.commit();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto getPhones(PersonDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Person pers = personDao.fetch(dto.getId());
			if(pers != null)
				for(Contact con : pers.getContacts())
					if(con instanceof Phone) {
						Phone phone = (Phone) con;
						coll.addElement(phone.getId(), phone.getExtension() + " " + phone.getNumber());
					}
			return coll;
		}
		return new CollectionDto();
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public CollectionDto getPhones(OrganisationDto dto) {
		if(dto.getId() != null) {
			CollectionDto coll = new CollectionDto();
			Organisation org = organisationDao.fetch(dto.getId());
			if(org != null)
				for(Contact con : org.getContacts())
					if(con instanceof Phone) {
						Phone phone = (Phone) con;
						coll.addElement(phone.getId(), phone.getExtension() + " " + phone.getNumber());
					}
			return coll;
		}
		return new CollectionDto();
	}
	
}
