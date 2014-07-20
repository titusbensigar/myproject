/**
 * 
 */
package models;

import java.util.Date;

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
	public boolean isAdmin = false;
	public boolean isTCAccepted = false;
	@Formats.DateTime(pattern="MM/dd/yyyy hh:mm:ss")
	public Date createdOn = new Date();
	
	@Formats.DateTime(pattern="MM/dd/yyyy hh:mm:ss")
	public Date modifiedOn = new Date();
}
