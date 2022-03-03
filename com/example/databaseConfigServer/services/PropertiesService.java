package com.example.databaseConfigServer.services;

import com.example.databaseConfigServer.domain.Properties;
import com.example.databaseConfigServer.repo.PropertiesRepository;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * sgoswami
 *
 */

@RestController
@RequestMapping(value = "/api")
public class PropertiesService {

	@Autowired
	private PropertiesRepository repository;

	@GetMapping(value = "/props")
	public Iterable<Properties> getAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/props/{application}")
	public Iterable<Properties> get(@PathVariable() String application) {
		return repository.findByApplication(application);
	}

	@GetMapping(value = "/props/{application}/{profile}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile) {
		return repository.findByApplicationAndProfile(application, profile);
	}

	@GetMapping(value = "/props/{application}/{profile}/{label}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile,
			@PathVariable() String label) {
		return repository.findByApplicationAndProfileAndLabel(application, profile, label);
	}

	@GetMapping(value = "/props/{application}/{profile}/{label}/{key}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile,
			@PathVariable() String label, @PathVariable() String key) {
		return repository.findByApplicationAndProfileAndLabelAndKey(application, profile, label, key);
	}

	@PutMapping(value = "/props")
  @ResponseStatus(value= HttpStatus.OK)
	public Optional<Properties> update(@Valid @RequestBody Properties properties) throws URISyntaxException {
		Optional<Properties> existing = repository.findOneByApplicationAndProfileAndLabelAndKey(
				properties.getApplication(), properties.getProfile(), properties.getLabel(),
				properties.getKey());
		return existing.map(rProp -> {
			rProp.setValue(properties.getValue());
			return repository.save(rProp);
		});
	}

	@PostMapping(value = "/props")
	@ResponseStatus(value= HttpStatus.OK)
	public Properties create(@Valid @RequestBody Properties properties) {
		return repository.save(properties);
	}
}
