package interfaces;

import beans.UsuarioDTO;

public interface UsuarioDAO {
	//Metodos para mantener Data
	//Usuario
	//Autenticar usuario
	public boolean autenticarUsuario(String codUsuario, String contraUsuario);
	//Buscar Usuario
	public UsuarioDTO buscarUsuario(String codUsuario);
	//Actualizar Usuario
	public int actualizarUsuario(UsuarioDTO usuario);
	//Registrar Usuario
	public int registrarUsuario(UsuarioDTO usuario);
	//Eliminar Usuario
	public int eliminarUsuario(String codUsuario);
}
