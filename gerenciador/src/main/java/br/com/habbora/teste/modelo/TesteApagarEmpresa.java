package br.com.habbora.teste.modelo;

import br.com.habbora.dao.EmpresasDao;

public class TesteApagarEmpresa {
	
	public static void main(String[] args) {
		
		EmpresasDao empresas = new EmpresasDao();
		EmpresasDao empresas2 = new EmpresasDao();
		
		System.out.println(empresas);
		System.out.println(empresas2);
		
		empresas.delete(4);
		
		System.out.println(empresas);
		System.out.println(empresas2);
		
	}

}
