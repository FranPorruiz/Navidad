package service;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuariosService {
	
	List<Usuario> listUsuario=new ArrayList<Usuario>(List.of(
			new Usuario("user1", "pwd1"),
			new Usuario("user2","pwd2"),
			new Usuario("user3","pwd3"),
			new Usuario("user4","pwd4")
			));

	public boolean autenticar(String usuario, String password) {
		for (Usuario usuario2 : listUsuario) {
			if (usuario2.getUsuario().equals(usuario)&&usuario2.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
		//solucion con programacion funcional
		//return usuarios.stream()
		//		.anyMatch(u->u.getUsuario().equals(usuario)&&u.getPassword(9.equals(pwd));*/
	}
}
