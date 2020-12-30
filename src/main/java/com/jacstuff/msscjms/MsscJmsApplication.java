package com.jacstuff.msscjms;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsscJmsApplication {

	public static void main(String[] args) {

		try {
		ActiveMQServer server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
				.setPersistenceEnabled(false)
				.setJournalDirectory("target/data/journal")
				.setSecurityEnabled(false)
				.addAcceptorConfiguration("invm", "vm://1121"));
		server.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
		SpringApplication.run(MsscJmsApplication.class, args);
	}

}
