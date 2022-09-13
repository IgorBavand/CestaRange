package com.john.john.dto;

import com.john.john.model.Cesta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CestaResponse {
    private Long id;
    private String nome;
    private String tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public static CestaResponse of(Cesta cesta){
        return CestaResponse.builder()
                .id(cesta.getId())
                .nome(cesta.getNome())
                .tipo(cesta.getTipo())
                .dataInicio(cesta.getDataInicio())
                .dataFim(cesta.getDataFim())
                .build();
    }

    public static List<CestaResponse> listaCesta(List<Cesta> cestas) {
        if ( cestas == null ) {
            return null;
        }

        List<CestaResponse> list = new ArrayList<CestaResponse>( cestas.size() );
        for ( Cesta cesta : cestas ) {
            list.add( of( cesta ) );
        }

        return list;
    }
}
