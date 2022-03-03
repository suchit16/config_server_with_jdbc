package com.example.databaseConfigServer.repo;

import com.example.databaseConfigServer.domain.Properties;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * sgoswami
 */

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Long> {

	public List<Properties> findByApplication(String application);

	public List<Properties> findByApplicationAndProfile(String application, String profile);

	public List<Properties> findByApplicationAndProfileAndLabel(String application, String profile, String label);

	public List<Properties> findByApplicationAndProfileAndLabelAndKey(String application, String profile,
			String label, String key);

	public Optional<Properties> findOneByApplicationAndProfileAndLabelAndKey(String application, String profile,
			String label, String key);

}
