package com.example.springcloudconfigclient.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ExampleController {

  @Value("${variable.name}")
  private String variable;

  @Value("${variable.orgId}")
  private List<String> orgIds;

  @GetMapping("/example")
  public String example() {
    return "Hello "+variable+" !! " + new Date();
  }

  @GetMapping("/orgId")
  public List<String> getOrgIds() {
    return orgIds;
  }
}
