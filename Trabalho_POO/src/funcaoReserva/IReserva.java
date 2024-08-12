package funcaoReserva;

//Interface da reserva com alguns métodos
import java.time.LocalDateTime;
import java.time.LocalTime;


public interface IReserva {

	 int getId();
	    Reserva getReserva();
	    SituacaoReserva getSituacao();
	    LocalDateTime getDiaDaReserva();
	    int getDuracao();
	    LocalTime getHoraInicial();
}
