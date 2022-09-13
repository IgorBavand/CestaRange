package com.john.john.controller;

import com.john.john.dto.CestaResponse;
import com.john.john.dto.RangeResponse;
import com.john.john.service.CestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cesta")
public class CestaController {

    @Autowired
    private CestaService service;

    @GetMapping
    public List<CestaResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("/range")
    public List<RangeResponse> buscarReanges(Long cestaId) {
        return service.retornaRange(cestaId);
    }

}
