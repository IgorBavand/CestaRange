package com.john.john.service;

import com.john.john.dto.CestaResponse;
import com.john.john.dto.RangeResponse;
import com.john.john.model.Cesta;
import com.john.john.repository.CestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CestaService {

    @Autowired
    private CestaRepository repository;

    public List<CestaResponse> findAll(){
        return CestaResponse.listaCesta(repository.findAll());
    }

    public List<RangeResponse> retornaRange(Long cestaId) {
        Optional<Cesta> cesta = repository.findById(cestaId);

        if (cesta.isPresent()) {
            int mesAtual = cesta.get().getDataInicio().getMonth().getValue();
            int anoAtual = cesta.get().getDataInicio().getYear();
            List<RangeResponse> retorno = new ArrayList<>();
            long diferenca = ChronoUnit.MONTHS.between(cesta.get().getDataInicio(), cesta.get().getDataFim().plusMonths(1));

            int i = 1;

            while (i <= diferenca) {

                retorno.add(RangeResponse.of(cesta.get(), mesAtual, diferenca, anoAtual));
                mesAtual++;
                i++;
                if (mesAtual > 12) {
                    mesAtual = 1;
                    anoAtual++;
                }
            }

            return retorno;
        }
        //retorna erro caso nao encontre a cesta
        return null;
    }

}
