package ETbwz.Bestellung;

import ETbwz.Computer.Computer;

import java.util.List;

public interface IBestellungRepository {

    List<Computer> getAll();
    Computer getById(int bestellnummer);
    void insert(Bestellung bestellung, String ComputerId, List<Bestellposition> bestellpositionen);
    void update(Bestellung bestellung, String ComputerId, Bestellposition bestellposition, int bestellnummer);
    void delete(int bestellnummer);
    boolean exists(int bestellnummer);

}
