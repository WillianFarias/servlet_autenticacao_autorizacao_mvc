package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer sequenciaId = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Caeulum");
		empresa.setId(sequenciaId++);
		empresa.setDataAbertura(Calendar.getInstance().getTime());

		Empresa empresa2 = new Empresa();
		empresa2.setNome("Alura");
		empresa2.setId(sequenciaId++);
		empresa2.setDataAbertura(Calendar.getInstance().getTime());
		
		empresas.add(empresa);
		empresas.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("willian");
		u1.setSenha("123");
		
		Usuario u2 = new Usuario();
		u2.setLogin("adm");
		u2.setSenha("123");
		
		usuarios.add(u1);
		usuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		System.out.println("Cadastrando nova empresa na lista!");
		empresa.setId(Banco.sequenciaId++);
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public void removeEmpresa(Integer id) {
		Banco.empresas.removeIf(empresa -> empresa.getId() == id);
//		Banco.empresas.removeIf(empresa -> Banco.empresas.contains(empresa));
	}

	public Empresa capturarEmpresa(Integer id) {
		Empresa empresa = new Empresa();
		
		for (Empresa empresaCadastrada : Banco.empresas) {
			if(empresaCadastrada.getId() == id) {
				empresa = empresaCadastrada;
			}
		}
		return empresa;
	}

	public Usuario existeUsuario(String login, String senha) {
//		Usuario usuario = usuarios.stream().filter(p -> p.ehIgual(login, senha));
		Usuario usuarioRetorno = null;
		for (Usuario usuario : usuarios) {
			if(usuario.ehIgual(login, senha)) {
				usuarioRetorno = usuario;
			}
		}
		return usuarioRetorno;
	}
	
//	public void removeEmpresa(Integer id) {
//		Iterator<Empresa> iterator = empresas.iterator();
//		
//		while(iterator.hasNext()) {
//			Empresa empresa = iterator.next();
//			
//			if(empresa.getId() == id) {
//				iterator.remove();
//			}
//		}
//	}
	
//	Vai resultar em erro pois estou alterando a lista que estou percorrendo
//	public void removeEmpresa(Integer id) {
//		for (Empresa empresa : empresas) {
//			if(empresa.getId() == id) {
//				empresas.remove(empresa);
//			}
//		}
//	}

}
