package com.example.demo.api;

import com.example.demo.dto.PagamentoDto;
import com.example.demo.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoApi {
    @Autowired
    PagamentoFacade pagamentoFacade;

    public String processar(@RequestBody PagamentoDto request){
        return pagamentoFacade.solicitarPagamento(request);
    }
}
