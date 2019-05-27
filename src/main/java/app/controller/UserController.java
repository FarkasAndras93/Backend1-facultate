package main.java.app.controller;

import java.util.List;

import main.java.app.service.impl.UserService;
import main.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
	@Autowired
	private UserService userService;	

	public UserController() {
		super();
	}
	
	@RequestMapping("/greetings")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
		userService.createUser(user);
    }

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
	   
	@RequestMapping(value = "/users")
	public List<User> printWelcome() {
		return userService.getAllUsers();
	}

//	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//	public ModelAndView hello(@PathVariable("name") String name) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("hello");
//		model.addObject("msg", name);
//
//		return model;
//	}
//
//	@RequestMapping("/persons/list")
//	public String personsList(Model model) {
//		List<Person> personsList = personService.listPersons();
//		model.addAttribute("personsList", personsList);
//
//		return "list";
//	}
//	
//	@RequestMapping(value = "/persons/listall")
//	public @ResponseBody List<Person> personsListAll() {
//		return personService.listPersons();
//	}
//
//	@RequestMapping("/persons/add")
//	public ModelAndView personAdd() {
//		Person person = new Person();
//		person.setFirstName("");
//		person.setLastName("");
//		person.setAddress("");
//		person.setAge(0);
//		person.setId(0);
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("add");
//		model.addObject("person", person);
//		
//		List<Person> personsList = personService.listPersons();
//		model.addObject("personsList", personsList);
//
//		return model;
//	}
//	
//	@RequestMapping(value = "/persons/edit/{personId}", method = RequestMethod.GET)
//	public ModelAndView personEdit(@PathVariable("personId") String personId) {
////		Person person = new Person();
////		person.setFirstName("");
////		person.setLastName("");
////		person.setAddress("");
////		person.setAge(0);
////		person.setId(0);
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("edit");
//		Person editPerson = new Person();
//		List<Person> personsList = personService.listPersons();
//		for (int i = 0;i<personsList.size(); i++) {
//			if (String.valueOf(personsList.get(i).getId()).equals(personId)) {
//				editPerson = personsList.get(i);
//			}
//		}
//		model.addObject("person", editPerson);
//
//		return model;
//	}
//
//	@RequestMapping(value = "/persons/add", method = RequestMethod.POST)
//	public String personAddSubmit(@ModelAttribute Person person) {
//		personService.addPerson(person);
//		return "redirect:/persons/list";
//	}
//	
//	@RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
//	public String personEditSubmit(@ModelAttribute Person person) {
//		System.out.println("CCCC" + person.getId());
//		personService.editPerson(person);
//		return "redirect:/persons/list";
//	}

}
