package model.service;

import java.sql.SQLException;

import model.bean.Agenda;
import model.dao.AgendaDAO;

public class AgendaService {
	AgendaDAO dao = new AgendaDAO();
	
	
	
	public int criar(Agenda agenda) {
		return dao.create(agenda);
	}
	
	public void atualizar(Agenda agenda) {
		dao.update(agenda);
	}
	
	public void excluir(int id) {
		dao.delete(id);
	}
	
	public Agenda carregar(int id) {
		return dao.read(id);
	}
}
