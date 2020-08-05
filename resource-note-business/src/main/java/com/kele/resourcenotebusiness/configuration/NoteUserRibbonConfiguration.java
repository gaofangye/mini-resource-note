package com.kele.resourcenotebusiness.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import ribbonconfiguration.RibbonConfiguration;

@Configuration
@RibbonClient(name = "mini-resource-user", configuration = RibbonConfiguration.class)
public class NoteUserRibbonConfiguration {

}
