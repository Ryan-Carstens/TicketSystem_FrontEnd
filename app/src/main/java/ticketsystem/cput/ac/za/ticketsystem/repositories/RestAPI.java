package ticketsystem.cput.ac.za.ticketsystem.repositories;

import java.util.List;

/**
 * Created by sanXion on 2015/09/27.
 */
public interface RestAPI<S, ID> {
    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}

