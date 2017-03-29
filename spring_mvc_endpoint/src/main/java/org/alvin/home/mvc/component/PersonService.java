package org.alvin.home.mvc.component;

import org.springframework.stereotype.Component;

import org.alvin.home.mvc.Person;
@Component
public class PersonService implements IPersonService {

	public Person getPersonDetail(Integer id){
		Person p = new Person();
		p.setId(id);
		p.setLocation("California");
		p.setName("Spring");
		return p;
	}
}
