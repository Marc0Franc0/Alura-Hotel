package app.service;

public interface CrudService {
    public Object create(Object object);
    public Object get(Long id);
    public Object update(Long id,Object object);
    public Object delete(Long id);
}
