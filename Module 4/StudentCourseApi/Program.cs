var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();
app.UseDefaultFiles();
app.UseStaticFiles();

var courses = new List<Course>
{
    new(1, "CMPS 360", "Survey of Programming Languages", 3, "Jeffrey Seaman"),
    new(2, "CMPS 480", "Senior Project", 3, "Mark Voortman"),
    new(3, "CMPS 460", "Mobile Application Development", 3, "Jeffrey Seaman"),
    new(4, "HON 499", "Honors Capstone", 3, "Jessica McCort"),
    new(5, "CMPS 355", "Internship in Computer Science", 3, "Mark Voortman"),
};

app.MapGet("/api/courses", () => Results.Ok(courses));

app.MapGet("/api/courses/{id:int}", (int id) =>
{
    var course = courses.FirstOrDefault(c => c.Id == id);
    return course is null ? Results.NotFound() : Results.Ok(course);
});

app.MapPost("/api/courses", (CreateCourse request) =>
{
    if (string.IsNullOrWhiteSpace(request.Code) || string.IsNullOrWhiteSpace(request.Title) || request.Credits < 0 || request.Credits > 6 || string.IsNullOrWhiteSpace(request.Instructor))
    {
        return Results.BadRequest("Code, Title, Credits, and Instructor cannot be blank and Credits must be nonnegative.");
    }

    int id = courses.Count == 0 ? 1 : courses.Max(c => c.Id) + 1;
    var course = new Course(id, request.Code, request.Title, request.Credits, request.Instructor);
    courses.Add(course);
    return Results.Created($"/api/courses/{id}", course);
});

app.MapPut("/api/courses/{id:int}", (int id, UpdateCourse request) =>
{
    var course = courses.FirstOrDefault(c => c.Id == id);
    if (course is null)
    {
        return Results.NotFound($"Course with ID {id} not found");
    }

    var updatedCourse = course with
    {
        Code = request.Code ?? course.Code,
        Title = request.Title ?? course.Title,
        Credits = request.Credits ?? course.Credits,
        Instructor = request.Instructor ?? course.Instructor,
    };

    courses.Remove(course);
    courses.Add(updatedCourse);

    return Results.Ok(updatedCourse);
});

app.MapDelete("/api/courses/{id:int}", (int id) =>
{
    var course = courses.FirstOrDefault(c => c.Id == id);
    if (course is null)
    {
        return Results.NotFound($"Course with ID {id} not found");
    }

    courses.Remove(course);
    return Results.Ok($"Course with ID {id} has been deleted.");
});

app.Run();

record Course(int Id, string Code, string Title, int Credits, string Instructor);
record CreateCourse(string Code, string Title, int Credits, string Instructor);
record UpdateCourse(string? Code, string? Title, int? Credits, string? Instructor);