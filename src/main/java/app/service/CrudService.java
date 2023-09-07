package app.service;

import java.util.List;

public interface CrudService {
    public Object create(Object object);
    public Object get(Long id);
    public Object update(Object object);
    public boolean delete(Long id);
    public List<?> getAll();
}
