package br.com.habbora.teste.modelo;

import br.com.habbora.dao.EmpresasDao;
import br.com.habbora.modelo.Empresa;

public class TesteCriarEmpresa {
	
	public static void main(String[] args) {
		
		EmpresasDao empresas = new EmpresasDao();
		
		empresas.add(new Empresa("Facebook"));
		
		System.out.println(empresas);
		
	}

}
