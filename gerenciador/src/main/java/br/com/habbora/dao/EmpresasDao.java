package br.com.habbora.dao;

import java.util.List;

import br.com.habbora.jdbc.BancoEmpresas;
import br.com.habbora.jdbc.FileDataObject;
import br.com.habbora.modelo.Empresa;

public class EmpresasDao {
	
	String dir = "empresa.jdb";

	private FileDataObject fileDataObject = new FileDataObject(dir);
	private static BancoEmpresas bancoEmpresas;
	
	public EmpresasDao() {
		if(bancoEmpresas == null) {
			//System.out.println("Banco de dados sendo carregado!");
			bancoEmpresas = (BancoEmpresas) fileDataObject.load();
			if(bancoEmpresas == null) {
				bancoEmpresas = new BancoEmpresas();
				fileDataObject.save(bancoEmpresas);
			}
		} else {
			//System.out.println("Banco de dados já iniciado!");
		}
	}

	public void add(Empresa empresa) {
		bancoEmpresas.add(empresa);
		fileDataObject.save(bancoEmpresas);
	}

	public Empresa read(Integer id) {
		return bancoEmpresas.read(id);
	}

	public void update(Empresa oldEmpresa, Empresa newEmpresa) {

	}

	public void delete(Integer chaveId) {
		bancoEmpresas.delete(chaveId);
		fileDataObject.save(bancoEmpresas);
	}
	
	@Override
	public String toString() {
		return bancoEmpresas.toString();
	}

	@SuppressWarnings("unused")
	private void clear() {
		bancoEmpresas.clear();
	}
	
	public void toBeDestroyed() {
		bancoEmpresas = null;
	}

	public List<Empresa> getEmpresas() {
		return bancoEmpresas.getEmpresas();
	}

}
