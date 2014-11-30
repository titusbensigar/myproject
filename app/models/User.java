/**
 * 
 */
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * @author Titus Bensigar
 *
 */
@Entity
@Table(name="User")
public class User extends Model {
	@Id
	@Constraints.Min(10)
	public Long id;
	@Constraints.Required
	@Constraints.Email
	public String email;
	@Constraints.Required
	public String username;
	@Constraints.Required
	public String password;
	public String firstname;
	public String lastname;
	public boolean isActive = false;
	public boolean isAdmin = false;
	public boolean isTCAccepted = false;
	@Formats.DateTime(pattern="MM/dd/yyyy hh:mm:ss")
	public Date createdOn = new Date();
	
	@Formats.DateTime(pattern="MM/dd/yyyy hh:mm:ss")
	public Date modifiedOn = new Date();
	
	public static Finder<Long,User> find = new Finder(
		    Long.class, User.class
		  );
	
	public static List<User> all() {
		  return find.all();
		}
	
	public static User findById(Long id) {
		  return find.byId(id);
		}
}
