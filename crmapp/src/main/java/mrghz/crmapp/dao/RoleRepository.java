package mrghz.crmapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mrghz.crmapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public List<Role> findByName(String name);
	
}
