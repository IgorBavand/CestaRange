package com.john.john.dto;

import com.john.john.model.Cesta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RangeResponse {

    private Integer ano;
    private Integer mes;
    private String tipo;
    private String nome;
    private long range;

    public static RangeResponse of(Cesta cesta, Integer mes, Long diferenca, Integer ano){
        return RangeResponse.builder()
                .ano(ano)
                .mes(mes)
                .tipo(cesta.getTipo())
                .nome(cesta.getNome())
                .range((diferenca))
                .build();
    }
}
