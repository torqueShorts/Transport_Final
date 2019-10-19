package Transport.Service.MainServ;

public interface MainService <T, ID>
{
    T create(T type);

    T update(T type);

    void delete(ID id);

    T read(ID id);

}
