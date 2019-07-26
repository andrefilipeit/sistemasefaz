package br.com.sistemasefaz.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemasefaz.dao.DAO;
import br.com.sistemasefaz.modelo.Cargo;

@ManagedBean
@ViewScoped
public class CargoBean {

	private Cargo cargo = new Cargo();
	
	private Integer cargoId;

	public Cargo getCargo() {
		return cargo;
	}

	public List<Cargo> getCargos() {
		return new DAO<Cargo>(Cargo.class).listaTodos();
	}

	public String gravar() {
		System.out.println("Gravando cargo " + this.cargo.getDescricao());

		if (this.cargo.getCdCargo() == null) {
			new DAO<Cargo>(Cargo.class).adiciona(this.cargo);
		} else {
			new DAO<Cargo>(Cargo.class).atualiza(this.cargo);
		}

		this.cargo = new Cargo();

		return "cargo?faces-redirect=true"; //Redirect
	}

	public void carregar(Cargo cargo) {
		System.out.println("Carregando cargo");
		this.cargo = cargo;
	}

	public void remover(Cargo cargo) {
		System.out.println("Removendo cargo");
		new DAO<Cargo>(Cargo.class).remove(cargo);
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}
	
	public void carregarCargoPelaId() {
		this.cargo = new DAO<Cargo>(Cargo.class).buscaPorId(cargoId);
	}
	
	public String formUsuario() {
		return "usuario?faces-redirect=true";
	}
}
