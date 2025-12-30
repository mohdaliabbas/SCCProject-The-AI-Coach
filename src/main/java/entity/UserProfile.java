package entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(name = "exp_years")
	private float expYears;
	
	@Column(name = "current_role")
	private String currentRole;
	
	@Column(name = "target_role")
	private String targetRole;
	
	@Column(name = "salary_target")
	private String salaryTarget;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getExpYears() {
		return expYears;
	}

	public void setExpYears(float expYears) {
		this.expYears = expYears;
	}

	public String getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public String getTargetRole() {
		return targetRole;
	}

	public void setTargetRole(String targetRole) {
		this.targetRole = targetRole;
	}

	public String getSalaryTarget() {
		return salaryTarget;
	}

	public void setSalaryTarget(String salaryTarget) {
		this.salaryTarget = salaryTarget;
	}
}
