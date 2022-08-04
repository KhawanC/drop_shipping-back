package com.br.egypto.drop_shipping.stream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.br.egypto.drop_shipping.DTO.ClickDTO;
import com.br.egypto.drop_shipping.service.CategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CategoriaConsumer {

	@Autowired
	CategoriaService categoriaService;
	
	@KafkaListener(topics = {"click.categoria"}, groupId = "drophsipping", containerFactory = "kafkaListenerContainerFactory")
	public void consume(ConsumerRecord<String, ClickDTO> mensagem) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ClickDTO id = mapper.convertValue(mensagem.value(), ClickDTO.class);
			categoriaService.clickCategoriaConsumer(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
