package br.ucb.talp.converters;

import br.ucb.talp.enums.TipoProduto;
import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterTipoProduto", forClass = TipoProduto.class)
public class ConverterTipoProduto extends EnumConverter {

    public ConverterTipoProduto() {
        super(TipoProduto.class);
    }

}
