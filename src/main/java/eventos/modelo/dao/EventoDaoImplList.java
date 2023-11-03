package eventos.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import eventos.modelo.javabeans.Evento;

public class EventoDaoImplList implements EventoDao{
	
	public List<Evento> lista;
	private static int idAuto;
	
	static {
		idAuto = 0;
	}
	public EventoDaoImplList() {
		lista = new ArrayList<>();
		cargarLista();
	}
	
	
	private void cargarLista() {
		// TODO Auto-generated method stub
		
	}
	
	




	@Override
	public Evento findById(int idEvento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Evento evento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idEvento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(Evento evento) {
		// TODO Auto-generated method stub
		return 0;
	}

}
