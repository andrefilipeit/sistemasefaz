package br.com.sistemasefaz.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemasefaz.dao.DAO;
import br.com.sistemasefaz.modelo.Sistema;

@ManagedBean
@ViewScoped
public class SistemaBean {

	private Sistema sistema = new Sistema();
	
	private Integer sistemaId;

	public Sistema getSistema() {
		return sistema;
	}

	public List<Sistema> getSistemas() {
		return new DAO<Sistema>(Sistema.class).listaTodos();
	}

	public String gravar() {
		System.out.println("Gravando sistema " + this.sistema.getDescricao());

		if (this.sistema.getCdSistema() == null) {
			new DAO<Sistema>(Sistema.class).adiciona(this.sistema);
		} else {
			new DAO<Sistema>(Sistema.class).atualiza(this.sistema);
		}

		this.sistema = new Sistema();

		return "sistema?faces-redirect=true"; //Redirect
	}

	public void carregar(Sistema sistema) {
		System.out.println("Carregando sistema");
		this.sistema = sistema;
	}

	public void remover(Sistema sistema) {
		System.out.println("Removendo sistema");
		new DAO<Sistema>(Sistema.class).remove(sistema);
	}

	public Integer getSistemaId() {
		return sistemaId;
	}

	public void setSistemaId(Integer sistemaId) {
		this.sistemaId = sistemaId;
	}
	
	public void carregarSistemaPelaId() {
		this.sistema = new DAO<Sistema>(Sistema.class).buscaPorId(sistemaId);
	}
	

public String formUsuario() {
		return "usuario?faces-redirect=true";
	}
}
