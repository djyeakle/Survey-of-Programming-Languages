var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();
app.UseDefaultFiles();
app.UseStaticFiles();

var books = new List<Book>
{
    new(1, "Learning C#", "Taylor", 29.99m),
    new(2, "Web APIs", "Jordan", 34.50m)
};

app.MapGet("/api/books", () => Results.Ok(books));

app.MapGet("/api/books/{id:int}", (int id) =>
{
    var book = books.FirstOrDefault(b => b.Id == id);
    return book is null ? Results.NotFound() : Results.Ok(book);
});

app.MapPost("/api/books", (CreateBook request) =>
{
    if (string.IsNullOrWhiteSpace(request.Title) || request.Price < 0)
    {
        return Results.BadRequest("Title is required and price must be nonnegative");
    }

    int id = books.Count == 0 ? 1 : books.Max(b => b.Id) + 1;
    var book = new Book(id, request.Title, request.Author, request.Price);
    books.Add(book);
    return Results.Created($"/api/books/{id}", book);
});

app.Run();

record Book(int Id, string Title, string Author, decimal Price);
record CreateBook(string Title, string Author, decimal Price);