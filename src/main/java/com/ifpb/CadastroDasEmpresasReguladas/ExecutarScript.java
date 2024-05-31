package com.ifpb.CadastroDasEmpresasReguladas;

import com.ifpb.CadastroDasEmpresasReguladas.controller.DominioDeMercadoController;
import com.ifpb.CadastroDasEmpresasReguladas.controller.EmpresaController;
import org.springframework.beans.factory.annotation.Autowired;

public class ExecutarScript {

    @Autowired
    private EmpresaController empresaController;
    @Autowired
    private DominioDeMercadoController dominioDeMercadoController;

    public static void executar(){

    }
}
