package br.com.casadocodigo.loja.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1385045566854510593L;
	
	
	private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();
	
	public void add(CarrinhoItem carrinhoItem){
		itens.put(carrinhoItem, getQuantidade(carrinhoItem) + 1);
	}

	public int getQuantidade(CarrinhoItem carrinhoItem) {
		
	    if(!itens.containsKey(carrinhoItem)){
	        itens.put(carrinhoItem, 0);
	    }
	    return itens.get(carrinhoItem);
	}
	
	public int getQuantidade(){
		return itens.values().stream().reduce(0, (proximo, acumulador) -> (proximo + acumulador));
	}
	
	public Collection<CarrinhoItem> getItens(){
		return itens.keySet();
	}
	
	public BigDecimal getTotal(CarrinhoItem carrinhoItem){
		return carrinhoItem.getTotal(getQuantidade(carrinhoItem));
	}
	
	public BigDecimal getTotal(){
		BigDecimal total = BigDecimal.ZERO;
		for (CarrinhoItem carrinhoItem : itens.keySet()) {
			total = total.add(getTotal(carrinhoItem));
		}
		
		return total;
	}

}
