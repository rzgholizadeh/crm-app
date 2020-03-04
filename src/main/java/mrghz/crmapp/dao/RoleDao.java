package mrghz.crmapp.dao;

import mrghz.crmapp.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
