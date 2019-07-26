package br.com.sistemasefaz.modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.swing.text.MaskFormatter;
import javax.validation.constraints.Max;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String cpf;

	private String nome;
	private String email;
	
	@ManyToOne
	private Cargo cargo;

	@ManyToOne
	private Orgao orgao;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Sistema> sistemas = new ArrayList<Sistema>();

	public String getCpf() throws ParseException {
		if(cpf != null) {
	        MaskFormatter mask = new MaskFormatter("###.###.###-##");
	        mask.setValueContainsLiteralCharacters(false);
			
			return mask.valueToString(cpf);
		}else {
			return cpf;
		}
			
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replace(".", "").replace("-", "");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public void setSistemas(List<Sistema> sistemas) {
		this.sistemas = sistemas;
	}

	public List<Sistema> getSistemas() {
		return sistemas;
	}

	public void adicionaSistema(Sistema sistema) {
		Boolean inserirSistema = true;
		
		//Valida se o Sistema já foi incluso na lista da tela
		if(!this.sistemas.isEmpty()) {
			for (Sistema sis : this.sistemas) {
				if(sis.getCdSistema().equals(sistema.getCdSistema())) {
					inserirSistema = false;
				}
			}
		}
		if(inserirSistema) {
			this.sistemas.add(sistema);
		}
	}

	public Usuario() {
	}

	public void removeSistema(Sistema sistema) {
		this.sistemas.remove(sistema);		
	}

}