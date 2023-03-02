package com.jeancaslv.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeancaslv.mvc.mudi.dto.RequisicaoNovoPedido;
import com.jeancaslv.mvc.mudi.model.Pedido;
import com.jeancaslv.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido pedidoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = pedidoDTO.toPedido();
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}
	
	

}
