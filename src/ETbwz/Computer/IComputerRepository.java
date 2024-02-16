package ETbwz.Computer;

import java.util.List;

public interface IComputerRepository {

    List<Computer> getAll();
    Computer getById(String ComputerId);
    void insert(Computer computer);
    void update(Computer computer, String ComputerId);
    void delete(String ComputerId);



}
