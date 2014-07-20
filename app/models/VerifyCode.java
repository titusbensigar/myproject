package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
@Table(name="VerifyCode")
public class VerifyCode extends Model {

	@Id
	@Constraints.Min(10)
	public Long id;
	@Constraints.Required
	public String code;
	public String type;
	public String data1;
	public String data2;
	@Constraints.Required
	public String emailAddress;
	@Formats.DateTime(pattern="MM/dd/yyyy hh:mm:ss")
	public Date createdOn = new Date();
	
	@Formats.DateTime(pattern="MM/dd/yyyy hh:mm:ss")
	public Date modifiedOn = new Date();
	/**
	 * Use timestamp to (eventually) expire codes out of Verify_Code
	 * 
	 * Note: This JPA annotation is MYSQL-specific.
	 * Note: columnDefinition could simply be = "TIMESTAMP", as the other settings are the MySQL default
	 **/
	@Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	public Date timestamp = new Date();;
	
//
//	/**
//	 * Create a new VerifyCode model
//	 * @param verifyCode
//	 * @param data1
//	 * @param data2
//	 * @param emailAddress
//	 */
//	public VerifyCode ( String verifyCode,
//						String data1,
//						String data2,
//						String emailAddress ) {
//		this.code = verifyCode;
//		this.data1 = data1;
//		this.data2 = data2;
//		this.emailAddress = emailAddress;
//		
//	}
	
	
//    /**
//     * Find VerifyCode
//     * @param tenant
//     * @param code
//     * @return
//     */
//    public static VerifyCode findByTenantAndCode(Tenant tenant, String code) {
//    	return VerifyCode.find("data1 = ? AND code = ?", tenant.id.toString(), code).first();
//    }
//
//
//	public static VerifyCode findByTestAndCode(TestSession test, String code) {
//    	return VerifyCode.find("data1 = ? AND data2 = 'test' AND code = ?", test.id.toString(), code).first();
//	}
//
//	public static VerifyCode findByOrgAndCode(Organization org, String code) {
//    	return VerifyCode.find("data1 = ? AND data2 = 'org' AND code = ?", org.id.toString(), code).first();
//	}
}
