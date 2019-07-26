package br.com.sistemasefaz.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orgao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_orgao;
	private String ds_orgao;
	
	//@OneToMany(mappedBy="cargo")
	//private List<Usuario> listaUsuarios;
	
	public Integer getCdOrgao() {
		return cd_orgao;
	}
	public void setCdOrgao(Integer cd_orgao) {
		this.cd_orgao = cd_orgao;
	}
	public String getDescricao() {
		return ds_orgao;
	}
	public void setDescricao(String descricao) {
		this.ds_orgao = descricao;
	}

}
