package com.exam;

//import java.util.HashSet;
//import java.util.Set;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.exam.entity.Role;
//import com.exam.entity.User;
//import com.exam.entity.UserRole;
//import com.exam.service.UserService;

@SpringBootApplication
public class ExamPortalServerApplication /*implements CommandLineRunner*/ {
	/*
	 * @Autowired UserService userService;
	 */
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalServerApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception { // TODO
	 * Auto-generated method stub
	 * 
	 * User user = new User(); user.setUsername("pijush667");
	 * user.setFirstName("Pijush"); user.setLastName("Nag");
	 * user.setEmail("pkn@gmail.com"); user.setPassword("1234");
	 * user.setPhone("1234567890"); user.setProfile("mypic.png");
	 * 
	 * Role role = new Role(); role.setRoleId(55L); role.setRoleName("ADMIN");
	 * 
	 * UserRole userRole = new UserRole(); userRole.setRole(role);
	 * userRole.setUser(user);
	 * 
	 * Set<UserRole> userRoles = new HashSet<>();
	 * 
	 * userRoles.add(userRole);
	 * 
	 * this.userService.addUser(user, userRoles); }
	 */

}
