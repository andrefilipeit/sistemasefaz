package br.com.sistemasefaz.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemasefaz.dao.DAO;
import br.com.sistemasefaz.modelo.Cargo;
import br.com.sistemasefaz.modelo.Orgao;
import br.com.sistemasefaz.modelo.Sistema;
import br.com.sistemasefaz.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	private Integer sistemaId;
	
	private Integer cargoId;

	private Integer usuarioId;
	
	private Integer orgaoId;
	
	private Boolean flagAlterar = false;
	
	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}

	public Integer getOrgaoId() {
		return orgaoId;
	}

	public void setOrgaoId(Integer orgaoId) {
		this.orgaoId = orgaoId;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setSistemaId(Integer SistemaId) {
		this.sistemaId = SistemaId;
	}

	public Integer getSistemaId() {
		return sistemaId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public List<Usuario> getUsuarios() {
		return new DAO<Usuario>(Usuario.class).listaTodos();
	}

	public List<Sistema> getSistemas() {
		return new DAO<Sistema>(Sistema.class).listaTodos();
	}
	
	public List<Cargo> getCargos() {
		return new DAO<Cargo>(Cargo.class).listaTodos();
	}
	
	public List<Orgao> getOrgaos() {
		return new DAO<Orgao>(Orgao.class).listaTodos();
	}

	public List<Sistema> getSistemasDoUsuario() {
		return this.usuario.getSistemas();
	}

	public void gravarSistema() {
		Sistema sistema = new DAO<Sistema>(Sistema.class).buscaPorId(this.sistemaId);
		this.usuario.adicionaSistema(sistema);
	}

	public void gravar() {
		
		if(this.getCargoId() != null) {
			Cargo c = new Cargo();
			c.setCdCargo(this.getCargoId());
			this.usuario.setCargo(c);
		}
		
		if(this.getOrgaoId() != null) {
			Orgao o = new Orgao();
			o.setCdOrgao(this.getOrgaoId());
			this.usuario.setOrgao(o);
		}
		//Sempre deixar usuário com nome maiusculo
		if(!flagAlterar) {
			new DAO<Usuario>(Usuario.class).adiciona(this.usuario);
		}else {
			new DAO<Usuario>(Usuario.class).atualiza(this.usuario);
		}

		this.usuario = new Usuario();
		this.cargoId = null;
		this.orgaoId = null;
	}

	public void carregar(Usuario usuario) {
		System.out.println("Carregando usuario " + usuario.getNome());
		this.usuario = usuario;
		this.flagAlterar = true;
		this.setCargoId(usuario.getCargo().getCdCargo());
		this.setOrgaoId(usuario.getOrgao().getCdOrgao());
	}

	public void remover(Usuario usuario) {
		System.out.println("Removendo usuario " + usuario.getNome());
		new DAO<Usuario>(Usuario.class).remove(usuario);
	}

	public void removerSistemaDoUsuario(Sistema sistema) {
		this.usuario.removeSistema(sistema);
	}

	public String formAutor() {
		System.out.println("Chamanda do formulário do Autor.");
		return "autor?faces-redirect=true";
	}
	
	public String formCargo() {
		System.out.println("Chamanda do formulário do Cargo.");
		return "cargo?faces-redirect=true";
	}
	
	public String formOrgao() {
		System.out.println("Chamanda do formulário do Orgao.");
		return "orgao?faces-redirect=true";
	}
	
	public String formSistema() {
		System.out.println("Chamanda do formulário do Sistema.");
		return "sistema?faces-redirect=true";
	}

	public void carregarUsuarioPelaId() {
		this.usuario = new DAO<Usuario>(Usuario.class).buscaPorId(usuarioId);
	}

}
