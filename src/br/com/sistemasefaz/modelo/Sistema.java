package br.com.sistemasefaz.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sistema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_sistema;
	private String ds_sistema;
	
	//@OneToMany(mappedBy="cargo")
	//private List<Usuario> listaUsuarios;
	
	public Integer getCdSistema() {
		return cd_sistema;
	}
	public void setCdSistema(Integer cd_sistema) {
		this.cd_sistema = cd_sistema;
	}
	public String getDescricao() {
		return ds_sistema;
	}
	public void setDescricao(String descricao) {
		this.ds_sistema = descricao;
	}

}
