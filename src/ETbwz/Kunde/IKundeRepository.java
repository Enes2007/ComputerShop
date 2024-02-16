package ETbwz.Kunde;

import java.util.List;

public interface IKundeRepository {
    List<Kunde> getAll();
    Kunde getById(String KundeId);
    void insert(Kunde kunde);
    void update(Kunde kunde, String KundeId);
    void delete(String KundeId);

}
