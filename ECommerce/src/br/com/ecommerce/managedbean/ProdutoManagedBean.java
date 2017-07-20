package br.com.ecommerce.managedbean;

import javax.faces.bean.ManagedBean;

import br.com.ecommerce.bean.Produto;
import br.com.ecommerce.dao.ProdutoDAO;

@ManagedBean(name="produtoMB")
public class ProdutoManagedBean {
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String cadastrar() {
		new ProdutoDAO().insere(produto);
		
		return "produtoCadastrado";
	}
}
