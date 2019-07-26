package br.com.sistemasefaz.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemasefaz.dao.DAO;
import br.com.sistemasefaz.modelo.Orgao;

@ManagedBean
@ViewScoped
public class OrgaoBean {

	private Orgao orgao = new Orgao();
	
	private Integer orgaoId;

	public Orgao getOrgao() {
		return orgao;
	}

	public List<Orgao> getOrgaos() {
		return new DAO<Orgao>(Orgao.class).listaTodos();
	}

	public String gravar() {
		System.out.println("Gravando orgao " + this.orgao.getDescricao());

		if (this.orgao.getCdOrgao() == null) {
			new DAO<Orgao>(Orgao.class).adiciona(this.orgao);
		} else {
			new DAO<Orgao>(Orgao.class).atualiza(this.orgao);
		}

		this.orgao = new Orgao();

		return "orgao?faces-redirect=true"; //Redirect
	}

	public void carregar(Orgao orgao) {
		System.out.println("Carregando orgao");
		this.orgao = orgao;
	}

	public void remover(Orgao orgao) {
		System.out.println("Removendo orgao");
		new DAO<Orgao>(Orgao.class).remove(orgao);
	}

	public Integer getOrgaoId() {
		return orgaoId;
	}

	public void setOrgaoId(Integer orgaoId) {
		this.orgaoId = orgaoId;
	}
	
	public void carregarOrgaoPelaId() {
		this.orgao = new DAO<Orgao>(Orgao.class).buscaPorId(orgaoId);
	}
	
	public String formUsuario() {
		return "usuario?faces-redirect=true";
	}
}
