package eventos.modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.javabeans.Evento;

@Repository
public class EventoDaoImplList implements EventoDao {

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
		TipoDaoImplList tipoDao = new TipoDaoImplList();
		lista.add(
				new Evento(1, "Concierto Rammstein", "Concierto de final de gira, por primera y última vez en Córdoba",
						new Date(), 1, "C/ Ejemplo 1", "Activo", "S", 5000, 100, 180, tipoDao.findById(1)));
		lista.add(new Evento(2, "'Historia y memoria con nombre de mujer'",
				"Exposición homenaje a las cordobesas represaliadas en la Guerra Civil", new Date(), 5, "C/ Prueba 23",
				"Activo", "S", 150, 15, 5.5, tipoDao.findById(2)));
		lista.add(new Evento(3, "Medina Azahara", "Visita nocturna al conjunto arqueológico Madinat al-Zahra",
				new Date(), 1, "C/ Omeyas 15", "Activo", null, 30, 10, 20, tipoDao.findById(3)));
		lista.add(new Evento(4, "Boda Rojas-Zamora", "Ceremonia en el Alcázar de los Reyes Cristianos", new Date(), 1,
				"C/ Inventada 43", "Activo", "S", 150, 20, 0, tipoDao.findById(4)));
		lista.add(new Evento(5, "Mezquita-Catedal de Córdoba", "Visita guiada a la famosa Mezquita-Catedral cordobesa",
				new Date(), 1, "C/ Judería 3", "Activo", null, 25, 8, 15, tipoDao.findById(3)));
		idAuto = 6;
	}

	@Override
	public Evento findById(int idEvento) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getIdEvento() == idEvento)
				return lista.get(i);
		}
		return null;
	}

	@Override
	public List<Evento> findAll() {
		return lista;
	}

	@Override
	public int insert(Evento evento) {
		if (!lista.contains(evento)) {
			evento.setIdEvento(idAuto++);
			lista.add(evento);
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(int idEvento) {
		Evento evento = findById(idEvento);
		if (evento == null)
			return 0;

		return lista.remove(evento) ? 1 : 0;
	}

	@Override
	public int updateOne(Evento evento) {
		int pos = lista.indexOf(evento);
		if (pos == -1)
			return 0;
		lista.set(pos, evento);
		return 1;
	}
 
}
