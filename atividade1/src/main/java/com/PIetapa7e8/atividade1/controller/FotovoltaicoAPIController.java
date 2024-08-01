package com.PIetapa7e8.atividade1.controller;

import com.PIetapa7e8.atividade1.service.FotovoltaicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fotovoltaico")
public class FotovoltaicoAPIController {
    
    @Autowired
    FotovoltaicoService fotovoltaicoService;
    
    
}
