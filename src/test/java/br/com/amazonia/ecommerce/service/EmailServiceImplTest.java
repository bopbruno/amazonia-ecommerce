package br.com.amazonia.ecommerce.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmailServiceImplTest {
	
	@Test
	public void enviarEmailComSucesso() {
		EmailServiceImpl emailService = EmailServiceImpl.getInstance();
		
		boolean isEmailEnviado = emailService.enviarEmail("bop_bruno@hotmail.com", "Assunto email", "Corpo email!");
		
		assertEquals(isEmailEnviado, true);
		
	}

}
