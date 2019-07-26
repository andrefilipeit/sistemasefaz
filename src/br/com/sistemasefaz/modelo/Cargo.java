package br.com.sistemasefaz.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cargo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_cargo;
	private String ds_cargo;
	
//	@OneToMany(mappedBy="cargo")
//	private List<Usuario> listaUsuarios;
	
	public Integer getCdCargo() {
		return cd_cargo;
	}
	public void setCdCargo(Integer cd_cargo) {
		this.cd_cargo = cd_cargo;
	}
	public String getDescricao() {
		return ds_cargo;
	}
	public void setDescricao(String descricao) {
		this.ds_cargo = descricao;
	}

}
