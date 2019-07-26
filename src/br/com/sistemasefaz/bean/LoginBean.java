package br.com.sistemasefaz.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.sistemasefaz.dao.LoginDao;
import br.com.sistemasefaz.modelo.Login;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Login login = new Login();

	public Login getLogin() {
		return login;
	}

	public String efetuaLogin() {
		System.out.println("Fazendo login do usuário "
				+ this.login.getUser());
		
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = new LoginDao().existe(this.login);
		
		if (existe) {

			context.getExternalContext().getSessionMap()
					.put("loginLogado", this.login);

			return "usuario?faces-redirect=true";
		}

		return null;
	}

}
