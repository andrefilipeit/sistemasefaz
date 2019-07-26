package br.com.sistemasefaz.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.sistemasefaz.modelo.Cargo;
import br.com.sistemasefaz.modelo.Login;
import br.com.sistemasefaz.modelo.Orgao;
import br.com.sistemasefaz.modelo.Sistema;
import br.com.sistemasefaz.modelo.Usuario;

public class PopulaBanco {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		//Acesso ao sistema
		Login login = new Login();
		login.setUser("admin");
		login.setSenha("admin");
		em.persist(login);
		
		//Sistema
		Sistema sistemaFinanceiro = geraSistema("FINANCEIRO");
		em.persist(sistemaFinanceiro);

		Sistema sistemaAdministrativo = geraSistema("ADMINISTRATIVO");
		em.persist(sistemaAdministrativo);

		Sistema sistemaCorporativo = geraSistema("CORPORATIVO");
		em.persist(sistemaCorporativo);
		//Cargo
		Cargo cargoDEV = geraCargo("DESENVOLVEDOR");
		em.persist(cargoDEV);
		
		Cargo cargoAnalistaSist = geraCargo("ANALISTA DE SISTEMAS");
		em.persist(cargoAnalistaSist);
		
		Cargo cargoGerente = geraCargo("GERENTE DE SOFTWARE");
		em.persist(cargoGerente);
		//Orgao
		Orgao orgaoSefaz = geraOrgao("SEFAZ");
		em.persist(orgaoSefaz);
		
		Orgao orgaoSSE = geraOrgao("SSE");
		em.persist(orgaoSSE);
		
		Usuario usuarioAndre = geraUsuario("10783413467", "ANDRÉ FILIPE OLIVEIRA DOS SANTOS",
				"ANDRE.FILIPE.IT@GMAIL.COM", cargoDEV, orgaoSefaz, Arrays.asList(sistemaFinanceiro, sistemaAdministrativo));
		Usuario usuarioRose = geraUsuario("88888899915", "ROSEADJANE MIRTES",
				"ROSEMIRTES@GMAIL.COM", cargoGerente, orgaoSSE, Arrays.asList(sistemaCorporativo));
		Usuario usuarioAndressa = geraUsuario("89609034420", "ANDRESSA KARLA",
				"ANDRESSA@GMAIL.COM", cargoAnalistaSist, orgaoSefaz, null);

		em.persist(usuarioAndre);
		em.persist(usuarioRose);
		em.persist(usuarioAndressa);


		em.getTransaction().commit();
		em.close();
	}

	private static Orgao geraOrgao(String descricao) {
		Orgao orgao = new Orgao();
		orgao.setDescricao(descricao);
		return orgao;
	}

	private static Cargo geraCargo(String descricao) {
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		return cargo;
	}

	private static Sistema geraSistema(String descricao) {
		Sistema sistema = new Sistema();
		sistema.setDescricao(descricao);
		return sistema;
	}

	private static Usuario geraUsuario(String cpf, String nome, String email,
			Cargo cargo, Orgao orgao, List<Sistema> sistema) {
		Usuario usuario = new Usuario();
		usuario.setCpf(cpf);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setCargo(cargo);
		usuario.setOrgao(orgao);
		
		if(sistema != null) {
			for (Sistema sis : sistema) {
				usuario.adicionaSistema(sis);
			}
		}
		return usuario;
	}

}
