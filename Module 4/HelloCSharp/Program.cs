Book book = new Book("Learning C#", 29.99m);
Console.WriteLine(book.Describe());

public class Book
{
    public string Title { get; set; }
    public decimal Price { get; set; }

    public Book(string title, decimal price)
    {
        Title = title;
        Price = price;
    }

    public string Describe()
    {
        return $"{Title} costs ${Price:F2}";
    }
}