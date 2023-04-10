package storage_classes;

public class GenericStorage<T>
{
    private T data;

    public GenericStorage(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }
}
